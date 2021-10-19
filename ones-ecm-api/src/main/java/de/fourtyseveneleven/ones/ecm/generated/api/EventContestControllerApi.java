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
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionResult;
import java.time.OffsetDateTime;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterNomination;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterResponce;
import de.fourtyseveneleven.ones.ecm.generated.model.ResponcePageContestsPlain;

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

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-10-19T11:08:50.846901703+02:00[Europe/Berlin]")
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
   * @return List&lt;EventContestCompetitionResult&gt;
   * @throws ApiException if fails to make API call
   */
  public List<EventContestCompetitionResult> getAccountContestCompetitionsResults(String uuid) throws ApiException {
    ApiResponse<List<EventContestCompetitionResult>> localVarResponse = getAccountContestCompetitionsResultsWithHttpInfo(uuid);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param uuid  (required)
   * @return ApiResponse&lt;List&lt;EventContestCompetitionResult&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<EventContestCompetitionResult>> getAccountContestCompetitionsResultsWithHttpInfo(String uuid) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAccountContestCompetitionsResultsRequestBuilder(uuid);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "getAccountContestCompetitionsResults call received non-success response");
      }
      return new ApiResponse<List<EventContestCompetitionResult>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<EventContestCompetitionResult>>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getAccountContestCompetitionsResultsRequestBuilder(String uuid) throws ApiException {
    // verify the required parameter 'uuid' is set
    if (uuid == null) {
      throw new ApiException(400, "Missing the required parameter 'uuid' when calling getAccountContestCompetitionsResults");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/event/contest/result/account/{uuid}"
        .replace("{uuid}", ApiClient.urlEncode(uuid.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

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
   * @param contestUuid  (required)
   * @param accountUuid  (required)
   * @return EventContest
   * @throws ApiException if fails to make API call
   */
  public EventContest getContestByUuid(String contestUuid, String accountUuid) throws ApiException {
    ApiResponse<EventContest> localVarResponse = getContestByUuidWithHttpInfo(contestUuid, accountUuid);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param contestUuid  (required)
   * @param accountUuid  (required)
   * @return ApiResponse&lt;EventContest&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<EventContest> getContestByUuidWithHttpInfo(String contestUuid, String accountUuid) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getContestByUuidRequestBuilder(contestUuid, accountUuid);
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

  private HttpRequest.Builder getContestByUuidRequestBuilder(String contestUuid, String accountUuid) throws ApiException {
    // verify the required parameter 'contestUuid' is set
    if (contestUuid == null) {
      throw new ApiException(400, "Missing the required parameter 'contestUuid' when calling getContestByUuid");
    }
    // verify the required parameter 'accountUuid' is set
    if (accountUuid == null) {
      throw new ApiException(400, "Missing the required parameter 'accountUuid' when calling getContestByUuid");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/event/contest";

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("contestUuid", contestUuid));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("accountUuid", accountUuid));

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
   * @param fromDate  (optional)
   * @param untilDate  (optional)
   * @param countryRegions  (optional
   * @param contestKinds  (optional
   * @param isCountryChampionship  (optional)
   * @param isCEI  (optional)
   * @param isCard  (optional)
   * @param onlyRegistered  (optional)
   * @param accountUuid  (optional)
   * @param pageNo  (optional, default to 0)
   * @param pageSize  (optional, default to 10)
   * @param sortBy  (optional, default to beginning)
   * @return ResponcePageContestsPlain
   * @throws ApiException if fails to make API call
   */
  public ResponcePageContestsPlain getContestByYear(OffsetDateTime fromDate, OffsetDateTime untilDate, List<String> countryRegions, List<String> contestKinds, Integer isCountryChampionship, Integer isCEI, Integer isCard, Boolean onlyRegistered, String accountUuid, Integer pageNo, Integer pageSize, String sortBy) throws ApiException {
    ApiResponse<ResponcePageContestsPlain> localVarResponse = getContestByYearWithHttpInfo(fromDate, untilDate, countryRegions, contestKinds, isCountryChampionship, isCEI, isCard, onlyRegistered, accountUuid, pageNo, pageSize, sortBy);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param fromDate  (optional)
   * @param untilDate  (optional)
   * @param countryRegions  (optional
   * @param contestKinds  (optional
   * @param isCountryChampionship  (optional)
   * @param isCEI  (optional)
   * @param isCard  (optional)
   * @param onlyRegistered  (optional)
   * @param accountUuid  (optional)
   * @param pageNo  (optional, default to 0)
   * @param pageSize  (optional, default to 10)
   * @param sortBy  (optional, default to beginning)
   * @return ApiResponse&lt;ResponcePageContestsPlain&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ResponcePageContestsPlain> getContestByYearWithHttpInfo(OffsetDateTime fromDate, OffsetDateTime untilDate, List<String> countryRegions, List<String> contestKinds, Integer isCountryChampionship, Integer isCEI, Integer isCard, Boolean onlyRegistered, String accountUuid, Integer pageNo, Integer pageSize, String sortBy) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getContestByYearRequestBuilder(fromDate, untilDate, countryRegions, contestKinds, isCountryChampionship, isCEI, isCard, onlyRegistered, accountUuid, pageNo, pageSize, sortBy);
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
      return new ApiResponse<ResponcePageContestsPlain>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ResponcePageContestsPlain>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getContestByYearRequestBuilder(OffsetDateTime fromDate, OffsetDateTime untilDate, List<String> countryRegions, List<String> contestKinds, Integer isCountryChampionship, Integer isCEI, Integer isCard, Boolean onlyRegistered, String accountUuid, Integer pageNo, Integer pageSize, String sortBy) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/event/contests";

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("fromDate", fromDate));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("untilDate", untilDate));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("multi", "countryRegions", countryRegions));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("multi", "contestKinds", contestKinds));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("isCountryChampionship", isCountryChampionship));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("isCEI", isCEI));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("isCard", isCard));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("onlyRegistered", onlyRegistered));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("accountUuid", accountUuid));
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
  /**
   * 
   * 
   * @return List&lt;EventContestCompetitionResult&gt;
   * @throws ApiException if fails to make API call
   */
  public List<EventContestCompetitionResult> getCurrentContestCompetitionsResults() throws ApiException {
    ApiResponse<List<EventContestCompetitionResult>> localVarResponse = getCurrentContestCompetitionsResultsWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @return ApiResponse&lt;List&lt;EventContestCompetitionResult&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<EventContestCompetitionResult>> getCurrentContestCompetitionsResultsWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getCurrentContestCompetitionsResultsRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "getCurrentContestCompetitionsResults call received non-success response");
      }
      return new ApiResponse<List<EventContestCompetitionResult>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<EventContestCompetitionResult>>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getCurrentContestCompetitionsResultsRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/event/contest/result/current";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

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
   * @param registerNomination  (required)
   * @return RegisterResponce
   * @throws ApiException if fails to make API call
   */
  public RegisterResponce postRegisterNomination(RegisterNomination registerNomination) throws ApiException {
    ApiResponse<RegisterResponce> localVarResponse = postRegisterNominationWithHttpInfo(registerNomination);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param registerNomination  (required)
   * @return ApiResponse&lt;RegisterResponce&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<RegisterResponce> postRegisterNominationWithHttpInfo(RegisterNomination registerNomination) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postRegisterNominationRequestBuilder(registerNomination);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "postRegisterNomination call received non-success response");
      }
      return new ApiResponse<RegisterResponce>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<RegisterResponce>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder postRegisterNominationRequestBuilder(RegisterNomination registerNomination) throws ApiException {
    // verify the required parameter 'registerNomination' is set
    if (registerNomination == null) {
      throw new ApiException(400, "Missing the required parameter 'registerNomination' when calling postRegisterNomination");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/event/register/nomination";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(registerNomination);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
}
