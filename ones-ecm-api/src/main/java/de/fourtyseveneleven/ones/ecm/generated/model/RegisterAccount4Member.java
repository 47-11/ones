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
 * RegisterAccount4Member
 */
@JsonPropertyOrder({
  RegisterAccount4Member.JSON_PROPERTY_UUID,
  RegisterAccount4Member.JSON_PROPERTY_VDD_MEMBER_NUMBER,
  RegisterAccount4Member.JSON_PROPERTY_LOGIN_IDENTIFICATION,
  RegisterAccount4Member.JSON_PROPERTY_LOGIN_KEYWORD,
  RegisterAccount4Member.JSON_PROPERTY_EMAIL
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-06T17:41:54.376651429+02:00[Europe/Berlin]")
public class RegisterAccount4Member {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_VDD_MEMBER_NUMBER = "vddMemberNumber";
  private Integer vddMemberNumber;

  public static final String JSON_PROPERTY_LOGIN_IDENTIFICATION = "loginIdentification";
  private String loginIdentification;

  public static final String JSON_PROPERTY_LOGIN_KEYWORD = "loginKeyword";
  private String loginKeyword;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;


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




  public RegisterAccount4Member vddMemberNumber(Integer vddMemberNumber) {
    this.vddMemberNumber = vddMemberNumber;
    return this;
  }

   /**
   * Get vddMemberNumber
   * minimum: 0
   * maximum: 10
   * @return vddMemberNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_VDD_MEMBER_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getVddMemberNumber() {
    return vddMemberNumber;
  }


  @JsonProperty(JSON_PROPERTY_VDD_MEMBER_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVddMemberNumber(Integer vddMemberNumber) {
    this.vddMemberNumber = vddMemberNumber;
  }


  public RegisterAccount4Member loginIdentification(String loginIdentification) {
    this.loginIdentification = loginIdentification;
    return this;
  }

   /**
   * Get loginIdentification
   * @return loginIdentification
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LOGIN_IDENTIFICATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLoginIdentification() {
    return loginIdentification;
  }


  @JsonProperty(JSON_PROPERTY_LOGIN_IDENTIFICATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLoginIdentification(String loginIdentification) {
    this.loginIdentification = loginIdentification;
  }


  public RegisterAccount4Member loginKeyword(String loginKeyword) {
    this.loginKeyword = loginKeyword;
    return this;
  }

   /**
   * Get loginKeyword
   * @return loginKeyword
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LOGIN_KEYWORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLoginKeyword() {
    return loginKeyword;
  }


  @JsonProperty(JSON_PROPERTY_LOGIN_KEYWORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLoginKeyword(String loginKeyword) {
    this.loginKeyword = loginKeyword;
  }


  public RegisterAccount4Member email(String email) {
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
   * Return true if this registerAccount4Member object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterAccount4Member registerAccount4Member = (RegisterAccount4Member) o;
    return Objects.equals(this.uuid, registerAccount4Member.uuid) &&
        Objects.equals(this.vddMemberNumber, registerAccount4Member.vddMemberNumber) &&
        Objects.equals(this.loginIdentification, registerAccount4Member.loginIdentification) &&
        Objects.equals(this.loginKeyword, registerAccount4Member.loginKeyword) &&
        Objects.equals(this.email, registerAccount4Member.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, vddMemberNumber, loginIdentification, loginKeyword, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterAccount4Member {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    vddMemberNumber: ").append(toIndentedString(vddMemberNumber)).append("\n");
    sb.append("    loginIdentification: ").append(toIndentedString(loginIdentification)).append("\n");
    sb.append("    loginKeyword: ").append(toIndentedString(loginKeyword)).append("\n");
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

