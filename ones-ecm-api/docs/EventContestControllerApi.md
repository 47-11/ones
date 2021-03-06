# EventContestControllerApi

All URIs are relative to *https://vdd4ones.de:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAccountContestCompetitionsResults**](EventContestControllerApi.md#getAccountContestCompetitionsResults) | **GET** /rest/event/contest/result/account/{uuid} | 
[**getAccountContestCompetitionsResultsWithHttpInfo**](EventContestControllerApi.md#getAccountContestCompetitionsResultsWithHttpInfo) | **GET** /rest/event/contest/result/account/{uuid} | 
[**getContestByFilters**](EventContestControllerApi.md#getContestByFilters) | **GET** /rest/event/contests | 
[**getContestByFiltersWithHttpInfo**](EventContestControllerApi.md#getContestByFiltersWithHttpInfo) | **GET** /rest/event/contests | 
[**getContestByUuid**](EventContestControllerApi.md#getContestByUuid) | **GET** /rest/event/contest | 
[**getContestByUuidWithHttpInfo**](EventContestControllerApi.md#getContestByUuidWithHttpInfo) | **GET** /rest/event/contest | 
[**getCurrentContestCompetitionsResults**](EventContestControllerApi.md#getCurrentContestCompetitionsResults) | **GET** /rest/event/contest/result/current | 
[**getCurrentContestCompetitionsResultsWithHttpInfo**](EventContestControllerApi.md#getCurrentContestCompetitionsResultsWithHttpInfo) | **GET** /rest/event/contest/result/current | 
[**postAccountNomination**](EventContestControllerApi.md#postAccountNomination) | **POST** /rest/event/nomination/account/{uuid} | 
[**postAccountNominationWithHttpInfo**](EventContestControllerApi.md#postAccountNominationWithHttpInfo) | **POST** /rest/event/nomination/account/{uuid} | 



## getAccountContestCompetitionsResults

> List<EventContestCompetitionResult> getAccountContestCompetitionsResults(uuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        try {
            List<EventContestCompetitionResult> result = apiInstance.getAccountContestCompetitionsResults(uuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getAccountContestCompetitionsResults");
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

[**List&lt;EventContestCompetitionResult&gt;**](EventContestCompetitionResult.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getAccountContestCompetitionsResultsWithHttpInfo

> ApiResponse<List<EventContestCompetitionResult>> getAccountContestCompetitionsResults getAccountContestCompetitionsResultsWithHttpInfo(uuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        try {
            ApiResponse<List<EventContestCompetitionResult>> response = apiInstance.getAccountContestCompetitionsResultsWithHttpInfo(uuid);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getAccountContestCompetitionsResults");
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

ApiResponse<[**List&lt;EventContestCompetitionResult&gt;**](EventContestCompetitionResult.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getContestByFilters

> ResponcePageContestsPlain getContestByFilters(fromDate, untilDate, countryRegions, contestKinds, isCountryChampionship, isCEI, isCard, onlyRegistered, accountUuid, pageNo, pageSize, sortBy)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        OffsetDateTime fromDate = OffsetDateTime.now(); // OffsetDateTime | 
        OffsetDateTime untilDate = OffsetDateTime.now(); // OffsetDateTime | 
        List<String> countryRegions = Arrays.asList(); // List<String> | 
        List<String> contestKinds = Arrays.asList(); // List<String> | 
        Integer isCountryChampionship = 56; // Integer | 
        Integer isCEI = 56; // Integer | 
        Integer isCard = 56; // Integer | 
        Boolean onlyRegistered = true; // Boolean | 
        String accountUuid = "accountUuid_example"; // String | 
        Integer pageNo = 0; // Integer | 
        Integer pageSize = 10; // Integer | 
        String sortBy = "beginning"; // String | 
        try {
            ResponcePageContestsPlain result = apiInstance.getContestByFilters(fromDate, untilDate, countryRegions, contestKinds, isCountryChampionship, isCEI, isCard, onlyRegistered, accountUuid, pageNo, pageSize, sortBy);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getContestByFilters");
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
 **fromDate** | **OffsetDateTime**|  | [optional]
 **untilDate** | **OffsetDateTime**|  | [optional]
 **countryRegions** | [**List&lt;String&gt;**](String.md)|  | [optional]
 **contestKinds** | [**List&lt;String&gt;**](String.md)|  | [optional]
 **isCountryChampionship** | **Integer**|  | [optional]
 **isCEI** | **Integer**|  | [optional]
 **isCard** | **Integer**|  | [optional]
 **onlyRegistered** | **Boolean**|  | [optional]
 **accountUuid** | **String**|  | [optional]
 **pageNo** | **Integer**|  | [optional] [default to 0]
 **pageSize** | **Integer**|  | [optional] [default to 10]
 **sortBy** | **String**|  | [optional] [default to beginning]

### Return type

[**ResponcePageContestsPlain**](ResponcePageContestsPlain.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getContestByFiltersWithHttpInfo

> ApiResponse<ResponcePageContestsPlain> getContestByFilters getContestByFiltersWithHttpInfo(fromDate, untilDate, countryRegions, contestKinds, isCountryChampionship, isCEI, isCard, onlyRegistered, accountUuid, pageNo, pageSize, sortBy)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        OffsetDateTime fromDate = OffsetDateTime.now(); // OffsetDateTime | 
        OffsetDateTime untilDate = OffsetDateTime.now(); // OffsetDateTime | 
        List<String> countryRegions = Arrays.asList(); // List<String> | 
        List<String> contestKinds = Arrays.asList(); // List<String> | 
        Integer isCountryChampionship = 56; // Integer | 
        Integer isCEI = 56; // Integer | 
        Integer isCard = 56; // Integer | 
        Boolean onlyRegistered = true; // Boolean | 
        String accountUuid = "accountUuid_example"; // String | 
        Integer pageNo = 0; // Integer | 
        Integer pageSize = 10; // Integer | 
        String sortBy = "beginning"; // String | 
        try {
            ApiResponse<ResponcePageContestsPlain> response = apiInstance.getContestByFiltersWithHttpInfo(fromDate, untilDate, countryRegions, contestKinds, isCountryChampionship, isCEI, isCard, onlyRegistered, accountUuid, pageNo, pageSize, sortBy);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getContestByFilters");
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
 **fromDate** | **OffsetDateTime**|  | [optional]
 **untilDate** | **OffsetDateTime**|  | [optional]
 **countryRegions** | [**List&lt;String&gt;**](String.md)|  | [optional]
 **contestKinds** | [**List&lt;String&gt;**](String.md)|  | [optional]
 **isCountryChampionship** | **Integer**|  | [optional]
 **isCEI** | **Integer**|  | [optional]
 **isCard** | **Integer**|  | [optional]
 **onlyRegistered** | **Boolean**|  | [optional]
 **accountUuid** | **String**|  | [optional]
 **pageNo** | **Integer**|  | [optional] [default to 0]
 **pageSize** | **Integer**|  | [optional] [default to 10]
 **sortBy** | **String**|  | [optional] [default to beginning]

### Return type

ApiResponse<[**ResponcePageContestsPlain**](ResponcePageContestsPlain.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getContestByUuid

> EventContestPlain getContestByUuid(contestUuid, accountUuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        String contestUuid = "contestUuid_example"; // String | 
        String accountUuid = "accountUuid_example"; // String | 
        try {
            EventContestPlain result = apiInstance.getContestByUuid(contestUuid, accountUuid);
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
 **contestUuid** | **String**|  |
 **accountUuid** | **String**|  |

### Return type

[**EventContestPlain**](EventContestPlain.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getContestByUuidWithHttpInfo

> ApiResponse<EventContestPlain> getContestByUuid getContestByUuidWithHttpInfo(contestUuid, accountUuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        String contestUuid = "contestUuid_example"; // String | 
        String accountUuid = "accountUuid_example"; // String | 
        try {
            ApiResponse<EventContestPlain> response = apiInstance.getContestByUuidWithHttpInfo(contestUuid, accountUuid);
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
 **contestUuid** | **String**|  |
 **accountUuid** | **String**|  |

### Return type

ApiResponse<[**EventContestPlain**](EventContestPlain.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getCurrentContestCompetitionsResults

> List<EventContestCompetitionResult> getCurrentContestCompetitionsResults()



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        try {
            List<EventContestCompetitionResult> result = apiInstance.getCurrentContestCompetitionsResults();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getCurrentContestCompetitionsResults");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;EventContestCompetitionResult&gt;**](EventContestCompetitionResult.md)


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getCurrentContestCompetitionsResultsWithHttpInfo

> ApiResponse<List<EventContestCompetitionResult>> getCurrentContestCompetitionsResults getCurrentContestCompetitionsResultsWithHttpInfo()



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        try {
            ApiResponse<List<EventContestCompetitionResult>> response = apiInstance.getCurrentContestCompetitionsResultsWithHttpInfo();
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#getCurrentContestCompetitionsResults");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

ApiResponse<[**List&lt;EventContestCompetitionResult&gt;**](EventContestCompetitionResult.md)>


### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## postAccountNomination

> RegisterResponce postAccountNomination(uuid, registerNomination)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        RegisterNomination registerNomination = new RegisterNomination(); // RegisterNomination | 
        try {
            RegisterResponce result = apiInstance.postAccountNomination(uuid, registerNomination);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#postAccountNomination");
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
 **registerNomination** | [**RegisterNomination**](RegisterNomination.md)|  |

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

## postAccountNominationWithHttpInfo

> ApiResponse<RegisterResponce> postAccountNomination postAccountNominationWithHttpInfo(uuid, registerNomination)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.auth.*;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.EventContestControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        EventContestControllerApi apiInstance = new EventContestControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        RegisterNomination registerNomination = new RegisterNomination(); // RegisterNomination | 
        try {
            ApiResponse<RegisterResponce> response = apiInstance.postAccountNominationWithHttpInfo(uuid, registerNomination);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling EventContestControllerApi#postAccountNomination");
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
 **registerNomination** | [**RegisterNomination**](RegisterNomination.md)|  |

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

