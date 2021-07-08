package de.fourtyseveneleven.ones.user.model.dto;

public class RegistrationDto extends AbstractEmailPasswordDto{

    private Integer vddMemberNumber;

    public Integer getVddMemberNumber() {
        return vddMemberNumber;
    }

    public void setVddMemberNumber(Integer vddMemberNumber) {
        this.vddMemberNumber = vddMemberNumber;
    }
}
