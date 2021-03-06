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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RegisterNominationHorse
 */
@JsonPropertyOrder({
  RegisterNominationHorse.JSON_PROPERTY_HORSE_UUID,
  RegisterNominationHorse.JSON_PROPERTY_ESCORT_HORSE,
  RegisterNominationHorse.JSON_PROPERTY_INSURANCE_POLICE_ID
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-01-11T10:56:24.580179898+01:00[Europe/Berlin]")
public class RegisterNominationHorse {
  public static final String JSON_PROPERTY_HORSE_UUID = "horseUuid";
  private String horseUuid;

  public static final String JSON_PROPERTY_ESCORT_HORSE = "escortHorse";
  private Boolean escortHorse;

  public static final String JSON_PROPERTY_INSURANCE_POLICE_ID = "insurancePoliceId";
  private String insurancePoliceId;

  public RegisterNominationHorse() { 
  }

  public RegisterNominationHorse horseUuid(String horseUuid) {
    this.horseUuid = horseUuid;
    return this;
  }

   /**
   * Get horseUuid
   * @return horseUuid
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_HORSE_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getHorseUuid() {
    return horseUuid;
  }


  @JsonProperty(JSON_PROPERTY_HORSE_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHorseUuid(String horseUuid) {
    this.horseUuid = horseUuid;
  }


  public RegisterNominationHorse escortHorse(Boolean escortHorse) {
    this.escortHorse = escortHorse;
    return this;
  }

   /**
   * Get escortHorse
   * @return escortHorse
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ESCORT_HORSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getEscortHorse() {
    return escortHorse;
  }


  @JsonProperty(JSON_PROPERTY_ESCORT_HORSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEscortHorse(Boolean escortHorse) {
    this.escortHorse = escortHorse;
  }


  public RegisterNominationHorse insurancePoliceId(String insurancePoliceId) {
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


  /**
   * Return true if this registerNominationHorse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterNominationHorse registerNominationHorse = (RegisterNominationHorse) o;
    return Objects.equals(this.horseUuid, registerNominationHorse.horseUuid) &&
        Objects.equals(this.escortHorse, registerNominationHorse.escortHorse) &&
        Objects.equals(this.insurancePoliceId, registerNominationHorse.insurancePoliceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(horseUuid, escortHorse, insurancePoliceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterNominationHorse {\n");
    sb.append("    horseUuid: ").append(toIndentedString(horseUuid)).append("\n");
    sb.append("    escortHorse: ").append(toIndentedString(escortHorse)).append("\n");
    sb.append("    insurancePoliceId: ").append(toIndentedString(insurancePoliceId)).append("\n");
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

