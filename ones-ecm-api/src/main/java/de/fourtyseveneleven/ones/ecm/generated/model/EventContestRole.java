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
 * EventContestRole
 */
@JsonPropertyOrder({
  EventContestRole.JSON_PROPERTY_UUID,
  EventContestRole.JSON_PROPERTY_CREATION_TIMESTAMP,
  EventContestRole.JSON_PROPERTY_CREATION_USER_UUID,
  EventContestRole.JSON_PROPERTY_CHANGE_TIMESTAMP,
  EventContestRole.JSON_PROPERTY_CHANGE_USER_UUID,
  EventContestRole.JSON_PROPERTY_CHANGE_COUNTER,
  EventContestRole.JSON_PROPERTY_CURRENT_STATE,
  EventContestRole.JSON_PROPERTY_KIND,
  EventContestRole.JSON_PROPERTY_MASTERDATA_CONTACT_UUID,
  EventContestRole.JSON_PROPERTY_DISPLAY,
  EventContestRole.JSON_PROPERTY_NAME1,
  EventContestRole.JSON_PROPERTY_NAME2,
  EventContestRole.JSON_PROPERTY_NAME3,
  EventContestRole.JSON_PROPERTY_TITLE_ACADEMIC,
  EventContestRole.JSON_PROPERTY_STREET,
  EventContestRole.JSON_PROPERTY_HOUSE_NUMBER,
  EventContestRole.JSON_PROPERTY_ZIPCODE,
  EventContestRole.JSON_PROPERTY_CITY,
  EventContestRole.JSON_PROPERTY_COUNTRY,
  EventContestRole.JSON_PROPERTY_PHONE,
  EventContestRole.JSON_PROPERTY_FAX,
  EventContestRole.JSON_PROPERTY_CELL_PHONE,
  EventContestRole.JSON_PROPERTY_EMAIL
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-06T17:41:54.376651429+02:00[Europe/Berlin]")
public class EventContestRole {
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

  public static final String JSON_PROPERTY_KIND = "kind";
  private String kind;

  public static final String JSON_PROPERTY_MASTERDATA_CONTACT_UUID = "masterdataContactUuid";
  private String masterdataContactUuid;

  public static final String JSON_PROPERTY_DISPLAY = "display";
  private String display;

  public static final String JSON_PROPERTY_NAME1 = "name1";
  private String name1;

  public static final String JSON_PROPERTY_NAME2 = "name2";
  private String name2;

  public static final String JSON_PROPERTY_NAME3 = "name3";
  private String name3;

  public static final String JSON_PROPERTY_TITLE_ACADEMIC = "titleAcademic";
  private String titleAcademic;

  public static final String JSON_PROPERTY_STREET = "street";
  private String street;

  public static final String JSON_PROPERTY_HOUSE_NUMBER = "houseNumber";
  private String houseNumber;

  public static final String JSON_PROPERTY_ZIPCODE = "zipcode";
  private String zipcode;

  public static final String JSON_PROPERTY_CITY = "city";
  private String city;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public static final String JSON_PROPERTY_PHONE = "phone";
  private String phone;

  public static final String JSON_PROPERTY_FAX = "fax";
  private String fax;

  public static final String JSON_PROPERTY_CELL_PHONE = "cellPhone";
  private String cellPhone;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;


  public EventContestRole uuid(String uuid) {
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


  public EventContestRole creationTimestamp(OffsetDateTime creationTimestamp) {
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


  public EventContestRole creationUserUuid(String creationUserUuid) {
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


  public EventContestRole changeTimestamp(OffsetDateTime changeTimestamp) {
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


  public EventContestRole changeUserUuid(String changeUserUuid) {
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


  public EventContestRole changeCounter(Integer changeCounter) {
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


  public EventContestRole currentState(Integer currentState) {
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


  public EventContestRole kind(String kind) {
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


  public EventContestRole masterdataContactUuid(String masterdataContactUuid) {
    this.masterdataContactUuid = masterdataContactUuid;
    return this;
  }

   /**
   * Get masterdataContactUuid
   * @return masterdataContactUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MASTERDATA_CONTACT_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMasterdataContactUuid() {
    return masterdataContactUuid;
  }


  @JsonProperty(JSON_PROPERTY_MASTERDATA_CONTACT_UUID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMasterdataContactUuid(String masterdataContactUuid) {
    this.masterdataContactUuid = masterdataContactUuid;
  }


  public EventContestRole display(String display) {
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


  public EventContestRole name1(String name1) {
    this.name1 = name1;
    return this;
  }

   /**
   * Get name1
   * @return name1
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAME1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName1() {
    return name1;
  }


  @JsonProperty(JSON_PROPERTY_NAME1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName1(String name1) {
    this.name1 = name1;
  }


  public EventContestRole name2(String name2) {
    this.name2 = name2;
    return this;
  }

   /**
   * Get name2
   * @return name2
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAME2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName2() {
    return name2;
  }


  @JsonProperty(JSON_PROPERTY_NAME2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName2(String name2) {
    this.name2 = name2;
  }


  public EventContestRole name3(String name3) {
    this.name3 = name3;
    return this;
  }

   /**
   * Get name3
   * @return name3
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAME3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName3() {
    return name3;
  }


  @JsonProperty(JSON_PROPERTY_NAME3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName3(String name3) {
    this.name3 = name3;
  }


  public EventContestRole titleAcademic(String titleAcademic) {
    this.titleAcademic = titleAcademic;
    return this;
  }

   /**
   * Get titleAcademic
   * @return titleAcademic
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TITLE_ACADEMIC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitleAcademic() {
    return titleAcademic;
  }


  @JsonProperty(JSON_PROPERTY_TITLE_ACADEMIC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitleAcademic(String titleAcademic) {
    this.titleAcademic = titleAcademic;
  }


  public EventContestRole street(String street) {
    this.street = street;
    return this;
  }

   /**
   * Get street
   * @return street
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STREET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStreet() {
    return street;
  }


  @JsonProperty(JSON_PROPERTY_STREET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStreet(String street) {
    this.street = street;
  }


  public EventContestRole houseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
    return this;
  }

   /**
   * Get houseNumber
   * @return houseNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HOUSE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getHouseNumber() {
    return houseNumber;
  }


  @JsonProperty(JSON_PROPERTY_HOUSE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }


  public EventContestRole zipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }

   /**
   * Get zipcode
   * @return zipcode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ZIPCODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getZipcode() {
    return zipcode;
  }


  @JsonProperty(JSON_PROPERTY_ZIPCODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }


  public EventContestRole city(String city) {
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCity() {
    return city;
  }


  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCity(String city) {
    this.city = city;
  }


  public EventContestRole country(String country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCountry() {
    return country;
  }


  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountry(String country) {
    this.country = country;
  }


  public EventContestRole phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * Get phone
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PHONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhone() {
    return phone;
  }


  @JsonProperty(JSON_PROPERTY_PHONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPhone(String phone) {
    this.phone = phone;
  }


  public EventContestRole fax(String fax) {
    this.fax = fax;
    return this;
  }

   /**
   * Get fax
   * @return fax
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FAX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFax() {
    return fax;
  }


  @JsonProperty(JSON_PROPERTY_FAX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFax(String fax) {
    this.fax = fax;
  }


  public EventContestRole cellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
    return this;
  }

   /**
   * Get cellPhone
   * @return cellPhone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CELL_PHONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCellPhone() {
    return cellPhone;
  }


  @JsonProperty(JSON_PROPERTY_CELL_PHONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }


  public EventContestRole email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmail() {
    return email;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmail(String email) {
    this.email = email;
  }


  /**
   * Return true if this EventContestRole object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventContestRole eventContestRole = (EventContestRole) o;
    return Objects.equals(this.uuid, eventContestRole.uuid) &&
        Objects.equals(this.creationTimestamp, eventContestRole.creationTimestamp) &&
        Objects.equals(this.creationUserUuid, eventContestRole.creationUserUuid) &&
        Objects.equals(this.changeTimestamp, eventContestRole.changeTimestamp) &&
        Objects.equals(this.changeUserUuid, eventContestRole.changeUserUuid) &&
        Objects.equals(this.changeCounter, eventContestRole.changeCounter) &&
        Objects.equals(this.currentState, eventContestRole.currentState) &&
        Objects.equals(this.kind, eventContestRole.kind) &&
        Objects.equals(this.masterdataContactUuid, eventContestRole.masterdataContactUuid) &&
        Objects.equals(this.display, eventContestRole.display) &&
        Objects.equals(this.name1, eventContestRole.name1) &&
        Objects.equals(this.name2, eventContestRole.name2) &&
        Objects.equals(this.name3, eventContestRole.name3) &&
        Objects.equals(this.titleAcademic, eventContestRole.titleAcademic) &&
        Objects.equals(this.street, eventContestRole.street) &&
        Objects.equals(this.houseNumber, eventContestRole.houseNumber) &&
        Objects.equals(this.zipcode, eventContestRole.zipcode) &&
        Objects.equals(this.city, eventContestRole.city) &&
        Objects.equals(this.country, eventContestRole.country) &&
        Objects.equals(this.phone, eventContestRole.phone) &&
        Objects.equals(this.fax, eventContestRole.fax) &&
        Objects.equals(this.cellPhone, eventContestRole.cellPhone) &&
        Objects.equals(this.email, eventContestRole.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, creationTimestamp, creationUserUuid, changeTimestamp, changeUserUuid, changeCounter, currentState, kind, masterdataContactUuid, display, name1, name2, name3, titleAcademic, street, houseNumber, zipcode, city, country, phone, fax, cellPhone, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventContestRole {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    creationUserUuid: ").append(toIndentedString(creationUserUuid)).append("\n");
    sb.append("    changeTimestamp: ").append(toIndentedString(changeTimestamp)).append("\n");
    sb.append("    changeUserUuid: ").append(toIndentedString(changeUserUuid)).append("\n");
    sb.append("    changeCounter: ").append(toIndentedString(changeCounter)).append("\n");
    sb.append("    currentState: ").append(toIndentedString(currentState)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    masterdataContactUuid: ").append(toIndentedString(masterdataContactUuid)).append("\n");
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
    sb.append("    name1: ").append(toIndentedString(name1)).append("\n");
    sb.append("    name2: ").append(toIndentedString(name2)).append("\n");
    sb.append("    name3: ").append(toIndentedString(name3)).append("\n");
    sb.append("    titleAcademic: ").append(toIndentedString(titleAcademic)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    houseNumber: ").append(toIndentedString(houseNumber)).append("\n");
    sb.append("    zipcode: ").append(toIndentedString(zipcode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    cellPhone: ").append(toIndentedString(cellPhone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

