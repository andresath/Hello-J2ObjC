package com.pets.core.shared.petstore.data.store.api;

import com.pets.core.shared.petstore.data.store.ApiClient;
import com.pets.core.shared.petstore.data.store.HttpClient;


import com.pets.core.shared.petstore.data.models.Pet;
import com.pets.core.shared.petstore.data.models.ModelApiResponse;
import java.io.File;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import rx.Subscriber;
import rx.Observer;
import rx.Observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PetApi
 */
public class PetApiTest {

    private PetApi api;
    private HttpClient httpClient;
    private ApiClient apiClient;

    @Before
    public void setup() {
        httpClient = null;
        apiClient = new ApiClient(httpClient);
        api = new PetApi(apiClient);
    }

    
    /**
     * Add a new pet to the store
     *
     * 
     */
    @Test
    public void addPetTest() {
        Pet body = null;
        // rx.Observable<Object> apiObservable = api.addPet(body);
        // Subscriber<Object> apiSubscriber = new Subscriber<Object>() {
        //    @Override
        //    public void onNext(Object dtoResponse) {
        //        // TODO: test validations
        //        Assert.assertNotNull("DTO Response should not be Null", dtoResponse);
        //    }

        //    @Override
        //    public void onCompleted() {
        //       // TODO: test any post-processing
        //        System.out.println("Api Call Complete");
        //    }

        //    @Override
        //    public void onError(Throwable e) {
        //        // TODO: handle error scenario
        //        System.out.println(e.getMessage());
        //    }
        // };
        // apiObservable.subscribe(apiSubscriber);
    }
    
    /**
     * Deletes a pet
     *
     * 
     */
    @Test
    public void deletePetTest() {
        Long petId = null;
        String apiKey = null;
        // rx.Observable<Object> apiObservable = api.deletePet(petId, apiKey);
        // Subscriber<Object> apiSubscriber = new Subscriber<Object>() {
        //    @Override
        //    public void onNext(Object dtoResponse) {
        //        // TODO: test validations
        //        Assert.assertNotNull("DTO Response should not be Null", dtoResponse);
        //    }

        //    @Override
        //    public void onCompleted() {
        //       // TODO: test any post-processing
        //        System.out.println("Api Call Complete");
        //    }

        //    @Override
        //    public void onError(Throwable e) {
        //        // TODO: handle error scenario
        //        System.out.println(e.getMessage());
        //    }
        // };
        // apiObservable.subscribe(apiSubscriber);
    }
    
    /**
     * Finds Pets by status
     *
     * Multiple status values can be provided with comma separated strings
     */
    @Test
    public void findPetsByStatusTest() {
        List<String> status = null;
        // rx.Observable<List<Pet>> apiObservable = api.findPetsByStatus(status);
        // Subscriber<List<Pet>> apiSubscriber = new Subscriber<List<Pet>>() {
        //    @Override
        //    public void onNext(List<Pet> dtoResponse) {
        //        // TODO: test validations
        //        Assert.assertNotNull("DTO Response should not be Null", dtoResponse);
        //    }

        //    @Override
        //    public void onCompleted() {
        //       // TODO: test any post-processing
        //        System.out.println("Api Call Complete");
        //    }

        //    @Override
        //    public void onError(Throwable e) {
        //        // TODO: handle error scenario
        //        System.out.println(e.getMessage());
        //    }
        // };
        // apiObservable.subscribe(apiSubscriber);
    }
    
    /**
     * Finds Pets by tags
     *
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     */
    @Test
    public void findPetsByTagsTest() {
        List<String> tags = null;
        // rx.Observable<List<Pet>> apiObservable = api.findPetsByTags(tags);
        // Subscriber<List<Pet>> apiSubscriber = new Subscriber<List<Pet>>() {
        //    @Override
        //    public void onNext(List<Pet> dtoResponse) {
        //        // TODO: test validations
        //        Assert.assertNotNull("DTO Response should not be Null", dtoResponse);
        //    }

        //    @Override
        //    public void onCompleted() {
        //       // TODO: test any post-processing
        //        System.out.println("Api Call Complete");
        //    }

        //    @Override
        //    public void onError(Throwable e) {
        //        // TODO: handle error scenario
        //        System.out.println(e.getMessage());
        //    }
        // };
        // apiObservable.subscribe(apiSubscriber);
    }
    
