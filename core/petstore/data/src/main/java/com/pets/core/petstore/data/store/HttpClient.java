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


package com.pets.core.petstore.data.store;

import rx.Observable;
import com.pets.core.petstore.data.store.ApiException;
import com.pets.core.petstore.data.store.ApiResponse;
import com.pets.core.petstore.data.store.ApiRequest;

/**
* Observable Generic HTTP Client.
*
* This should be a Native Implementation of an generic HTTP Client. The client is responsible for
* implementing SSL/Certificate Functionality, as well as any other typical HTTP Client functionality.
* All other logic that this specific to this API will be contained in the ApiClient class.
*
* All actions on the HTTP Client should correctly return observables that properly trigger onError
* when a call fails.
*
* // TODO or onNextError
*/
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-19T15:39:03.409-04:00")
public interface HttpClient {
    /**
    * This method makes an HTTP GET request and return response as ApiResponse of Observable.
    *
    * @param endpoint        Endpoint at which to make the POST call (including Query Parameters (i.e. &foo=bar))
    * @param request 		  ApiRequest that will be used to build the final Request
    * @return Observable with ApiResponse value
    */
    Observable<ApiResponse> get(String endpoint, ApiRequest request);

    /**
    * This method makes an HTTP POST request and return response as ApiResponse of Observable.
    *
    * @param endpoint        Endpoint at which to make the POST call (including Query Parameters (i.e. &foo=bar))
    * @param request 		  ApiRequest that will be used to build the final Request
    * @return Observable with ApiResponse value
    */
    Observable<ApiResponse> post(String endpoint, ApiRequest request);

    /**
    * This method makes an HTTP PUT request and return response as ApiResponse of Observable.
    *
    * @param endpoint        Endpoint at which to make the POST call (including Query Parameters (i.e. &foo=bar))
    * @param request 		  ApiRequest that will be used to build the final Request
    * @return Observable with ApiResponse value
    */
    Observable<ApiResponse> put(String endpoint, ApiRequest request);

    /**
    * This method makes an HTTP DELETE request and return response as ApiResponse of Observable.
    *
    * @param endpoint        Endpoint at which to make the POST call (including Query Parameters (i.e. &foo=bar))
    * @param request 		  ApiRequest that will be used to build the final Request
    * @return Observable with ApiResponse value
    */
    Observable<ApiResponse> delete(String endpoint, ApiRequest request);
}