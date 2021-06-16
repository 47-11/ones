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
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionStage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * EventContestCompetition
 */
@JsonPropertyOrder({
  EventContestCompetition.JSON_PROPERTY_UUID,
  EventContestCompetition.JSON_PROPERTY_EVENT_CONTEST_UUID,
  EventContestCompetition.JSON_PROPERTY_CREATION_TIMESTAMP,
  EventContestCompetition.JSON_PROPERTY_CREATION_USER_UUID,
  EventContestCompetition.JSON_PROPERTY_CHANGE_TIMESTAMP,
  EventContestCompetition.JSON_PROPERTY_CHANGE_USER_UUID,
  EventContestCompetition.JSON_PROPERTY_CHANGE_COUNTER,
  EventContestCompetition.JSON_PROPERTY_CURRENT_STATE,
  EventContestCompetition.JSON_PROPERTY_TITLE,
  EventContestCompetition.JSON_PROPERTY_KIND,
  EventContestCompetition.JSON_PROPERTY_BEGINNING,
  EventContestCompetition.JSON_PROPERTY_ENDING,
  EventContestCompetition.JSON_PROPERTY_RAISE_LENGTH,
  EventContestCompetition.JSON_PROPERTY_MINUTES_MAXIMUM,
  EventContestCompetition.JSON_PROPERTY_MINUTES_ALLOWED,
  EventContestCompetition.JSON_PROPERTY_PENALTY_POINTS_TIMEOUT,
  EventContestCompetition.JSON_PROPERTY_PENALTY_POINTS_TIME_UNDERRUN,
  EventContestCompetition.JSON_PROPERTY_PENALTY_POINTS_AT_PULSE_RATE_OF,
  EventContestCompetition.JSON_PROPERTY_PENALTY_POINTS_PULSE_RATE_EXCEEDED,
  EventContestCompetition.JSON_PROPERTY_BREAKS_TOTAL_NUMBERS,
  EventContestCompetition.JSON_PROPERTY_BREAKS_TOTAL_MINUTES,
  EventContestCompetition.JSON_PROPERTY_RESPONSIBLE_VETERINARIAN_UUID,
  EventContestCompetition.JSON_PROPERTY_COMPETITION_UUID_TO_EXTEND,
  EventContestCompetition.JSON_PROPERTY_COMPETITION_UUID_TO_REDUCE,
  EventContestCompetition.JSON_PROPERTY_CONTESTANT_LIMITIATION_MIN,
  EventContestCompetition.JSON_PROPERTY_CONTESTANT_LIMITIATION_MAX,
  EventContestCompetition.JSON_PROPERTY_STAGES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-06-16T11:44:09.276003800+02:00[Europe/Berlin]")
public class EventContestCompetition {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_EVENT_CONTEST_UUID = "eventContestUuid";
  private String eventContestUuid;

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

  public static final String JSON_PROPERTY_COMPETITION_UUID_TO_EXTEND = "competitionUuidToExtend";
  private String competitionUuidToExtend;

  public static final String JSON_PROPERTY_COMPETITION_UUID_TO_REDUCE = "competitionUuidToReduce";
  private String competitionUuidToReduce;

  public static final String JSON_PROPERTY_CONTESTANT_LIMITIATION_MIN = "contestantLimitiationMin";
  private Integer contestantLimitiationMin;

  public static final String JSON_PROPERTY_CONTESTANT_LIMITIATION_MAX = "contestantLimitiationMax";
  private Integer contestantLimitiationMax;

  public static final String JSON_PROPERTY_STAGES = "_stages";
  private Set<EventContestCompetitionStage> stages = null;


  public EventContestCompetition uuid(String uuid) {
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


  public EventContestCompetition eventContestUuid(String eventContestUuid) {
    this.eventContestUuid = eventContestUuid;
    return this;
  }

   /**
   * Get eventContestUuid
   * @return eventContestUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EVENT_CONTEST_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEventContestUuid() {
    return eventContestUuid;
  }


  @JsonProperty(JSON_PROPERTY_EVENT_CONTEST_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEventContestUuid(String eventContestUuid) {
    this.eventContestUuid = eventContestUuid;
  }


  public EventContestCompetition creationTimestamp(OffsetDateTime creationTimestamp) {
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


  @JsonProperty(JSON_PROPERTY_CREATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreationTimestamp(OffsetDateTime creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
  }


  public EventContestCompetition creationUserUuid(String creationUserUuid) {
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


  public EventContestCompetition changeTimestamp(OffsetDateTime changeTimestamp) {
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


  public EventContestCompetition changeUserUuid(String changeUserUuid) {
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


  public EventContestCompetition changeCounter(Integer changeCounter) {
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


  public EventContestCompetition currentState(Integer currentState) {
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


  public EventContestCompetition title(String title) {
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


  public EventContestCompetition kind(String kind) {
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


  public EventContestCompetition beginning(OffsetDateTime beginning) {
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


  public EventContestCompetition ending(OffsetDateTime ending) {
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


  public EventContestCompetition raiseLength(Integer raiseLength) {
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


  public EventContestCompetition minutesMaximum(Integer minutesMaximum) {
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


  public EventContestCompetition minutesAllowed(Integer minutesAllowed) {
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


  public EventContestCompetition penaltyPointsTimeout(Integer penaltyPointsTimeout) {
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


  public EventContestCompetition penaltyPointsTimeUnderrun(Integer penaltyPointsTimeUnderrun) {
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


  public EventContestCompetition penaltyPointsAtPulseRateOf(Integer penaltyPointsAtPulseRateOf) {
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


  public EventContestCompetition penaltyPointsPulseRateExceeded(Integer penaltyPointsPulseRateExceeded) {
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


  public EventContestCompetition breaksTotalNumbers(Integer breaksTotalNumbers) {
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


  public EventContestCompetition breaksTotalMinutes(Integer breaksTotalMinutes) {
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


  public EventContestCompetition responsibleVeterinarianUuid(String responsibleVeterinarianUuid) {
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


  public EventContestCompetition competitionUuidToExtend(String competitionUuidToExtend) {
    this.competitionUuidToExtend = competitionUuidToExtend;
    return this;
  }

   /**
   * Get competitionUuidToExtend
   * @return competitionUuidToExtend
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COMPETITION_UUID_TO_EXTEND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCompetitionUuidToExtend() {
    return competitionUuidToExtend;
  }


  @JsonProperty(JSON_PROPERTY_COMPETITION_UUID_TO_EXTEND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCompetitionUuidToExtend(String competitionUuidToExtend) {
    this.competitionUuidToExtend = competitionUuidToExtend;
  }


  public EventContestCompetition competitionUuidToReduce(String competitionUuidToReduce) {
    this.competitionUuidToReduce = competitionUuidToReduce;
    return this;
  }

   /**
   * Get competitionUuidToReduce
   * @return competitionUuidToReduce
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COMPETITION_UUID_TO_REDUCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCompetitionUuidToReduce() {
    return competitionUuidToReduce;
  }


  @JsonProperty(JSON_PROPERTY_COMPETITION_UUID_TO_REDUCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCompetitionUuidToReduce(String competitionUuidToReduce) {
    this.competitionUuidToReduce = competitionUuidToReduce;
  }


  public EventContestCompetition contestantLimitiationMin(Integer contestantLimitiationMin) {
    this.contestantLimitiationMin = contestantLimitiationMin;
    return this;
  }

   /**
   * Get contestantLimitiationMin
   * @return contestantLimitiationMin
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONTESTANT_LIMITIATION_MIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getContestantLimitiationMin() {
    return contestantLimitiationMin;
  }


  @JsonProperty(JSON_PROPERTY_CONTESTANT_LIMITIATION_MIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContestantLimitiationMin(Integer contestantLimitiationMin) {
    this.contestantLimitiationMin = contestantLimitiationMin;
  }


  public EventContestCompetition contestantLimitiationMax(Integer contestantLimitiationMax) {
    this.contestantLimitiationMax = contestantLimitiationMax;
    return this;
  }

   /**
   * Get contestantLimitiationMax
   * @return contestantLimitiationMax
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONTESTANT_LIMITIATION_MAX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getContestantLimitiationMax() {
    return contestantLimitiationMax;
  }


  @JsonProperty(JSON_PROPERTY_CONTESTANT_LIMITIATION_MAX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContestantLimitiationMax(Integer contestantLimitiationMax) {
    this.contestantLimitiationMax = contestantLimitiationMax;
  }


  public EventContestCompetition stages(Set<EventContestCompetitionStage> stages) {
    this.stages = stages;
    return this;
  }

  public EventContestCompetition addStagesItem(EventContestCompetitionStage stagesItem) {
    if (this.stages == null) {
      this.stages = new LinkedHashSet<>();
    }
    this.stages.add(stagesItem);
    return this;
  }

   /**
   * Get stages
   * @return stages
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STAGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Set<EventContestCompetitionStage> getStages() {
    return stages;
  }


  @JsonProperty(JSON_PROPERTY_STAGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStages(Set<EventContestCompetitionStage> stages) {
    this.stages = stages;
  }


  /**
   * Return true if this EventContestCompetition object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventContestCompetition eventContestCompetition = (EventContestCompetition) o;
    return Objects.equals(this.uuid, eventContestCompetition.uuid) &&
        Objects.equals(this.eventContestUuid, eventContestCompetition.eventContestUuid) &&
        Objects.equals(this.creationTimestamp, eventContestCompetition.creationTimestamp) &&
        Objects.equals(this.creationUserUuid, eventContestCompetition.creationUserUuid) &&
        Objects.equals(this.changeTimestamp, eventContestCompetition.changeTimestamp) &&
        Objects.equals(this.changeUserUuid, eventContestCompetition.changeUserUuid) &&
        Objects.equals(this.changeCounter, eventContestCompetition.changeCounter) &&
        Objects.equals(this.currentState, eventContestCompetition.currentState) &&
        Objects.equals(this.title, eventContestCompetition.title) &&
        Objects.equals(this.kind, eventContestCompetition.kind) &&
        Objects.equals(this.beginning, eventContestCompetition.beginning) &&
        Objects.equals(this.ending, eventContestCompetition.ending) &&
        Objects.equals(this.raiseLength, eventContestCompetition.raiseLength) &&
        Objects.equals(this.minutesMaximum, eventContestCompetition.minutesMaximum) &&
        Objects.equals(this.minutesAllowed, eventContestCompetition.minutesAllowed) &&
        Objects.equals(this.penaltyPointsTimeout, eventContestCompetition.penaltyPointsTimeout) &&
        Objects.equals(this.penaltyPointsTimeUnderrun, eventContestCompetition.penaltyPointsTimeUnderrun) &&
        Objects.equals(this.penaltyPointsAtPulseRateOf, eventContestCompetition.penaltyPointsAtPulseRateOf) &&
        Objects.equals(this.penaltyPointsPulseRateExceeded, eventContestCompetition.penaltyPointsPulseRateExceeded) &&
        Objects.equals(this.breaksTotalNumbers, eventContestCompetition.breaksTotalNumbers) &&
        Objects.equals(this.breaksTotalMinutes, eventContestCompetition.breaksTotalMinutes) &&
        Objects.equals(this.responsibleVeterinarianUuid, eventContestCompetition.responsibleVeterinarianUuid) &&
        Objects.equals(this.competitionUuidToExtend, eventContestCompetition.competitionUuidToExtend) &&
        Objects.equals(this.competitionUuidToReduce, eventContestCompetition.competitionUuidToReduce) &&
        Objects.equals(this.contestantLimitiationMin, eventContestCompetition.contestantLimitiationMin) &&
        Objects.equals(this.contestantLimitiationMax, eventContestCompetition.contestantLimitiationMax) &&
        Objects.equals(this.stages, eventContestCompetition.stages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, eventContestUuid, creationTimestamp, creationUserUuid, changeTimestamp, changeUserUuid, changeCounter, currentState, title, kind, beginning, ending, raiseLength, minutesMaximum, minutesAllowed, penaltyPointsTimeout, penaltyPointsTimeUnderrun, penaltyPointsAtPulseRateOf, penaltyPointsPulseRateExceeded, breaksTotalNumbers, breaksTotalMinutes, responsibleVeterinarianUuid, competitionUuidToExtend, competitionUuidToReduce, contestantLimitiationMin, contestantLimitiationMax, stages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventContestCompetition {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    eventContestUuid: ").append(toIndentedString(eventContestUuid)).append("\n");
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
    sb.append("    competitionUuidToExtend: ").append(toIndentedString(competitionUuidToExtend)).append("\n");
    sb.append("    competitionUuidToReduce: ").append(toIndentedString(competitionUuidToReduce)).append("\n");
    sb.append("    contestantLimitiationMin: ").append(toIndentedString(contestantLimitiationMin)).append("\n");
    sb.append("    contestantLimitiationMax: ").append(toIndentedString(contestantLimitiationMax)).append("\n");
    sb.append("    stages: ").append(toIndentedString(stages)).append("\n");
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

