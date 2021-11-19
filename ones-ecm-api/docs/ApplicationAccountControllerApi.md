# ApplicationAccountControllerApi

All URIs are relative to *https://vdd4ones.de:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteRegisteredAccount**](ApplicationAccountControllerApi.md#deleteRegisteredAccount) | **DELETE** /rest/application/register/account/{loginIdentification} | 
[**deleteRegisteredAccountWithHttpInfo**](ApplicationAccountControllerApi.md#deleteRegisteredAccountWithHttpInfo) | **DELETE** /rest/application/register/account/{loginIdentification} | 
[**getAccoundByUuid**](ApplicationAccountControllerApi.md#getAccoundByUuid) | **GET** /rest/application/register/account/{accountUuid} | 
[**getAccoundByUuidWithHttpInfo**](ApplicationAccountControllerApi.md#getAccoundByUuidWithHttpInfo) | **GET** /rest/application/register/account/{accountUuid} | 
[**postRegisterAccount**](ApplicationAccountControllerApi.md#postRegisterAccount) | **POST** /rest/application/register/account | 
[**postRegisterAccountWithHttpInfo**](ApplicationAccountControllerApi.md#postRegisterAccountWithHttpInfo) | **POST** /rest/application/register/account | 
[**putRegisterAccount**](ApplicationAccountControllerApi.md#putRegisterAccount) | **PUT** /rest/application/register/account/{accountUuid} | 
[**putRegisterAccountWithHttpInfo**](ApplicationAccountControllerApi.md#putRegisterAccountWithHttpInfo) | **PUT** /rest/application/register/account/{accountUuid} | 
[**putRegisterAccountUnlock**](ApplicationAccountControllerApi.md#putRegisterAccountUnlock) | **PUT** /rest/application/register/account/unlock | 
[**putRegisterAccountUnlockWithHttpInfo**](ApplicationAccountControllerApi.md#putRegisterAccountUnlockWithHttpInfo) | **PUT** /rest/application/register/account/unlock | 



## deleteRegisteredAccount

> RegisterResponce deleteRegisteredAccount(loginIdentification)



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
        String loginIdentification = "loginIdentification_example"; // String | 
        try {
            RegisterResponce result = apiInstance.deleteRegisteredAccount(loginIdentification);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#deleteRegisteredAccount");
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
 **loginIdentification** | **String**|  |

### Return type

[**RegisterResponce**](RegisterResponce.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## deleteRegisteredAccountWithHttpInfo

> ApiResponse<RegisterResponce> deleteRegisteredAccount deleteRegisteredAccountWithHttpInfo(loginIdentification)



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
        String loginIdentification = "loginIdentification_example"; // String | 
        try {
            ApiResponse<RegisterResponce> response = apiInstance.deleteRegisteredAccountWithHttpInfo(loginIdentification);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#deleteRegisteredAccount");
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
 **loginIdentification** | **String**|  |

### Return type

ApiResponse<[**RegisterResponce**](RegisterResponce.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getAccoundByUuid

> RegisteredAccount getAccoundByUuid(accountUuid)



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
        String accountUuid = "accountUuid_example"; // String | 
        try {
            RegisteredAccount result = apiInstance.getAccoundByUuid(accountUuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#getAccoundByUuid");
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
 **accountUuid** | **String**|  |

### Return type

[**RegisteredAccount**](RegisteredAccount.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getAccoundByUuidWithHttpInfo

> ApiResponse<RegisteredAccount> getAccoundByUuid getAccoundByUuidWithHttpInfo(accountUuid)



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
        String accountUuid = "accountUuid_example"; // String | 
        try {
            ApiResponse<RegisteredAccount> response = apiInstance.getAccoundByUuidWithHttpInfo(accountUuid);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#getAccoundByUuid");
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
 **accountUuid** | **String**|  |

### Return type

ApiResponse<[**RegisteredAccount**](RegisteredAccount.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


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


## putRegisterAccount

> RegisterResponce putRegisterAccount(accountUuid, updateAccount)



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
        String accountUuid = "accountUuid_example"; // String | 
        UpdateAccount updateAccount = new UpdateAccount(); // UpdateAccount | 
        try {
            RegisterResponce result = apiInstance.putRegisterAccount(accountUuid, updateAccount);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#putRegisterAccount");
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
 **accountUuid** | **String**|  |
 **updateAccount** | [**UpdateAccount**](UpdateAccount.md)|  |

### Return type

[**RegisterResponce**](RegisterResponce.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## putRegisterAccountWithHttpInfo

> ApiResponse<RegisterResponce> putRegisterAccount putRegisterAccountWithHttpInfo(accountUuid, updateAccount)



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
        String accountUuid = "accountUuid_example"; // String | 
        UpdateAccount updateAccount = new UpdateAccount(); // UpdateAccount | 
        try {
            ApiResponse<RegisterResponce> response = apiInstance.putRegisterAccountWithHttpInfo(accountUuid, updateAccount);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ApplicationAccountControllerApi#putRegisterAccount");
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
 **accountUuid** | **String**|  |
 **updateAccount** | [**UpdateAccount**](UpdateAccount.md)|  |

### Return type

ApiResponse<[**RegisterResponce**](RegisterResponce.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

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

