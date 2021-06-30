# ApplicationAccountControllerApi

All URIs are relative to *https://vdd4ones.de:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**postRegisterAccount**](ApplicationAccountControllerApi.md#postRegisterAccount) | **POST** /rest/application/register/account | 
[**postRegisterAccountWithHttpInfo**](ApplicationAccountControllerApi.md#postRegisterAccountWithHttpInfo) | **POST** /rest/application/register/account | 
[**postRegisterAccount4Member**](ApplicationAccountControllerApi.md#postRegisterAccount4Member) | **POST** /rest/application/register/account4Member | 
[**postRegisterAccount4MemberWithHttpInfo**](ApplicationAccountControllerApi.md#postRegisterAccount4MemberWithHttpInfo) | **POST** /rest/application/register/account4Member | 
[**putRegisterAccountUnlock**](ApplicationAccountControllerApi.md#putRegisterAccountUnlock) | **PUT** /rest/application/register/account/unlock | 
[**putRegisterAccountUnlockWithHttpInfo**](ApplicationAccountControllerApi.md#putRegisterAccountUnlockWithHttpInfo) | **PUT** /rest/application/register/account/unlock | 



## postRegisterAccount

> RegisterResponce postRegisterAccount(registerAccount)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ApplicationAccountControllerApi apiInstance = new ApplicationAccountControllerApi(defaultClient);
        RegisterAccount registerAccount = new RegisterAccount(); // RegisterAccount | 
        try {
            RegisterResponce result = apiInstance.postRegisterAccount(registerAccount);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#postRegisterAccount");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registerAccount** | [**RegisterAccount**](RegisterAccount.md)|  |

### Return type

[**RegisterResponce**](RegisterResponce.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## postRegisterAccountWithHttpInfo

> ApiResponse<RegisterResponce> postRegisterAccount postRegisterAccountWithHttpInfo(registerAccount)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ApplicationAccountControllerApi apiInstance = new ApplicationAccountControllerApi(defaultClient);
        RegisterAccount registerAccount = new RegisterAccount(); // RegisterAccount | 
        try {
            ApiResponse<RegisterResponce> response = apiInstance.postRegisterAccountWithHttpInfo(registerAccount);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#postRegisterAccount");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registerAccount** | [**RegisterAccount**](RegisterAccount.md)|  |

### Return type

ApiResponse<[**RegisterResponce**](RegisterResponce.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## postRegisterAccount4Member

> RegisterResponce postRegisterAccount4Member(registerAccount4Member)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ApplicationAccountControllerApi apiInstance = new ApplicationAccountControllerApi(defaultClient);
        RegisterAccount4Member registerAccount4Member = new RegisterAccount4Member(); // RegisterAccount4Member | 
        try {
            RegisterResponce result = apiInstance.postRegisterAccount4Member(registerAccount4Member);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#postRegisterAccount4Member");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registerAccount4Member** | [**RegisterAccount4Member**](RegisterAccount4Member.md)|  |

### Return type

[**RegisterResponce**](RegisterResponce.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## postRegisterAccount4MemberWithHttpInfo

> ApiResponse<RegisterResponce> postRegisterAccount4Member postRegisterAccount4MemberWithHttpInfo(registerAccount4Member)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ApplicationAccountControllerApi apiInstance = new ApplicationAccountControllerApi(defaultClient);
        RegisterAccount4Member registerAccount4Member = new RegisterAccount4Member(); // RegisterAccount4Member | 
        try {
            ApiResponse<RegisterResponce> response = apiInstance.postRegisterAccount4MemberWithHttpInfo(registerAccount4Member);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#postRegisterAccount4Member");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registerAccount4Member** | [**RegisterAccount4Member**](RegisterAccount4Member.md)|  |

### Return type

ApiResponse<[**RegisterResponce**](RegisterResponce.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## putRegisterAccountUnlock

> RegisterResponce putRegisterAccountUnlock(uuid, code)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ApplicationAccountControllerApi apiInstance = new ApplicationAccountControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        String code = "code_example"; // String | 
        try {
            RegisterResponce result = apiInstance.putRegisterAccountUnlock(uuid, code);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#putRegisterAccountUnlock");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**|  |
 **code** | **String**|  |

### Return type

[**RegisterResponce**](RegisterResponce.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## putRegisterAccountUnlockWithHttpInfo

> ApiResponse<RegisterResponce> putRegisterAccountUnlock putRegisterAccountUnlockWithHttpInfo(uuid, code)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ApplicationAccountControllerApi apiInstance = new ApplicationAccountControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        String code = "code_example"; // String | 
        try {
            ApiResponse<RegisterResponce> response = apiInstance.putRegisterAccountUnlockWithHttpInfo(uuid, code);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#putRegisterAccountUnlock");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**|  |
 **code** | **String**|  |

### Return type

ApiResponse<[**RegisterResponce**](RegisterResponce.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

