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
 * RegisterAddress
 */
@JsonPropertyOrder({
  RegisterAddress.JSON_PROPERTY_COUNTRY,
  RegisterAddress.JSON_PROPERTY_ZIP_CODE,
  RegisterAddress.JSON_PROPERTY_CITY,
  RegisterAddress.JSON_PROPERTY_STREET,
  RegisterAddress.JSON_PROPERTY_HOUSE_NUMBER
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-06-17T11:45:53.590955+02:00[Europe/Berlin]")
public class RegisterAddress {
  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public static final String JSON_PROPERTY_ZIP_CODE = "zipCode";
  private String zipCode;

  public static final String JSON_PROPERTY_CITY = "city";
  private String city;

  public static final String JSON_PROPERTY_STREET = "street";
  private String street;

  public static final String JSON_PROPERTY_HOUSE_NUMBER = "houseNumber";
  private String houseNumber;


  public RegisterAddress country(String country) {
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


  public RegisterAddress zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

   /**
   * Get zipCode
   * @return zipCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ZIP_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getZipCode() {
    return zipCode;
  }


  @JsonProperty(JSON_PROPERTY_ZIP_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }


  public RegisterAddress city(String city) {
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCity() {
    return city;
  }


  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCity(String city) {
    this.city = city;
  }


  public RegisterAddress street(String street) {
    this.street = street;
    return this;
  }

   /**
   * Get street
   * @return street
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STREET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getStreet() {
    return street;
  }


  @JsonProperty(JSON_PROPERTY_STREET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStreet(String street) {
    this.street = street;
  }


  public RegisterAddress houseNumber(String houseNumber) {
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


  /**
   * Return true if this registerAddress object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterAddress registerAddress = (RegisterAddress) o;
    return Objects.equals(this.country, registerAddress.country) &&
        Objects.equals(this.zipCode, registerAddress.zipCode) &&
        Objects.equals(this.city, registerAddress.city) &&
        Objects.equals(this.street, registerAddress.street) &&
        Objects.equals(this.houseNumber, registerAddress.houseNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, zipCode, city, street, houseNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterAddress {\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    houseNumber: ").append(toIndentedString(houseNumber)).append("\n");
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

