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
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContactAddress;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContactRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * MasterdataContact
 */
@JsonPropertyOrder({
  MasterdataContact.JSON_PROPERTY_UUID,
  MasterdataContact.JSON_PROPERTY_CREATION_TIMESTAMP,
  MasterdataContact.JSON_PROPERTY_CREATION_USER_UUID,
  MasterdataContact.JSON_PROPERTY_CHANGE_TIMESTAMP,
  MasterdataContact.JSON_PROPERTY_CHANGE_USER_UUID,
  MasterdataContact.JSON_PROPERTY_CHANGE_COUNTER,
  MasterdataContact.JSON_PROPERTY_KIND,
  MasterdataContact.JSON_PROPERTY_SALUTATION,
  MasterdataContact.JSON_PROPERTY_SURNAME,
  MasterdataContact.JSON_PROPERTY_FORENAME,
  MasterdataContact.JSON_PROPERTY_BORN_NAME,
  MasterdataContact.JSON_PROPERTY_BORN_DATE,
  MasterdataContact.JSON_PROPERTY_NATIONALITY,
  MasterdataContact.JSON_PROPERTY_TITLE_ADDITION,
  MasterdataContact.JSON_PROPERTY_TITLE_NOBILITY,
  MasterdataContact.JSON_PROPERTY_TITLE_ACADEMIC,
  MasterdataContact.JSON_PROPERTY_TITLE_BUSINESS,
  MasterdataContact.JSON_PROPERTY_ARTIST_NAME,
  MasterdataContact.JSON_PROPERTY_NICK_NAME,
  MasterdataContact.JSON_PROPERTY_PHONE_PRIVATE,
  MasterdataContact.JSON_PROPERTY_PHONE_BUSINESS,
  MasterdataContact.JSON_PROPERTY_CELL_PHONE_PRIVATE,
  MasterdataContact.JSON_PROPERTY_CELL_PHONE_BUSINESS,
  MasterdataContact.JSON_PROPERTY_FAX_PRIVATE,
  MasterdataContact.JSON_PROPERTY_FAX_BUSINESS,
  MasterdataContact.JSON_PROPERTY_EMAIL_PRIVATE,
  MasterdataContact.JSON_PROPERTY_EMAIL_BUSINESS,
  MasterdataContact.JSON_PROPERTY_INFO1,
  MasterdataContact.JSON_PROPERTY_INFO2,
  MasterdataContact.JSON_PROPERTY_INFO3,
  MasterdataContact.JSON_PROPERTY_INFO4,
  MasterdataContact.JSON_PROPERTY_INFO5,
  MasterdataContact.JSON_PROPERTY_INFO6,
  MasterdataContact.JSON_PROPERTY_INFO7,
  MasterdataContact.JSON_PROPERTY_INFO8,
  MasterdataContact.JSON_PROPERTY_INFO9,
  MasterdataContact.JSON_PROPERTY_DISPLAY,
  MasterdataContact.JSON_PROPERTY_ADDRESSES,
  MasterdataContact.JSON_PROPERTY_ROLES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-06-16T11:44:09.276003800+02:00[Europe/Berlin]")
public class MasterdataContact {
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

  public static final String JSON_PROPERTY_KIND = "kind";
  private Integer kind;

  public static final String JSON_PROPERTY_SALUTATION = "salutation";
  private String salutation;

  public static final String JSON_PROPERTY_SURNAME = "surname";
  private String surname;

  public static final String JSON_PROPERTY_FORENAME = "forename";
  private String forename;

  public static final String JSON_PROPERTY_BORN_NAME = "bornName";
  private String bornName;

  public static final String JSON_PROPERTY_BORN_DATE = "bornDate";
  private OffsetDateTime bornDate;

  public static final String JSON_PROPERTY_NATIONALITY = "nationality";
  private String nationality;

  public static final String JSON_PROPERTY_TITLE_ADDITION = "titleAddition";
  private String titleAddition;

  public static final String JSON_PROPERTY_TITLE_NOBILITY = "titleNobility";
  private String titleNobility;

  public static final String JSON_PROPERTY_TITLE_ACADEMIC = "titleAcademic";
  private String titleAcademic;

  public static final String JSON_PROPERTY_TITLE_BUSINESS = "titleBusiness";
  private String titleBusiness;

  public static final String JSON_PROPERTY_ARTIST_NAME = "artistName";
  private String artistName;

  public static final String JSON_PROPERTY_NICK_NAME = "nickName";
  private String nickName;

  public static final String JSON_PROPERTY_PHONE_PRIVATE = "phonePrivate";
  private String phonePrivate;

  public static final String JSON_PROPERTY_PHONE_BUSINESS = "phoneBusiness";
  private String phoneBusiness;

  public static final String JSON_PROPERTY_CELL_PHONE_PRIVATE = "cellPhonePrivate";
  private String cellPhonePrivate;

  public static final String JSON_PROPERTY_CELL_PHONE_BUSINESS = "cellPhoneBusiness";
  private String cellPhoneBusiness;

  public static final String JSON_PROPERTY_FAX_PRIVATE = "faxPrivate";
  private String faxPrivate;

  public static final String JSON_PROPERTY_FAX_BUSINESS = "faxBusiness";
  private String faxBusiness;

  public static final String JSON_PROPERTY_EMAIL_PRIVATE = "emailPrivate";
  private String emailPrivate;

  public static final String JSON_PROPERTY_EMAIL_BUSINESS = "emailBusiness";
  private String emailBusiness;

  public static final String JSON_PROPERTY_INFO1 = "info1";
  private String info1;

  public static final String JSON_PROPERTY_INFO2 = "info2";
  private String info2;

  public static final String JSON_PROPERTY_INFO3 = "info3";
  private String info3;

  public static final String JSON_PROPERTY_INFO4 = "info4";
  private String info4;

  public static final String JSON_PROPERTY_INFO5 = "info5";
  private String info5;

  public static final String JSON_PROPERTY_INFO6 = "info6";
  private String info6;

  public static final String JSON_PROPERTY_INFO7 = "info7";
  private String info7;

  public static final String JSON_PROPERTY_INFO8 = "info8";
  private String info8;

  public static final String JSON_PROPERTY_INFO9 = "info9";
  private String info9;

  public static final String JSON_PROPERTY_DISPLAY = "display";
  private String display;

  public static final String JSON_PROPERTY_ADDRESSES = "_addresses";
  private List<MasterdataContactAddress> addresses = null;

  public static final String JSON_PROPERTY_ROLES = "_roles";
  private List<MasterdataContactRole> roles = null;


  public MasterdataContact uuid(String uuid) {
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


  public MasterdataContact creationTimestamp(OffsetDateTime creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
    return this;
  }

   /**
   * Get creationTimestamp
   * @return creationTimestamp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CREATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreationTimestamp() {
    return creationTimestamp;
  }


  @JsonProperty(JSON_PROPERTY_CREATION_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreationTimestamp(OffsetDateTime creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
  }


  public MasterdataContact creationUserUuid(String creationUserUuid) {
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


  public MasterdataContact changeTimestamp(OffsetDateTime changeTimestamp) {
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


  public MasterdataContact changeUserUuid(String changeUserUuid) {
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


  public MasterdataContact changeCounter(Integer changeCounter) {
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


  public MasterdataContact kind(Integer kind) {
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

  public Integer getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKind(Integer kind) {
    this.kind = kind;
  }


  public MasterdataContact salutation(String salutation) {
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


  public MasterdataContact surname(String surname) {
    this.surname = surname;
    return this;
  }

   /**
   * Get surname
   * @return surname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SURNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSurname() {
    return surname;
  }


  @JsonProperty(JSON_PROPERTY_SURNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSurname(String surname) {
    this.surname = surname;
  }


  public MasterdataContact forename(String forename) {
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


  public MasterdataContact bornName(String bornName) {
    this.bornName = bornName;
    return this;
  }

   /**
   * Get bornName
   * @return bornName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BORN_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBornName() {
    return bornName;
  }


  @JsonProperty(JSON_PROPERTY_BORN_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBornName(String bornName) {
    this.bornName = bornName;
  }


  public MasterdataContact bornDate(OffsetDateTime bornDate) {
    this.bornDate = bornDate;
    return this;
  }

   /**
   * Get bornDate
   * @return bornDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BORN_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getBornDate() {
    return bornDate;
  }


  @JsonProperty(JSON_PROPERTY_BORN_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBornDate(OffsetDateTime bornDate) {
    this.bornDate = bornDate;
  }


  public MasterdataContact nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

   /**
   * Get nationality
   * @return nationality
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NATIONALITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNationality() {
    return nationality;
  }


  @JsonProperty(JSON_PROPERTY_NATIONALITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }


  public MasterdataContact titleAddition(String titleAddition) {
    this.titleAddition = titleAddition;
    return this;
  }

   /**
   * Get titleAddition
   * @return titleAddition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TITLE_ADDITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitleAddition() {
    return titleAddition;
  }


  @JsonProperty(JSON_PROPERTY_TITLE_ADDITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitleAddition(String titleAddition) {
    this.titleAddition = titleAddition;
  }


  public MasterdataContact titleNobility(String titleNobility) {
    this.titleNobility = titleNobility;
    return this;
  }

   /**
   * Get titleNobility
   * @return titleNobility
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TITLE_NOBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitleNobility() {
    return titleNobility;
  }


  @JsonProperty(JSON_PROPERTY_TITLE_NOBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitleNobility(String titleNobility) {
    this.titleNobility = titleNobility;
  }


  public MasterdataContact titleAcademic(String titleAcademic) {
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


  public MasterdataContact titleBusiness(String titleBusiness) {
    this.titleBusiness = titleBusiness;
    return this;
  }

   /**
   * Get titleBusiness
   * @return titleBusiness
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TITLE_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitleBusiness() {
    return titleBusiness;
  }


  @JsonProperty(JSON_PROPERTY_TITLE_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitleBusiness(String titleBusiness) {
    this.titleBusiness = titleBusiness;
  }


  public MasterdataContact artistName(String artistName) {
    this.artistName = artistName;
    return this;
  }

   /**
   * Get artistName
   * @return artistName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ARTIST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getArtistName() {
    return artistName;
  }


  @JsonProperty(JSON_PROPERTY_ARTIST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }


  public MasterdataContact nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

   /**
   * Get nickName
   * @return nickName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NICK_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNickName() {
    return nickName;
  }


  @JsonProperty(JSON_PROPERTY_NICK_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }


  public MasterdataContact phonePrivate(String phonePrivate) {
    this.phonePrivate = phonePrivate;
    return this;
  }

   /**
   * Get phonePrivate
   * @return phonePrivate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PHONE_PRIVATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhonePrivate() {
    return phonePrivate;
  }


  @JsonProperty(JSON_PROPERTY_PHONE_PRIVATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPhonePrivate(String phonePrivate) {
    this.phonePrivate = phonePrivate;
  }


  public MasterdataContact phoneBusiness(String phoneBusiness) {
    this.phoneBusiness = phoneBusiness;
    return this;
  }

   /**
   * Get phoneBusiness
   * @return phoneBusiness
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PHONE_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhoneBusiness() {
    return phoneBusiness;
  }


  @JsonProperty(JSON_PROPERTY_PHONE_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPhoneBusiness(String phoneBusiness) {
    this.phoneBusiness = phoneBusiness;
  }


  public MasterdataContact cellPhonePrivate(String cellPhonePrivate) {
    this.cellPhonePrivate = cellPhonePrivate;
    return this;
  }

   /**
   * Get cellPhonePrivate
   * @return cellPhonePrivate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CELL_PHONE_PRIVATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCellPhonePrivate() {
    return cellPhonePrivate;
  }


  @JsonProperty(JSON_PROPERTY_CELL_PHONE_PRIVATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCellPhonePrivate(String cellPhonePrivate) {
    this.cellPhonePrivate = cellPhonePrivate;
  }


  public MasterdataContact cellPhoneBusiness(String cellPhoneBusiness) {
    this.cellPhoneBusiness = cellPhoneBusiness;
    return this;
  }

   /**
   * Get cellPhoneBusiness
   * @return cellPhoneBusiness
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CELL_PHONE_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCellPhoneBusiness() {
    return cellPhoneBusiness;
  }


  @JsonProperty(JSON_PROPERTY_CELL_PHONE_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCellPhoneBusiness(String cellPhoneBusiness) {
    this.cellPhoneBusiness = cellPhoneBusiness;
  }


  public MasterdataContact faxPrivate(String faxPrivate) {
    this.faxPrivate = faxPrivate;
    return this;
  }

   /**
   * Get faxPrivate
   * @return faxPrivate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FAX_PRIVATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFaxPrivate() {
    return faxPrivate;
  }


  @JsonProperty(JSON_PROPERTY_FAX_PRIVATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFaxPrivate(String faxPrivate) {
    this.faxPrivate = faxPrivate;
  }


  public MasterdataContact faxBusiness(String faxBusiness) {
    this.faxBusiness = faxBusiness;
    return this;
  }

   /**
   * Get faxBusiness
   * @return faxBusiness
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FAX_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFaxBusiness() {
    return faxBusiness;
  }


  @JsonProperty(JSON_PROPERTY_FAX_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFaxBusiness(String faxBusiness) {
    this.faxBusiness = faxBusiness;
  }


  public MasterdataContact emailPrivate(String emailPrivate) {
    this.emailPrivate = emailPrivate;
    return this;
  }

   /**
   * Get emailPrivate
   * @return emailPrivate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EMAIL_PRIVATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmailPrivate() {
    return emailPrivate;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL_PRIVATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmailPrivate(String emailPrivate) {
    this.emailPrivate = emailPrivate;
  }


  public MasterdataContact emailBusiness(String emailBusiness) {
    this.emailBusiness = emailBusiness;
    return this;
  }

   /**
   * Get emailBusiness
   * @return emailBusiness
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EMAIL_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmailBusiness() {
    return emailBusiness;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL_BUSINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmailBusiness(String emailBusiness) {
    this.emailBusiness = emailBusiness;
  }


  public MasterdataContact info1(String info1) {
    this.info1 = info1;
    return this;
  }

   /**
   * Get info1
   * @return info1
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo1() {
    return info1;
  }


  @JsonProperty(JSON_PROPERTY_INFO1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo1(String info1) {
    this.info1 = info1;
  }


  public MasterdataContact info2(String info2) {
    this.info2 = info2;
    return this;
  }

   /**
   * Get info2
   * @return info2
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo2() {
    return info2;
  }


  @JsonProperty(JSON_PROPERTY_INFO2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo2(String info2) {
    this.info2 = info2;
  }


  public MasterdataContact info3(String info3) {
    this.info3 = info3;
    return this;
  }

   /**
   * Get info3
   * @return info3
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo3() {
    return info3;
  }


  @JsonProperty(JSON_PROPERTY_INFO3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo3(String info3) {
    this.info3 = info3;
  }


  public MasterdataContact info4(String info4) {
    this.info4 = info4;
    return this;
  }

   /**
   * Get info4
   * @return info4
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO4)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo4() {
    return info4;
  }


  @JsonProperty(JSON_PROPERTY_INFO4)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo4(String info4) {
    this.info4 = info4;
  }


  public MasterdataContact info5(String info5) {
    this.info5 = info5;
    return this;
  }

   /**
   * Get info5
   * @return info5
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO5)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo5() {
    return info5;
  }


  @JsonProperty(JSON_PROPERTY_INFO5)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo5(String info5) {
    this.info5 = info5;
  }


  public MasterdataContact info6(String info6) {
    this.info6 = info6;
    return this;
  }

   /**
   * Get info6
   * @return info6
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO6)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo6() {
    return info6;
  }


  @JsonProperty(JSON_PROPERTY_INFO6)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo6(String info6) {
    this.info6 = info6;
  }


  public MasterdataContact info7(String info7) {
    this.info7 = info7;
    return this;
  }

   /**
   * Get info7
   * @return info7
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO7)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo7() {
    return info7;
  }


  @JsonProperty(JSON_PROPERTY_INFO7)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo7(String info7) {
    this.info7 = info7;
  }


  public MasterdataContact info8(String info8) {
    this.info8 = info8;
    return this;
  }

   /**
   * Get info8
   * @return info8
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO8)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo8() {
    return info8;
  }


  @JsonProperty(JSON_PROPERTY_INFO8)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo8(String info8) {
    this.info8 = info8;
  }


  public MasterdataContact info9(String info9) {
    this.info9 = info9;
    return this;
  }

   /**
   * Get info9
   * @return info9
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INFO9)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInfo9() {
    return info9;
  }


  @JsonProperty(JSON_PROPERTY_INFO9)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfo9(String info9) {
    this.info9 = info9;
  }


  public MasterdataContact display(String display) {
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


  public MasterdataContact addresses(List<MasterdataContactAddress> addresses) {
    this.addresses = addresses;
    return this;
  }

  public MasterdataContact addAddressesItem(MasterdataContactAddress addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

   /**
   * Get addresses
   * @return addresses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<MasterdataContactAddress> getAddresses() {
    return addresses;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddresses(List<MasterdataContactAddress> addresses) {
    this.addresses = addresses;
  }


  public MasterdataContact roles(List<MasterdataContactRole> roles) {
    this.roles = roles;
    return this;
  }

  public MasterdataContact addRolesItem(MasterdataContactRole rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ROLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<MasterdataContactRole> getRoles() {
    return roles;
  }


  @JsonProperty(JSON_PROPERTY_ROLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoles(List<MasterdataContactRole> roles) {
    this.roles = roles;
  }


  /**
   * Return true if this MasterdataContact object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MasterdataContact masterdataContact = (MasterdataContact) o;
    return Objects.equals(this.uuid, masterdataContact.uuid) &&
        Objects.equals(this.creationTimestamp, masterdataContact.creationTimestamp) &&
        Objects.equals(this.creationUserUuid, masterdataContact.creationUserUuid) &&
        Objects.equals(this.changeTimestamp, masterdataContact.changeTimestamp) &&
        Objects.equals(this.changeUserUuid, masterdataContact.changeUserUuid) &&
        Objects.equals(this.changeCounter, masterdataContact.changeCounter) &&
        Objects.equals(this.kind, masterdataContact.kind) &&
        Objects.equals(this.salutation, masterdataContact.salutation) &&
        Objects.equals(this.surname, masterdataContact.surname) &&
        Objects.equals(this.forename, masterdataContact.forename) &&
        Objects.equals(this.bornName, masterdataContact.bornName) &&
        Objects.equals(this.bornDate, masterdataContact.bornDate) &&
        Objects.equals(this.nationality, masterdataContact.nationality) &&
        Objects.equals(this.titleAddition, masterdataContact.titleAddition) &&
        Objects.equals(this.titleNobility, masterdataContact.titleNobility) &&
        Objects.equals(this.titleAcademic, masterdataContact.titleAcademic) &&
        Objects.equals(this.titleBusiness, masterdataContact.titleBusiness) &&
        Objects.equals(this.artistName, masterdataContact.artistName) &&
        Objects.equals(this.nickName, masterdataContact.nickName) &&
        Objects.equals(this.phonePrivate, masterdataContact.phonePrivate) &&
        Objects.equals(this.phoneBusiness, masterdataContact.phoneBusiness) &&
        Objects.equals(this.cellPhonePrivate, masterdataContact.cellPhonePrivate) &&
        Objects.equals(this.cellPhoneBusiness, masterdataContact.cellPhoneBusiness) &&
        Objects.equals(this.faxPrivate, masterdataContact.faxPrivate) &&
        Objects.equals(this.faxBusiness, masterdataContact.faxBusiness) &&
        Objects.equals(this.emailPrivate, masterdataContact.emailPrivate) &&
        Objects.equals(this.emailBusiness, masterdataContact.emailBusiness) &&
        Objects.equals(this.info1, masterdataContact.info1) &&
        Objects.equals(this.info2, masterdataContact.info2) &&
        Objects.equals(this.info3, masterdataContact.info3) &&
        Objects.equals(this.info4, masterdataContact.info4) &&
        Objects.equals(this.info5, masterdataContact.info5) &&
        Objects.equals(this.info6, masterdataContact.info6) &&
        Objects.equals(this.info7, masterdataContact.info7) &&
        Objects.equals(this.info8, masterdataContact.info8) &&
        Objects.equals(this.info9, masterdataContact.info9) &&
        Objects.equals(this.display, masterdataContact.display) &&
        Objects.equals(this.addresses, masterdataContact.addresses) &&
        Objects.equals(this.roles, masterdataContact.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, creationTimestamp, creationUserUuid, changeTimestamp, changeUserUuid, changeCounter, kind, salutation, surname, forename, bornName, bornDate, nationality, titleAddition, titleNobility, titleAcademic, titleBusiness, artistName, nickName, phonePrivate, phoneBusiness, cellPhonePrivate, cellPhoneBusiness, faxPrivate, faxBusiness, emailPrivate, emailBusiness, info1, info2, info3, info4, info5, info6, info7, info8, info9, display, addresses, roles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MasterdataContact {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    creationUserUuid: ").append(toIndentedString(creationUserUuid)).append("\n");
    sb.append("    changeTimestamp: ").append(toIndentedString(changeTimestamp)).append("\n");
    sb.append("    changeUserUuid: ").append(toIndentedString(changeUserUuid)).append("\n");
    sb.append("    changeCounter: ").append(toIndentedString(changeCounter)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    forename: ").append(toIndentedString(forename)).append("\n");
    sb.append("    bornName: ").append(toIndentedString(bornName)).append("\n");
    sb.append("    bornDate: ").append(toIndentedString(bornDate)).append("\n");
    sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
    sb.append("    titleAddition: ").append(toIndentedString(titleAddition)).append("\n");
    sb.append("    titleNobility: ").append(toIndentedString(titleNobility)).append("\n");
    sb.append("    titleAcademic: ").append(toIndentedString(titleAcademic)).append("\n");
    sb.append("    titleBusiness: ").append(toIndentedString(titleBusiness)).append("\n");
    sb.append("    artistName: ").append(toIndentedString(artistName)).append("\n");
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    phonePrivate: ").append(toIndentedString(phonePrivate)).append("\n");
    sb.append("    phoneBusiness: ").append(toIndentedString(phoneBusiness)).append("\n");
    sb.append("    cellPhonePrivate: ").append(toIndentedString(cellPhonePrivate)).append("\n");
    sb.append("    cellPhoneBusiness: ").append(toIndentedString(cellPhoneBusiness)).append("\n");
    sb.append("    faxPrivate: ").append(toIndentedString(faxPrivate)).append("\n");
    sb.append("    faxBusiness: ").append(toIndentedString(faxBusiness)).append("\n");
    sb.append("    emailPrivate: ").append(toIndentedString(emailPrivate)).append("\n");
    sb.append("    emailBusiness: ").append(toIndentedString(emailBusiness)).append("\n");
    sb.append("    info1: ").append(toIndentedString(info1)).append("\n");
    sb.append("    info2: ").append(toIndentedString(info2)).append("\n");
    sb.append("    info3: ").append(toIndentedString(info3)).append("\n");
    sb.append("    info4: ").append(toIndentedString(info4)).append("\n");
    sb.append("    info5: ").append(toIndentedString(info5)).append("\n");
    sb.append("    info6: ").append(toIndentedString(info6)).append("\n");
    sb.append("    info7: ").append(toIndentedString(info7)).append("\n");
    sb.append("    info8: ").append(toIndentedString(info8)).append("\n");
    sb.append("    info9: ").append(toIndentedString(info9)).append("\n");
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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

