package de.fourtyseveneleven.ones.horse.model;

import java.util.Objects;
import java.util.UUID;

public class SimpleHorseDto {

    private UUID uuid;
    private String name;

    public SimpleHorseDto(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleHorseDto that = (SimpleHorseDto) o;
        return uuid.equals(that.uuid) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name);
    }
}
