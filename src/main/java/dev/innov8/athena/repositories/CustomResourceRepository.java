package dev.innov8.athena.repositories;

import dev.innov8.athena.domain.Resource;
import org.springframework.util.MultiValueMap;

import java.util.Set;

public interface CustomResourceRepository {

    Set<? extends Resource> findAll(MultiValueMap<String, String> params);
    void setResourceType(Class<? extends Resource> resourceType);

}
