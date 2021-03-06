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
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestPlain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ResponcePageContestsPlain
 */
@JsonPropertyOrder({
  ResponcePageContestsPlain.JSON_PROPERTY_LAST_PAGE,
  ResponcePageContestsPlain.JSON_PROPERTY_TOTAL_ELEMENTS,
  ResponcePageContestsPlain.JSON_PROPERTY_DATA
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-01-11T10:56:24.580179898+01:00[Europe/Berlin]")
public class ResponcePageContestsPlain {
  public static final String JSON_PROPERTY_LAST_PAGE = "lastPage";
  private Integer lastPage;

  public static final String JSON_PROPERTY_TOTAL_ELEMENTS = "totalElements";
  private Long totalElements;

  public static final String JSON_PROPERTY_DATA = "data";
  private List<EventContestPlain> data = null;

  public ResponcePageContestsPlain() { 
  }

  public ResponcePageContestsPlain lastPage(Integer lastPage) {
    this.lastPage = lastPage;
    return this;
  }

   /**
   * Get lastPage
   * @return lastPage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LAST_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getLastPage() {
    return lastPage;
  }


  @JsonProperty(JSON_PROPERTY_LAST_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastPage(Integer lastPage) {
    this.lastPage = lastPage;
  }


  public ResponcePageContestsPlain totalElements(Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

   /**
   * Get totalElements
   * @return totalElements
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TOTAL_ELEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTotalElements() {
    return totalElements;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_ELEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }


  public ResponcePageContestsPlain data(List<EventContestPlain> data) {
    this.data = data;
    return this;
  }

  public ResponcePageContestsPlain addDataItem(EventContestPlain dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<EventContestPlain> getData() {
    return data;
  }


  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setData(List<EventContestPlain> data) {
    this.data = data;
  }


  /**
   * Return true if this ResponcePageContests_Plain object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponcePageContestsPlain responcePageContestsPlain = (ResponcePageContestsPlain) o;
    return Objects.equals(this.lastPage, responcePageContestsPlain.lastPage) &&
        Objects.equals(this.totalElements, responcePageContestsPlain.totalElements) &&
        Objects.equals(this.data, responcePageContestsPlain.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastPage, totalElements, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponcePageContestsPlain {\n");
    sb.append("    lastPage: ").append(toIndentedString(lastPage)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

