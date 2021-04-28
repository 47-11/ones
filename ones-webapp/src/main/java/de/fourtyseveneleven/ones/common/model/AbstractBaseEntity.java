package de.fourtyseveneleven.ones.common.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 6552323927493879022L;

    private long id = 0;
    private int version = 1;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime lastModified = LocalDateTime.now();

    protected abstract boolean canEqual(Object other);

    @Id
    @NotNull
    public abstract long getId();

    protected long doGetId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Version
    @NotNull
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @NotNull
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @NotNull
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public final int hashCode() {

        return Long.hashCode(getId());
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
}
