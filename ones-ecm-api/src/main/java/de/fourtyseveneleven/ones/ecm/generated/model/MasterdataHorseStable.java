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
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContact;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * MasterdataHorseStable
 */
@JsonPropertyOrder({
  MasterdataHorseStable.JSON_PROPERTY_UUID,
  MasterdataHorseStable.JSON_PROPERTY_MASTERDATA_HORSE_UUID,
  MasterdataHorseStable.JSON_PROPERTY_CREATION_TIMESTAMP,
  MasterdataHorseStable.JSON_PROPERTY_CREATION_USER_UUID,
  MasterdataHorseStable.JSON_PROPERTY_CHANGE_TIMESTAMP,
  MasterdataHorseStable.JSON_PROPERTY_CHANGE_USER_UUID,
  MasterdataHorseStable.JSON_PROPERTY_CHANGE_COUNTER,
  MasterdataHorseStable.JSON_PROPERTY_KIND,
  MasterdataHorseStable.JSON_PROPERTY_DISPLAY,
  MasterdataHorseStable.JSON_PROPERTY_ACCOMMODATION_FROM,
  MasterdataHorseStable.JSON_PROPERTY_ACCOMMODATION_UNTIL,
  MasterdataHorseStable.JSON_PROPERTY_REMARKS,
  MasterdataHorseStable.JSON_PROPERTY_CONTACT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-06-16T11:44:09.276003800+02:00[Europe/Berlin]")
public class MasterdataHorseStable {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_MASTERDATA_HORSE_UUID = "masterdataHorseUuid";
  private String masterdataHorseUuid;

  public static final String JSON_PROPERTY_CREATION_TIMESTAMP = "creationTimestamp";
  private OffsetDateTime creationTimestamp;

  public static final String JSON_PROPERTY_CREATION_USER_UUID = "creationUserUuid";
  private String creationUserUuid;

  public static final String JSON_PROPERTY_CHANGE_TIMESTAMP = "changeTimestamp";
  private OffsetDateTime changeTimestamp;

  public static final String JSON_PROPERTY_CHANGE_USER_UUID = "changeUserUuid";
  private String changeUserUuid;

  public static final String JSON_PROPERTY_CHANGE_COUNTER = "changeCounter";
  private Integer changeCounter;

  public static final String JSON_PROPERTY_KIND = "kind";
  private String kind;

  public static final String JSON_PROPERTY_DISPLAY = "display";
  private String display;

  public static final String JSON_PROPERTY_ACCOMMODATION_FROM = "accommodationFrom";
  private OffsetDateTime accommodationFrom;

  public static final String JSON_PROPERTY_ACCOMMODATION_UNTIL = "accommodationUntil";
  private OffsetDateTime accommodationUntil;

  public static final String JSON_PROPERTY_REMARKS = "remarks";
  private String remarks;

  public static final String JSON_PROPERTY_CONTACT = "contact";
  private MasterdataContact contact;


  public MasterdataHorseStable uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUuid() {
    return uuid;
  }


  @JsonProperty(JSON_PROPERTY_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public MasterdataHorseStable masterdataHorseUuid(String masterdataHorseUuid) {
    this.masterdataHorseUuid = masterdataHorseUuid;
    return this;
  }

   /**
   * Get masterdataHorseUuid
   * @return masterdataHorseUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MASTERDATA_HORSE_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMasterdataHorseUuid() {
    return masterdataHorseUuid;
  }


  @JsonProperty(JSON_PROPERTY_MASTERDATA_HORSE_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMasterdataHorseUuid(String masterdataHorseUuid) {
    this.masterdataHorseUuid = masterdataHorseUuid;
  }


  public MasterdataHorseStable creationTimestamp(OffsetDateTime creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
    return this;
  }

   /**
   * Get creationTimestamp
   * @return creationTimestamp
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CREATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getCreationTimestamp() {
    return creationTimestamp;
  }


  @JsonProperty(JSON_PROPERTY_CREATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreationTimestamp(OffsetDateTime creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
  }


  public MasterdataHorseStable creationUserUuid(String creationUserUuid) {
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


  @JsonProperty(JSON_PROPERTY_CREATION_USER_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreationUserUuid(String creationUserUuid) {
    this.creationUserUuid = creationUserUuid;
  }


  public MasterdataHorseStable changeTimestamp(OffsetDateTime changeTimestamp) {
    this.changeTimestamp = changeTimestamp;
    return this;
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


  @JsonProperty(JSON_PROPERTY_CHANGE_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChangeTimestamp(OffsetDateTime changeTimestamp) {
    this.changeTimestamp = changeTimestamp;
  }


  public MasterdataHorseStable changeUserUuid(String changeUserUuid) {
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


  @JsonProperty(JSON_PROPERTY_CHANGE_USER_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChangeUserUuid(String changeUserUuid) {
    this.changeUserUuid = changeUserUuid;
  }


  public MasterdataHorseStable changeCounter(Integer changeCounter) {
    this.changeCounter = changeCounter;
    return this;
  }

   /**
   * Get changeCounter
   * @return changeCounter
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CHANGE_COUNTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getChangeCounter() {
    return changeCounter;
  }


  @JsonProperty(JSON_PROPERTY_CHANGE_COUNTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChangeCounter(Integer changeCounter) {
    this.changeCounter = changeCounter;
  }


  public MasterdataHorseStable kind(String kind) {
    this.kind = kind;
    return this;
  }

   /**
   * Get kind
   * @return kind
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKind(String kind) {
    this.kind = kind;
  }


  public MasterdataHorseStable display(String display) {
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


  @JsonProperty(JSON_PROPERTY_DISPLAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplay(String display) {
    this.display = display;
  }


  public MasterdataHorseStable accommodationFrom(OffsetDateTime accommodationFrom) {
    this.accommodationFrom = accommodationFrom;
    return this;
  }

   /**
   * Get accommodationFrom
   * @return accommodationFrom
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACCOMMODATION_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getAccommodationFrom() {
    return accommodationFrom;
  }


  @JsonProperty(JSON_PROPERTY_ACCOMMODATION_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccommodationFrom(OffsetDateTime accommodationFrom) {
    this.accommodationFrom = accommodationFrom;
  }


  public MasterdataHorseStable accommodationUntil(OffsetDateTime accommodationUntil) {
    this.accommodationUntil = accommodationUntil;
    return this;
  }

   /**
   * Get accommodationUntil
   * @return accommodationUntil
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACCOMMODATION_UNTIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getAccommodationUntil() {
    return accommodationUntil;
  }


  @JsonProperty(JSON_PROPERTY_ACCOMMODATION_UNTIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccommodationUntil(OffsetDateTime accommodationUntil) {
    this.accommodationUntil = accommodationUntil;
  }


  public MasterdataHorseStable remarks(String remarks) {
    this.remarks = remarks;
    return this;
  }

   /**
   * Get remarks
   * @return remarks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_REMARKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRemarks() {
    return remarks;
  }


  @JsonProperty(JSON_PROPERTY_REMARKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public MasterdataHorseStable contact(MasterdataContact contact) {
    this.contact = contact;
    return this;
  }

   /**
   * Get contact
   * @return contact
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MasterdataContact getContact() {
    return contact;
  }


  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContact(MasterdataContact contact) {
    this.contact = contact;
  }


  /**
   * Return true if this MasterdataHorseStable object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MasterdataHorseStable masterdataHorseStable = (MasterdataHorseStable) o;
    return Objects.equals(this.uuid, masterdataHorseStable.uuid) &&
        Objects.equals(this.masterdataHorseUuid, masterdataHorseStable.masterdataHorseUuid) &&
        Objects.equals(this.creationTimestamp, masterdataHorseStable.creationTimestamp) &&
        Objects.equals(this.creationUserUuid, masterdataHorseStable.creationUserUuid) &&
        Objects.equals(this.changeTimestamp, masterdataHorseStable.changeTimestamp) &&
        Objects.equals(this.changeUserUuid, masterdataHorseStable.changeUserUuid) &&
        Objects.equals(this.changeCounter, masterdataHorseStable.changeCounter) &&
        Objects.equals(this.kind, masterdataHorseStable.kind) &&
        Objects.equals(this.display, masterdataHorseStable.display) &&
        Objects.equals(this.accommodationFrom, masterdataHorseStable.accommodationFrom) &&
        Objects.equals(this.accommodationUntil, masterdataHorseStable.accommodationUntil) &&
        Objects.equals(this.remarks, masterdataHorseStable.remarks) &&
        Objects.equals(this.contact, masterdataHorseStable.contact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, masterdataHorseUuid, creationTimestamp, creationUserUuid, changeTimestamp, changeUserUuid, changeCounter, kind, display, accommodationFrom, accommodationUntil, remarks, contact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MasterdataHorseStable {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    masterdataHorseUuid: ").append(toIndentedString(masterdataHorseUuid)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    creationUserUuid: ").append(toIndentedString(creationUserUuid)).append("\n");
    sb.append("    changeTimestamp: ").append(toIndentedString(changeTimestamp)).append("\n");
    sb.append("    changeUserUuid: ").append(toIndentedString(changeUserUuid)).append("\n");
    sb.append("    changeCounter: ").append(toIndentedString(changeCounter)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
    sb.append("    accommodationFrom: ").append(toIndentedString(accommodationFrom)).append("\n");
    sb.append("    accommodationUntil: ").append(toIndentedString(accommodationUntil)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
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

