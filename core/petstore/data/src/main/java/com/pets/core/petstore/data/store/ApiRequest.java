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

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

/**
 * API Request created for API call.
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-12T16:32:29.271-04:00")
public class ApiRequest<T> {
    private String[] authTypes;
    private String method;
    private T data;
    private String body;
    private Map<String, String> headers;
    private Map<String, Object> formParams;
    private List<Pair> rawQueryParams;

    /**
     * @param method The method of the HTTP Request
     * @param headers The headers of HTTP Request
     * @param data The body of the HTTP Request
     */
    public ApiRequest(String method, Map<String, String> headers, T data) {
        this(method, headers, data, null, null, null);
    }

    /**
     * @param method The method of the HTTP Request
     * @param headers The headers of HTTP Request
     * @param data The body of the HTTP Request
     * @param formParams The (optional) Form Params (multipart, etc.)
     */
    public ApiRequest(String method, Map<String, String> headers, T data, Map<String, Object> formParams) {
        this(method, headers, data, formParams, null, null);
    }

    /**
     * @param method The method of the HTTP Request
     * @param headers The headers of HTTP Request
     * @param data The body of the HTTP Request
     * @param formParams The (optional) Form Params (multipart, etc.)
     * @param rawQueryParams The (pre-translated) Query Params (NOTE this is typically for debugging purposes)
     */
    public ApiRequest(String method, Map<String, String> headers, T data, Map<String, Object> formParams, List<Pair> rawQueryParams, String[] authTypes) {
        this.method = method;
        this.headers = headers;
        this.data = data;
        this.formParams = formParams;
        this.rawQueryParams = rawQueryParams;
        this.authTypes = authTypes;
    }

    public String getMethod() {
        return method;
    }

    public T getData() {
        return data;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String[] getAuthTypes() {
        return authTypes;
    }

    public ApiRequest addHeaders(Map<String, String> additionalHeaders) {
        if (additionalHeaders != null) {
            for (Entry<String, String> header : additionalHeaders.entrySet()) {
                if (!headers.containsKey(header.getKey())) {
                    headers.put(header.getKey(), HttpClientUtils.parameterToString(header.getValue()));
                }
            }
        }
        return this;
    }

    public ApiRequest addQueryParam(Pair param) {
        rawQueryParams.add(param);
        return this;
    }

	public ApiRequest addHeaderParam(String param, String value) {
		headers.put(param, HttpClientUtils.parameterToString(value));
		return this;
	}

    public Map<String, Object> getFormParams() {
        return formParams;
    }

    public List<Pair> getRawQueryParams() {
        return rawQueryParams;
    }

    public boolean isJsonContentType() {
        return HttpClientUtils.isJsonMime(getContentType());
    }

    public String getContentType() {
        String contentType = headers.get("Content-Type");
        if (contentType == null) {
            // ensuring a default content type
            contentType = "application/json";
        }
        return contentType;
    }

    public void setSerializedBody(String bodyContent) {
        body = bodyContent;
    }

    public String getSerializedBody() {
        return body;
    }
}