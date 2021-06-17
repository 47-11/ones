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

import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContact;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContact;

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

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-06-17T11:45:53.590955+02:00[Europe/Berlin]")
public class MasterdataContactControllerApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

  public MasterdataContactControllerApi() {
    this(new ApiClient());
  }

  public MasterdataContactControllerApi(ApiClient apiClient) {
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
   * @return MasterdataContact
   * @throws ApiException if fails to make API call
   */
  public MasterdataContact getContactByUuid(String uuid) throws ApiException {
    ApiResponse<MasterdataContact> localVarResponse = getContactByUuidWithHttpInfo(uuid);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param uuid  (required)
   * @return ApiResponse&lt;MasterdataContact&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<MasterdataContact> getContactByUuidWithHttpInfo(String uuid) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getContactByUuidRequestBuilder(uuid);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "getContactByUuid call received non-success response");
      }
      return new ApiResponse<MasterdataContact>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<MasterdataContact>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getContactByUuidRequestBuilder(String uuid) throws ApiException {
    // verify the required parameter 'uuid' is set
    if (uuid == null) {
      throw new ApiException(400, "Missing the required parameter 'uuid' when calling getContactByUuid");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/masterdata/contact/{uuid}"
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
   * @return MasterdataContact
   * @throws ApiException if fails to make API call
   */
  public MasterdataContact getCurrentContact() throws ApiException {
    ApiResponse<MasterdataContact> localVarResponse = getCurrentContactWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @return ApiResponse&lt;MasterdataContact&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<MasterdataContact> getCurrentContactWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getCurrentContactRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "getCurrentContact call received non-success response");
      }
      return new ApiResponse<MasterdataContact>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<MasterdataContact>() {})
        );
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getCurrentContactRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/masterdata/contact/current";

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
   * @param registerContact  (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object postRegisterContactContestant(RegisterContact registerContact) throws ApiException {
    ApiResponse<Object> localVarResponse = postRegisterContactContestantWithHttpInfo(registerContact);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param registerContact  (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Object> postRegisterContactContestantWithHttpInfo(RegisterContact registerContact) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postRegisterContactContestantRequestBuilder(registerContact);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "postRegisterContactContestant call received non-success response");
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

  private HttpRequest.Builder postRegisterContactContestantRequestBuilder(RegisterContact registerContact) throws ApiException {
    // verify the required parameter 'registerContact' is set
    if (registerContact == null) {
      throw new ApiException(400, "Missing the required parameter 'registerContact' when calling postRegisterContactContestant");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/masterdata/register/contact/contestant";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(registerContact);
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
  /**
   * 
   * 
   * @param registerContact  (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object postRegisterContactHorseOwner(RegisterContact registerContact) throws ApiException {
    ApiResponse<Object> localVarResponse = postRegisterContactHorseOwnerWithHttpInfo(registerContact);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param registerContact  (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Object> postRegisterContactHorseOwnerWithHttpInfo(RegisterContact registerContact) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postRegisterContactHorseOwnerRequestBuilder(registerContact);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "postRegisterContactHorseOwner call received non-success response");
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

  private HttpRequest.Builder postRegisterContactHorseOwnerRequestBuilder(RegisterContact registerContact) throws ApiException {
    // verify the required parameter 'registerContact' is set
    if (registerContact == null) {
      throw new ApiException(400, "Missing the required parameter 'registerContact' when calling postRegisterContactHorseOwner");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/masterdata/register/contact/horseOwner";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(registerContact);
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
  /**
   * 
   * 
   * @param registerContact  (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object postRegisterContactStable(RegisterContact registerContact) throws ApiException {
    ApiResponse<Object> localVarResponse = postRegisterContactStableWithHttpInfo(registerContact);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param registerContact  (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Object> postRegisterContactStableWithHttpInfo(RegisterContact registerContact) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postRegisterContactStableRequestBuilder(registerContact);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "postRegisterContactStable call received non-success response");
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

  private HttpRequest.Builder postRegisterContactStableRequestBuilder(RegisterContact registerContact) throws ApiException {
    // verify the required parameter 'registerContact' is set
    if (registerContact == null) {
      throw new ApiException(400, "Missing the required parameter 'registerContact' when calling postRegisterContactStable");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/masterdata/register/contact/stable";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(registerContact);
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
