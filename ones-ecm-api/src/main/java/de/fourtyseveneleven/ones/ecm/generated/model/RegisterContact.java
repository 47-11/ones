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
 * RegisterContact
 */
@JsonPropertyOrder({
  RegisterContact.JSON_PROPERTY_SURNAME,
  RegisterContact.JSON_PROPERTY_FORENAME,
  RegisterContact.JSON_PROPERTY_SALUTATION,
  RegisterContact.JSON_PROPERTY_BIRTHDAY,
  RegisterContact.JSON_PROPERTY_EMAIL,
  RegisterContact.JSON_PROPERTY_PHONE_NUMBER,
  RegisterContact.JSON_PROPERTY_PHONE_NUMBER_MOBILE,
  RegisterContact.JSON_PROPERTY_POSTAL_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-30T14:01:51.063115102+02:00[Europe/Berlin]")
public class RegisterContact {
  public static final String JSON_PROPERTY_SURNAME = "surname";
  private String surname;

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

  public static final String JSON_PROPERTY_POSTAL_ADDRESS = "postalAddress";
  private RegisterAddress postalAddress;


  public RegisterContact surname(String surname) {
    this.surname = surname;
    return this;
  }

   /**
   * Get surname
   * @return surname
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SURNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSurname() {
    return surname;
  }


  public void setSurname(String surname) {
    this.surname = surname;
  }


  public RegisterContact forename(String forename) {
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


  public void setForename(String forename) {
    this.forename = forename;
  }


  public RegisterContact salutation(String salutation) {
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


  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }


  public RegisterContact birthday(LocalDate birthday) {
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


  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }


  public RegisterContact email(String email) {
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


  public void setEmail(String email) {
    this.email = email;
  }


  public RegisterContact phoneNumber(String phoneNumber) {
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


  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public RegisterContact phoneNumberMobile(String phoneNumberMobile) {
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


  public void setPhoneNumberMobile(String phoneNumberMobile) {
    this.phoneNumberMobile = phoneNumberMobile;
  }


  public RegisterContact postalAddress(RegisterAddress postalAddress) {
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


  public void setPostalAddress(RegisterAddress postalAddress) {
    this.postalAddress = postalAddress;
  }


  /**
   * Return true if this registerContact object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterContact registerContact = (RegisterContact) o;
    return Objects.equals(this.surname, registerContact.surname) &&
        Objects.equals(this.forename, registerContact.forename) &&
        Objects.equals(this.salutation, registerContact.salutation) &&
        Objects.equals(this.birthday, registerContact.birthday) &&
        Objects.equals(this.email, registerContact.email) &&
        Objects.equals(this.phoneNumber, registerContact.phoneNumber) &&
        Objects.equals(this.phoneNumberMobile, registerContact.phoneNumberMobile) &&
        Objects.equals(this.postalAddress, registerContact.postalAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surname, forename, salutation, birthday, email, phoneNumber, phoneNumberMobile, postalAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterContact {\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    forename: ").append(toIndentedString(forename)).append("\n");
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
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

