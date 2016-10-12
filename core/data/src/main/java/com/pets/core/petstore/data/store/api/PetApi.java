/*
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.pets.core.petstore.data.store.api;

import com.pets.core.petstore.data.store.ApiClient;
import com.pets.core.petstore.data.store.ApiException;
import com.pets.core.petstore.data.store.ApiResponse;
import com.pets.core.petstore.data.store.ApiRequest;
import com.pets.core.petstore.data.store.HttpClientUtils;
import com.pets.core.petstore.data.store.Pair;
import rx.Observable;
import rx.Observer;
import rx.functions.*;
import rx.exceptions.Exceptions;

import com.pets.core.petstore.data.models.Pet;
import com.pets.core.petstore.data.models.ModelApiResponse;
import java.io.File;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetApi {
    private ApiClient apiClient;

    public PetApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Observable<Object> addPet(Pet body) {
        Object localVarPostBody = body;
        
        // verify the required parameter 'body' is set
        if (body == null) {
            return Observable.error(new ApiException("Missing the required parameter 'body' when calling addPet"));
        }
        

        // create path and map variables
        String localVarPath = "/pet".replaceAll("\\{format\\}","json");

        // Turn Query Params into Pairs
        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        // Add all generic header params
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        // Setup Form Params
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        // Add Accept Header(s) (if provided)
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = HttpClientUtils.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        // Add Content-Type Header(s) (if provided)
        final String[] localVarContentTypes = {
            "application/json", "application/xml"
        };
        final String localVarContentType = HttpClientUtils.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "petstore_auth" };

        // Build final URL for Call
        String endpointWithQuery = apiClient.buildUrl(localVarPath, localVarQueryParams);

        // Build Request
		ApiRequest apiRequest = new ApiRequest("POST", localVarHeaderParams, localVarPostBody, localVarFormParams, localVarQueryParams, localVarAuthNames);
        try {
			apiRequest = apiClient.prepareRequestForCall(apiRequest);
        } catch (ApiException e) {
        	return Observable.error(e);
        }



        // Setup Response mapping to generic DTO Type
        final Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return apiClient.POST(endpointWithQuery, apiRequest)
            .map(new Func1<ApiResponse, Object>() {
                @Override public Object call(ApiResponse response) {
                    try {
                        return apiClient.handleResponse(response, localVarReturnType);
                    } catch (ApiException e) {
                        throw Exceptions.propagate(e);
                    }
                }
            });

    }

    public Observable<Object> deletePet(Long petId, String apiKey) {
        Object localVarPostBody = null;
        
        // verify the required parameter 'petId' is set
        if (petId == null) {
            return Observable.error(new ApiException("Missing the required parameter 'petId' when calling deletePet"));
        }
        

        // create path and map variables
        String localVarPath = "/pet/{petId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "petId" + "\\}", HttpClientUtils.escapeString(petId.toString()));

        // Turn Query Params into Pairs
        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        // Add all generic header params
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", HttpClientUtils.parameterToString(apiKey));

        // Setup Form Params
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        // Add Accept Header(s) (if provided)
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = HttpClientUtils.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        // Add Content-Type Header(s) (if provided)
        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = HttpClientUtils.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "petstore_auth" };

        // Build final URL for Call
        String endpointWithQuery = apiClient.buildUrl(localVarPath, localVarQueryParams);

        // Build Request
		ApiRequest apiRequest = new ApiRequest("DELETE", localVarHeaderParams, localVarPostBody, localVarFormParams, localVarQueryParams, localVarAuthNames);
        try {
			apiRequest = apiClient.prepareRequestForCall(apiRequest);
        } catch (ApiException e) {
        	return Observable.error(e);
        }



        // Setup Response mapping to generic DTO Type
        final Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return apiClient.DELETE(endpointWithQuery, apiRequest)
            .map(new Func1<ApiResponse, Object>() {
                @Override public Object call(ApiResponse response) {
                    try {
                        return apiClient.handleResponse(response, localVarReturnType);
                    } catch (ApiException e) {
                        throw Exceptions.propagate(e);
                    }
                }
            });

    }

    public Observable<List<Pet>> findPetsByStatus(List<String> status) {
        Object localVarPostBody = null;
        
        // verify the required parameter 'status' is set
        if (status == null) {
            return Observable.error(new ApiException("Missing the required parameter 'status' when calling findPetsByStatus"));
        }
        

        // create path and map variables
        String localVarPath = "/pet/findByStatus".replaceAll("\\{format\\}","json");

        // Turn Query Params into Pairs
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (status != null)
        localVarQueryParams.addAll(HttpClientUtils.parameterToPairs("multi", "status", status));

        // Add all generic header params
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        // Setup Form Params
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        // Add Accept Header(s) (if provided)
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = HttpClientUtils.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        // Add Content-Type Header(s) (if provided)
        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = HttpClientUtils.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "petstore_auth" };

        // Build final URL for Call
        String endpointWithQuery = apiClient.buildUrl(localVarPath, localVarQueryParams);

        // Build Request
		ApiRequest apiRequest = new ApiRequest("GET", localVarHeaderParams, localVarPostBody, localVarFormParams, localVarQueryParams, localVarAuthNames);
        try {
			apiRequest = apiClient.prepareRequestForCall(apiRequest);
        } catch (ApiException e) {
        	return Observable.error(e);
        }



        // Setup Response mapping to DTO Type
        final Type localVarReturnType = new TypeToken<List<Pet>>(){}.getType();
        return apiClient.GET(endpointWithQuery, apiRequest)
            .map(new Func1<ApiResponse, List<Pet>>() {
                @Override public List<Pet> call(ApiResponse response) {
                    try {
                        return apiClient.handleResponse(response, localVarReturnType);
                    } catch (ApiException e) {
                        throw Exceptions.propagate(e);
                    }
                }
            });

    }

    public Observable<List<Pet>> findPetsByTags(List<String> tags) {
        Object localVarPostBody = null;
        
        // verify the required parameter 'tags' is set
        if (tags == null) {
            return Observable.error(new ApiException("Missing the required parameter 'tags' when calling findPetsByTags"));
        }
        

        // create path and map variables
        String localVarPath = "/pet/findByTags".replaceAll("\\{format\\}","json");

        // Turn Query Params into Pairs
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (tags != null)
        localVarQueryParams.addAll(HttpClientUtils.parameterToPairs("multi", "tags", tags));

        // Add all generic header params
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        // Setup Form Params
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        // Add Accept Header(s) (if provided)
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = HttpClientUtils.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        // Add Content-Type Header(s) (if provided)
        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = HttpClientUtils.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "petstore_auth" };

        // Build final URL for Call
        String endpointWithQuery = apiClient.buildUrl(localVarPath, localVarQueryParams);

        // Build Request
		ApiRequest apiRequest = new ApiRequest("GET", localVarHeaderParams, localVarPostBody, localVarFormParams, localVarQueryParams, localVarAuthNames);
        try {
			apiRequest = apiClient.prepareRequestForCall(apiRequest);
        } catch (ApiException e) {
        	return Observable.error(e);
        }



        // Setup Response mapping to DTO Type
        final Type localVarReturnType = new TypeToken<List<Pet>>(){}.getType();
        return apiClient.GET(endpointWithQuery, apiRequest)
            .map(new Func1<ApiResponse, List<Pet>>() {
                @Override public List<Pet> call(ApiResponse response) {
                    try {
                        return apiClient.handleResponse(response, localVarReturnType);
                    } catch (ApiException e) {
                        throw Exceptions.propagate(e);
                    }
                }
            });

    }

    public Observable<Pet> getPetById(Long petId) {
        Object localVarPostBody = null;
        
        // verify the required parameter 'petId' is set
        if (petId == null) {
            return Observable.error(new ApiException("Missing the required parameter 'petId' when calling getPetById"));
        }
        

        // create path and map variables
        String localVarPath = "/pet/{petId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "petId" + "\\}", HttpClientUtils.escapeString(petId.toString()));

        // Turn Query Params into Pairs
        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        // Add all generic header params
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        // Setup Form Params
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        // Add Accept Header(s) (if provided)
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = HttpClientUtils.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        // Add Content-Type Header(s) (if provided)
        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = HttpClientUtils.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "api_key" };

        // Build final URL for Call
        String endpointWithQuery = apiClient.buildUrl(localVarPath, localVarQueryParams);

        // Build Request
		ApiRequest apiRequest = new ApiRequest("GET", localVarHeaderParams, localVarPostBody, localVarFormParams, localVarQueryParams, localVarAuthNames);
        try {
			apiRequest = apiClient.prepareRequestForCall(apiRequest);
        } catch (ApiException e) {
        	return Observable.error(e);
        }



        // Setup Response mapping to DTO Type
        final Type localVarReturnType = new TypeToken<Pet>(){}.getType();
        return apiClient.GET(endpointWithQuery, apiRequest)
            .map(new Func1<ApiResponse, Pet>() {
                @Override public Pet call(ApiResponse response) {
                    try {
                        return apiClient.handleResponse(response, localVarReturnType);
                    } catch (ApiException e) {
                        throw Exceptions.propagate(e);
                    }
                }
            });

    }

    public Observable<Object> updatePet(Pet body) {
        Object localVarPostBody = body;
        
        // verify the required parameter 'body' is set
        if (body == null) {
            return Observable.error(new ApiException("Missing the required parameter 'body' when calling updatePet"));
        }
        

        // create path and map variables
        String localVarPath = "/pet".replaceAll("\\{format\\}","json");

        // Turn Query Params into Pairs
        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        // Add all generic header params
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        // Setup Form Params
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        // Add Accept Header(s) (if provided)
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = HttpClientUtils.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        // Add Content-Type Header(s) (if provided)
        final String[] localVarContentTypes = {
            "application/json", "application/xml"
        };
        final String localVarContentType = HttpClientUtils.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "petstore_auth" };

        // Build final URL for Call
        String endpointWithQuery = apiClient.buildUrl(localVarPath, localVarQueryParams);

        // Build Request
		ApiRequest apiRequest = new ApiRequest("PUT", localVarHeaderParams, localVarPostBody, localVarFormParams, localVarQueryParams, localVarAuthNames);
        try {
			apiRequest = apiClient.prepareRequestForCall(apiRequest);
        } catch (ApiException e) {
        	return Observable.error(e);
        }



        // Setup Response mapping to generic DTO Type
        final Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return apiClient.PUT(endpointWithQuery, apiRequest)
            .map(new Func1<ApiResponse, Object>() {
                @Override public Object call(ApiResponse response) {
                    try {
                        return apiClient.handleResponse(response, localVarReturnType);
                    } catch (ApiException e) {
                        throw Exceptions.propagate(e);
                    }
                }
            });

    }

    public Observable<Object> updatePetWithForm(Long petId, String name, String status) {
        Object localVarPostBody = null;
        
        // verify the required parameter 'petId' is set
        if (petId == null) {
            return Observable.error(new ApiException("Missing the required parameter 'petId' when calling updatePetWithForm"));
        }
        

        // create path and map variables
        String localVarPath = "/pet/{petId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "petId" + "\\}", HttpClientUtils.escapeString(petId.toString()));

        // Turn Query Params into Pairs
        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        // Add all generic header params
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        // Setup Form Params
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (name != null)
        localVarFormParams.put("name", name);
        if (status != null)
        localVarFormParams.put("status", status);

        // Add Accept Header(s) (if provided)
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = HttpClientUtils.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        // Add Content-Type Header(s) (if provided)
        final String[] localVarContentTypes = {
            "application/x-www-form-urlencoded"
        };
        final String localVarContentType = HttpClientUtils.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "petstore_auth" };

        // Build final URL for Call
        String endpointWithQuery = apiClient.buildUrl(localVarPath, localVarQueryParams);

        // Build Request
		ApiRequest apiRequest = new ApiRequest("POST", localVarHeaderParams, localVarPostBody, localVarFormParams, localVarQueryParams, localVarAuthNames);
        try {
			apiRequest = apiClient.prepareRequestForCall(apiRequest);
        } catch (ApiException e) {
        	return Observable.error(e);
        }



        // Setup Response mapping to generic DTO Type
        final Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return apiClient.POST(endpointWithQuery, apiRequest)
            .map(new Func1<ApiResponse, Object>() {
                @Override public Object call(ApiResponse response) {
                    try {
                        return apiClient.handleResponse(response, localVarReturnType);
                    } catch (ApiException e) {
                        throw Exceptions.propagate(e);
                    }
                }
            });

    }

    public Observable<ModelApiResponse> uploadFile(Long petId, String additionalMetadata, File file) {
        Object localVarPostBody = null;
        
        // verify the required parameter 'petId' is set
        if (petId == null) {
            return Observable.error(new ApiException("Missing the required parameter 'petId' when calling uploadFile"));
        }
        

        // create path and map variables
        String localVarPath = "/pet/{petId}/uploadImage".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "petId" + "\\}", HttpClientUtils.escapeString(petId.toString()));

        // Turn Query Params into Pairs
        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        // Add all generic header params
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        // Setup Form Params
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (additionalMetadata != null)
        localVarFormParams.put("additionalMetadata", additionalMetadata);
        if (file != null)
        localVarFormParams.put("file", file);

        // Add Accept Header(s) (if provided)
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = HttpClientUtils.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        // Add Content-Type Header(s) (if provided)
        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = HttpClientUtils.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "petstore_auth" };

        // Build final URL for Call
        String endpointWithQuery = apiClient.buildUrl(localVarPath, localVarQueryParams);

        // Build Request
		ApiRequest apiRequest = new ApiRequest("POST", localVarHeaderParams, localVarPostBody, localVarFormParams, localVarQueryParams, localVarAuthNames);
        try {
			apiRequest = apiClient.prepareRequestForCall(apiRequest);
        } catch (ApiException e) {
        	return Observable.error(e);
        }



        // Setup Response mapping to DTO Type
        final Type localVarReturnType = new TypeToken<ModelApiResponse>(){}.getType();
        return apiClient.POST(endpointWithQuery, apiRequest)
            .map(new Func1<ApiResponse, ModelApiResponse>() {
                @Override public ModelApiResponse call(ApiResponse response) {
                    try {
                        return apiClient.handleResponse(response, localVarReturnType);
                    } catch (ApiException e) {
                        throw Exceptions.propagate(e);
                    }
                }
            });

    }

}
