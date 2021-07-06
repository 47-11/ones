# MasterdataPropertyControllerApi

All URIs are relative to *https://vdd4ones.de:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPropertyItems**](MasterdataPropertyControllerApi.md#getPropertyItems) | **GET** /rest/masterdata/property/items/{proptery} | 
[**getPropertyItemsWithHttpInfo**](MasterdataPropertyControllerApi.md#getPropertyItemsWithHttpInfo) | **GET** /rest/masterdata/property/items/{proptery} | 



## getPropertyItems

> List<MasterdataProperty> getPropertyItems(proptery)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataPropertyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MasterdataPropertyControllerApi apiInstance = new MasterdataPropertyControllerApi(defaultClient);
        String proptery = "proptery_example"; // String | 
        try {
            List<MasterdataProperty> result = apiInstance.getPropertyItems(proptery);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataPropertyControllerApi#getPropertyItems");
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
 **proptery** | **String**|  |

### Return type

[**List&lt;MasterdataProperty&gt;**](MasterdataProperty.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getPropertyItemsWithHttpInfo

> ApiResponse<List<MasterdataProperty>> getPropertyItems getPropertyItemsWithHttpInfo(proptery)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataPropertyControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        MasterdataPropertyControllerApi apiInstance = new MasterdataPropertyControllerApi(defaultClient);
        String proptery = "proptery_example"; // String | 
        try {
            ApiResponse<List<MasterdataProperty>> response = apiInstance.getPropertyItemsWithHttpInfo(proptery);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataPropertyControllerApi#getPropertyItems");
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
 **proptery** | **String**|  |

### Return type

ApiResponse<[**List&lt;MasterdataProperty&gt;**](MasterdataProperty.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

