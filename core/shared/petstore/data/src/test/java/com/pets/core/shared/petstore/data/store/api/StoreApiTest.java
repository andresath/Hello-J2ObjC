package com.pets.core.shared.petstore.data.store.api;

import com.pets.core.shared.petstore.data.store.ApiClient;
import com.pets.core.shared.petstore.data.store.HttpClient;


import com.pets.core.shared.petstore.data.models.Order;
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
 * API tests for StoreApi
 */
public class StoreApiTest {

    private StoreApi api;
    private HttpClient httpClient;
    private ApiClient apiClient;

    @Before
    public void setup() {
        httpClient = null;
        apiClient = new ApiClient(httpClient);
        api = new StoreApi(apiClient);
    }

    
    /**
     * Delete purchase order by ID
     *
     * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
     */
    @Test
    public void deleteOrderTest() {
        Long orderId = null;
        // rx.Observable<Object> apiObservable = api.deleteOrder(orderId);
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
     * Returns pet inventories by status
     *
     * Returns a map of status codes to quantities
     */
    @Test
    public void getInventoryTest() {
        // rx.Observable<Map<String, Integer>> apiObservable = api.getInventory();
        // Subscriber<Map<String, Integer>> apiSubscriber = new Subscriber<Map<String, Integer>>() {
        //    @Override
        //    public void onNext(Map<String, Integer> dtoResponse) {
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
     * Find purchase order by ID
     *
     * For valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10. Other values will generated exceptions
     */
    @Test
    public void getOrderByIdTest() {
        Long orderId = null;
        // rx.Observable<Order> apiObservable = api.getOrderById(orderId);
        // Subscriber<Order> apiSubscriber = new Subscriber<Order>() {
        //    @Override
        //    public void onNext(Order dtoResponse) {
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
     * Place an order for a pet
     *
     * 
     */
    @Test
    public void placeOrderTest() {
        Order body = null;
        // rx.Observable<Order> apiObservable = api.placeOrder(body);
        // Subscriber<Order> apiSubscriber = new Subscriber<Order>() {
        //    @Override
        //    public void onNext(Order dtoResponse) {
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
