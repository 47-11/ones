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
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContactLegal;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContactNatural;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RegisteredHorse
 */
@JsonPropertyOrder({
  RegisteredHorse.JSON_PROPERTY_UUID,
  RegisteredHorse.JSON_PROPERTY_NAME,
  RegisteredHorse.JSON_PROPERTY_PASSPORT_ID,
  RegisteredHorse.JSON_PROPERTY_FEI_PASSPORT_ID,
  RegisteredHorse.JSON_PROPERTY_FN_PASSPORT_ID,
  RegisteredHorse.JSON_PROPERTY_CHIP_ID,
  RegisteredHorse.JSON_PROPERTY_BREED,
  RegisteredHorse.JSON_PROPERTY_GENDER,
  RegisteredHorse.JSON_PROPERTY_COLOR,
  RegisteredHorse.JSON_PROPERTY_YEAR_OF_BIRTH,
  RegisteredHorse.JSON_PROPERTY_STICK_SIZE,
  RegisteredHorse.JSON_PROPERTY_OWNER,
  RegisteredHorse.JSON_PROPERTY_STABLE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-30T10:23:10.438880610+01:00[Europe/Berlin]")
public class RegisteredHorse {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_PASSPORT_ID = "passportId";
  private String passportId;

  public static final String JSON_PROPERTY_FEI_PASSPORT_ID = "feiPassportId";
  private String feiPassportId;

  public static final String JSON_PROPERTY_FN_PASSPORT_ID = "fnPassportId";
  private String fnPassportId;

  public static final String JSON_PROPERTY_CHIP_ID = "chipId";
  private String chipId;

  public static final String JSON_PROPERTY_BREED = "breed";
  private String breed;

  /**
   * Gets or Sets gender
   */
  public enum GenderEnum {
    M("M"),
    
    S("S"),
    
    G("G");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GenderEnum fromValue(String value) {
      for (GenderEnum b : GenderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_GENDER = "gender";
  private GenderEnum gender;

  public static final String JSON_PROPERTY_COLOR = "color";
  private String color;

  public static final String JSON_PROPERTY_YEAR_OF_BIRTH = "yearOfBirth";
  private Integer yearOfBirth;

  public static final String JSON_PROPERTY_STICK_SIZE = "stickSize";
  private Integer stickSize;

  public static final String JSON_PROPERTY_OWNER = "owner";
  private RegisterContactNatural owner;

  public static final String JSON_PROPERTY_STABLE = "stable";
  private RegisterContactLegal stable;


  public RegisteredHorse uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUuid() {
    return uuid;
  }


  @JsonProperty(JSON_PROPERTY_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public RegisteredHorse name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nonnull
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


  public RegisteredHorse passportId(String passportId) {
    this.passportId = passportId;
    return this;
  }

   /**
   * Get passportId
   * @return passportId
  **/
  @javax.annotation.Nonnull
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


  public RegisteredHorse feiPassportId(String feiPassportId) {
    this.feiPassportId = feiPassportId;
    return this;
  }

   /**
   * Get feiPassportId
   * @return feiPassportId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FEI_PASSPORT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFeiPassportId() {
    return feiPassportId;
  }


  @JsonProperty(JSON_PROPERTY_FEI_PASSPORT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFeiPassportId(String feiPassportId) {
    this.feiPassportId = feiPassportId;
  }


  public RegisteredHorse fnPassportId(String fnPassportId) {
    this.fnPassportId = fnPassportId;
    return this;
  }

   /**
   * Get fnPassportId
   * @return fnPassportId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FN_PASSPORT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFnPassportId() {
    return fnPassportId;
  }


  @JsonProperty(JSON_PROPERTY_FN_PASSPORT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFnPassportId(String fnPassportId) {
    this.fnPassportId = fnPassportId;
  }


  public RegisteredHorse chipId(String chipId) {
    this.chipId = chipId;
    return this;
  }

   /**
   * Get chipId
   * @return chipId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CHIP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getChipId() {
    return chipId;
  }


  @JsonProperty(JSON_PROPERTY_CHIP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChipId(String chipId) {
    this.chipId = chipId;
  }


  public RegisteredHorse breed(String breed) {
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


  public RegisteredHorse gender(GenderEnum gender) {
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

  public GenderEnum getGender() {
    return gender;
  }


  @JsonProperty(JSON_PROPERTY_GENDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }


  public RegisteredHorse color(String color) {
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


  public RegisteredHorse yearOfBirth(Integer yearOfBirth) {
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


  public RegisteredHorse stickSize(Integer stickSize) {
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


  public RegisteredHorse owner(RegisterContactNatural owner) {
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

  public RegisterContactNatural getOwner() {
    return owner;
  }


  @JsonProperty(JSON_PROPERTY_OWNER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOwner(RegisterContactNatural owner) {
    this.owner = owner;
  }


  public RegisteredHorse stable(RegisterContactLegal stable) {
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

  public RegisterContactLegal getStable() {
    return stable;
  }


  @JsonProperty(JSON_PROPERTY_STABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStable(RegisterContactLegal stable) {
    this.stable = stable;
  }


  /**
   * Return true if this registeredHorse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisteredHorse registeredHorse = (RegisteredHorse) o;
    return Objects.equals(this.uuid, registeredHorse.uuid) &&
        Objects.equals(this.name, registeredHorse.name) &&
        Objects.equals(this.passportId, registeredHorse.passportId) &&
        Objects.equals(this.feiPassportId, registeredHorse.feiPassportId) &&
        Objects.equals(this.fnPassportId, registeredHorse.fnPassportId) &&
        Objects.equals(this.chipId, registeredHorse.chipId) &&
        Objects.equals(this.breed, registeredHorse.breed) &&
        Objects.equals(this.gender, registeredHorse.gender) &&
        Objects.equals(this.color, registeredHorse.color) &&
        Objects.equals(this.yearOfBirth, registeredHorse.yearOfBirth) &&
        Objects.equals(this.stickSize, registeredHorse.stickSize) &&
        Objects.equals(this.owner, registeredHorse.owner) &&
        Objects.equals(this.stable, registeredHorse.stable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, passportId, feiPassportId, fnPassportId, chipId, breed, gender, color, yearOfBirth, stickSize, owner, stable);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisteredHorse {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    passportId: ").append(toIndentedString(passportId)).append("\n");
    sb.append("    feiPassportId: ").append(toIndentedString(feiPassportId)).append("\n");
    sb.append("    fnPassportId: ").append(toIndentedString(fnPassportId)).append("\n");
    sb.append("    chipId: ").append(toIndentedString(chipId)).append("\n");
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
