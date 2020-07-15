package dev.innov8.athena.services;

import org.springframework.util.MultiValueMap;

import java.util.Set;

public interface ResourceService<T> {

    Set<T> findAll();
    Set<T> findAll(MultiValueMap<String, String> parameters);
    Set<T> findMyResources(int resourceOwnerId);
    T findById(int resourceId);
    T save(T newResource);
    boolean update(int resourceId, T updatedResource);
    boolean deleteById(int resourceId);
    boolean deleteAllById(Iterable<Integer> resourceIds);

}
