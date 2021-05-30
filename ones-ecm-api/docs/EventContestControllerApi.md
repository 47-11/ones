# EventContestControllerApi

All URIs are relative to *https://vdd4ones.de:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getContestByUuid**](EventContestControllerApi.md#getContestByUuid) | **GET** /rest/event/contest | 
[**getContestByUuidWithHttpInfo**](EventContestControllerApi.md#getContestByUuidWithHttpInfo) | **GET** /rest/event/contest | 
[**getContestByYear**](EventContestControllerApi.md#getContestByYear) | **GET** /rest/event/contests | 
[**getContestByYearWithHttpInfo**](EventContestControllerApi.md#getContestByYearWithHttpInfo) | **GET** /rest/event/contests | 



## getContestByUuid

> EventContest getContestByUuid(uuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        try {
            EventContest result = apiInstance.getContestByUuid(uuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getContestByUuid");
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

[**EventContest**](EventContest.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getContestByUuidWithHttpInfo

> ApiResponse<EventContest> getContestByUuid getContestByUuidWithHttpInfo(uuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        try {
            ApiResponse<EventContest> response = apiInstance.getContestByUuidWithHttpInfo(uuid);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getContestByUuid");
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

ApiResponse<[**EventContest**](EventContest.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getContestByYear

> List<EventContestPlain> getContestByYear(year, pageNo, pageSize, sortBy)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        Integer year = 56; // Integer | 
        Integer pageNo = 0; // Integer | 
        Integer pageSize = 10; // Integer | 
        String sortBy = "beginning"; // String | 
        try {
            List<EventContestPlain> result = apiInstance.getContestByYear(year, pageNo, pageSize, sortBy);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getContestByYear");
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
 **year** | **Integer**|  |
 **pageNo** | **Integer**|  | [optional] [default to 0]
 **pageSize** | **Integer**|  | [optional] [default to 10]
 **sortBy** | **String**|  | [optional] [default to beginning]

### Return type

[**List&lt;EventContestPlain&gt;**](EventContestPlain.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getContestByYearWithHttpInfo

> ApiResponse<List<EventContestPlain>> getContestByYear getContestByYearWithHttpInfo(year, pageNo, pageSize, sortBy)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        Integer year = 56; // Integer | 
        Integer pageNo = 0; // Integer | 
        Integer pageSize = 10; // Integer | 
        String sortBy = "beginning"; // String | 
        try {
            ApiResponse<List<EventContestPlain>> response = apiInstance.getContestByYearWithHttpInfo(year, pageNo, pageSize, sortBy);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getContestByYear");
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
 **year** | **Integer**|  |
 **pageNo** | **Integer**|  | [optional] [default to 0]
 **pageSize** | **Integer**|  | [optional] [default to 10]
 **sortBy** | **String**|  | [optional] [default to beginning]

### Return type

ApiResponse<[**List&lt;EventContestPlain&gt;**](EventContestPlain.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

