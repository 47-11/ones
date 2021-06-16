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

package de.fourtyseveneleven.ones.ecm.generated.api;

import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Pair;

import de.fourtyseveneleven.ones.ecm.generated.model.EventContest;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestPlain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Consumer;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-06-16T11:44:09.276003800+02:00[Europe/Berlin]")
public class EventContestControllerApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

  public EventContestControllerApi() {
    this(new ApiClient());
  }

  public EventContestControllerApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
  }

  protected ApiException createApiException(HttpResponse<InputStream> response, String msgPrefix) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    if (body != null) {
      msgPrefix += ": " + body;
    }
    return new ApiException(response.statusCode(), msgPrefix, response.headers(), body);
  }

  /**
   * 
   * 
   * @param uuid  (required)
   * @return EventContest
   * @throws ApiException if fails to make API call
   */
  public EventContest getContestByUuid(String uuid) throws ApiException {
    ApiResponse<EventContest> localVarResponse = getContestByUuidWithHttpInfo(uuid);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param uuid  (required)
   * @return ApiResponse&lt;EventContest&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<EventContest> getContestByUuidWithHttpInfo(String uuid) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getContestByUuidRequestBuilder(uuid);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "getContestByUuid call received non-success response");
      }
      return new ApiResponse<EventContest>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<EventContest>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getContestByUuidRequestBuilder(String uuid) throws ApiException {
    // verify the required parameter 'uuid' is set
    if (uuid == null) {
      throw new ApiException(400, "Missing the required parameter 'uuid' when calling getContestByUuid");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/event/contest";

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("uuid", uuid));

    if (!localVarQueryParams.isEmpty()) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * 
   * 
   * @param year  (required)
   * @param pageNo  (optional, default to 0)
   * @param pageSize  (optional, default to 10)
   * @param sortBy  (optional, default to beginning)
   * @return List&lt;EventContestPlain&gt;
   * @throws ApiException if fails to make API call
   */
  public List<EventContestPlain> getContestByYear(Integer year, Integer pageNo, Integer pageSize, String sortBy) throws ApiException {
    ApiResponse<List<EventContestPlain>> localVarResponse = getContestByYearWithHttpInfo(year, pageNo, pageSize, sortBy);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param year  (required)
   * @param pageNo  (optional, default to 0)
   * @param pageSize  (optional, default to 10)
   * @param sortBy  (optional, default to beginning)
   * @return ApiResponse&lt;List&lt;EventContestPlain&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<EventContestPlain>> getContestByYearWithHttpInfo(Integer year, Integer pageNo, Integer pageSize, String sortBy) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getContestByYearRequestBuilder(year, pageNo, pageSize, sortBy);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "getContestByYear call received non-success response");
      }
      return new ApiResponse<List<EventContestPlain>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<EventContestPlain>>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getContestByYearRequestBuilder(Integer year, Integer pageNo, Integer pageSize, String sortBy) throws ApiException {
    // verify the required parameter 'year' is set
    if (year == null) {
      throw new ApiException(400, "Missing the required parameter 'year' when calling getContestByYear");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/event/contests";

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("year", year));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("pageNo", pageNo));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("pageSize", pageSize));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("sortBy", sortBy));

    if (!localVarQueryParams.isEmpty()) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
}
