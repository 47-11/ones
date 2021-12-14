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
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionRegistrationHorse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * EventContestCompetitionRegistration
 */
@JsonPropertyOrder({
  EventContestCompetitionRegistration.JSON_PROPERTY_UUID,
  EventContestCompetitionRegistration.JSON_PROPERTY_EVENT_CONTEST_COMPETITION_UUUID,
  EventContestCompetitionRegistration.JSON_PROPERTY_CREATION_TIMESTAMP,
  EventContestCompetitionRegistration.JSON_PROPERTY_CREATION_USER_UUID,
  EventContestCompetitionRegistration.JSON_PROPERTY_CHANGE_TIMESTAMP,
  EventContestCompetitionRegistration.JSON_PROPERTY_CHANGE_USER_UUID,
  EventContestCompetitionRegistration.JSON_PROPERTY_CHANGE_COUNTER,
  EventContestCompetitionRegistration.JSON_PROPERTY_CURRENT_STATE,
  EventContestCompetitionRegistration.JSON_PROPERTY_REGISTRATION_COMPETITION_DATE,
  EventContestCompetitionRegistration.JSON_PROPERTY_REGISTRATION_ACCOUNT_UUID,
  EventContestCompetitionRegistration.JSON_PROPERTY_CONTESTANT_UUID,
  EventContestCompetitionRegistration.JSON_PROPERTY_PAYMENT_METHOD,
  EventContestCompetitionRegistration.JSON_PROPERTY_INSURANCE_POLICE_ID,
  EventContestCompetitionRegistration.JSON_PROPERTY_REMARK,
  EventContestCompetitionRegistration.JSON_PROPERTY_DISPLAY_CONTESTANT,
  EventContestCompetitionRegistration.JSON_PROPERTY_DISPLAY_HORSE,
  EventContestCompetitionRegistration.JSON_PROPERTY_HORSES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-14T11:16:59.043131602+01:00[Europe/Berlin]")
public class EventContestCompetitionRegistration {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_EVENT_CONTEST_COMPETITION_UUUID = "eventContestCompetitionUuuid";
  private String eventContestCompetitionUuuid;

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

  public static final String JSON_PROPERTY_REGISTRATION_COMPETITION_DATE = "registrationCompetitionDate";
  private OffsetDateTime registrationCompetitionDate;

  public static final String JSON_PROPERTY_REGISTRATION_ACCOUNT_UUID = "registrationAccountUuid";
  private String registrationAccountUuid;

  public static final String JSON_PROPERTY_CONTESTANT_UUID = "contestantUuid";
  private String contestantUuid;

  public static final String JSON_PROPERTY_PAYMENT_METHOD = "paymentMethod";
  private Integer paymentMethod;

  public static final String JSON_PROPERTY_INSURANCE_POLICE_ID = "insurancePoliceId";
  private String insurancePoliceId;

  public static final String JSON_PROPERTY_REMARK = "remark";
  private String remark;

  public static final String JSON_PROPERTY_DISPLAY_CONTESTANT = "displayContestant";
  private String displayContestant;

  public static final String JSON_PROPERTY_DISPLAY_HORSE = "displayHorse";
  private String displayHorse;

  public static final String JSON_PROPERTY_HORSES = "_horses";
  private Set<EventContestCompetitionRegistrationHorse> horses = null;


  public EventContestCompetitionRegistration uuid(String uuid) {
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


  public EventContestCompetitionRegistration eventContestCompetitionUuuid(String eventContestCompetitionUuuid) {
    this.eventContestCompetitionUuuid = eventContestCompetitionUuuid;
    return this;
  }

   /**
   * Get eventContestCompetitionUuuid
   * @return eventContestCompetitionUuuid
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EVENT_CONTEST_COMPETITION_UUUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEventContestCompetitionUuuid() {
    return eventContestCompetitionUuuid;
  }


  @JsonProperty(JSON_PROPERTY_EVENT_CONTEST_COMPETITION_UUUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEventContestCompetitionUuuid(String eventContestCompetitionUuuid) {
    this.eventContestCompetitionUuuid = eventContestCompetitionUuuid;
  }


  public EventContestCompetitionRegistration creationTimestamp(OffsetDateTime creationTimestamp) {
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


  public EventContestCompetitionRegistration creationUserUuid(String creationUserUuid) {
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


  public EventContestCompetitionRegistration changeTimestamp(OffsetDateTime changeTimestamp) {
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


  public EventContestCompetitionRegistration changeUserUuid(String changeUserUuid) {
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


  public EventContestCompetitionRegistration changeCounter(Integer changeCounter) {
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


  public EventContestCompetitionRegistration currentState(Integer currentState) {
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


  public EventContestCompetitionRegistration registrationCompetitionDate(OffsetDateTime registrationCompetitionDate) {
    this.registrationCompetitionDate = registrationCompetitionDate;
    return this;
  }

   /**
   * Get registrationCompetitionDate
   * @return registrationCompetitionDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_REGISTRATION_COMPETITION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getRegistrationCompetitionDate() {
    return registrationCompetitionDate;
  }


  @JsonProperty(JSON_PROPERTY_REGISTRATION_COMPETITION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRegistrationCompetitionDate(OffsetDateTime registrationCompetitionDate) {
    this.registrationCompetitionDate = registrationCompetitionDate;
  }


  public EventContestCompetitionRegistration registrationAccountUuid(String registrationAccountUuid) {
    this.registrationAccountUuid = registrationAccountUuid;
    return this;
  }

   /**
   * Get registrationAccountUuid
   * @return registrationAccountUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_REGISTRATION_ACCOUNT_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRegistrationAccountUuid() {
    return registrationAccountUuid;
  }


  @JsonProperty(JSON_PROPERTY_REGISTRATION_ACCOUNT_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRegistrationAccountUuid(String registrationAccountUuid) {
    this.registrationAccountUuid = registrationAccountUuid;
  }


  public EventContestCompetitionRegistration contestantUuid(String contestantUuid) {
    this.contestantUuid = contestantUuid;
    return this;
  }

   /**
   * Get contestantUuid
   * @return contestantUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONTESTANT_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getContestantUuid() {
    return contestantUuid;
  }


  @JsonProperty(JSON_PROPERTY_CONTESTANT_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContestantUuid(String contestantUuid) {
    this.contestantUuid = contestantUuid;
  }


  public EventContestCompetitionRegistration paymentMethod(Integer paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

   /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PAYMENT_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPaymentMethod() {
    return paymentMethod;
  }


  @JsonProperty(JSON_PROPERTY_PAYMENT_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentMethod(Integer paymentMethod) {
    this.paymentMethod = paymentMethod;
  }


  public EventContestCompetitionRegistration insurancePoliceId(String insurancePoliceId) {
    this.insurancePoliceId = insurancePoliceId;
    return this;
  }

   /**
   * Get insurancePoliceId
   * @return insurancePoliceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INSURANCE_POLICE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInsurancePoliceId() {
    return insurancePoliceId;
  }


  @JsonProperty(JSON_PROPERTY_INSURANCE_POLICE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInsurancePoliceId(String insurancePoliceId) {
    this.insurancePoliceId = insurancePoliceId;
  }


  public EventContestCompetitionRegistration remark(String remark) {
    this.remark = remark;
    return this;
  }

   /**
   * Get remark
   * @return remark
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_REMARK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRemark() {
    return remark;
  }


  @JsonProperty(JSON_PROPERTY_REMARK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRemark(String remark) {
    this.remark = remark;
  }


  public EventContestCompetitionRegistration displayContestant(String displayContestant) {
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


  public EventContestCompetitionRegistration displayHorse(String displayHorse) {
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


  public EventContestCompetitionRegistration horses(Set<EventContestCompetitionRegistrationHorse> horses) {
    this.horses = horses;
    return this;
  }

  public EventContestCompetitionRegistration addHorsesItem(EventContestCompetitionRegistrationHorse horsesItem) {
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

  public Set<EventContestCompetitionRegistrationHorse> getHorses() {
    return horses;
  }


  @JsonProperty(JSON_PROPERTY_HORSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHorses(Set<EventContestCompetitionRegistrationHorse> horses) {
    this.horses = horses;
  }


  /**
   * Return true if this EventContestCompetitionRegistration object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventContestCompetitionRegistration eventContestCompetitionRegistration = (EventContestCompetitionRegistration) o;
    return Objects.equals(this.uuid, eventContestCompetitionRegistration.uuid) &&
        Objects.equals(this.eventContestCompetitionUuuid, eventContestCompetitionRegistration.eventContestCompetitionUuuid) &&
        Objects.equals(this.creationTimestamp, eventContestCompetitionRegistration.creationTimestamp) &&
        Objects.equals(this.creationUserUuid, eventContestCompetitionRegistration.creationUserUuid) &&
        Objects.equals(this.changeTimestamp, eventContestCompetitionRegistration.changeTimestamp) &&
        Objects.equals(this.changeUserUuid, eventContestCompetitionRegistration.changeUserUuid) &&
        Objects.equals(this.changeCounter, eventContestCompetitionRegistration.changeCounter) &&
        Objects.equals(this.currentState, eventContestCompetitionRegistration.currentState) &&
        Objects.equals(this.registrationCompetitionDate, eventContestCompetitionRegistration.registrationCompetitionDate) &&
        Objects.equals(this.registrationAccountUuid, eventContestCompetitionRegistration.registrationAccountUuid) &&
        Objects.equals(this.contestantUuid, eventContestCompetitionRegistration.contestantUuid) &&
        Objects.equals(this.paymentMethod, eventContestCompetitionRegistration.paymentMethod) &&
        Objects.equals(this.insurancePoliceId, eventContestCompetitionRegistration.insurancePoliceId) &&
        Objects.equals(this.remark, eventContestCompetitionRegistration.remark) &&
        Objects.equals(this.displayContestant, eventContestCompetitionRegistration.displayContestant) &&
        Objects.equals(this.displayHorse, eventContestCompetitionRegistration.displayHorse) &&
        Objects.equals(this.horses, eventContestCompetitionRegistration.horses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, eventContestCompetitionUuuid, creationTimestamp, creationUserUuid, changeTimestamp, changeUserUuid, changeCounter, currentState, registrationCompetitionDate, registrationAccountUuid, contestantUuid, paymentMethod, insurancePoliceId, remark, displayContestant, displayHorse, horses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventContestCompetitionRegistration {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    eventContestCompetitionUuuid: ").append(toIndentedString(eventContestCompetitionUuuid)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    creationUserUuid: ").append(toIndentedString(creationUserUuid)).append("\n");
    sb.append("    changeTimestamp: ").append(toIndentedString(changeTimestamp)).append("\n");
    sb.append("    changeUserUuid: ").append(toIndentedString(changeUserUuid)).append("\n");
    sb.append("    changeCounter: ").append(toIndentedString(changeCounter)).append("\n");
    sb.append("    currentState: ").append(toIndentedString(currentState)).append("\n");
    sb.append("    registrationCompetitionDate: ").append(toIndentedString(registrationCompetitionDate)).append("\n");
    sb.append("    registrationAccountUuid: ").append(toIndentedString(registrationAccountUuid)).append("\n");
    sb.append("    contestantUuid: ").append(toIndentedString(contestantUuid)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    insurancePoliceId: ").append(toIndentedString(insurancePoliceId)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
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

