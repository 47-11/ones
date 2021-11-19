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
 * EventContestCompetitionStagePlain
 */
@JsonPropertyOrder({
  EventContestCompetitionStagePlain.JSON_PROPERTY_UUID,
  EventContestCompetitionStagePlain.JSON_PROPERTY_CREATION_TIMESTAMP,
  EventContestCompetitionStagePlain.JSON_PROPERTY_CREATION_USER_UUID,
  EventContestCompetitionStagePlain.JSON_PROPERTY_CHANGE_TIMESTAMP,
  EventContestCompetitionStagePlain.JSON_PROPERTY_CHANGE_USER_UUID,
  EventContestCompetitionStagePlain.JSON_PROPERTY_CHANGE_COUNTER,
  EventContestCompetitionStagePlain.JSON_PROPERTY_CURRENT_STATE,
  EventContestCompetitionStagePlain.JSON_PROPERTY_TITLE,
  EventContestCompetitionStagePlain.JSON_PROPERTY_KIND,
  EventContestCompetitionStagePlain.JSON_PROPERTY_BEGINNING,
  EventContestCompetitionStagePlain.JSON_PROPERTY_ENDING,
  EventContestCompetitionStagePlain.JSON_PROPERTY_RAISE_LENGTH,
  EventContestCompetitionStagePlain.JSON_PROPERTY_MINUTES_MAXIMUM,
  EventContestCompetitionStagePlain.JSON_PROPERTY_MINUTES_ALLOWED,
  EventContestCompetitionStagePlain.JSON_PROPERTY_PENALTY_POINTS_TIMEOUT,
  EventContestCompetitionStagePlain.JSON_PROPERTY_PENALTY_POINTS_TIME_UNDERRUN,
  EventContestCompetitionStagePlain.JSON_PROPERTY_PENALTY_POINTS_AT_PULSE_RATE_OF,
  EventContestCompetitionStagePlain.JSON_PROPERTY_PENALTY_POINTS_PULSE_RATE_EXCEEDED,
  EventContestCompetitionStagePlain.JSON_PROPERTY_BREAKS_TOTAL_NUMBERS,
  EventContestCompetitionStagePlain.JSON_PROPERTY_BREAKS_TOTAL_MINUTES,
  EventContestCompetitionStagePlain.JSON_PROPERTY_RESPONSIBLE_VETERINARIAN_UUID
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-19T17:51:39.567128100+01:00[Europe/Berlin]")
public class EventContestCompetitionStagePlain {
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

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public static final String JSON_PROPERTY_KIND = "kind";
  private String kind;

  public static final String JSON_PROPERTY_BEGINNING = "beginning";
  private OffsetDateTime beginning;

  public static final String JSON_PROPERTY_ENDING = "ending";
  private OffsetDateTime ending;

  public static final String JSON_PROPERTY_RAISE_LENGTH = "raiseLength";
  private Integer raiseLength;

  public static final String JSON_PROPERTY_MINUTES_MAXIMUM = "minutesMaximum";
  private Integer minutesMaximum;

  public static final String JSON_PROPERTY_MINUTES_ALLOWED = "minutesAllowed";
  private Integer minutesAllowed;

  public static final String JSON_PROPERTY_PENALTY_POINTS_TIMEOUT = "penaltyPointsTimeout";
  private Integer penaltyPointsTimeout;

  public static final String JSON_PROPERTY_PENALTY_POINTS_TIME_UNDERRUN = "penaltyPointsTimeUnderrun";
  private Integer penaltyPointsTimeUnderrun;

  public static final String JSON_PROPERTY_PENALTY_POINTS_AT_PULSE_RATE_OF = "penaltyPointsAtPulseRateOf";
  private Integer penaltyPointsAtPulseRateOf;

  public static final String JSON_PROPERTY_PENALTY_POINTS_PULSE_RATE_EXCEEDED = "penaltyPointsPulseRateExceeded";
  private Integer penaltyPointsPulseRateExceeded;

  public static final String JSON_PROPERTY_BREAKS_TOTAL_NUMBERS = "breaksTotalNumbers";
  private Integer breaksTotalNumbers;

  public static final String JSON_PROPERTY_BREAKS_TOTAL_MINUTES = "breaksTotalMinutes";
  private Integer breaksTotalMinutes;

  public static final String JSON_PROPERTY_RESPONSIBLE_VETERINARIAN_UUID = "responsibleVeterinarianUuid";
  private String responsibleVeterinarianUuid;


  public EventContestCompetitionStagePlain uuid(String uuid) {
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


  public EventContestCompetitionStagePlain creationTimestamp(OffsetDateTime creationTimestamp) {
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


  public EventContestCompetitionStagePlain creationUserUuid(String creationUserUuid) {
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


  public EventContestCompetitionStagePlain changeTimestamp(OffsetDateTime changeTimestamp) {
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


  public EventContestCompetitionStagePlain changeUserUuid(String changeUserUuid) {
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


  public EventContestCompetitionStagePlain changeCounter(Integer changeCounter) {
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


  public EventContestCompetitionStagePlain currentState(Integer currentState) {
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


  public EventContestCompetitionStagePlain title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitle() {
    return title;
  }


  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitle(String title) {
    this.title = title;
  }


  public EventContestCompetitionStagePlain kind(String kind) {
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


  public EventContestCompetitionStagePlain beginning(OffsetDateTime beginning) {
    this.beginning = beginning;
    return this;
  }

   /**
   * Get beginning
   * @return beginning
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BEGINNING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getBeginning() {
    return beginning;
  }


  @JsonProperty(JSON_PROPERTY_BEGINNING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBeginning(OffsetDateTime beginning) {
    this.beginning = beginning;
  }


  public EventContestCompetitionStagePlain ending(OffsetDateTime ending) {
    this.ending = ending;
    return this;
  }

   /**
   * Get ending
   * @return ending
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ENDING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getEnding() {
    return ending;
  }


  @JsonProperty(JSON_PROPERTY_ENDING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnding(OffsetDateTime ending) {
    this.ending = ending;
  }


  public EventContestCompetitionStagePlain raiseLength(Integer raiseLength) {
    this.raiseLength = raiseLength;
    return this;
  }

   /**
   * Get raiseLength
   * @return raiseLength
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RAISE_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRaiseLength() {
    return raiseLength;
  }


  @JsonProperty(JSON_PROPERTY_RAISE_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRaiseLength(Integer raiseLength) {
    this.raiseLength = raiseLength;
  }


  public EventContestCompetitionStagePlain minutesMaximum(Integer minutesMaximum) {
    this.minutesMaximum = minutesMaximum;
    return this;
  }

   /**
   * Get minutesMaximum
   * @return minutesMaximum
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MINUTES_MAXIMUM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMinutesMaximum() {
    return minutesMaximum;
  }


  @JsonProperty(JSON_PROPERTY_MINUTES_MAXIMUM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMinutesMaximum(Integer minutesMaximum) {
    this.minutesMaximum = minutesMaximum;
  }


  public EventContestCompetitionStagePlain minutesAllowed(Integer minutesAllowed) {
    this.minutesAllowed = minutesAllowed;
    return this;
  }

   /**
   * Get minutesAllowed
   * @return minutesAllowed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MINUTES_ALLOWED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMinutesAllowed() {
    return minutesAllowed;
  }


  @JsonProperty(JSON_PROPERTY_MINUTES_ALLOWED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMinutesAllowed(Integer minutesAllowed) {
    this.minutesAllowed = minutesAllowed;
  }


  public EventContestCompetitionStagePlain penaltyPointsTimeout(Integer penaltyPointsTimeout) {
    this.penaltyPointsTimeout = penaltyPointsTimeout;
    return this;
  }

   /**
   * Get penaltyPointsTimeout
   * @return penaltyPointsTimeout
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PENALTY_POINTS_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPenaltyPointsTimeout() {
    return penaltyPointsTimeout;
  }


  @JsonProperty(JSON_PROPERTY_PENALTY_POINTS_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPenaltyPointsTimeout(Integer penaltyPointsTimeout) {
    this.penaltyPointsTimeout = penaltyPointsTimeout;
  }


  public EventContestCompetitionStagePlain penaltyPointsTimeUnderrun(Integer penaltyPointsTimeUnderrun) {
    this.penaltyPointsTimeUnderrun = penaltyPointsTimeUnderrun;
    return this;
  }

   /**
   * Get penaltyPointsTimeUnderrun
   * @return penaltyPointsTimeUnderrun
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PENALTY_POINTS_TIME_UNDERRUN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPenaltyPointsTimeUnderrun() {
    return penaltyPointsTimeUnderrun;
  }


  @JsonProperty(JSON_PROPERTY_PENALTY_POINTS_TIME_UNDERRUN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPenaltyPointsTimeUnderrun(Integer penaltyPointsTimeUnderrun) {
    this.penaltyPointsTimeUnderrun = penaltyPointsTimeUnderrun;
  }


  public EventContestCompetitionStagePlain penaltyPointsAtPulseRateOf(Integer penaltyPointsAtPulseRateOf) {
    this.penaltyPointsAtPulseRateOf = penaltyPointsAtPulseRateOf;
    return this;
  }

   /**
   * Get penaltyPointsAtPulseRateOf
   * @return penaltyPointsAtPulseRateOf
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PENALTY_POINTS_AT_PULSE_RATE_OF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPenaltyPointsAtPulseRateOf() {
    return penaltyPointsAtPulseRateOf;
  }


  @JsonProperty(JSON_PROPERTY_PENALTY_POINTS_AT_PULSE_RATE_OF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPenaltyPointsAtPulseRateOf(Integer penaltyPointsAtPulseRateOf) {
    this.penaltyPointsAtPulseRateOf = penaltyPointsAtPulseRateOf;
  }


  public EventContestCompetitionStagePlain penaltyPointsPulseRateExceeded(Integer penaltyPointsPulseRateExceeded) {
    this.penaltyPointsPulseRateExceeded = penaltyPointsPulseRateExceeded;
    return this;
  }

   /**
   * Get penaltyPointsPulseRateExceeded
   * @return penaltyPointsPulseRateExceeded
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PENALTY_POINTS_PULSE_RATE_EXCEEDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPenaltyPointsPulseRateExceeded() {
    return penaltyPointsPulseRateExceeded;
  }


  @JsonProperty(JSON_PROPERTY_PENALTY_POINTS_PULSE_RATE_EXCEEDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPenaltyPointsPulseRateExceeded(Integer penaltyPointsPulseRateExceeded) {
    this.penaltyPointsPulseRateExceeded = penaltyPointsPulseRateExceeded;
  }


  public EventContestCompetitionStagePlain breaksTotalNumbers(Integer breaksTotalNumbers) {
    this.breaksTotalNumbers = breaksTotalNumbers;
    return this;
  }

   /**
   * Get breaksTotalNumbers
   * @return breaksTotalNumbers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BREAKS_TOTAL_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getBreaksTotalNumbers() {
    return breaksTotalNumbers;
  }


  @JsonProperty(JSON_PROPERTY_BREAKS_TOTAL_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBreaksTotalNumbers(Integer breaksTotalNumbers) {
    this.breaksTotalNumbers = breaksTotalNumbers;
  }


  public EventContestCompetitionStagePlain breaksTotalMinutes(Integer breaksTotalMinutes) {
    this.breaksTotalMinutes = breaksTotalMinutes;
    return this;
  }

   /**
   * Get breaksTotalMinutes
   * @return breaksTotalMinutes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BREAKS_TOTAL_MINUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getBreaksTotalMinutes() {
    return breaksTotalMinutes;
  }


  @JsonProperty(JSON_PROPERTY_BREAKS_TOTAL_MINUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBreaksTotalMinutes(Integer breaksTotalMinutes) {
    this.breaksTotalMinutes = breaksTotalMinutes;
  }


  public EventContestCompetitionStagePlain responsibleVeterinarianUuid(String responsibleVeterinarianUuid) {
    this.responsibleVeterinarianUuid = responsibleVeterinarianUuid;
    return this;
  }

   /**
   * Get responsibleVeterinarianUuid
   * @return responsibleVeterinarianUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESPONSIBLE_VETERINARIAN_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getResponsibleVeterinarianUuid() {
    return responsibleVeterinarianUuid;
  }


  @JsonProperty(JSON_PROPERTY_RESPONSIBLE_VETERINARIAN_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResponsibleVeterinarianUuid(String responsibleVeterinarianUuid) {
    this.responsibleVeterinarianUuid = responsibleVeterinarianUuid;
  }


  /**
   * Return true if this EventContestCompetitionStage_Plain object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventContestCompetitionStagePlain eventContestCompetitionStagePlain = (EventContestCompetitionStagePlain) o;
    return Objects.equals(this.uuid, eventContestCompetitionStagePlain.uuid) &&
        Objects.equals(this.creationTimestamp, eventContestCompetitionStagePlain.creationTimestamp) &&
        Objects.equals(this.creationUserUuid, eventContestCompetitionStagePlain.creationUserUuid) &&
        Objects.equals(this.changeTimestamp, eventContestCompetitionStagePlain.changeTimestamp) &&
        Objects.equals(this.changeUserUuid, eventContestCompetitionStagePlain.changeUserUuid) &&
        Objects.equals(this.changeCounter, eventContestCompetitionStagePlain.changeCounter) &&
        Objects.equals(this.currentState, eventContestCompetitionStagePlain.currentState) &&
        Objects.equals(this.title, eventContestCompetitionStagePlain.title) &&
        Objects.equals(this.kind, eventContestCompetitionStagePlain.kind) &&
        Objects.equals(this.beginning, eventContestCompetitionStagePlain.beginning) &&
        Objects.equals(this.ending, eventContestCompetitionStagePlain.ending) &&
        Objects.equals(this.raiseLength, eventContestCompetitionStagePlain.raiseLength) &&
        Objects.equals(this.minutesMaximum, eventContestCompetitionStagePlain.minutesMaximum) &&
        Objects.equals(this.minutesAllowed, eventContestCompetitionStagePlain.minutesAllowed) &&
        Objects.equals(this.penaltyPointsTimeout, eventContestCompetitionStagePlain.penaltyPointsTimeout) &&
        Objects.equals(this.penaltyPointsTimeUnderrun, eventContestCompetitionStagePlain.penaltyPointsTimeUnderrun) &&
        Objects.equals(this.penaltyPointsAtPulseRateOf, eventContestCompetitionStagePlain.penaltyPointsAtPulseRateOf) &&
        Objects.equals(this.penaltyPointsPulseRateExceeded, eventContestCompetitionStagePlain.penaltyPointsPulseRateExceeded) &&
        Objects.equals(this.breaksTotalNumbers, eventContestCompetitionStagePlain.breaksTotalNumbers) &&
        Objects.equals(this.breaksTotalMinutes, eventContestCompetitionStagePlain.breaksTotalMinutes) &&
        Objects.equals(this.responsibleVeterinarianUuid, eventContestCompetitionStagePlain.responsibleVeterinarianUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, creationTimestamp, creationUserUuid, changeTimestamp, changeUserUuid, changeCounter, currentState, title, kind, beginning, ending, raiseLength, minutesMaximum, minutesAllowed, penaltyPointsTimeout, penaltyPointsTimeUnderrun, penaltyPointsAtPulseRateOf, penaltyPointsPulseRateExceeded, breaksTotalNumbers, breaksTotalMinutes, responsibleVeterinarianUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventContestCompetitionStagePlain {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    creationUserUuid: ").append(toIndentedString(creationUserUuid)).append("\n");
    sb.append("    changeTimestamp: ").append(toIndentedString(changeTimestamp)).append("\n");
    sb.append("    changeUserUuid: ").append(toIndentedString(changeUserUuid)).append("\n");
    sb.append("    changeCounter: ").append(toIndentedString(changeCounter)).append("\n");
    sb.append("    currentState: ").append(toIndentedString(currentState)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    beginning: ").append(toIndentedString(beginning)).append("\n");
    sb.append("    ending: ").append(toIndentedString(ending)).append("\n");
    sb.append("    raiseLength: ").append(toIndentedString(raiseLength)).append("\n");
    sb.append("    minutesMaximum: ").append(toIndentedString(minutesMaximum)).append("\n");
    sb.append("    minutesAllowed: ").append(toIndentedString(minutesAllowed)).append("\n");
    sb.append("    penaltyPointsTimeout: ").append(toIndentedString(penaltyPointsTimeout)).append("\n");
    sb.append("    penaltyPointsTimeUnderrun: ").append(toIndentedString(penaltyPointsTimeUnderrun)).append("\n");
    sb.append("    penaltyPointsAtPulseRateOf: ").append(toIndentedString(penaltyPointsAtPulseRateOf)).append("\n");
    sb.append("    penaltyPointsPulseRateExceeded: ").append(toIndentedString(penaltyPointsPulseRateExceeded)).append("\n");
    sb.append("    breaksTotalNumbers: ").append(toIndentedString(breaksTotalNumbers)).append("\n");
    sb.append("    breaksTotalMinutes: ").append(toIndentedString(breaksTotalMinutes)).append("\n");
    sb.append("    responsibleVeterinarianUuid: ").append(toIndentedString(responsibleVeterinarianUuid)).append("\n");
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

