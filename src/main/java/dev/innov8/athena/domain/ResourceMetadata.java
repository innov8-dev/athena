package dev.innov8.athena.domain;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * A model which is embedded into all Resource documents and is used to convey
 * system information.
 *
 * @author Wezley Singleton (GitHub: wsingleton)
 *
 */
@Embeddable
public class ResourceMetadata {

    /** The id of the creator of this resource */
    private Integer resourceCreatorId;

    /** The id of the last modifier of this resource */
    private Integer lastModifierId;

    /** The id of the owner of this resource */
    private Integer resourceOwnerId;

    /** A bool representing whether or not this an active resource or not */
    private boolean isActive;

    /** The datetime of resource creation */
    private LocalDateTime resourceCreationDateTime;

    /** The datetime of the last modification to this resource */
    private LocalDateTime lastModifiedDateTime;

    public ResourceMetadata() {
        super();
    }

    /**
     * Creates a new ResourceMetadata instance where the provided creator id is used as the
     * last modifier id, and the resource creation time and last modified time is set to
     * the time of instantiation.
     *
     * @param creator id of the user that created a resource (also used as the last modifier id)
     * @param owner id of the owner of a resource
     */
    public ResourceMetadata(Integer creator, Integer owner) {
        this.resourceCreatorId = creator;
        this.resourceCreationDateTime = LocalDateTime.now();
        this.lastModifierId = creator;
        this.lastModifiedDateTime = LocalDateTime.now();
        this.resourceOwnerId = owner;
        this.isActive = true;
    }

    /**
     * Creates a new ResourceMetadata instance where the provided creator id is used as the
     * last modifier id, and the resource creation time and last modified time is set to
     * the time of instantiation.
     *
     * @param creator id of the user that created a resource (also used as the last modifier id)
     * @param owner id of the owner of a resource
     * @param active bool representing whether or not this an active resource or not
     */
    public ResourceMetadata(Integer creator, Integer owner, boolean active) {
        this(creator, owner);
        this.isActive = false;
    }

    /**
     * Creates a new ResourceMetadata instance.
     *
     * @param creator id of the user that created a resource
     * @param creationDT datetime of resource creation
     * @param modId id of the user that last modified this resource
     * @param modDT datetime of the last modification to this resource
     * @param owner id of the owner of a resource
     * @param active bool representing whether or not this an active resource or not
     */
    public ResourceMetadata(Integer creator, LocalDateTime creationDT, Integer modId, LocalDateTime modDT, Integer owner, boolean active) {
        this(creator,  owner, active);
        this.resourceCreationDateTime = creationDT;
        this.lastModifierId = modId;
        this.lastModifiedDateTime = modDT;
    }

    public Integer getResourceCreatorId() {
        return resourceCreatorId;
    }

    public ResourceMetadata setResourceCreatorId(Integer resourceCreatorId) {
        this.resourceCreatorId = resourceCreatorId;
        return this;
    }

    public Integer getLastModifierId() {
        return lastModifierId;
    }

    public ResourceMetadata setLastModifierId(Integer lastModifierId) {
        this.lastModifierId = lastModifierId;
        return this;
    }

    public Integer getResourceOwnerId() {
        return resourceOwnerId;
    }

    public ResourceMetadata setResourceOwnerId(Integer resourceOwnerId) {
        this.resourceOwnerId = resourceOwnerId;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public ResourceMetadata setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getResourceCreationDateTime() {
        return resourceCreationDateTime.toString();
    }

    public ResourceMetadata setResourceCreationDateTime(LocalDateTime resourceCreationDateTime) {
        this.resourceCreationDateTime = resourceCreationDateTime;
        return this;
    }

    public String getLastModifiedDateTime() {
        return lastModifiedDateTime.toString();
    }

    public ResourceMetadata setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
        return this;
    }

}
