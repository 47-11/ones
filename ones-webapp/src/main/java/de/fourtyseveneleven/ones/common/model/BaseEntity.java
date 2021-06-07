package de.fourtyseveneleven.ones.common.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface BaseEntity extends Serializable {

    long getId();

    void setId(long id);

    int getVersion();

    void setVersion(int version);

    LocalDateTime getCreated();

    void setCreated(LocalDateTime created);

    LocalDateTime getLastModified();

    void setLastModified(LocalDateTime lastModified);

}
