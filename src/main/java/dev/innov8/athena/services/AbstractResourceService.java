package dev.innov8.athena.services;

import dev.innov8.athena.domain.Resource;
import dev.innov8.athena.repositories.ResourceRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.MultiValueMap;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * Serves as a base implementation for business service classes that handle resource requests
 * coming from the beyond the application's domain boundary.
 *
 * @param <R> the resource type that will be used within the CustomResourceRepository implementation
 * @param <T> the DTO that will be the return type and param type for various service methods
 *
 * @author Wezley Singleton (Github: wsingleton)
 *
 */
public abstract class AbstractResourceService<R extends Resource, T> implements ResourceService<T> {

    private final ResourceRepository<R> resourceRepository;
    private final Class<? extends Resource> resourceType;

    public AbstractResourceService(ResourceRepository<R> resourceRepository, Class<? extends Resource> resourceType) {
        this.resourceRepository = resourceRepository;
        this.resourceType = resourceType;
    }

    @Override
    public Set<T> findAll() {
        return null;
    }

    @Override
    public Set<T> findAll(MultiValueMap<String, String> parameters) {
        return null;
    }

    @Override
    public Set<T> findMyResources(int resourceOwnerId) {
        return null;
    }

    @Override
    public T findById(int resourceId) {
        return null;
    }

    @Override
    public T save(T newResource) {
        return null;
    }

    @Override
    public boolean update(int resourceId, T updatedResource) {
        return false;
    }

    @Override
    public boolean deleteById(int resourceId) {
        return false;
    }

    @Override
    public boolean deleteAllById(Iterable<Integer> resourceIds) {
        return false;
    }

    @PostConstruct
    public void postConstruct() throws Exception {

        if (resourceType == null) {
            throw new IllegalStateException("No resource type found for AbstractResourceService!");
        }

    }

}
