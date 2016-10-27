package com.pets.core.shared.petstore.domain;

import com.pets.core.shared.petstore.data.store.ApiException;

import java.util.Map;
import java.util.List;

public class PetstoreException extends Exception {

    private ApiException apiException;

    public PetstoreException() {}

    public PetstoreException(Throwable throwable) {
        super(throwable);
    }

    public PetstoreException(String message) {
        super(message);
    }

    public PetstoreException(String message, Throwable throwable, ApiException apiException) {
        super(message, throwable);
        this.apiException = apiException;
    }

    public ApiException getApiException() {
        return apiException;
    }

    public boolean containsApiException() {
        return (apiException != null);
    }
}