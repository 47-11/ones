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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionResultHorse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * EventContestCompetitionResult
 */
@JsonPropertyOrder({
  EventContestCompetitionResult.JSON_PROPERTY_UUID,
  EventContestCompetitionResult.JSON_PROPERTY_CREATION_TIMESTAMP,
  EventContestCompetitionResult.JSON_PROPERTY_CREATION_USER_UUID,
  EventContestCompetitionResult.JSON_PROPERTY_CHANGE_TIMESTAMP,
  EventContestCompetitionResult.JSON_PROPERTY_CHANGE_USER_UUID,
  EventContestCompetitionResult.JSON_PROPERTY_CHANGE_COUNTER,
  EventContestCompetitionResult.JSON_PROPERTY_CURRENT_STATE,
  EventContestCompetitionResult.JSON_PROPERTY_COMPETITION_DATE,
  EventContestCompetitionResult.JSON_PROPERTY_MASTERDATA_CONTESTANT_UUID,
  EventContestCompetitionResult.JSON_PROPERTY_COMPETITION_KIND_REMARK,
  EventContestCompetitionResult.JSON_PROPERTY_FAILURE_REASON_REMARK,
  EventContestCompetitionResult.JSON_PROPERTY_RANKING_RAISE_LENGTH,
  EventContestCompetitionResult.JSON_PROPERTY_PLACEMENT,
  EventContestCompetitionResult.JSON_PROPERTY_TIME_TOTAL,
  EventContestCompetitionResult.JSON_PROPERTY_TIME_RACE,
  EventContestCompetitionResult.JSON_PROPERTY_TEMPO,
  EventContestCompetitionResult.JSON_PROPERTY_SPEED,
  EventContestCompetitionResult.JSON_PROPERTY_KM_H,
  EventContestCompetitionResult.JSON_PROPERTY_REMARKS,
  EventContestCompetitionResult.JSON_PROPERTY_DISPLAY_CONTESTANT,
  EventContestCompetitionResult.JSON_PROPERTY_DISPLAY_HORSE,
  EventContestCompetitionResult.JSON_PROPERTY_HORSES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-01-11T10:56:24.580179898+01:00[Europe/Berlin]")
public class EventContestCompetitionResult {
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

  public static final String JSON_PROPERTY_COMPETITION_DATE = "competitionDate";
  private OffsetDateTime competitionDate;

  public static final String JSON_PROPERTY_MASTERDATA_CONTESTANT_UUID = "masterdataContestantUuid";
  private String masterdataContestantUuid;

  public static final String JSON_PROPERTY_COMPETITION_KIND_REMARK = "competitionKindRemark";
  private String competitionKindRemark;

  public static final String JSON_PROPERTY_FAILURE_REASON_REMARK = "failureReasonRemark";
  private String failureReasonRemark;

  public static final String JSON_PROPERTY_RANKING_RAISE_LENGTH = "rankingRaiseLength";
  private Integer rankingRaiseLength;

  public static final String JSON_PROPERTY_PLACEMENT = "placement";
  private Integer placement;

  public static final String JSON_PROPERTY_TIME_TOTAL = "timeTotal";
  private OffsetDateTime timeTotal;

  public static final String JSON_PROPERTY_TIME_RACE = "timeRace";
  private OffsetDateTime timeRace;

  public static final String JSON_PROPERTY_TEMPO = "tempo";
  private Double tempo;

  public static final String JSON_PROPERTY_SPEED = "speed";
  private Double speed;

  public static final String JSON_PROPERTY_KM_H = "kmH";
  private Double kmH;

  public static final String JSON_PROPERTY_REMARKS = "remarks";
  private String remarks;

  public static final String JSON_PROPERTY_DISPLAY_CONTESTANT = "displayContestant";
  private String displayContestant;

  public static final String JSON_PROPERTY_DISPLAY_HORSE = "displayHorse";
  private String displayHorse;

  public static final String JSON_PROPERTY_HORSES = "_horses";
  private Set<EventContestCompetitionResultHorse> horses = null;

  public EventContestCompetitionResult() { 
  }

  public EventContestCompetitionResult uuid(String uuid) {
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


  public EventContestCompetitionResult creationTimestamp(OffsetDateTime creationTimestamp) {
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


  public EventContestCompetitionResult creationUserUuid(String creationUserUuid) {
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


  public EventContestCompetitionResult changeTimestamp(OffsetDateTime changeTimestamp) {
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


  public EventContestCompetitionResult changeUserUuid(String changeUserUuid) {
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


  public EventContestCompetitionResult changeCounter(Integer changeCounter) {
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


  public EventContestCompetitionResult currentState(Integer currentState) {
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


  public EventContestCompetitionResult competitionDate(OffsetDateTime competitionDate) {
    this.competitionDate = competitionDate;
    return this;
  }

   /**
   * Get competitionDate
   * @return competitionDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COMPETITION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCompetitionDate() {
    return competitionDate;
  }


  @JsonProperty(JSON_PROPERTY_COMPETITION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCompetitionDate(OffsetDateTime competitionDate) {
    this.competitionDate = competitionDate;
  }


  public EventContestCompetitionResult masterdataContestantUuid(String masterdataContestantUuid) {
    this.masterdataContestantUuid = masterdataContestantUuid;
    return this;
  }

   /**
   * Get masterdataContestantUuid
   * @return masterdataContestantUuid
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_MASTERDATA_CONTESTANT_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getMasterdataContestantUuid() {
    return masterdataContestantUuid;
  }


  @JsonProperty(JSON_PROPERTY_MASTERDATA_CONTESTANT_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMasterdataContestantUuid(String masterdataContestantUuid) {
    this.masterdataContestantUuid = masterdataContestantUuid;
  }


  public EventContestCompetitionResult competitionKindRemark(String competitionKindRemark) {
    this.competitionKindRemark = competitionKindRemark;
    return this;
  }

   /**
   * Get competitionKindRemark
   * @return competitionKindRemark
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COMPETITION_KIND_REMARK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCompetitionKindRemark() {
    return competitionKindRemark;
  }


  @JsonProperty(JSON_PROPERTY_COMPETITION_KIND_REMARK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCompetitionKindRemark(String competitionKindRemark) {
    this.competitionKindRemark = competitionKindRemark;
  }


  public EventContestCompetitionResult failureReasonRemark(String failureReasonRemark) {
    this.failureReasonRemark = failureReasonRemark;
    return this;
  }

   /**
   * Get failureReasonRemark
   * @return failureReasonRemark
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FAILURE_REASON_REMARK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFailureReasonRemark() {
    return failureReasonRemark;
  }


  @JsonProperty(JSON_PROPERTY_FAILURE_REASON_REMARK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFailureReasonRemark(String failureReasonRemark) {
    this.failureReasonRemark = failureReasonRemark;
  }


  public EventContestCompetitionResult rankingRaiseLength(Integer rankingRaiseLength) {
    this.rankingRaiseLength = rankingRaiseLength;
    return this;
  }

   /**
   * Get rankingRaiseLength
   * @return rankingRaiseLength
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RANKING_RAISE_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRankingRaiseLength() {
    return rankingRaiseLength;
  }


  @JsonProperty(JSON_PROPERTY_RANKING_RAISE_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRankingRaiseLength(Integer rankingRaiseLength) {
    this.rankingRaiseLength = rankingRaiseLength;
  }


  public EventContestCompetitionResult placement(Integer placement) {
    this.placement = placement;
    return this;
  }

   /**
   * Get placement
   * @return placement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PLACEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPlacement() {
    return placement;
  }


  @JsonProperty(JSON_PROPERTY_PLACEMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlacement(Integer placement) {
    this.placement = placement;
  }


  public EventContestCompetitionResult timeTotal(OffsetDateTime timeTotal) {
    this.timeTotal = timeTotal;
    return this;
  }

   /**
   * Get timeTotal
   * @return timeTotal
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TIME_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getTimeTotal() {
    return timeTotal;
  }


  @JsonProperty(JSON_PROPERTY_TIME_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimeTotal(OffsetDateTime timeTotal) {
    this.timeTotal = timeTotal;
  }


  public EventContestCompetitionResult timeRace(OffsetDateTime timeRace) {
    this.timeRace = timeRace;
    return this;
  }

   /**
   * Get timeRace
   * @return timeRace
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TIME_RACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getTimeRace() {
    return timeRace;
  }


  @JsonProperty(JSON_PROPERTY_TIME_RACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimeRace(OffsetDateTime timeRace) {
    this.timeRace = timeRace;
  }


  public EventContestCompetitionResult tempo(Double tempo) {
    this.tempo = tempo;
    return this;
  }

   /**
   * Get tempo
   * @return tempo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TEMPO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getTempo() {
    return tempo;
  }


  @JsonProperty(JSON_PROPERTY_TEMPO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTempo(Double tempo) {
    this.tempo = tempo;
  }


  public EventContestCompetitionResult speed(Double speed) {
    this.speed = speed;
    return this;
  }

   /**
   * Get speed
   * @return speed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getSpeed() {
    return speed;
  }


  @JsonProperty(JSON_PROPERTY_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSpeed(Double speed) {
    this.speed = speed;
  }


  public EventContestCompetitionResult kmH(Double kmH) {
    this.kmH = kmH;
    return this;
  }

   /**
   * Get kmH
   * @return kmH
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_KM_H)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getKmH() {
    return kmH;
  }


  @JsonProperty(JSON_PROPERTY_KM_H)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKmH(Double kmH) {
    this.kmH = kmH;
  }


  public EventContestCompetitionResult remarks(String remarks) {
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


  public EventContestCompetitionResult displayContestant(String displayContestant) {
    this.displayContestant = displayContestant;
    return this;
  }

   /**
   * Get displayContestant
   * @return displayContestant
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DISPLAY_CONTESTANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayContestant() {
    return displayContestant;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_CONTESTANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayContestant(String displayContestant) {
    this.displayContestant = displayContestant;
  }


  public EventContestCompetitionResult displayHorse(String displayHorse) {
    this.displayHorse = displayHorse;
    return this;
  }

   /**
   * Get displayHorse
   * @return displayHorse
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DISPLAY_HORSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayHorse() {
    return displayHorse;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_HORSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayHorse(String displayHorse) {
    this.displayHorse = displayHorse;
  }


  public EventContestCompetitionResult horses(Set<EventContestCompetitionResultHorse> horses) {
    this.horses = horses;
    return this;
  }

  public EventContestCompetitionResult addHorsesItem(EventContestCompetitionResultHorse horsesItem) {
    if (this.horses == null) {
      this.horses = new LinkedHashSet<>();
    }
    this.horses.add(horsesItem);
    return this;
  }

   /**
   * Get horses
   * @return horses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HORSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Set<EventContestCompetitionResultHorse> getHorses() {
    return horses;
  }


  @JsonDeserialize(as = LinkedHashSet.class)
  @JsonProperty(JSON_PROPERTY_HORSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHorses(Set<EventContestCompetitionResultHorse> horses) {
    this.horses = horses;
  }


  /**
   * Return true if this EventContestCompetitionResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventContestCompetitionResult eventContestCompetitionResult = (EventContestCompetitionResult) o;
    return Objects.equals(this.uuid, eventContestCompetitionResult.uuid) &&
        Objects.equals(this.creationTimestamp, eventContestCompetitionResult.creationTimestamp) &&
        Objects.equals(this.creationUserUuid, eventContestCompetitionResult.creationUserUuid) &&
        Objects.equals(this.changeTimestamp, eventContestCompetitionResult.changeTimestamp) &&
        Objects.equals(this.changeUserUuid, eventContestCompetitionResult.changeUserUuid) &&
        Objects.equals(this.changeCounter, eventContestCompetitionResult.changeCounter) &&
        Objects.equals(this.currentState, eventContestCompetitionResult.currentState) &&
        Objects.equals(this.competitionDate, eventContestCompetitionResult.competitionDate) &&
        Objects.equals(this.masterdataContestantUuid, eventContestCompetitionResult.masterdataContestantUuid) &&
        Objects.equals(this.competitionKindRemark, eventContestCompetitionResult.competitionKindRemark) &&
        Objects.equals(this.failureReasonRemark, eventContestCompetitionResult.failureReasonRemark) &&
        Objects.equals(this.rankingRaiseLength, eventContestCompetitionResult.rankingRaiseLength) &&
        Objects.equals(this.placement, eventContestCompetitionResult.placement) &&
        Objects.equals(this.timeTotal, eventContestCompetitionResult.timeTotal) &&
        Objects.equals(this.timeRace, eventContestCompetitionResult.timeRace) &&
        Objects.equals(this.tempo, eventContestCompetitionResult.tempo) &&
        Objects.equals(this.speed, eventContestCompetitionResult.speed) &&
        Objects.equals(this.kmH, eventContestCompetitionResult.kmH) &&
        Objects.equals(this.remarks, eventContestCompetitionResult.remarks) &&
        Objects.equals(this.displayContestant, eventContestCompetitionResult.displayContestant) &&
        Objects.equals(this.displayHorse, eventContestCompetitionResult.displayHorse) &&
        Objects.equals(this.horses, eventContestCompetitionResult.horses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, creationTimestamp, creationUserUuid, changeTimestamp, changeUserUuid, changeCounter, currentState, competitionDate, masterdataContestantUuid, competitionKindRemark, failureReasonRemark, rankingRaiseLength, placement, timeTotal, timeRace, tempo, speed, kmH, remarks, displayContestant, displayHorse, horses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventContestCompetitionResult {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    creationUserUuid: ").append(toIndentedString(creationUserUuid)).append("\n");
    sb.append("    changeTimestamp: ").append(toIndentedString(changeTimestamp)).append("\n");
    sb.append("    changeUserUuid: ").append(toIndentedString(changeUserUuid)).append("\n");
    sb.append("    changeCounter: ").append(toIndentedString(changeCounter)).append("\n");
    sb.append("    currentState: ").append(toIndentedString(currentState)).append("\n");
    sb.append("    competitionDate: ").append(toIndentedString(competitionDate)).append("\n");
    sb.append("    masterdataContestantUuid: ").append(toIndentedString(masterdataContestantUuid)).append("\n");
    sb.append("    competitionKindRemark: ").append(toIndentedString(competitionKindRemark)).append("\n");
    sb.append("    failureReasonRemark: ").append(toIndentedString(failureReasonRemark)).append("\n");
    sb.append("    rankingRaiseLength: ").append(toIndentedString(rankingRaiseLength)).append("\n");
    sb.append("    placement: ").append(toIndentedString(placement)).append("\n");
    sb.append("    timeTotal: ").append(toIndentedString(timeTotal)).append("\n");
    sb.append("    timeRace: ").append(toIndentedString(timeRace)).append("\n");
    sb.append("    tempo: ").append(toIndentedString(tempo)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
    sb.append("    kmH: ").append(toIndentedString(kmH)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    displayContestant: ").append(toIndentedString(displayContestant)).append("\n");
    sb.append("    displayHorse: ").append(toIndentedString(displayHorse)).append("\n");
    sb.append("    horses: ").append(toIndentedString(horses)).append("\n");
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

