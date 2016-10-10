package com.pets.core.petstore.data.store.store.auth;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ApiKeyAuth implements Authentication {
    private final String location;
    private final String paramName;

    private String apiKey;

    public ApiKeyAuth(String location, String paramName) {
        this.location = location;
        this.paramName = paramName;
    }

    public String getLocation() {
        return location;
    }

    public String getParamName() {
        return paramName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public ApiRequest applyToRequest(ApiRequest request) throws ApiException {
        throw new ApiException("Api Key Authentication Not Implemented");
    }
}
