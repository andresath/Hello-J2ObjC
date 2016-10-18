package com.pets.core.petstore.domain.store;

import com.pets.core.petstore.data.store.ApiClient;
import com.pets.core.petstore.data.store.HttpClient;
import com.pets.core.petstore.data.store.OkHttpServiceClient;
import com.pets.core.petstore.domain.models.OrderConfirmationModel;
import com.pets.core.petstore.domain.models.PetModel;
import com.pets.core.petstore.domain.store.PetstoreStore;
import com.pets.core.
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import java.util.ArrayList;
import java.util.List;

/**
 * API tests for PetApi
 */
public class PetstoreStoreTest {

    private PetstoreStore petstore;
    private HttpClient httpClient;
    private ApiClient apiClient;

    @Before
    public void setup() {
        httpClient = new OkHttpServiceClient();
        apiClient = new ApiClient(httpClient);
        petstore = new PetstoreStore(apiClient);
    }

    
    /**
     * Add a new pet to the store
     *
     * 
     */
    @Test
    public void findAvailablePetsTest() {
         rx.Observable<List<PetModel>> apiObservable = petstore.findAvailablePets();
         Subscriber<List<PetModel>> apiSubscriber = new Subscriber<List<PetModel>>() {
            @Override
            public void onNext(List<PetModel> pets) {
                // TODO: test validations
                Assert.assertNotNull("Available Pets should not be Null", pets);
            }

            @Override
            public void onCompleted() {
               // TODO: test any post-processing
                System.out.println("Api Call Complete");
            }

            @Override
            public void onError(Throwable e) {
                // TODO: handle error scenario
                System.out.println(e.getMessage());
            }
         };
         apiObservable.subscribe(apiSubscriber);
    }

    public void orderPetTest() {
        PetModel pet = new PetModel(new Long(1475574931));
        rx.Observable<OrderConfirmationModel> apiObservable = petstore.orderPet(pet, 2);
        Subscriber<OrderConfirmationModel> apiSubscriber = new Subscriber<OrderConfirmationModel>() {
            @Override
            public void onNext(OrderConfirmationModel orderConfirmation) {
                // TODO: test validations
                Assert.assertNotNull("Order Confirmation should not be Null", orderConfirmation);
            }

            @Override
            public void onCompleted() {
                // TODO: test any post-processing
                System.out.println("Api Call Complete");
            }

            @Override
            public void onError(Throwable e) {
                // TODO: handle error scenario
                System.out.println(e.getMessage());
            }
        };
        apiObservable.subscribe(apiSubscriber);
    }
}
