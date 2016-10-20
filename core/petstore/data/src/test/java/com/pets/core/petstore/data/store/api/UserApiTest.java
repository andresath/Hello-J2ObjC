package com.pets.core.petstore.data.store.api;

import com.pets.core.petstore.data.store.ApiClient;
import com.pets.core.petstore.data.store.HttpClient;


import com.pets.core.petstore.data.models.User;
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
 * API tests for UserApi
 */
public class UserApiTest {

    private UserApi api;
    private HttpClient httpClient;
    private ApiClient apiClient;

    @Before
    public void setup() {
        httpClient = null;
        apiClient = new ApiClient(httpClient);
        api = new UserApi(apiClient);
    }

    
    /**
     * Create user
     *
     * This can only be done by the logged in user.
     */
    @Test
    public void createUserTest() {
        User body = null;
        // rx.Observable<Object> apiObservable = api.createUser(body);
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
     * Creates list of users with given input array
     *
     * 
     */
    @Test
    public void createUsersWithArrayInputTest() {
        List<User> body = null;
        // rx.Observable<Object> apiObservable = api.createUsersWithArrayInput(body);
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
     * Creates list of users with given input array
     *
     * 
     */
    @Test
    public void createUsersWithListInputTest() {
        List<User> body = null;
        // rx.Observable<Object> apiObservable = api.createUsersWithListInput(body);
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
     * Delete user
     *
     * This can only be done by the logged in user.
     */
    @Test
    public void deleteUserTest() {
        String username = null;
        // rx.Observable<Object> apiObservable = api.deleteUser(username);
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
     * Get user by user name
     *
     * 
     */
    @Test
    public void getUserByNameTest() {
        String username = null;
        // rx.Observable<User> apiObservable = api.getUserByName(username);
        // Subscriber<User> apiSubscriber = new Subscriber<User>() {
        //    @Override
        //    public void onNext(User dtoResponse) {
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
     * Logs user into the system
     *
     * 
     */
    @Test
    public void loginUserTest() {
        String username = null;
        String password = null;
        // rx.Observable<String> apiObservable = api.loginUser(username, password);
        // Subscriber<String> apiSubscriber = new Subscriber<String>() {
        //    @Override
        //    public void onNext(String dtoResponse) {
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
     * Logs out current logged in user session
     *
     * 
     */
    @Test
    public void logoutUserTest() {
        // rx.Observable<Object> apiObservable = api.logoutUser();
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
     * Updated user
     *
     * This can only be done by the logged in user.
     */
    @Test
    public void updateUserTest() {
        String username = null;
        User body = null;
        // rx.Observable<Object> apiObservable = api.updateUser(username, body);
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
    
}
