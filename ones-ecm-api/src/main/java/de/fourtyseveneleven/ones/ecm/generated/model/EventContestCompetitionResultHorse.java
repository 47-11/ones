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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * EventContestCompetitionResultHorse
 */
@JsonPropertyOrder({
  EventContestCompetitionResultHorse.JSON_PROPERTY_UUID,
  EventContestCompetitionResultHorse.JSON_PROPERTY_CREATION_TIMESTAMP,
  EventContestCompetitionResultHorse.JSON_PROPERTY_CREATION_USER_UUID,
  EventContestCompetitionResultHorse.JSON_PROPERTY_CHANGE_TIMESTAMP,
  EventContestCompetitionResultHorse.JSON_PROPERTY_CHANGE_USER_UUID,
  EventContestCompetitionResultHorse.JSON_PROPERTY_CHANGE_COUNTER,
  EventContestCompetitionResultHorse.JSON_PROPERTY_CURRENT_STATE,
  EventContestCompetitionResultHorse.JSON_PROPERTY_MASTERDATA_HORSE_UUID,
  EventContestCompetitionResultHorse.JSON_PROPERTY_DESCRIPTION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-14T11:16:59.043131602+01:00[Europe/Berlin]")
public class EventContestCompetitionResultHorse {
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

  public static final String JSON_PROPERTY_CHANGE_COUNTER = "changeCounter";
  private Integer changeCounter;

  public static final String JSON_PROPERTY_CURRENT_STATE = "currentState";
  private Integer currentState;

  public static final String JSON_PROPERTY_MASTERDATA_HORSE_UUID = "masterdataHorseUuid";
  private String masterdataHorseUuid;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;


  public EventContestCompetitionResultHorse uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @javax.annotation.Nonnull
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


  public EventContestCompetitionResultHorse creationTimestamp(OffsetDateTime creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
    return this;
  }

   /**
   * Get creationTimestamp
   * @return creationTimestamp
  **/
  @javax.annotation.Nonnull
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


  public EventContestCompetitionResultHorse creationUserUuid(String creationUserUuid) {
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


  public EventContestCompetitionResultHorse changeTimestamp(OffsetDateTime changeTimestamp) {
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


  public EventContestCompetitionResultHorse changeUserUuid(String changeUserUuid) {
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


  public EventContestCompetitionResultHorse changeCounter(Integer changeCounter) {
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


  public EventContestCompetitionResultHorse currentState(Integer currentState) {
    this.currentState = currentState;
    return this;
  }

   /**
   * Get currentState
   * @return currentState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCurrentState() {
    return currentState;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrentState(Integer currentState) {
    this.currentState = currentState;
  }


  public EventContestCompetitionResultHorse masterdataHorseUuid(String masterdataHorseUuid) {
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


  public EventContestCompetitionResultHorse description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }


  /**
   * Return true if this EventContestCompetitionResultHorse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventContestCompetitionResultHorse eventContestCompetitionResultHorse = (EventContestCompetitionResultHorse) o;
    return Objects.equals(this.uuid, eventContestCompetitionResultHorse.uuid) &&
        Objects.equals(this.creationTimestamp, eventContestCompetitionResultHorse.creationTimestamp) &&
        Objects.equals(this.creationUserUuid, eventContestCompetitionResultHorse.creationUserUuid) &&
        Objects.equals(this.changeTimestamp, eventContestCompetitionResultHorse.changeTimestamp) &&
        Objects.equals(this.changeUserUuid, eventContestCompetitionResultHorse.changeUserUuid) &&
        Objects.equals(this.changeCounter, eventContestCompetitionResultHorse.changeCounter) &&
        Objects.equals(this.currentState, eventContestCompetitionResultHorse.currentState) &&
        Objects.equals(this.masterdataHorseUuid, eventContestCompetitionResultHorse.masterdataHorseUuid) &&
        Objects.equals(this.description, eventContestCompetitionResultHorse.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, creationTimestamp, creationUserUuid, changeTimestamp, changeUserUuid, changeCounter, currentState, masterdataHorseUuid, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventContestCompetitionResultHorse {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    creationUserUuid: ").append(toIndentedString(creationUserUuid)).append("\n");
    sb.append("    changeTimestamp: ").append(toIndentedString(changeTimestamp)).append("\n");
    sb.append("    changeUserUuid: ").append(toIndentedString(changeUserUuid)).append("\n");
    sb.append("    changeCounter: ").append(toIndentedString(changeCounter)).append("\n");
    sb.append("    currentState: ").append(toIndentedString(currentState)).append("\n");
    sb.append("    masterdataHorseUuid: ").append(toIndentedString(masterdataHorseUuid)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

