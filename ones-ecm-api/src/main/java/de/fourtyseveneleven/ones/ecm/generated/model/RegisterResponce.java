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
 * RegisterResponce
 */
@JsonPropertyOrder({
  RegisterResponce.JSON_PROPERTY_UUID,
  RegisterResponce.JSON_PROPERTY_STATE,
  RegisterResponce.JSON_PROPERTY_REASON_CODE,
  RegisterResponce.JSON_PROPERTY_JUSTIFICATION,
  RegisterResponce.JSON_PROPERTY_REGISTER_OBJECT_UUID
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-19T17:51:39.567128100+01:00[Europe/Berlin]")
public class RegisterResponce {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_STATE = "state";
  private String state;

  public static final String JSON_PROPERTY_REASON_CODE = "reasonCode";
  private Integer reasonCode;

  public static final String JSON_PROPERTY_JUSTIFICATION = "justification";
  private String justification;

  public static final String JSON_PROPERTY_REGISTER_OBJECT_UUID = "registerObjectUuid";
  private String registerObjectUuid;


  public RegisterResponce uuid(String uuid) {
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


  public RegisterResponce state(String state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(String state) {
    this.state = state;
  }


  public RegisterResponce reasonCode(Integer reasonCode) {
    this.reasonCode = reasonCode;
    return this;
  }

   /**
   * Get reasonCode
   * @return reasonCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_REASON_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getReasonCode() {
    return reasonCode;
  }


  @JsonProperty(JSON_PROPERTY_REASON_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReasonCode(Integer reasonCode) {
    this.reasonCode = reasonCode;
  }


  public RegisterResponce justification(String justification) {
    this.justification = justification;
    return this;
  }

   /**
   * Get justification
   * @return justification
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_JUSTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getJustification() {
    return justification;
  }


  @JsonProperty(JSON_PROPERTY_JUSTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setJustification(String justification) {
    this.justification = justification;
  }


  public RegisterResponce registerObjectUuid(String registerObjectUuid) {
    this.registerObjectUuid = registerObjectUuid;
    return this;
  }

   /**
   * Get registerObjectUuid
   * @return registerObjectUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_REGISTER_OBJECT_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRegisterObjectUuid() {
    return registerObjectUuid;
  }


  @JsonProperty(JSON_PROPERTY_REGISTER_OBJECT_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRegisterObjectUuid(String registerObjectUuid) {
    this.registerObjectUuid = registerObjectUuid;
  }


  /**
   * Return true if this registerResponce object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterResponce registerResponce = (RegisterResponce) o;
    return Objects.equals(this.uuid, registerResponce.uuid) &&
        Objects.equals(this.state, registerResponce.state) &&
        Objects.equals(this.reasonCode, registerResponce.reasonCode) &&
        Objects.equals(this.justification, registerResponce.justification) &&
        Objects.equals(this.registerObjectUuid, registerResponce.registerObjectUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, state, reasonCode, justification, registerObjectUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterResponce {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
    sb.append("    justification: ").append(toIndentedString(justification)).append("\n");
    sb.append("    registerObjectUuid: ").append(toIndentedString(registerObjectUuid)).append("\n");
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

