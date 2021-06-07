# MasterdataHorseControllerApi

All URIs are relative to *https://vdd4ones.de:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getHorseByUuid**](MasterdataHorseControllerApi.md#getHorseByUuid) | **GET** /rest/masterdata/horse/{uuid} | 
[**getHorseByUuidWithHttpInfo**](MasterdataHorseControllerApi.md#getHorseByUuidWithHttpInfo) | **GET** /rest/masterdata/horse/{uuid} | 
[**postRegisterHorse**](MasterdataHorseControllerApi.md#postRegisterHorse) | **POST** /rest/masterdata/register/horse | 
[**postRegisterHorseWithHttpInfo**](MasterdataHorseControllerApi.md#postRegisterHorseWithHttpInfo) | **POST** /rest/masterdata/register/horse | 



## getHorseByUuid

> MasterdataHorse getHorseByUuid(uuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataHorseControllerApi apiInstance = new MasterdataHorseControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        try {
            MasterdataHorse result = apiInstance.getHorseByUuid(uuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataHorseControllerApi#getHorseByUuid");
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

### Return type

[**MasterdataHorse**](MasterdataHorse.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getHorseByUuidWithHttpInfo

> ApiResponse<MasterdataHorse> getHorseByUuid getHorseByUuidWithHttpInfo(uuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataHorseControllerApi apiInstance = new MasterdataHorseControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        try {
            ApiResponse<MasterdataHorse> response = apiInstance.getHorseByUuidWithHttpInfo(uuid);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataHorseControllerApi#getHorseByUuid");
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

### Return type

ApiResponse<[**MasterdataHorse**](MasterdataHorse.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## postRegisterHorse

> Object postRegisterHorse(registerHorse)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataHorseControllerApi apiInstance = new MasterdataHorseControllerApi(defaultClient);
        RegisterHorse registerHorse = new RegisterHorse(); // RegisterHorse | 
        try {
            Object result = apiInstance.postRegisterHorse(registerHorse);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataHorseControllerApi#postRegisterHorse");
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
 **registerHorse** | [**RegisterHorse**](RegisterHorse.md)|  |

### Return type

**Object**


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## postRegisterHorseWithHttpInfo

> ApiResponse<Object> postRegisterHorse postRegisterHorseWithHttpInfo(registerHorse)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataHorseControllerApi apiInstance = new MasterdataHorseControllerApi(defaultClient);
        RegisterHorse registerHorse = new RegisterHorse(); // RegisterHorse | 
        try {
            ApiResponse<Object> response = apiInstance.postRegisterHorseWithHttpInfo(registerHorse);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataHorseControllerApi#postRegisterHorse");
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
 **registerHorse** | [**RegisterHorse**](RegisterHorse.md)|  |

### Return type

ApiResponse<**Object**>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

