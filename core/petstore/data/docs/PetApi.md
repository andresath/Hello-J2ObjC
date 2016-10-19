# PetApi

All URIs are relative to *http://petstore.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addPet**](PetApi.md#addPet) | **POST** /pet | Add a new pet to the store
[**deletePet**](PetApi.md#deletePet) | **DELETE** /pet/{petId} | Deletes a pet
[**findPetsByStatus**](PetApi.md#findPetsByStatus) | **GET** /pet/findByStatus | Finds Pets by status
[**findPetsByTags**](PetApi.md#findPetsByTags) | **GET** /pet/findByTags | Finds Pets by tags
[**getPetById**](PetApi.md#getPetById) | **GET** /pet/{petId} | Find pet by ID
[**updatePet**](PetApi.md#updatePet) | **PUT** /pet | Update an existing pet
[**updatePetWithForm**](PetApi.md#updatePetWithForm) | **POST** /pet/{petId} | Updates a pet in the store with form data
[**uploadFile**](PetApi.md#uploadFile) | **POST** /pet/{petId}/uploadImage | uploads an image


<a name="addPet"></a>
# **addPet**
> addPet(body)

Add a new pet to the store



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
//import com.pets.core.petstore.data.store.api.PetApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
PetApi api = new PetApi(apiClient);


// Configure OAuth2 access token for authorization: petstore_auth
apiClient.setAccessToken("YOUR ACCESS TOKEN");
// OR ...
//OAuth petstore_auth = (OAuth) apiClient.getAuthentication("petstore_auth");
//petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

Pet body = new Pet(); // Pet | Pet object that needs to be added to the store
Observable<Object> apiObservable = api.addPet(body);
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
 **body** | [**Pet**](Pet.md)| Pet object that needs to be added to the store |

### Return type

null (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/xml, application/json

<a name="deletePet"></a>
# **deletePet**
> deletePet(petId, apiKey)

Deletes a pet



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
//import com.pets.core.petstore.data.store.api.PetApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
PetApi api = new PetApi(apiClient);


// Configure OAuth2 access token for authorization: petstore_auth
apiClient.setAccessToken("YOUR ACCESS TOKEN");
// OR ...
//OAuth petstore_auth = (OAuth) apiClient.getAuthentication("petstore_auth");
//petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

Long petId = 789L; // Long | Pet id to delete
String apiKey = "apiKey_example"; // String | 
Observable<Object> apiObservable = api.deletePet(petId, apiKey);
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
 **petId** | **Long**| Pet id to delete |
 **apiKey** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="findPetsByStatus"></a>
# **findPetsByStatus**
> List&lt;Pet&gt; findPetsByStatus(status)

Finds Pets by status

Multiple status values can be provided with comma separated strings

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
//import com.pets.core.petstore.data.store.api.PetApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
PetApi api = new PetApi(apiClient);


// Configure OAuth2 access token for authorization: petstore_auth
apiClient.setAccessToken("YOUR ACCESS TOKEN");
// OR ...
//OAuth petstore_auth = (OAuth) apiClient.getAuthentication("petstore_auth");
//petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

List<String> status = Arrays.asList("status_example"); // List<String> | Status values that need to be considered for filter
Observable<List<Pet>> apiObservable = api.findPetsByStatus(status);
Subscriber<List<Pet>> apiSubscriber = new Subscriber<List<Pet>>() {
    @Override
    public void onNext(List<Pet> dtoResponse) {
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
 **status** | [**List&lt;String&gt;**](String.md)| Status values that need to be considered for filter | [enum: available, pending, sold]

### Return type

[**List&lt;Pet&gt;**](Pet.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="findPetsByTags"></a>
# **findPetsByTags**
> List&lt;Pet&gt; findPetsByTags(tags)

Finds Pets by tags

Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

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
//import com.pets.core.petstore.data.store.api.PetApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
PetApi api = new PetApi(apiClient);


// Configure OAuth2 access token for authorization: petstore_auth
apiClient.setAccessToken("YOUR ACCESS TOKEN");
// OR ...
//OAuth petstore_auth = (OAuth) apiClient.getAuthentication("petstore_auth");
//petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

List<String> tags = Arrays.asList("tags_example"); // List<String> | Tags to filter by
Observable<List<Pet>> apiObservable = api.findPetsByTags(tags);
Subscriber<List<Pet>> apiSubscriber = new Subscriber<List<Pet>>() {
    @Override
    public void onNext(List<Pet> dtoResponse) {
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
 **tags** | [**List&lt;String&gt;**](String.md)| Tags to filter by |

### Return type

[**List&lt;Pet&gt;**](Pet.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="getPetById"></a>
# **getPetById**
> Pet getPetById(petId)

Find pet by ID

Returns a single pet

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
//import com.pets.core.petstore.data.store.api.PetApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
PetApi api = new PetApi(apiClient);


// Configure API key authorization: api_key
api_key.setApiKey("YOUR API KEY");
// OR ...
//ApiKeyAuth api_key = (ApiKeyAuth) apiClient.getAuthentication("api_key");
//api_key.setApiKey("YOUR API KEY");
// To set a prefix for the API key, e.g. "Token" (defaults to null):
//api_key.setApiKeyPrefix("KEYPREFIX");

Long petId = 789L; // Long | ID of pet to return
Observable<Pet> apiObservable = api.getPetById(petId);
Subscriber<Pet> apiSubscriber = new Subscriber<Pet>() {
    @Override
    public void onNext(Pet dtoResponse) {
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
 **petId** | **Long**| ID of pet to return |

### Return type

[**Pet**](Pet.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

<a name="updatePet"></a>
# **updatePet**
> updatePet(body)

Update an existing pet



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
//import com.pets.core.petstore.data.store.api.PetApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
PetApi api = new PetApi(apiClient);


// Configure OAuth2 access token for authorization: petstore_auth
apiClient.setAccessToken("YOUR ACCESS TOKEN");
// OR ...
//OAuth petstore_auth = (OAuth) apiClient.getAuthentication("petstore_auth");
//petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

Pet body = new Pet(); // Pet | Pet object that needs to be added to the store
Observable<Object> apiObservable = api.updatePet(body);
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
 **body** | [**Pet**](Pet.md)| Pet object that needs to be added to the store |

### Return type

null (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/xml, application/json

<a name="updatePetWithForm"></a>
# **updatePetWithForm**
> updatePetWithForm(petId, name, status)

Updates a pet in the store with form data



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
//import com.pets.core.petstore.data.store.api.PetApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
PetApi api = new PetApi(apiClient);


// Configure OAuth2 access token for authorization: petstore_auth
apiClient.setAccessToken("YOUR ACCESS TOKEN");
// OR ...
//OAuth petstore_auth = (OAuth) apiClient.getAuthentication("petstore_auth");
//petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

Long petId = 789L; // Long | ID of pet that needs to be updated
String name = "name_example"; // String | Updated name of the pet
String status = "status_example"; // String | Updated status of the pet
Observable<Object> apiObservable = api.updatePetWithForm(petId, name, status);
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
 **petId** | **Long**| ID of pet that needs to be updated |
 **name** | **String**| Updated name of the pet | [optional]
 **status** | **String**| Updated status of the pet | [optional]

### Return type

null (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/xml, application/json

<a name="uploadFile"></a>
# **uploadFile**
> ModelApiResponse uploadFile(petId, additionalMetadata, file)

uploads an image



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
//import com.pets.core.petstore.data.store.api.PetApi;

HttpClient httpClient = new HttpClientDriverImpl();
ApiClient apiClient = new ApiClient(httpClient);
PetApi api = new PetApi(apiClient);


// Configure OAuth2 access token for authorization: petstore_auth
apiClient.setAccessToken("YOUR ACCESS TOKEN");
// OR ...
//OAuth petstore_auth = (OAuth) apiClient.getAuthentication("petstore_auth");
//petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

Long petId = 789L; // Long | ID of pet to update
String additionalMetadata = "additionalMetadata_example"; // String | Additional data to pass to server
File file = new File("/path/to/file.txt"); // File | file to upload
Observable<ModelApiResponse> apiObservable = api.uploadFile(petId, additionalMetadata, file);
Subscriber<ModelApiResponse> apiSubscriber = new Subscriber<ModelApiResponse>() {
    @Override
    public void onNext(ModelApiResponse dtoResponse) {
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
 **petId** | **Long**| ID of pet to update |
 **additionalMetadata** | **String**| Additional data to pass to server | [optional]
 **file** | **File**| file to upload | [optional]

### Return type

[**ModelApiResponse**](ModelApiResponse.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

