
package com.pets.core.petstore.domain.store;

import com.pets.core.petstore.data.store.ApiClient;
import com.pets.core.petstore.data.store.ApiException;
import com.pets.core.petstore.data.store.api.UserApi;
import com.pets.core.petstore.data.store.api.PetApi;
import com.pets.core.petstore.data.store.api.StoreApi;

import com.pets.core.petstore.data.models.Pet;
import com.pets.core.petstore.data.models.Order;

import com.pets.core.petstore.domain.models.PetModel;
import com.pets.core.petstore.domain.models.OrderConfirmationModel;
import com.pets.core.petstore.domain.PetstoreException;
import com.pets.core.petstore.domain.mappers.PetModelMapper;
import com.pets.core.petstore.domain.mappers.OrderConfirmationModelMapper;


import rx.Observable;
import rx.Subscriber;
import rx.functions.*;

import java.util.ArrayList;
import java.util.List;

public class PetstoreStore {
    private ApiClient apiClient;
    private PetApi petApi;
    private UserApi userApi;
    private StoreApi storeApi;

    public PetstoreStore(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.userApi = new UserApi(apiClient);
        this.petApi = new PetApi(apiClient);
        this.storeApi = new StoreApi(apiClient);
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Retrieve a list of all Available Pets (Observable)
     * @return Observable<List<Pet>> Observable service call
     * Observable.onError will be called with an ApiException if anything about the Request fails, or it is an unsuccessful response.
     */
    public Observable<List<PetModel>> findAvailablePets() {
        // TODO we probably want a Pet domain model instead of the DTO
        List<String> status = new ArrayList<String>();
        status.add("available");
        Subscriber<List<Pet>> apiSubscriber = new Subscriber<List<Pet>>() {
            @Override
            public void onNext(List<Pet> dtoResponse) {
                // TODO: test validations
                System.out.println("Got Pet");
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
        return petApi.findPetsByStatus(status)
//                .onErrorResumeNext(new Func1<Throwable, Observable<?>>() {
//                    @Override
//                    public Observable<?> call(Throwable throwable) {
//                        // Here simply return an Observable which will emit the Throwable of your liking
//                        return Observable.error(new PetstoreException("Unable to Retrieve available pets at this time.", throwable, throwable));
//                    }
//                })
                .map(new Func1<List<Pet>, List<PetModel>>() {
                    @Override public List<PetModel> call(List<Pet> pets) {
                        return PetModelMapper.transform(pets);
                    }
                });
//                .retryWhen(
//                    TODO create retry example
//                );
    }

    /**
     * Order N quantity of a Pet (Observable)
     * Note: This will validate that a Pet is still available to Order, prior to placing the Order.
     *
     * @param pet PetModel object that needs to be added to the store (required)
     * @param quantity Long The number of pets to place an Order for
     * @return Observable<OrderConfirmationModel> Observable service call
     * Observable.onError will be called with an ApiException if anything about the Request fails, or it is an unsuccessful response.
     */
    public Observable<OrderConfirmationModel> orderPet(final PetModel pet, final Integer quantity) {
        if (pet != null) {
            final PetModel petForOrder = null;
            return petApi.getPetById(pet.getId())
//                    .onErrorResumeNext(new Func1<Throwable, Observable<?>>() {
//                        @Override
//                        public Observable<?> call(Throwable throwable) {
//                            // Here simply return an Observable which will emit the Throwable of your liking
//                            return Observable.error(new PetstoreException("Unable to find Pet referenced in the Order", throwable, throwable));
//                        }
//                    })
                    .flatMap(new Func1<Pet, Observable<Order>>() {
                        @Override public Observable<Order> call(Pet pet) {
                            if (pet.getStatus() != Pet.StatusEnum.AVAILABLE) {
                                return Observable.error(new PetstoreException("This Pet is no longer available to order"));
                            }
                            //petForOrder = pet;
                            Order order = new Order();
                            order.setPetId(pet.getId());
                            order.setQuantity(quantity);

                            return storeApi.placeOrder(order);
                        }
                    })
//                    .onErrorResumeNext(new Func1<Throwable, Observable<?>>() {
//                        @Override
//                        public Observable<?> call(Throwable throwable) {
//                            // Here simply return an Observable which will emit the Throwable of your liking
//                            return Observable.error(new PetstoreException("Unable to place Order for Pet:" + pet.getId(), throwable, throwable));
//                        }
//                    })
                    .map(new Func1<Order, OrderConfirmationModel>() {
                        @Override public OrderConfirmationModel call(Order order) {
                            //PetModel orderedPet = PetModelMapper.transform(petForOrder);
                            OrderConfirmationModel orderConfirmation = OrderConfirmationModelMapper.transform(order, pet);
                            return orderConfirmation;
                        }
                    });

                    // .retryWhen(
                    //   TODO Add retry example
                    //);
        } else {
            return Observable.error(new PetstoreException("A Pet was not included when attempting to place the order."));
        }
    }
}
