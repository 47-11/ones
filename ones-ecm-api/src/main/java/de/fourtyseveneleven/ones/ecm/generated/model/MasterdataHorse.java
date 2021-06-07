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
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataHorseOwner;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataHorseStable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * MasterdataHorse
 */
@JsonPropertyOrder({
  MasterdataHorse.JSON_PROPERTY_UUID,
  MasterdataHorse.JSON_PROPERTY_CREATION_TIMESTAMP,
  MasterdataHorse.JSON_PROPERTY_CREATION_USER_UUID,
  MasterdataHorse.JSON_PROPERTY_CHANGE_TIMESTAMP,
  MasterdataHorse.JSON_PROPERTY_CHANGE_USER_UUID,
  MasterdataHorse.JSON_PROPERTY_DISPLAY,
  MasterdataHorse.JSON_PROPERTY_NAME,
  MasterdataHorse.JSON_PROPERTY_PASSPORT_ID,
  MasterdataHorse.JSON_PROPERTY_BREED,
  MasterdataHorse.JSON_PROPERTY_GENDER,
  MasterdataHorse.JSON_PROPERTY_YEAR_OF_BIRTH,
  MasterdataHorse.JSON_PROPERTY_STICK_SIZE,
  MasterdataHorse.JSON_PROPERTY_COLOR,
  MasterdataHorse.JSON_PROPERTY_OWNERSX,
  MasterdataHorse.JSON_PROPERTY_STABLES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-30T14:01:51.063115102+02:00[Europe/Berlin]")
public class MasterdataHorse {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_CREATION_TIMESTAMP = "creationTimestamp";
  private OffsetDateTime creationTimestamp;

  public static final String JSON_PROPERTY_CREATION_USER_UUID = "creationUserUuid";
  private String creationUserUuid;

  public static final String JSON_PROPERTY_CHANGE_TIMESTAMP = "changeTimestamp";
  private OffsetDateTime changeTimestamp;

  public static final String JSON_PROPERTY_CHANGE_USER_UUID = "changeUserUuid";
  private String changeUserUuid;

  public static final String JSON_PROPERTY_DISPLAY = "display";
  private String display;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_PASSPORT_ID = "passportId";
  private String passportId;

  public static final String JSON_PROPERTY_BREED = "breed";
  private String breed;

  public static final String JSON_PROPERTY_GENDER = "gender";
  private String gender;

  public static final String JSON_PROPERTY_YEAR_OF_BIRTH = "yearOfBirth";
  private Integer yearOfBirth;

  public static final String JSON_PROPERTY_STICK_SIZE = "stickSize";
  private Integer stickSize;

  public static final String JSON_PROPERTY_COLOR = "color";
  private String color;

  public static final String JSON_PROPERTY_OWNERSX = "_ownersx";
  private List<MasterdataHorseOwner> ownersx = null;

  public static final String JSON_PROPERTY_STABLES = "_stables";
  private List<MasterdataHorseStable> stables = null;


  public MasterdataHorse uuid(String uuid) {
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


  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public MasterdataHorse creationTimestamp(OffsetDateTime creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
    return this;
  }

   /**
   * Get creationTimestamp
   * @return creationTimestamp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CREATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreationTimestamp() {
    return creationTimestamp;
  }


  public void setCreationTimestamp(OffsetDateTime creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
  }


  public MasterdataHorse creationUserUuid(String creationUserUuid) {
    this.creationUserUuid = creationUserUuid;
    return this;
  }

   /**
   * Get creationUserUuid
   * @return creationUserUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CREATION_USER_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCreationUserUuid() {
    return creationUserUuid;
  }


  public void setCreationUserUuid(String creationUserUuid) {
    this.creationUserUuid = creationUserUuid;
  }


   /**
   * Get changeTimestamp
   * @return changeTimestamp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CHANGE_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getChangeTimestamp() {
    return changeTimestamp;
  }




  public MasterdataHorse changeUserUuid(String changeUserUuid) {
    this.changeUserUuid = changeUserUuid;
    return this;
  }

   /**
   * Get changeUserUuid
   * @return changeUserUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CHANGE_USER_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getChangeUserUuid() {
    return changeUserUuid;
  }


  public void setChangeUserUuid(String changeUserUuid) {
    this.changeUserUuid = changeUserUuid;
  }


  public MasterdataHorse display(String display) {
    this.display = display;
    return this;
  }

   /**
   * Get display
   * @return display
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DISPLAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplay() {
    return display;
  }


  public void setDisplay(String display) {
    this.display = display;
  }


  public MasterdataHorse name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public MasterdataHorse passportId(String passportId) {
    this.passportId = passportId;
    return this;
  }

   /**
   * Get passportId
   * @return passportId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PASSPORT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPassportId() {
    return passportId;
  }


  public void setPassportId(String passportId) {
    this.passportId = passportId;
  }


  public MasterdataHorse breed(String breed) {
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


  public void setBreed(String breed) {
    this.breed = breed;
  }


  public MasterdataHorse gender(String gender) {
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


  public void setGender(String gender) {
    this.gender = gender;
  }


  public MasterdataHorse yearOfBirth(Integer yearOfBirth) {
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


  public void setYearOfBirth(Integer yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }


  public MasterdataHorse stickSize(Integer stickSize) {
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


  public void setStickSize(Integer stickSize) {
    this.stickSize = stickSize;
  }


  public MasterdataHorse color(String color) {
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


  public void setColor(String color) {
    this.color = color;
  }


  public MasterdataHorse ownersx(List<MasterdataHorseOwner> ownersx) {
    this.ownersx = ownersx;
    return this;
  }

  public MasterdataHorse addOwnersxItem(MasterdataHorseOwner ownersxItem) {
    if (this.ownersx == null) {
      this.ownersx = new ArrayList<>();
    }
    this.ownersx.add(ownersxItem);
    return this;
  }

   /**
   * Get ownersx
   * @return ownersx
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OWNERSX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<MasterdataHorseOwner> getOwnersx() {
    return ownersx;
  }


  public void setOwnersx(List<MasterdataHorseOwner> ownersx) {
    this.ownersx = ownersx;
  }


  public MasterdataHorse stables(List<MasterdataHorseStable> stables) {
    this.stables = stables;
    return this;
  }

  public MasterdataHorse addStablesItem(MasterdataHorseStable stablesItem) {
    if (this.stables == null) {
      this.stables = new ArrayList<>();
    }
    this.stables.add(stablesItem);
    return this;
  }

   /**
   * Get stables
   * @return stables
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STABLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<MasterdataHorseStable> getStables() {
    return stables;
  }


  public void setStables(List<MasterdataHorseStable> stables) {
    this.stables = stables;
  }


  /**
   * Return true if this MasterdataHorse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MasterdataHorse masterdataHorse = (MasterdataHorse) o;
    return Objects.equals(this.uuid, masterdataHorse.uuid) &&
        Objects.equals(this.creationTimestamp, masterdataHorse.creationTimestamp) &&
        Objects.equals(this.creationUserUuid, masterdataHorse.creationUserUuid) &&
        Objects.equals(this.changeTimestamp, masterdataHorse.changeTimestamp) &&
        Objects.equals(this.changeUserUuid, masterdataHorse.changeUserUuid) &&
        Objects.equals(this.display, masterdataHorse.display) &&
        Objects.equals(this.name, masterdataHorse.name) &&
        Objects.equals(this.passportId, masterdataHorse.passportId) &&
        Objects.equals(this.breed, masterdataHorse.breed) &&
        Objects.equals(this.gender, masterdataHorse.gender) &&
        Objects.equals(this.yearOfBirth, masterdataHorse.yearOfBirth) &&
        Objects.equals(this.stickSize, masterdataHorse.stickSize) &&
        Objects.equals(this.color, masterdataHorse.color) &&
        Objects.equals(this.ownersx, masterdataHorse.ownersx) &&
        Objects.equals(this.stables, masterdataHorse.stables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, creationTimestamp, creationUserUuid, changeTimestamp, changeUserUuid, display, name, passportId, breed, gender, yearOfBirth, stickSize, color, ownersx, stables);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MasterdataHorse {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    creationUserUuid: ").append(toIndentedString(creationUserUuid)).append("\n");
    sb.append("    changeTimestamp: ").append(toIndentedString(changeTimestamp)).append("\n");
    sb.append("    changeUserUuid: ").append(toIndentedString(changeUserUuid)).append("\n");
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    passportId: ").append(toIndentedString(passportId)).append("\n");
    sb.append("    breed: ").append(toIndentedString(breed)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    yearOfBirth: ").append(toIndentedString(yearOfBirth)).append("\n");
    sb.append("    stickSize: ").append(toIndentedString(stickSize)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    ownersx: ").append(toIndentedString(ownersx)).append("\n");
    sb.append("    stables: ").append(toIndentedString(stables)).append("\n");
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

