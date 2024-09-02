# DefaultApi

All URIs are relative to *https://push.databox.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**dataDelete**](DefaultApi.md#dataDelete) | **DELETE** /data |  |
| [**dataMetricKeyDelete**](DefaultApi.md#dataMetricKeyDelete) | **DELETE** /data/{metricKey} |  |
| [**dataPost**](DefaultApi.md#dataPost) | **POST** /data |  |
| [**metrickeysGet**](DefaultApi.md#metrickeysGet) | **GET** /metrickeys |  |
| [**metrickeysPost**](DefaultApi.md#metrickeysPost) | **POST** /metrickeys |  |
| [**pingGet**](DefaultApi.md#pingGet) | **GET** /ping |  |


<a id="dataDelete"></a>
# **dataDelete**
> dataDelete()



### Example
```java
// Import classes:
import org.databox.ApiClient;
import org.databox.ApiException;
import org.databox.Configuration;
import org.databox.auth.*;
import org.databox.models.*;
import org.databox.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://push.databox.com");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.dataDelete();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#dataDelete");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="dataMetricKeyDelete"></a>
# **dataMetricKeyDelete**
> dataMetricKeyDelete(metricKey)



### Example
```java
// Import classes:
import org.databox.ApiClient;
import org.databox.ApiException;
import org.databox.Configuration;
import org.databox.auth.*;
import org.databox.models.*;
import org.databox.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://push.databox.com");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String metricKey = "metricKey_example"; // String | 
    try {
      apiInstance.dataMetricKeyDelete(metricKey);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#dataMetricKeyDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **metricKey** | **String**|  | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="dataPost"></a>
# **dataPost**
> dataPost(pushData)



### Example
```java
// Import classes:
import org.databox.ApiClient;
import org.databox.ApiException;
import org.databox.Configuration;
import org.databox.auth.*;
import org.databox.models.*;
import org.databox.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://push.databox.com");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    List<PushData> pushData = Arrays.asList(); // List<PushData> | 
    try {
      apiInstance.dataPost(pushData);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#dataPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **pushData** | [**List&lt;PushData&gt;**](PushData.md)|  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/vnd.databox.v2+json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="metrickeysGet"></a>
# **metrickeysGet**
> metrickeysGet()



### Example
```java
// Import classes:
import org.databox.ApiClient;
import org.databox.ApiException;
import org.databox.Configuration;
import org.databox.auth.*;
import org.databox.models.*;
import org.databox.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://push.databox.com");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.metrickeysGet();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#metrickeysGet");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="metrickeysPost"></a>
# **metrickeysPost**
> metrickeysPost(body)



### Example
```java
// Import classes:
import org.databox.ApiClient;
import org.databox.ApiException;
import org.databox.Configuration;
import org.databox.auth.*;
import org.databox.models.*;
import org.databox.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://push.databox.com");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Object body = null; // Object | 
    try {
      apiInstance.metrickeysPost(body);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#metrickeysPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **body** | **Object**|  | [optional] |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/vnd.databox.v2+json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="pingGet"></a>
# **pingGet**
> pingGet()



### Example
```java
// Import classes:
import org.databox.ApiClient;
import org.databox.ApiException;
import org.databox.Configuration;
import org.databox.auth.*;
import org.databox.models.*;
import org.databox.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://push.databox.com");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.pingGet();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#pingGet");
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

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

