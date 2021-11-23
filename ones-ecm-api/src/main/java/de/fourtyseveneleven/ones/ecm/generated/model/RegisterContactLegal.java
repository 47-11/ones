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
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RegisterContactLegal
 */
@JsonPropertyOrder({
  RegisterContactLegal.JSON_PROPERTY_NAME,
  RegisterContactLegal.JSON_PROPERTY_TYPE_OF,
  RegisterContactLegal.JSON_PROPERTY_FOUNDING_DAY,
  RegisterContactLegal.JSON_PROPERTY_EMAIL,
  RegisterContactLegal.JSON_PROPERTY_PHONE_NUMBER,
  RegisterContactLegal.JSON_PROPERTY_PHONE_NUMBER_MOBILE,
  RegisterContactLegal.JSON_PROPERTY_POSTAL_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-19T17:51:39.567128100+01:00[Europe/Berlin]")
public class RegisterContactLegal {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_TYPE_OF = "typeOf";
  private String typeOf;

  public static final String JSON_PROPERTY_FOUNDING_DAY = "foundingDay";
  private LocalDate foundingDay;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";
  private String phoneNumber;

  public static final String JSON_PROPERTY_PHONE_NUMBER_MOBILE = "phoneNumberMobile";
  private String phoneNumberMobile;

  public static final String JSON_PROPERTY_POSTAL_ADDRESS = "postalAddress";
  private RegisterAddress postalAddress;


  public RegisterContactLegal name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }


  public RegisterContactLegal typeOf(String typeOf) {
    this.typeOf = typeOf;
    return this;
  }

   /**
   * Get typeOf
   * @return typeOf
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TYPE_OF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTypeOf() {
    return typeOf;
  }


  @JsonProperty(JSON_PROPERTY_TYPE_OF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTypeOf(String typeOf) {
    this.typeOf = typeOf;
  }


  public RegisterContactLegal foundingDay(LocalDate foundingDay) {
    this.foundingDay = foundingDay;
    return this;
  }

   /**
   * Get foundingDay
   * @return foundingDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FOUNDING_DAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocalDate getFoundingDay() {
    return foundingDay;
  }


  @JsonProperty(JSON_PROPERTY_FOUNDING_DAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFoundingDay(LocalDate foundingDay) {
    this.foundingDay = foundingDay;
  }


  public RegisterContactLegal email(String email) {
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


  public RegisterContactLegal phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

   /**
   * Get phoneNumber
   * @return phoneNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhoneNumber() {
    return phoneNumber;
  }


  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public RegisterContactLegal phoneNumberMobile(String phoneNumberMobile) {
    this.phoneNumberMobile = phoneNumberMobile;
    return this;
  }

   /**
   * Get phoneNumberMobile
   * @return phoneNumberMobile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER_MOBILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhoneNumberMobile() {
    return phoneNumberMobile;
  }


  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER_MOBILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPhoneNumberMobile(String phoneNumberMobile) {
    this.phoneNumberMobile = phoneNumberMobile;
  }


  public RegisterContactLegal postalAddress(RegisterAddress postalAddress) {
    this.postalAddress = postalAddress;
    return this;
  }

   /**
   * Get postalAddress
   * @return postalAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_POSTAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RegisterAddress getPostalAddress() {
    return postalAddress;
  }


  @JsonProperty(JSON_PROPERTY_POSTAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPostalAddress(RegisterAddress postalAddress) {
    this.postalAddress = postalAddress;
  }


  /**
   * Return true if this registerContactLegal object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterContactLegal registerContactLegal = (RegisterContactLegal) o;
    return Objects.equals(this.name, registerContactLegal.name) &&
        Objects.equals(this.typeOf, registerContactLegal.typeOf) &&
        Objects.equals(this.foundingDay, registerContactLegal.foundingDay) &&
        Objects.equals(this.email, registerContactLegal.email) &&
        Objects.equals(this.phoneNumber, registerContactLegal.phoneNumber) &&
        Objects.equals(this.phoneNumberMobile, registerContactLegal.phoneNumberMobile) &&
        Objects.equals(this.postalAddress, registerContactLegal.postalAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, typeOf, foundingDay, email, phoneNumber, phoneNumberMobile, postalAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterContactLegal {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    typeOf: ").append(toIndentedString(typeOf)).append("\n");
    sb.append("    foundingDay: ").append(toIndentedString(foundingDay)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    phoneNumberMobile: ").append(toIndentedString(phoneNumberMobile)).append("\n");
    sb.append("    postalAddress: ").append(toIndentedString(postalAddress)).append("\n");
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

