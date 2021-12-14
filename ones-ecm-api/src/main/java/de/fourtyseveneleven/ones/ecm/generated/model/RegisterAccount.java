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
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContactNatural;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterMembership;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RegisterAccount
 */
@JsonPropertyOrder({
  RegisterAccount.JSON_PROPERTY_UUID,
  RegisterAccount.JSON_PROPERTY_LOGIN_IDENTIFICATION,
  RegisterAccount.JSON_PROPERTY_LOGIN_KEYWORD,
  RegisterAccount.JSON_PROPERTY_NATIVE_LANGUAGE,
  RegisterAccount.JSON_PROPERTY_USER,
  RegisterAccount.JSON_PROPERTY_MEMBERSHIPS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-14T11:16:59.043131602+01:00[Europe/Berlin]")
public class RegisterAccount {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_LOGIN_IDENTIFICATION = "loginIdentification";
  private String loginIdentification;

  public static final String JSON_PROPERTY_LOGIN_KEYWORD = "loginKeyword";
  private String loginKeyword;

  public static final String JSON_PROPERTY_NATIVE_LANGUAGE = "nativeLanguage";
  private String nativeLanguage;

  public static final String JSON_PROPERTY_USER = "user";
  private RegisterContactNatural user;

  public static final String JSON_PROPERTY_MEMBERSHIPS = "memberships";
  private RegisterMembership memberships;


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




  public RegisterAccount loginIdentification(String loginIdentification) {
    this.loginIdentification = loginIdentification;
    return this;
  }

   /**
   * Get loginIdentification
   * @return loginIdentification
  **/
  @javax.annotation.Nonnull
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


  public RegisterAccount loginKeyword(String loginKeyword) {
    this.loginKeyword = loginKeyword;
    return this;
  }

   /**
   * Get loginKeyword
   * @return loginKeyword
  **/
  @javax.annotation.Nonnull
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


  public RegisterAccount nativeLanguage(String nativeLanguage) {
    this.nativeLanguage = nativeLanguage;
    return this;
  }

   /**
   * Get nativeLanguage
   * @return nativeLanguage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NATIVE_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNativeLanguage() {
    return nativeLanguage;
  }


  @JsonProperty(JSON_PROPERTY_NATIVE_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNativeLanguage(String nativeLanguage) {
    this.nativeLanguage = nativeLanguage;
  }


  public RegisterAccount user(RegisterContactNatural user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_USER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RegisterContactNatural getUser() {
    return user;
  }


  @JsonProperty(JSON_PROPERTY_USER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUser(RegisterContactNatural user) {
    this.user = user;
  }


  public RegisterAccount memberships(RegisterMembership memberships) {
    this.memberships = memberships;
    return this;
  }

   /**
   * Get memberships
   * @return memberships
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MEMBERSHIPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RegisterMembership getMemberships() {
    return memberships;
  }


  @JsonProperty(JSON_PROPERTY_MEMBERSHIPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMemberships(RegisterMembership memberships) {
    this.memberships = memberships;
  }


  /**
   * Return true if this registerAccount object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterAccount registerAccount = (RegisterAccount) o;
    return Objects.equals(this.uuid, registerAccount.uuid) &&
        Objects.equals(this.loginIdentification, registerAccount.loginIdentification) &&
        Objects.equals(this.loginKeyword, registerAccount.loginKeyword) &&
        Objects.equals(this.nativeLanguage, registerAccount.nativeLanguage) &&
        Objects.equals(this.user, registerAccount.user) &&
        Objects.equals(this.memberships, registerAccount.memberships);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, loginIdentification, loginKeyword, nativeLanguage, user, memberships);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterAccount {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    loginIdentification: ").append(toIndentedString(loginIdentification)).append("\n");
    sb.append("    loginKeyword: ").append(toIndentedString(loginKeyword)).append("\n");
    sb.append("    nativeLanguage: ").append(toIndentedString(nativeLanguage)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    memberships: ").append(toIndentedString(memberships)).append("\n");
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

