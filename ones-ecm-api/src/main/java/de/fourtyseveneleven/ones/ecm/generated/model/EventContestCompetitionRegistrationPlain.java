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
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionRegistrationHorsePlain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * EventContestCompetitionRegistrationPlain
 */
@JsonPropertyOrder({
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_UUID,
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_REGISTRATION_COMPETITION_DATE,
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_REGISTRATION_ACCOUNT_UUID,
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_CONTESTANT_UUID,
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_PAYMENT_METHOD,
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_INSURANCE_POLICE_ID,
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_REMARK,
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_DISPLAY_CONTESTANT,
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_DISPLAY_HORSE,
  EventContestCompetitionRegistrationPlain.JSON_PROPERTY_HORSES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-30T10:23:10.438880610+01:00[Europe/Berlin]")
public class EventContestCompetitionRegistrationPlain {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

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
  private Set<EventContestCompetitionRegistrationHorsePlain> horses = null;


  public EventContestCompetitionRegistrationPlain uuid(String uuid) {
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


  public EventContestCompetitionRegistrationPlain registrationCompetitionDate(OffsetDateTime registrationCompetitionDate) {
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


  public EventContestCompetitionRegistrationPlain registrationAccountUuid(String registrationAccountUuid) {
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


  public EventContestCompetitionRegistrationPlain contestantUuid(String contestantUuid) {
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


  public EventContestCompetitionRegistrationPlain paymentMethod(Integer paymentMethod) {
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


  public EventContestCompetitionRegistrationPlain insurancePoliceId(String insurancePoliceId) {
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


  public EventContestCompetitionRegistrationPlain remark(String remark) {
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


  public EventContestCompetitionRegistrationPlain displayContestant(String displayContestant) {
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


  public EventContestCompetitionRegistrationPlain displayHorse(String displayHorse) {
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


  public EventContestCompetitionRegistrationPlain horses(Set<EventContestCompetitionRegistrationHorsePlain> horses) {
    this.horses = horses;
    return this;
  }

  public EventContestCompetitionRegistrationPlain addHorsesItem(EventContestCompetitionRegistrationHorsePlain horsesItem) {
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

  public Set<EventContestCompetitionRegistrationHorsePlain> getHorses() {
    return horses;
  }


  @JsonProperty(JSON_PROPERTY_HORSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHorses(Set<EventContestCompetitionRegistrationHorsePlain> horses) {
    this.horses = horses;
  }


  /**
   * Return true if this EventContestCompetitionRegistration_Plain object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventContestCompetitionRegistrationPlain eventContestCompetitionRegistrationPlain = (EventContestCompetitionRegistrationPlain) o;
    return Objects.equals(this.uuid, eventContestCompetitionRegistrationPlain.uuid) &&
        Objects.equals(this.registrationCompetitionDate, eventContestCompetitionRegistrationPlain.registrationCompetitionDate) &&
        Objects.equals(this.registrationAccountUuid, eventContestCompetitionRegistrationPlain.registrationAccountUuid) &&
        Objects.equals(this.contestantUuid, eventContestCompetitionRegistrationPlain.contestantUuid) &&
        Objects.equals(this.paymentMethod, eventContestCompetitionRegistrationPlain.paymentMethod) &&
        Objects.equals(this.insurancePoliceId, eventContestCompetitionRegistrationPlain.insurancePoliceId) &&
        Objects.equals(this.remark, eventContestCompetitionRegistrationPlain.remark) &&
        Objects.equals(this.displayContestant, eventContestCompetitionRegistrationPlain.displayContestant) &&
        Objects.equals(this.displayHorse, eventContestCompetitionRegistrationPlain.displayHorse) &&
        Objects.equals(this.horses, eventContestCompetitionRegistrationPlain.horses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, registrationCompetitionDate, registrationAccountUuid, contestantUuid, paymentMethod, insurancePoliceId, remark, displayContestant, displayHorse, horses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventContestCompetitionRegistrationPlain {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

