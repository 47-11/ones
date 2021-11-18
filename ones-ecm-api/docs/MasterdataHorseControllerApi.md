# MasterdataHorseControllerApi

All URIs are relative to *https://vdd4ones.de:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**postRegisterHorse**](MasterdataHorseControllerApi.md#postRegisterHorse) | **POST** /rest/masterdata/horse/account/{uuid} | 
[**postRegisterHorseWithHttpInfo**](MasterdataHorseControllerApi.md#postRegisterHorseWithHttpInfo) | **POST** /rest/masterdata/horse/account/{uuid} | 



## postRegisterHorse

> Object postRegisterHorse(uuid, registerHorse)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MasterdataHorseControllerApi apiInstance = new MasterdataHorseControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        RegisterHorse registerHorse = new RegisterHorse(); // RegisterHorse | 
        try {
            Object result = apiInstance.postRegisterHorse(uuid, registerHorse);
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
 **uuid** | **String**|  |
 **registerHorse** | [**RegisterHorse**](RegisterHorse.md)|  |

### Return type

**Object**


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## postRegisterHorseWithHttpInfo

> ApiResponse<Object> postRegisterHorse postRegisterHorseWithHttpInfo(uuid, registerHorse)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataHorseControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MasterdataHorseControllerApi apiInstance = new MasterdataHorseControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        RegisterHorse registerHorse = new RegisterHorse(); // RegisterHorse | 
        try {
            ApiResponse<Object> response = apiInstance.postRegisterHorseWithHttpInfo(uuid, registerHorse);
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
 **uuid** | **String**|  |
 **registerHorse** | [**RegisterHorse**](RegisterHorse.md)|  |

### Return type

ApiResponse<**Object**>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

