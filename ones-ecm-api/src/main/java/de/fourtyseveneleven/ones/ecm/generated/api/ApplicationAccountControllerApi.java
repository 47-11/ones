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

import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAccount;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAccount4Member;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterResponce;

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
public class ApplicationAccountControllerApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

  public ApplicationAccountControllerApi() {
    this(new ApiClient());
  }

  public ApplicationAccountControllerApi(ApiClient apiClient) {
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
   * @param registerAccount  (required)
   * @return RegisterResponce
   * @throws ApiException if fails to make API call
   */
  public RegisterResponce postRegisterAccount(RegisterAccount registerAccount) throws ApiException {
    ApiResponse<RegisterResponce> localVarResponse = postRegisterAccountWithHttpInfo(registerAccount);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param registerAccount  (required)
   * @return ApiResponse&lt;RegisterResponce&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<RegisterResponce> postRegisterAccountWithHttpInfo(RegisterAccount registerAccount) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postRegisterAccountRequestBuilder(registerAccount);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "postRegisterAccount call received non-success response");
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

  private HttpRequest.Builder postRegisterAccountRequestBuilder(RegisterAccount registerAccount) throws ApiException {
    // verify the required parameter 'registerAccount' is set
    if (registerAccount == null) {
      throw new ApiException(400, "Missing the required parameter 'registerAccount' when calling postRegisterAccount");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/application/register/account";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(registerAccount);
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
   * @param registerAccount4Member  (required)
   * @return RegisterResponce
   * @throws ApiException if fails to make API call
   */
  public RegisterResponce postRegisterAccount4Member(RegisterAccount4Member registerAccount4Member) throws ApiException {
    ApiResponse<RegisterResponce> localVarResponse = postRegisterAccount4MemberWithHttpInfo(registerAccount4Member);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param registerAccount4Member  (required)
   * @return ApiResponse&lt;RegisterResponce&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<RegisterResponce> postRegisterAccount4MemberWithHttpInfo(RegisterAccount4Member registerAccount4Member) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postRegisterAccount4MemberRequestBuilder(registerAccount4Member);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "postRegisterAccount4Member call received non-success response");
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

  private HttpRequest.Builder postRegisterAccount4MemberRequestBuilder(RegisterAccount4Member registerAccount4Member) throws ApiException {
    // verify the required parameter 'registerAccount4Member' is set
    if (registerAccount4Member == null) {
      throw new ApiException(400, "Missing the required parameter 'registerAccount4Member' when calling postRegisterAccount4Member");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/application/register/account4Member";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(registerAccount4Member);
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
   * @param uuid  (required)
   * @param code  (required)
   * @return RegisterResponce
   * @throws ApiException if fails to make API call
   */
  public RegisterResponce putRegisterAccountUnlock(String uuid, String code) throws ApiException {
    ApiResponse<RegisterResponce> localVarResponse = putRegisterAccountUnlockWithHttpInfo(uuid, code);
    return localVarResponse.getData();
  }

  /**
   * 
   * 
   * @param uuid  (required)
   * @param code  (required)
   * @return ApiResponse&lt;RegisterResponce&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<RegisterResponce> putRegisterAccountUnlockWithHttpInfo(String uuid, String code) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = putRegisterAccountUnlockRequestBuilder(uuid, code);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      if (localVarResponse.statusCode()/ 100 != 2) {
        throw createApiException(localVarResponse, "putRegisterAccountUnlock call received non-success response");
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

  private HttpRequest.Builder putRegisterAccountUnlockRequestBuilder(String uuid, String code) throws ApiException {
    // verify the required parameter 'uuid' is set
    if (uuid == null) {
      throw new ApiException(400, "Missing the required parameter 'uuid' when calling putRegisterAccountUnlock");
    }
    // verify the required parameter 'code' is set
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling putRegisterAccountUnlock");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/rest/application/register/account/unlock";

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("uuid", uuid));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("code", code));

    if (!localVarQueryParams.isEmpty()) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
}
