package de.fourtyseveneleven.ones.horse.model;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;

import java.util.Objects;
import java.util.UUID;

public class FullHorseDto extends SimpleHorseDto {

    private String passportNumber;
    private String chipNumber;
    private String feiNumber;

    private Gender gender;
    private String breed;
    private String color;
    // In centimeters (cm)
    private short size;
    private short yearOfBirth;

    private AddressDto stableAddress;
    private PersonDto owner;

    public FullHorseDto(UUID uuid, String name, String passportNumber, String chipNumber, Gender gender, String breed, String color, short size, short yearOfBirth, AddressDto stableAddress, PersonDto owner) {
        super(uuid, name);

        this.passportNumber = passportNumber;
        this.chipNumber = chipNumber;
        this.gender = gender;
        this.breed = breed;
        this.color = color;
        this.size = size;
        this.yearOfBirth = yearOfBirth;
        this.stableAddress = stableAddress;
        this.owner = owner;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(String chipNumber) {
        this.chipNumber = chipNumber;
    }

    public String getFeiNumber() {
        return feiNumber;
    }

    public void setFeiNumber(String feiNumber) {
        this.feiNumber = feiNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(short yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public AddressDto getStableAddress() {
        return stableAddress;
    }

    public void setStableAddress(AddressDto stableAddress) {
        this.stableAddress = stableAddress;
    }

    public PersonDto getOwner() {
        return owner;
    }

    public void setOwner(PersonDto owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        FullHorseDto that = (FullHorseDto) o;
        return size == that.size
                && yearOfBirth == that.yearOfBirth
                && Objects.equals(passportNumber, that.passportNumber)
                && Objects.equals(chipNumber, that.chipNumber)
                && Objects.equals(feiNumber, that.feiNumber) && gender == that.gender
                && Objects.equals(breed, that.breed)
                && Objects.equals(color, that.color)
                && Objects.equals(stableAddress, that.stableAddress)
                && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passportNumber, chipNumber, feiNumber, gender, breed, color, size, yearOfBirth, stableAddress, owner);
    }
}
