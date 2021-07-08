package de.fourtyseveneleven.ones.user.model.dto;

import de.fourtyseveneleven.ones.common.model.dto.PersonDto;

public class UserDto extends PersonDto {

    private boolean isPersonalDataKnown;

    public UserDto() {}

    public UserDto(String emailAddress) {
        
        setEmailAddress(emailAddress);
        setIsPersonalDataKnown(false);
    }

    public boolean getIsPersonalDataKnown() {
        return isPersonalDataKnown;
    }

    public void setIsPersonalDataKnown(boolean personalDataKnown) {
        isPersonalDataKnown = personalDataKnown;
    }
}
