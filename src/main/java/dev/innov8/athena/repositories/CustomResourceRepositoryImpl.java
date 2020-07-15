package dev.innov8.athena.repositories;

import dev.innov8.athena.domain.Resource;
import dev.innov8.athena.exceptions.InvalidRequestException;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CustomResourceRepositoryImpl implements CustomResourceRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<? extends Resource> resourceType;

    @Override
    public Set<? extends Resource> findAll(MultiValueMap<String, String> parameters) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<? extends Resource> queryBuilder = criteriaBuilder.createQuery(Resource.class);
        Root<? extends Resource> resource = queryBuilder.from(resourceType);

        List<String> paramKeys = new ArrayList<>(parameters.keySet());
        List<String> resourceFieldNames = Stream.concat(
                                                    Arrays.stream(resourceType.getDeclaredFields()),
                                                    Arrays.stream(Resource.class.getDeclaredFields())
                                                 )
                                                .map(Field::getName)
                                                .collect(Collectors.toList());

        for (String paramKey : paramKeys) {

            if (!resourceFieldNames.contains(paramKey)) {
                String msg = "The field, " + paramKey + ", was not found on resource type, " + resourceType.getName();
                throw new InvalidRequestException(msg);
            }

            Predicate predicate = criteriaBuilder.equal(resource.get(paramKey), parameters.getFirst(paramKey));
            queryBuilder.where(predicate);

        }

        List<? extends Resource> resultList = entityManager.createQuery(queryBuilder).getResultList();
        return new HashSet<>(resultList);

    }

    @Override
    public void setResourceType(Class<? extends Resource> resourceType) {
        this.resourceType = resourceType;
    }

}
