# MasterdataContactControllerApi

All URIs are relative to *https://vdd4ones.de:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getContactByUuid**](MasterdataContactControllerApi.md#getContactByUuid) | **GET** /rest/masterdata/contact/{uuid} | 
[**getContactByUuidWithHttpInfo**](MasterdataContactControllerApi.md#getContactByUuidWithHttpInfo) | **GET** /rest/masterdata/contact/{uuid} | 
[**postRegisterContactContestant**](MasterdataContactControllerApi.md#postRegisterContactContestant) | **POST** /rest/masterdata/register/contact/contestant | 
[**postRegisterContactContestantWithHttpInfo**](MasterdataContactControllerApi.md#postRegisterContactContestantWithHttpInfo) | **POST** /rest/masterdata/register/contact/contestant | 
[**postRegisterContactHorseOwner**](MasterdataContactControllerApi.md#postRegisterContactHorseOwner) | **POST** /rest/masterdata/register/contact/horseOwner | 
[**postRegisterContactHorseOwnerWithHttpInfo**](MasterdataContactControllerApi.md#postRegisterContactHorseOwnerWithHttpInfo) | **POST** /rest/masterdata/register/contact/horseOwner | 
[**postRegisterContactStable**](MasterdataContactControllerApi.md#postRegisterContactStable) | **POST** /rest/masterdata/register/contact/stable | 
[**postRegisterContactStableWithHttpInfo**](MasterdataContactControllerApi.md#postRegisterContactStableWithHttpInfo) | **POST** /rest/masterdata/register/contact/stable | 



## getContactByUuid

> MasterdataContact getContactByUuid(uuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataContactControllerApi apiInstance = new MasterdataContactControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        try {
            MasterdataContact result = apiInstance.getContactByUuid(uuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataContactControllerApi#getContactByUuid");
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

[**MasterdataContact**](MasterdataContact.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

## getContactByUuidWithHttpInfo

> ApiResponse<MasterdataContact> getContactByUuid getContactByUuidWithHttpInfo(uuid)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataContactControllerApi apiInstance = new MasterdataContactControllerApi(defaultClient);
        String uuid = "uuid_example"; // String | 
        try {
            ApiResponse<MasterdataContact> response = apiInstance.getContactByUuidWithHttpInfo(uuid);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataContactControllerApi#getContactByUuid");
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

ApiResponse<[**MasterdataContact**](MasterdataContact.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## postRegisterContactContestant

> Object postRegisterContactContestant(registerContact)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataContactControllerApi apiInstance = new MasterdataContactControllerApi(defaultClient);
        RegisterContact registerContact = new RegisterContact(); // RegisterContact | 
        try {
            Object result = apiInstance.postRegisterContactContestant(registerContact);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataContactControllerApi#postRegisterContactContestant");
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
 **registerContact** | [**RegisterContact**](RegisterContact.md)|  |

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

## postRegisterContactContestantWithHttpInfo

> ApiResponse<Object> postRegisterContactContestant postRegisterContactContestantWithHttpInfo(registerContact)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataContactControllerApi apiInstance = new MasterdataContactControllerApi(defaultClient);
        RegisterContact registerContact = new RegisterContact(); // RegisterContact | 
        try {
            ApiResponse<Object> response = apiInstance.postRegisterContactContestantWithHttpInfo(registerContact);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataContactControllerApi#postRegisterContactContestant");
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
 **registerContact** | [**RegisterContact**](RegisterContact.md)|  |

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


## postRegisterContactHorseOwner

> Object postRegisterContactHorseOwner(registerContact)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataContactControllerApi apiInstance = new MasterdataContactControllerApi(defaultClient);
        RegisterContact registerContact = new RegisterContact(); // RegisterContact | 
        try {
            Object result = apiInstance.postRegisterContactHorseOwner(registerContact);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataContactControllerApi#postRegisterContactHorseOwner");
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
 **registerContact** | [**RegisterContact**](RegisterContact.md)|  |

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

## postRegisterContactHorseOwnerWithHttpInfo

> ApiResponse<Object> postRegisterContactHorseOwner postRegisterContactHorseOwnerWithHttpInfo(registerContact)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataContactControllerApi apiInstance = new MasterdataContactControllerApi(defaultClient);
        RegisterContact registerContact = new RegisterContact(); // RegisterContact | 
        try {
            ApiResponse<Object> response = apiInstance.postRegisterContactHorseOwnerWithHttpInfo(registerContact);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataContactControllerApi#postRegisterContactHorseOwner");
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
 **registerContact** | [**RegisterContact**](RegisterContact.md)|  |

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


## postRegisterContactStable

> Object postRegisterContactStable(registerContact)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataContactControllerApi apiInstance = new MasterdataContactControllerApi(defaultClient);
        RegisterContact registerContact = new RegisterContact(); // RegisterContact | 
        try {
            Object result = apiInstance.postRegisterContactStable(registerContact);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataContactControllerApi#postRegisterContactStable");
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
 **registerContact** | [**RegisterContact**](RegisterContact.md)|  |

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

## postRegisterContactStableWithHttpInfo

> ApiResponse<Object> postRegisterContactStable postRegisterContactStableWithHttpInfo(registerContact)



### Example

```java
// Import classes:
import de.fourtyseveneleven.ones.ecm.generated.ApiClient;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiResponse;
import de.fourtyseveneleven.ones.ecm.generated.Configuration;
import de.fourtyseveneleven.ones.ecm.generated.models.*;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://vdd4ones.de:8080");

        MasterdataContactControllerApi apiInstance = new MasterdataContactControllerApi(defaultClient);
        RegisterContact registerContact = new RegisterContact(); // RegisterContact | 
        try {
            ApiResponse<Object> response = apiInstance.postRegisterContactStableWithHttpInfo(registerContact);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MasterdataContactControllerApi#postRegisterContactStable");
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
 **registerContact** | [**RegisterContact**](RegisterContact.md)|  |

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

