package de.fourtyseveneleven.ones.common.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractBaseEntity implements BaseEntity {

    @Serial
    private static final long serialVersionUID = -1815177948766945289L;

    private long id;
    private int version;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime lastModified = LocalDateTime.now();

    protected abstract boolean canEqual(Object other);

    protected long doGetId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    @Version
    @NotNull
    public int getVersion() {
        return version;
    }

    @Override
    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    @NotNull
    @Column(updatable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    @NotNull
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    @Override
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public final int hashCode() {

        return Long.hashCode(doGetId());
    }

    @Override
    public final boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractBaseEntity other)) {
            return false;
        }
        if (!other.canEqual(this)) {
            return false;
        }
        return getId() == other.getId();
    }

    @PrePersist
    protected void setCreatedAndLastModifiedOnCreate() {

        final LocalDateTime now = LocalDateTime.now();
        created = now;
        lastModified = now;
    }

    @PreUpdate
    protected void setLastModifiedOnUpdate() {

        lastModified = LocalDateTime.now();
    }
}
