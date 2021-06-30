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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RegisterNomination
 */
@JsonPropertyOrder({
  RegisterNomination.JSON_PROPERTY_COMPETITION_UUID,
  RegisterNomination.JSON_PROPERTY_CONTACT_UUID,
  RegisterNomination.JSON_PROPERTY_HORSES_UUIDS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-06-30T11:09:43.623625400+02:00[Europe/Berlin]")
public class RegisterNomination {
  public static final String JSON_PROPERTY_COMPETITION_UUID = "competitionUuid";
  private String competitionUuid;

  public static final String JSON_PROPERTY_CONTACT_UUID = "contactUuid";
  private String contactUuid;

  public static final String JSON_PROPERTY_HORSES_UUIDS = "horsesUuids";
  private List<String> horsesUuids = null;


  public RegisterNomination competitionUuid(String competitionUuid) {
    this.competitionUuid = competitionUuid;
    return this;
  }

   /**
   * Get competitionUuid
   * @return competitionUuid
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COMPETITION_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCompetitionUuid() {
    return competitionUuid;
  }


  @JsonProperty(JSON_PROPERTY_COMPETITION_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCompetitionUuid(String competitionUuid) {
    this.competitionUuid = competitionUuid;
  }


  public RegisterNomination contactUuid(String contactUuid) {
    this.contactUuid = contactUuid;
    return this;
  }

   /**
   * Get contactUuid
   * @return contactUuid
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CONTACT_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getContactUuid() {
    return contactUuid;
  }


  @JsonProperty(JSON_PROPERTY_CONTACT_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setContactUuid(String contactUuid) {
    this.contactUuid = contactUuid;
  }


  public RegisterNomination horsesUuids(List<String> horsesUuids) {
    this.horsesUuids = horsesUuids;
    return this;
  }

  public RegisterNomination addHorsesUuidsItem(String horsesUuidsItem) {
    if (this.horsesUuids == null) {
      this.horsesUuids = new ArrayList<>();
    }
    this.horsesUuids.add(horsesUuidsItem);
    return this;
  }

   /**
   * Get horsesUuids
   * @return horsesUuids
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HORSES_UUIDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getHorsesUuids() {
    return horsesUuids;
  }


  @JsonProperty(JSON_PROPERTY_HORSES_UUIDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHorsesUuids(List<String> horsesUuids) {
    this.horsesUuids = horsesUuids;
  }


  /**
   * Return true if this registerNomination object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterNomination registerNomination = (RegisterNomination) o;
    return Objects.equals(this.competitionUuid, registerNomination.competitionUuid) &&
        Objects.equals(this.contactUuid, registerNomination.contactUuid) &&
        Objects.equals(this.horsesUuids, registerNomination.horsesUuids);
  }

  @Override
  public int hashCode() {
    return Objects.hash(competitionUuid, contactUuid, horsesUuids);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterNomination {\n");
    sb.append("    competitionUuid: ").append(toIndentedString(competitionUuid)).append("\n");
    sb.append("    contactUuid: ").append(toIndentedString(contactUuid)).append("\n");
    sb.append("    horsesUuids: ").append(toIndentedString(horsesUuids)).append("\n");
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

