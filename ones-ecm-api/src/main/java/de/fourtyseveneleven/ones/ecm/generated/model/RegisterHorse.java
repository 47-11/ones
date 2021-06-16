/*
 * vdd4ones
 * Rest-Interface for ONES
 *
 * The version of the OpenAPI document: 1.0a
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.fourtyseveneleven.ones.ecm.generated.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContact;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RegisterHorse
 */
@JsonPropertyOrder({
  RegisterHorse.JSON_PROPERTY_NAME,
  RegisterHorse.JSON_PROPERTY_PASSPORT_ID,
  RegisterHorse.JSON_PROPERTY_BREED,
  RegisterHorse.JSON_PROPERTY_GENDER,
  RegisterHorse.JSON_PROPERTY_COLOR,
  RegisterHorse.JSON_PROPERTY_YEAR_OF_BIRTH,
  RegisterHorse.JSON_PROPERTY_STICK_SIZE,
  RegisterHorse.JSON_PROPERTY_OWNER,
  RegisterHorse.JSON_PROPERTY_STABLE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-06-16T11:44:09.276003800+02:00[Europe/Berlin]")
public class RegisterHorse {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_PASSPORT_ID = "passportId";
  private String passportId;

  public static final String JSON_PROPERTY_BREED = "breed";
  private String breed;

  public static final String JSON_PROPERTY_GENDER = "gender";
  private String gender;

  public static final String JSON_PROPERTY_COLOR = "color";
  private String color;

  public static final String JSON_PROPERTY_YEAR_OF_BIRTH = "yearOfBirth";
  private Integer yearOfBirth;

  public static final String JSON_PROPERTY_STICK_SIZE = "stickSize";
  private Integer stickSize;

  public static final String JSON_PROPERTY_OWNER = "owner";
  private RegisterContact owner;

  public static final String JSON_PROPERTY_STABLE = "stable";
  private RegisterContact stable;


  public RegisterHorse name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }


  public RegisterHorse passportId(String passportId) {
    this.passportId = passportId;
    return this;
  }

   /**
   * Get passportId
   * @return passportId
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PASSPORT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPassportId() {
    return passportId;
  }


  @JsonProperty(JSON_PROPERTY_PASSPORT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPassportId(String passportId) {
    this.passportId = passportId;
  }


  public RegisterHorse breed(String breed) {
    this.breed = breed;
    return this;
  }

   /**
   * Get breed
   * @return breed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BREED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBreed() {
    return breed;
  }


  @JsonProperty(JSON_PROPERTY_BREED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBreed(String breed) {
    this.breed = breed;
  }


  public RegisterHorse gender(String gender) {
    this.gender = gender;
    return this;
  }

   /**
   * Get gender
   * @return gender
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_GENDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGender() {
    return gender;
  }


  @JsonProperty(JSON_PROPERTY_GENDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGender(String gender) {
    this.gender = gender;
  }


  public RegisterHorse color(String color) {
    this.color = color;
    return this;
  }

   /**
   * Get color
   * @return color
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COLOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getColor() {
    return color;
  }


  @JsonProperty(JSON_PROPERTY_COLOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setColor(String color) {
    this.color = color;
  }


  public RegisterHorse yearOfBirth(Integer yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
    return this;
  }

   /**
   * Get yearOfBirth
   * @return yearOfBirth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_YEAR_OF_BIRTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getYearOfBirth() {
    return yearOfBirth;
  }


  @JsonProperty(JSON_PROPERTY_YEAR_OF_BIRTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setYearOfBirth(Integer yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }


  public RegisterHorse stickSize(Integer stickSize) {
    this.stickSize = stickSize;
    return this;
  }

   /**
   * Get stickSize
   * @return stickSize
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STICK_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getStickSize() {
    return stickSize;
  }


  @JsonProperty(JSON_PROPERTY_STICK_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStickSize(Integer stickSize) {
    this.stickSize = stickSize;
  }


  public RegisterHorse owner(RegisterContact owner) {
    this.owner = owner;
    return this;
  }

   /**
   * Get owner
   * @return owner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OWNER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RegisterContact getOwner() {
    return owner;
  }


  @JsonProperty(JSON_PROPERTY_OWNER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOwner(RegisterContact owner) {
    this.owner = owner;
  }


  public RegisterHorse stable(RegisterContact stable) {
    this.stable = stable;
    return this;
  }

   /**
   * Get stable
   * @return stable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RegisterContact getStable() {
    return stable;
  }


  @JsonProperty(JSON_PROPERTY_STABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStable(RegisterContact stable) {
    this.stable = stable;
  }


  /**
   * Return true if this registerHorse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterHorse registerHorse = (RegisterHorse) o;
    return Objects.equals(this.name, registerHorse.name) &&
        Objects.equals(this.passportId, registerHorse.passportId) &&
        Objects.equals(this.breed, registerHorse.breed) &&
        Objects.equals(this.gender, registerHorse.gender) &&
        Objects.equals(this.color, registerHorse.color) &&
        Objects.equals(this.yearOfBirth, registerHorse.yearOfBirth) &&
        Objects.equals(this.stickSize, registerHorse.stickSize) &&
        Objects.equals(this.owner, registerHorse.owner) &&
        Objects.equals(this.stable, registerHorse.stable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, passportId, breed, gender, color, yearOfBirth, stickSize, owner, stable);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterHorse {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    passportId: ").append(toIndentedString(passportId)).append("\n");
    sb.append("    breed: ").append(toIndentedString(breed)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    yearOfBirth: ").append(toIndentedString(yearOfBirth)).append("\n");
    sb.append("    stickSize: ").append(toIndentedString(stickSize)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    stable: ").append(toIndentedString(stable)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

