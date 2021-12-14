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
 * RegisterContactNatural
 */
@JsonPropertyOrder({
  RegisterContactNatural.JSON_PROPERTY_SURNAME,
  RegisterContactNatural.JSON_PROPERTY_BIRTHNAME,
  RegisterContactNatural.JSON_PROPERTY_FORENAME,
  RegisterContactNatural.JSON_PROPERTY_SALUTATION,
  RegisterContactNatural.JSON_PROPERTY_BIRTHDAY,
  RegisterContactNatural.JSON_PROPERTY_EMAIL,
  RegisterContactNatural.JSON_PROPERTY_PHONE_NUMBER,
  RegisterContactNatural.JSON_PROPERTY_PHONE_NUMBER_MOBILE,
  RegisterContactNatural.JSON_PROPERTY_EMERGENCY_PHONE_NUMBER,
  RegisterContactNatural.JSON_PROPERTY_POSTAL_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-14T11:16:59.043131602+01:00[Europe/Berlin]")
public class RegisterContactNatural {
  public static final String JSON_PROPERTY_SURNAME = "surname";
  private String surname;

  public static final String JSON_PROPERTY_BIRTHNAME = "birthname";
  private String birthname;

  public static final String JSON_PROPERTY_FORENAME = "forename";
  private String forename;

  public static final String JSON_PROPERTY_SALUTATION = "salutation";
  private String salutation;

  public static final String JSON_PROPERTY_BIRTHDAY = "birthday";
  private LocalDate birthday;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";
  private String phoneNumber;

  public static final String JSON_PROPERTY_PHONE_NUMBER_MOBILE = "phoneNumberMobile";
  private String phoneNumberMobile;

  public static final String JSON_PROPERTY_EMERGENCY_PHONE_NUMBER = "emergencyPhoneNumber";
  private String emergencyPhoneNumber;

  public static final String JSON_PROPERTY_POSTAL_ADDRESS = "postalAddress";
  private RegisterAddress postalAddress;


  public RegisterContactNatural surname(String surname) {
    this.surname = surname;
    return this;
  }

   /**
   * Get surname
   * @return surname
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SURNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSurname() {
    return surname;
  }


  @JsonProperty(JSON_PROPERTY_SURNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSurname(String surname) {
    this.surname = surname;
  }


  public RegisterContactNatural birthname(String birthname) {
    this.birthname = birthname;
    return this;
  }

   /**
   * Get birthname
   * @return birthname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BIRTHNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBirthname() {
    return birthname;
  }


  @JsonProperty(JSON_PROPERTY_BIRTHNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBirthname(String birthname) {
    this.birthname = birthname;
  }


  public RegisterContactNatural forename(String forename) {
    this.forename = forename;
    return this;
  }

   /**
   * Get forename
   * @return forename
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FORENAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getForename() {
    return forename;
  }


  @JsonProperty(JSON_PROPERTY_FORENAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setForename(String forename) {
    this.forename = forename;
  }


  public RegisterContactNatural salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

   /**
   * Get salutation
   * @return salutation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SALUTATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSalutation() {
    return salutation;
  }


  @JsonProperty(JSON_PROPERTY_SALUTATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }


  public RegisterContactNatural birthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

   /**
   * Get birthday
   * @return birthday
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BIRTHDAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocalDate getBirthday() {
    return birthday;
  }


  @JsonProperty(JSON_PROPERTY_BIRTHDAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }


  public RegisterContactNatural email(String email) {
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


  public RegisterContactNatural phoneNumber(String phoneNumber) {
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


  public RegisterContactNatural phoneNumberMobile(String phoneNumberMobile) {
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


  public RegisterContactNatural emergencyPhoneNumber(String emergencyPhoneNumber) {
    this.emergencyPhoneNumber = emergencyPhoneNumber;
    return this;
  }

   /**
   * Get emergencyPhoneNumber
   * @return emergencyPhoneNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EMERGENCY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmergencyPhoneNumber() {
    return emergencyPhoneNumber;
  }


  @JsonProperty(JSON_PROPERTY_EMERGENCY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
    this.emergencyPhoneNumber = emergencyPhoneNumber;
  }


  public RegisterContactNatural postalAddress(RegisterAddress postalAddress) {
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
   * Return true if this registerContactNatural object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterContactNatural registerContactNatural = (RegisterContactNatural) o;
    return Objects.equals(this.surname, registerContactNatural.surname) &&
        Objects.equals(this.birthname, registerContactNatural.birthname) &&
        Objects.equals(this.forename, registerContactNatural.forename) &&
        Objects.equals(this.salutation, registerContactNatural.salutation) &&
        Objects.equals(this.birthday, registerContactNatural.birthday) &&
        Objects.equals(this.email, registerContactNatural.email) &&
        Objects.equals(this.phoneNumber, registerContactNatural.phoneNumber) &&
        Objects.equals(this.phoneNumberMobile, registerContactNatural.phoneNumberMobile) &&
        Objects.equals(this.emergencyPhoneNumber, registerContactNatural.emergencyPhoneNumber) &&
        Objects.equals(this.postalAddress, registerContactNatural.postalAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surname, birthname, forename, salutation, birthday, email, phoneNumber, phoneNumberMobile, emergencyPhoneNumber, postalAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterContactNatural {\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    birthname: ").append(toIndentedString(birthname)).append("\n");
    sb.append("    forename: ").append(toIndentedString(forename)).append("\n");
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    phoneNumberMobile: ").append(toIndentedString(phoneNumberMobile)).append("\n");
    sb.append("    emergencyPhoneNumber: ").append(toIndentedString(emergencyPhoneNumber)).append("\n");
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

