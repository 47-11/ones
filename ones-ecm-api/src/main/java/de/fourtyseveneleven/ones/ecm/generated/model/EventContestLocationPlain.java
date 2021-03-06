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
 * EventContestLocationPlain
 */
@JsonPropertyOrder({
  EventContestLocationPlain.JSON_PROPERTY_UUID,
  EventContestLocationPlain.JSON_PROPERTY_NAME1,
  EventContestLocationPlain.JSON_PROPERTY_NAME2,
  EventContestLocationPlain.JSON_PROPERTY_NAME3,
  EventContestLocationPlain.JSON_PROPERTY_STREET,
  EventContestLocationPlain.JSON_PROPERTY_HOUSE_NUMBER,
  EventContestLocationPlain.JSON_PROPERTY_ZIPCODE,
  EventContestLocationPlain.JSON_PROPERTY_CITY,
  EventContestLocationPlain.JSON_PROPERTY_COUNTRY,
  EventContestLocationPlain.JSON_PROPERTY_PHONE,
  EventContestLocationPlain.JSON_PROPERTY_FAX,
  EventContestLocationPlain.JSON_PROPERTY_CELL_PHONE,
  EventContestLocationPlain.JSON_PROPERTY_EMAIL,
  EventContestLocationPlain.JSON_PROPERTY_GPS_COORDINATE,
  EventContestLocationPlain.JSON_PROPERTY_INFO
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-01-11T10:56:24.580179898+01:00[Europe/Berlin]")
public class EventContestLocationPlain {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_NAME1 = "name1";
  private String name1;

  public static final String JSON_PROPERTY_NAME2 = "name2";
  private String name2;

  public static final String JSON_PROPERTY_NAME3 = "name3";
  private String name3;

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

  public static final String JSON_PROPERTY_GPS_COORDINATE = "gpsCoordinate";
  private String gpsCoordinate;

  public static final String JSON_PROPERTY_INFO = "info";
  private String info;

  public EventContestLocationPlain() { 
  }

  public EventContestLocationPlain uuid(String uuid) {
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


  public EventContestLocationPlain name1(String name1) {
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


  public EventContestLocationPlain name2(String name2) {
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


  public EventContestLocationPlain name3(String name3) {
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


  public EventContestLocationPlain street(String street) {
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


  public EventContestLocationPlain houseNumber(String houseNumber) {
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


  public EventContestLocationPlain zipcode(String zipcode) {
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


  public EventContestLocationPlain city(String city) {
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


  public EventContestLocationPlain country(String country) {
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


  public EventContestLocationPlain phone(String phone) {
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


  public EventContestLocationPlain fax(String fax) {
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


  public EventContestLocationPlain cellPhone(String cellPhone) {
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


  public EventContestLocationPlain email(String email) {
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


  public EventContestLocationPlain gpsCoordinate(String gpsCoordinate) {
    this.gpsCoordinate = gpsCoordinate;
    return this;
  }

   /**
   * Get gpsCoordinate
   * @return gpsCoordinate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_GPS_COORDINATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGpsCoordinate() {
    return gpsCoordinate;
  }


  @JsonProperty(JSON_PROPERTY_GPS_COORDINATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGpsCoordinate(String gpsCoordinate) {
    this.gpsCoordinate = gpsCoordinate;
  }


  public EventContestLocationPlain info(String info) {
    this.info = info;
    return this;
  }

   /**
   * Get info
   * @return info
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo() {
    return info;
  }


  @JsonProperty(JSON_PROPERTY_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo(String info) {
    this.info = info;
  }


  /**
   * Return true if this EventContestLocation_Plain object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventContestLocationPlain eventContestLocationPlain = (EventContestLocationPlain) o;
    return Objects.equals(this.uuid, eventContestLocationPlain.uuid) &&
        Objects.equals(this.name1, eventContestLocationPlain.name1) &&
        Objects.equals(this.name2, eventContestLocationPlain.name2) &&
        Objects.equals(this.name3, eventContestLocationPlain.name3) &&
        Objects.equals(this.street, eventContestLocationPlain.street) &&
        Objects.equals(this.houseNumber, eventContestLocationPlain.houseNumber) &&
        Objects.equals(this.zipcode, eventContestLocationPlain.zipcode) &&
        Objects.equals(this.city, eventContestLocationPlain.city) &&
        Objects.equals(this.country, eventContestLocationPlain.country) &&
        Objects.equals(this.phone, eventContestLocationPlain.phone) &&
        Objects.equals(this.fax, eventContestLocationPlain.fax) &&
        Objects.equals(this.cellPhone, eventContestLocationPlain.cellPhone) &&
        Objects.equals(this.email, eventContestLocationPlain.email) &&
        Objects.equals(this.gpsCoordinate, eventContestLocationPlain.gpsCoordinate) &&
        Objects.equals(this.info, eventContestLocationPlain.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name1, name2, name3, street, houseNumber, zipcode, city, country, phone, fax, cellPhone, email, gpsCoordinate, info);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventContestLocationPlain {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name1: ").append(toIndentedString(name1)).append("\n");
    sb.append("    name2: ").append(toIndentedString(name2)).append("\n");
    sb.append("    name3: ").append(toIndentedString(name3)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    houseNumber: ").append(toIndentedString(houseNumber)).append("\n");
    sb.append("    zipcode: ").append(toIndentedString(zipcode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    cellPhone: ").append(toIndentedString(cellPhone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    gpsCoordinate: ").append(toIndentedString(gpsCoordinate)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
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

