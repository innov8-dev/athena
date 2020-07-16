package dev.innov8.athena.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * An abstract representation of a Resource.
 *
 * @author Wezley Singleton (GitHub: wsingleton)
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Resource {

    /** A unique id string for this resource */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    /** System information related to this resource */
    @NotNull
    @Embedded
    protected ResourceMetadata metadata;

    public Resource() {
        super();
    }

    public Resource(ResourceMetadata metadata) {
        this.metadata = metadata;
    }

    public Resource(Integer id, ResourceMetadata metadata) {
        this(metadata);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Resource setId(Integer id) {
        this.id = id;
        return this;
    }

    public ResourceMetadata getMetadata() {
        return metadata;
    }

    public Resource setMetadata(ResourceMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

}