    /**
     * Find pet by ID
     *
     * Returns a single pet
     */
    @Test
    public void getPetByIdTest() {
        Long petId = null;
        // rx.Observable<Pet> apiObservable = api.getPetById(petId);
        // Subscriber<Pet> apiSubscriber = new Subscriber<Pet>() {
        //    @Override
        //    public void onNext(Pet dtoResponse) {
        //        // TODO: test validations
        //        Assert.assertNotNull("DTO Response should not be Null", dtoResponse);
        //    }

        //    @Override
        //    public void onCompleted() {
        //       // TODO: test any post-processing
        //        System.out.println("Api Call Complete");
        //    }

        //    @Override
        //    public void onError(Throwable e) {
        //        // TODO: handle error scenario
        //        System.out.println(e.getMessage());
        //    }
        // };
        // apiObservable.subscribe(apiSubscriber);
    }
    
    /**
     * Update an existing pet
     *
     * 
     */
    @Test
    public void updatePetTest() {
        Pet body = null;
        // rx.Observable<Object> apiObservable = api.updatePet(body);
        // Subscriber<Object> apiSubscriber = new Subscriber<Object>() {
        //    @Override
        //    public void onNext(Object dtoResponse) {
        //        // TODO: test validations
        //        Assert.assertNotNull("DTO Response should not be Null", dtoResponse);
        //    }

        //    @Override
        //    public void onCompleted() {
        //       // TODO: test any post-processing
        //        System.out.println("Api Call Complete");
        //    }

        //    @Override
        //    public void onError(Throwable e) {
        //        // TODO: handle error scenario
        //        System.out.println(e.getMessage());
        //    }
        // };
        // apiObservable.subscribe(apiSubscriber);
    }
    
    /**
     * Updates a pet in the store with form data
     *
     * 
     */
    @Test
    public void updatePetWithFormTest() {
        Long petId = null;
        String name = null;
        String status = null;
        // rx.Observable<Object> apiObservable = api.updatePetWithForm(petId, name, status);
        // Subscriber<Object> apiSubscriber = new Subscriber<Object>() {
        //    @Override
        //    public void onNext(Object dtoResponse) {
        //        // TODO: test validations
        //        Assert.assertNotNull("DTO Response should not be Null", dtoResponse);
        //    }

        //    @Override
        //    public void onCompleted() {
        //       // TODO: test any post-processing
        //        System.out.println("Api Call Complete");
        //    }

        //    @Override
        //    public void onError(Throwable e) {
        //        // TODO: handle error scenario
        //        System.out.println(e.getMessage());
        //    }
        // };
        // apiObservable.subscribe(apiSubscriber);
    }
    
    /**
     * uploads an image
     *
     * 
     */
    @Test
    public void uploadFileTest() {
        Long petId = null;
        String additionalMetadata = null;
        File file = null;
        // rx.Observable<ModelApiResponse> apiObservable = api.uploadFile(petId, additionalMetadata, file);
        // Subscriber<ModelApiResponse> apiSubscriber = new Subscriber<ModelApiResponse>() {
        //    @Override
        //    public void onNext(ModelApiResponse dtoResponse) {
        //        // TODO: test validations
        //        Assert.assertNotNull("DTO Response should not be Null", dtoResponse);
        //    }

        //    @Override
        //    public void onCompleted() {
        //       // TODO: test any post-processing
        //        System.out.println("Api Call Complete");
        //    }

        //    @Override
        //    public void onError(Throwable e) {
        //        // TODO: handle error scenario
        //        System.out.println(e.getMessage());
        //    }
        // };
        // apiObservable.subscribe(apiSubscriber);
    }
    
}
