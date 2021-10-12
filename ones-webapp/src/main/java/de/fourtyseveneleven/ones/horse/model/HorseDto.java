package de.fourtyseveneleven.ones.horse.model;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;

import java.util.UUID;

public class HorseDto {

    private UUID uuid;

    private String passportNumber;
    private String chipNumber;

    private String name;
    private Gender gender;
    private String breed;
    private String color;
    private short yearOfBirth;

    private AddressDto stableAddress;
    private PersonDto owner;

    public HorseDto() {
    }

    public HorseDto(UUID uuid, String passportNumber, String chipNumber, String name, Gender gender, String breed, String color, short yearOfBirth, AddressDto stableAddress, PersonDto owner) {
        this.uuid = uuid;
        this.passportNumber = passportNumber;
        this.chipNumber = chipNumber;
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.color = color;
        this.yearOfBirth = yearOfBirth;
        this.stableAddress = stableAddress;
        this.owner = owner;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
