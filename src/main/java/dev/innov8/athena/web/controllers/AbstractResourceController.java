package dev.innov8.athena.web.controllers;

import dev.innov8.athena.services.ResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public abstract class AbstractResourceController<T> implements ResourceController<T> {

    private ResourceService<T> resourceService;

    public AbstractResourceController(ResourceService<T> resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public Set<T> findAll() {
        return resourceService.findAll();
    }

    @GetMapping("/search")
    public Set<T> findBy(@RequestParam MultiValueMap<String, String> params) {
        return resourceService.findAll(params);
    }

    @GetMapping("/myResources/{ownerId}")
    public Set<T> findMyResources(@PathVariable Integer ownerId) {
        return resourceService.findMyResources(ownerId);
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable @NotEmpty Integer id) {
        return resourceService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public T save(@RequestBody @Valid T newObj) {
        return resourceService.save(newObj);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable @NotEmpty Integer id, @RequestBody @Valid T updatedObj) {
        resourceService.update(id, updatedObj);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable @NotEmpty Integer id) {
        resourceService.deleteById(id);
    }

}
