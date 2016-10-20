package com.pets.core.drivers;

import com.pets.core.petstore.data.store.ApiClient;
import com.pets.core.petstore.data.store.HttpClient;
import com.pets.core.drivers.OkHttpServiceClient;
import com.pets.core.petstore.data.store.auth.ApiKeyAuth;
import com.pets.core.petstore.domain.models.OrderConfirmationModel;
import com.pets.core.petstore.domain.models.PetModel;
import com.pets.core.petstore.domain.store.PetstoreStore;
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
public class OKHttpClientPetstoreIntegrationTest {

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
     * Find all Available Pets
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

    /**
     * Find all Available Pets that have Photos
     */
    @Test
    public void findAvailablePetsWithPhotosTest() {
        rx.Observable<List<PetModel>> apiObservable = petstore.findAvailablePetsWithPhotos();
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

    /**
     * Order a Pet and Recieve an Order Confirmation
     */
    @Test
    public void orderPetTest() {
        PetModel pet = new PetModel(new Long(1006227));
        // Authenticate with API Key:
        // Static API Key for Petstore API
        apiClient.setApiKey("special-key");
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
