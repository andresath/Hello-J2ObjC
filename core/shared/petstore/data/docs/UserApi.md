# UserApi

All URIs are relative to *http://petstore.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UserApi.md#createUser) | **POST** /user | Create user
[**createUsersWithArrayInput**](UserApi.md#createUsersWithArrayInput) | **POST** /user/createWithArray | Creates list of users with given input array
[**createUsersWithListInput**](UserApi.md#createUsersWithListInput) | **POST** /user/createWithList | Creates list of users with given input array
[**deleteUser**](UserApi.md#deleteUser) | **DELETE** /user/{username} | Delete user
[**getUserByName**](UserApi.md#getUserByName) | **GET** /user/{username} | Get user by user name
[**loginUser**](UserApi.md#loginUser) | **GET** /user/login | Logs user into the system
[**logoutUser**](UserApi.md#logoutUser) | **GET** /user/logout | Logs out current logged in user session
[**updateUser**](UserApi.md#updateUser) | **PUT** /user/{username} | Updated user


<a name="createUser"></a>
# **createUser**
``` Observable<Object>createUser(body)```

Create user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import com.pets.core.shared.petstore.data.store.ApiClient;
//import com.pets.core.shared.petstore.data.store.ApiException;
//import com.pets.core.shared.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.shared.petstore.data.store.models.*;
//import com.pets.core.shared.petstore.data.store.api.UserApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
UserApi api = new UserApi(apiClient);


User body = new User(); // User | Created user object
Observable<Object> apiObservable = api.createUser(body);
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
 **body** | [**User**](User.md)| Created user object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="createUsersWithArrayInput"></a>
# **createUsersWithArrayInput**
``` Observable<Object>createUsersWithArrayInput(body)```

Creates list of users with given input array



### Example
```java
// Import classes:
//import com.pets.core.shared.petstore.data.store.ApiClient;
//import com.pets.core.shared.petstore.data.store.ApiException;
//import com.pets.core.shared.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.shared.petstore.data.store.models.*;
//import com.pets.core.shared.petstore.data.store.api.UserApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
UserApi api = new UserApi(apiClient);


List<User> body = Arrays.asList(new User()); // List<User> | List of user object
Observable<Object> apiObservable = api.createUsersWithArrayInput(body);
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
 **body** | [**List&lt;User&gt;**](User.md)| List of user object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="createUsersWithListInput"></a>
# **createUsersWithListInput**
``` Observable<Object>createUsersWithListInput(body)```

Creates list of users with given input array



### Example
```java
// Import classes:
//import com.pets.core.shared.petstore.data.store.ApiClient;
//import com.pets.core.shared.petstore.data.store.ApiException;
//import com.pets.core.shared.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.shared.petstore.data.store.models.*;
//import com.pets.core.shared.petstore.data.store.api.UserApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
UserApi api = new UserApi(apiClient);


List<User> body = Arrays.asList(new User()); // List<User> | List of user object
Observable<Object> apiObservable = api.createUsersWithListInput(body);
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
 **body** | [**List&lt;User&gt;**](User.md)| List of user object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="deleteUser"></a>
# **deleteUser**
``` Observable<Object>deleteUser(username)```

Delete user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import com.pets.core.shared.petstore.data.store.ApiClient;
//import com.pets.core.shared.petstore.data.store.ApiException;
//import com.pets.core.shared.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.shared.petstore.data.store.models.*;
//import com.pets.core.shared.petstore.data.store.api.UserApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
UserApi api = new UserApi(apiClient);


String username = "username_example"; // String | The name that needs to be deleted
Observable<Object> apiObservable = api.deleteUser(username);
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
 **username** | **String**| The name that needs to be deleted |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="getUserByName"></a>
# **getUserByName**
``` Observable<User>getUserByName(username)```

Get user by user name



### Example
```java
// Import classes:
//import com.pets.core.shared.petstore.data.store.ApiClient;
//import com.pets.core.shared.petstore.data.store.ApiException;
//import com.pets.core.shared.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.shared.petstore.data.store.models.*;
//import com.pets.core.shared.petstore.data.store.api.UserApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
UserApi api = new UserApi(apiClient);


String username = "username_example"; // String | The name that needs to be fetched. Use user1 for testing. 
Observable<User> apiObservable = api.getUserByName(username);
Subscriber<User> apiSubscriber = new Subscriber<User>() {
    @Override
    public void onNext(User dtoResponse) {
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
 **username** | **String**| The name that needs to be fetched. Use user1 for testing.  |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="loginUser"></a>
# **loginUser**
``` Observable<String>loginUser(username, password)```

Logs user into the system



### Example
```java
// Import classes:
//import com.pets.core.shared.petstore.data.store.ApiClient;
//import com.pets.core.shared.petstore.data.store.ApiException;
//import com.pets.core.shared.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.shared.petstore.data.store.models.*;
//import com.pets.core.shared.petstore.data.store.api.UserApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
UserApi api = new UserApi(apiClient);


String username = "username_example"; // String | The user name for login
String password = "password_example"; // String | The password for login in clear text
Observable<String> apiObservable = api.loginUser(username, password);
Subscriber<String> apiSubscriber = new Subscriber<String>() {
    @Override
    public void onNext(String dtoResponse) {
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
 **username** | **String**| The user name for login |
 **password** | **String**| The password for login in clear text |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="logoutUser"></a>
# **logoutUser**
``` Observable<Object>logoutUser()```

Logs out current logged in user session



### Example
```java
// Import classes:
//import com.pets.core.shared.petstore.data.store.ApiClient;
//import com.pets.core.shared.petstore.data.store.ApiException;
//import com.pets.core.shared.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.shared.petstore.data.store.models.*;
//import com.pets.core.shared.petstore.data.store.api.UserApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
UserApi api = new UserApi(apiClient);


Observable<Object> apiObservable = api.logoutUser();
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
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="updateUser"></a>
# **updateUser**
``` Observable<Object>updateUser(username, body)```

Updated user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import com.pets.core.shared.petstore.data.store.ApiClient;
//import com.pets.core.shared.petstore.data.store.ApiException;
//import com.pets.core.shared.petstore.data.store.HttpClient;
//import com.my.package.drivers.HttpClientDriverImpl;
//import rx.Observer;
//import rx.Observable;
//import rx.Subscriber;


//import com.pets.core.shared.petstore.data.store.models.*;
//import com.pets.core.shared.petstore.data.store.api.UserApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
UserApi api = new UserApi(apiClient);


String username = "username_example"; // String | name that need to be updated
User body = new User(); // User | Updated user object
Observable<Object> apiObservable = api.updateUser(username, body);
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
 **username** | **String**| name that need to be updated |
 **body** | [**User**](User.md)| Updated user object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

