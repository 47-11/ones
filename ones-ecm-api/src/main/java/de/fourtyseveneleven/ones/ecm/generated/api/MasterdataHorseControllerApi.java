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

import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataHorse;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterHorse;

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

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-30T14:01:51.063115102+02:00[Europe/Berlin]")
public class MasterdataHorseControllerApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

  public MasterdataHorseControllerApi() {
    this(new ApiClient());
  }

  public MasterdataHorseControllerApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
  }

  /**
   * 
   * 
   * @param uuid  (required)
   * @return MasterdataHorse
   * @throws ApiException if fails to make API call
   */
  public MasterdataHorse getHorseByUuid(String uuid) throws ApiException {
    ApiResponse<MasterdataHorse> localVarResponse = getHorseByUuidWithHttpInfo(uuid);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param uuid  (required)
   * @return ApiResponse&lt;MasterdataHorse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<MasterdataHorse> getHorseByUuidWithHttpInfo(String uuid) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getHorseByUuidRequestBuilder(uuid);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw new ApiException(localVarResponse.statusCode(),
            "getHorseByUuid call received non-success response",
            localVarResponse.headers(),
            localVarResponse.body() == null ? null : new String(localVarResponse.body().readAllBytes()));
      }
      return new ApiResponse<MasterdataHorse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<MasterdataHorse>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getHorseByUuidRequestBuilder(String uuid) throws ApiException {
    // verify the required parameter 'uuid' is set
    if (uuid == null) {
      throw new ApiException(400, "Missing the required parameter 'uuid' when calling getHorseByUuid");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/masterdata/horse/{uuid}"
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
   * @param registerHorse  (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object postRegisterHorse(RegisterHorse registerHorse) throws ApiException {
    ApiResponse<Object> localVarResponse = postRegisterHorseWithHttpInfo(registerHorse);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param registerHorse  (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Object> postRegisterHorseWithHttpInfo(RegisterHorse registerHorse) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postRegisterHorseRequestBuilder(registerHorse);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw new ApiException(localVarResponse.statusCode(),
            "postRegisterHorse call received non-success response",
            localVarResponse.headers(),
            localVarResponse.body() == null ? null : new String(localVarResponse.body().readAllBytes()));
      }
      return new ApiResponse<Object>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Object>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder postRegisterHorseRequestBuilder(RegisterHorse registerHorse) throws ApiException {
    // verify the required parameter 'registerHorse' is set
    if (registerHorse == null) {
      throw new ApiException(400, "Missing the required parameter 'registerHorse' when calling postRegisterHorse");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/masterdata/register/horse";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(registerHorse);
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