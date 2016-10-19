# StoreApi

All URIs are relative to *http://petstore.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteOrder**](StoreApi.md#deleteOrder) | **DELETE** /store/order/{orderId} | Delete purchase order by ID
[**getInventory**](StoreApi.md#getInventory) | **GET** /store/inventory | Returns pet inventories by status
[**getOrderById**](StoreApi.md#getOrderById) | **GET** /store/order/{orderId} | Find purchase order by ID
[**placeOrder**](StoreApi.md#placeOrder) | **POST** /store/order | Place an order for a pet


<a name="deleteOrder"></a>
# **deleteOrder**
> Observable<Object>deleteOrder(orderId)

Delete purchase order by ID

For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors

### Example
```java
// Import classes:
//import com.pets.core.petstore.data.store.ApiClient;
//import com.pets.core.petstore.data.store.ApiException;
//import com.pets.core.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.petstore.data.store.models.*;
//import com.pets.core.petstore.data.store.api.StoreApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
StoreApi api = new StoreApi(apiClient);


Long orderId = 789L; // Long | ID of the order that needs to be deleted
Observable<Object> apiObservable = api.deleteOrder(orderId);
Subscriber<Object> apiSubscriber = new Subscriber<Object>() {
    @Override
    public void onNext(Object dtoResponse) {
        // TODO: Handle Response DTO
        System.out.println("Received Response" + dtoResponse.toString());
    }

    @Override
    public void onCompleted() {
        // TODO: Post-processing or Clean-up
        System.out.println("Api Call Complete");
    }

    @Override
    public void onError(Throwable e) {
        // TODO: Handle Errors (ApiException)
        System.out.println(e.getMessage());
    }
};
apiObservable.subscribe(apiSubscriber);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Long**| ID of the order that needs to be deleted |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="getInventory"></a>
# **getInventory**
> Observable<Map<String, Integer>>getInventory()

Returns pet inventories by status

Returns a map of status codes to quantities

### Example
```java
// Import classes:
//import com.pets.core.petstore.data.store.ApiClient;
//import com.pets.core.petstore.data.store.ApiException;
//import com.pets.core.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;

//import com.pets.core.petstore.data.store.auth.*;
//import com.pets.core.petstore.data.store.models.*;
//import com.pets.core.petstore.data.store.api.StoreApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
StoreApi api = new StoreApi(apiClient);


// Configure API key authorization: api_key
api_key.setApiKey("YOUR API KEY");
// OR ...
//ApiKeyAuth api_key = (ApiKeyAuth) apiClient.getAuthentication("api_key");
//api_key.setApiKey("YOUR API KEY");
// To set a prefix for the API key, e.g. "Token" (defaults to null):
//api_key.setApiKeyPrefix("KEYPREFIX");

Observable<Map<String, Integer>> apiObservable = api.getInventory();
Subscriber<Map<String, Integer>> apiSubscriber = new Subscriber<Map<String, Integer>>() {
    @Override
    public void onNext(Map<String, Integer> dtoResponse) {
        // TODO: Handle Response DTO
        System.out.println("Received Response" + dtoResponse.toString());
    }

    @Override
    public void onCompleted() {
        // TODO: Post-processing or Clean-up
        System.out.println("Api Call Complete");
    }

    @Override
    public void onError(Throwable e) {
        // TODO: Handle Errors (ApiException)
        System.out.println(e.getMessage());
    }
};
apiObservable.subscribe(apiSubscriber);
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Map&lt;String, Integer&gt;**](Map.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getOrderById"></a>
# **getOrderById**
> Observable<Order>getOrderById(orderId)

Find purchase order by ID

For valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10. Other values will generated exceptions

### Example
```java
// Import classes:
//import com.pets.core.petstore.data.store.ApiClient;
//import com.pets.core.petstore.data.store.ApiException;
//import com.pets.core.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.petstore.data.store.models.*;
//import com.pets.core.petstore.data.store.api.StoreApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
StoreApi api = new StoreApi(apiClient);


Long orderId = 789L; // Long | ID of pet that needs to be fetched
Observable<Order> apiObservable = api.getOrderById(orderId);
Subscriber<Order> apiSubscriber = new Subscriber<Order>() {
    @Override
    public void onNext(Order dtoResponse) {
        // TODO: Handle Response DTO
        System.out.println("Received Response" + dtoResponse.toString());
    }

    @Override
    public void onCompleted() {
        // TODO: Post-processing or Clean-up
        System.out.println("Api Call Complete");
    }

    @Override
    public void onError(Throwable e) {
        // TODO: Handle Errors (ApiException)
        System.out.println(e.getMessage());
    }
};
apiObservable.subscribe(apiSubscriber);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Long**| ID of pet that needs to be fetched |

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="placeOrder"></a>
# **placeOrder**
> Observable<Order>placeOrder(body)

Place an order for a pet



### Example
```java
// Import classes:
//import com.pets.core.petstore.data.store.ApiClient;
//import com.pets.core.petstore.data.store.ApiException;
//import com.pets.core.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.petstore.data.store.models.*;
//import com.pets.core.petstore.data.store.api.StoreApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
StoreApi api = new StoreApi(apiClient);


Order body = new Order(); // Order | order placed for purchasing the pet
Observable<Order> apiObservable = api.placeOrder(body);
Subscriber<Order> apiSubscriber = new Subscriber<Order>() {
    @Override
    public void onNext(Order dtoResponse) {
        // TODO: Handle Response DTO
        System.out.println("Received Response" + dtoResponse.toString());
    }

    @Override
    public void onCompleted() {
        // TODO: Post-processing or Clean-up
        System.out.println("Api Call Complete");
    }

    @Override
    public void onError(Throwable e) {
        // TODO: Handle Errors (ApiException)
        System.out.println(e.getMessage());
    }
};
apiObservable.subscribe(apiSubscriber);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Order**](Order.md)| order placed for purchasing the pet |

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

