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
import de.fourtyseveneleven.ones.ecm.generated.model.RegisteredHorse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * RegisteredAccount
 */
@JsonPropertyOrder({
  RegisteredAccount.JSON_PROPERTY_UUID,
  RegisteredAccount.JSON_PROPERTY_LOGIN_IDENTIFICATION,
  RegisteredAccount.JSON_PROPERTY_NATIVE_LANGUAGE,
  RegisteredAccount.JSON_PROPERTY_USER,
  RegisteredAccount.JSON_PROPERTY_MEMBERSHIPS,
  RegisteredAccount.JSON_PROPERTY_HORSES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-09T11:10:50.309099276+01:00[Europe/Berlin]")
public class RegisteredAccount {
  public static final String JSON_PROPERTY_UUID = "uuid";
  private String uuid;

  public static final String JSON_PROPERTY_LOGIN_IDENTIFICATION = "loginIdentification";
  private String loginIdentification;

  public static final String JSON_PROPERTY_NATIVE_LANGUAGE = "nativeLanguage";
  private String nativeLanguage;

  public static final String JSON_PROPERTY_USER = "user";
  private RegisterContactNatural user;

  public static final String JSON_PROPERTY_MEMBERSHIPS = "memberships";
  private RegisterMembership memberships;

  public static final String JSON_PROPERTY_HORSES = "horses";
  private Set<RegisteredHorse> horses = null;


  public RegisteredAccount uuid(String uuid) {
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


  public RegisteredAccount loginIdentification(String loginIdentification) {
    this.loginIdentification = loginIdentification;
    return this;
  }

   /**
   * Get loginIdentification
   * @return loginIdentification
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LOGIN_IDENTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLoginIdentification() {
    return loginIdentification;
  }


  @JsonProperty(JSON_PROPERTY_LOGIN_IDENTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLoginIdentification(String loginIdentification) {
    this.loginIdentification = loginIdentification;
  }


  public RegisteredAccount nativeLanguage(String nativeLanguage) {
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


  public RegisteredAccount user(RegisterContactNatural user) {
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


  public RegisteredAccount memberships(RegisterMembership memberships) {
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


  public RegisteredAccount horses(Set<RegisteredHorse> horses) {
    this.horses = horses;
    return this;
  }

  public RegisteredAccount addHorsesItem(RegisteredHorse horsesItem) {
    if (this.horses == null) {
      this.horses = new LinkedHashSet<>();
    }
    this.horses.add(horsesItem);
    return this;
  }

   /**
   * Get horses
   * @return horses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HORSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Set<RegisteredHorse> getHorses() {
    return horses;
  }


  @JsonProperty(JSON_PROPERTY_HORSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHorses(Set<RegisteredHorse> horses) {
    this.horses = horses;
  }


  /**
   * Return true if this registeredAccount object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisteredAccount registeredAccount = (RegisteredAccount) o;
    return Objects.equals(this.uuid, registeredAccount.uuid) &&
        Objects.equals(this.loginIdentification, registeredAccount.loginIdentification) &&
        Objects.equals(this.nativeLanguage, registeredAccount.nativeLanguage) &&
        Objects.equals(this.user, registeredAccount.user) &&
        Objects.equals(this.memberships, registeredAccount.memberships) &&
        Objects.equals(this.horses, registeredAccount.horses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, loginIdentification, nativeLanguage, user, memberships, horses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisteredAccount {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    loginIdentification: ").append(toIndentedString(loginIdentification)).append("\n");
    sb.append("    nativeLanguage: ").append(toIndentedString(nativeLanguage)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    memberships: ").append(toIndentedString(memberships)).append("\n");
    sb.append("    horses: ").append(toIndentedString(horses)).append("\n");
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

