package de.fourtyseveneleven.ones.event.model.dto;

import de.fourtyseveneleven.ones.common.model.dto.GpsAddressDto;

public class EventAddressDto extends GpsAddressDto {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
