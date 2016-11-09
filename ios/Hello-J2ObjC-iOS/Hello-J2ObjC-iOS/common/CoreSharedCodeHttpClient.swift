//
//  CoreSharedCodeHttpClient.swift
//  Hello-J2ObjC-iOS
//
//  Created by Hinz, Kayla on 11/3/16.
//  Copyright © 2016 Hinz, Kayla. All rights reserved.
//

import Foundation
import Alamofire

class CoreSharedCodeHttpClient: NSObject, ComPetsCoreSharedPetstoreDataStoreHttpClient {

    @objc func getWithNSString(endpoint: String!, withComPetsCoreSharedPetstoreDataStoreApiRequest request: ComPetsCoreSharedPetstoreDataStoreApiRequest!) -> RxObservable! {
        

        
        let onSubscribe = RxObservable_OnSubscribe()({
            (f) -> RxObservable_OnSubscribe! in
            
            func onSubscribeDoCall(subscriber:RxSubscriber) -> Void {
                do {
                    Alamofire.request(endpoint).responseJSON { response in
                        print(response.request)  // original URL request
                        print(response.response) // HTTP URL response
                        print(response.data)     // server data
                        print(response.result)   // result of response serialization
                        
                        if let JSON = response.result.value {
                            print("JSON: \(JSON)")
                            //                        if let apiResponse:ComPetsCoreSharedPetstoreDataStoreApiRequest = ComPetsCoreSharedPetstoreDataStoreApiRequest(code: response.response.code, headers: response.response.headers, data: JSON) {
                            //                            if response.isSuccessful() {
                            //                                subscriber.onNext(apiResponse)
                            //                                subscriber.onCompleted()
                            //                            } else {
                            //                                let errorMsg = String(format: "Unsuccessful response returned from: %s. Code: %d, Message: %s", endpoint, response.code(), response.message())
                            //                                let error:ComPetsCoreSharedPetstoreDataStoreApiException = ComPetsCoreSharedPetstoreDataStoreApiException(message:errorMsg, code:response.code(), request:request, response:apiResponse)
                            //                                subscriber.onError(error)
                            //                            }
                            //                        }
                        }
                    }
                } catch let exception as JavaIoIOException {
                    //                let errorMessage = String(format:"Error occurred during HTTP call to: %s. Message: %s", endpoint, e.getLocalizedMessage())
                    //                let error:ComPetsCoreSharedPetstoreDataStoreApiException = ComPetsCoreSharedPetstoreDataStoreApiException(message:errorMsg, throwable:exception.getCause(), request:request)
                    //                subscriber.onError(error)
                }
                f(onSubscribeDoCall)
            }
            
        });

        return RxObservable.createWithRxObservable_OnSubscribe({
            (subscriber) -> Void in
            // return RxObservable_OnSubscribeExtend {
            //     (subscriber) -> Void in
            do {
                Alamofire.request(endpoint).responseJSON { response in
                    print(response.request)  // original URL request
                    print(response.response) // HTTP URL response
                    print(response.data)     // server data
                    print(response.result)   // result of response serialization
                    
                    if let JSON = response.result.value {
                        print("JSON: \(JSON)")
//                        if let apiResponse:ComPetsCoreSharedPetstoreDataStoreApiRequest = ComPetsCoreSharedPetstoreDataStoreApiRequest(code: response.response.code, headers: response.response.headers, data: JSON) {
//                            if response.isSuccessful() {
//                                subscriber.onNext(apiResponse)
//                                subscriber.onCompleted()
//                            } else {
//                                let errorMsg = String(format: "Unsuccessful response returned from: %s. Code: %d, Message: %s", endpoint, response.code(), response.message())
//                                let error:ComPetsCoreSharedPetstoreDataStoreApiException = ComPetsCoreSharedPetstoreDataStoreApiException(message:errorMsg, code:response.code(), request:request, response:apiResponse)
//                                subscriber.onError(error)
//                            }
//                        }
                    }
                }
            } catch let exception as JavaIoIOException {
//                let errorMessage = String(format:"Error occurred during HTTP call to: %s. Message: %s", endpoint, e.getLocalizedMessage())
//                let error:ComPetsCoreSharedPetstoreDataStoreApiException = ComPetsCoreSharedPetstoreDataStoreApiException(message:errorMsg, throwable:exception.getCause(), request:request)
//                subscriber.onError(error)
            }
        });
    }
//          Java:
//        return Observable.create(new Observable.OnSubscribe<ApiResponse>() {
//            @Override
//            public void call(Subscriber subscriber) {
//                try {
//                    Response response = buildGetRequest(endpoint, request);
//                    Headers responseHeaders = response.headers();
//                    Map<String, String>headers = new HashMap<String, String>();
//                    for (int i = 0; i < responseHeaders.size(); i++) {
//                        headers.put(responseHeaders.name(i), responseHeaders.value(i));
//                    }
//                    ApiResponse<String> apiResponse = new ApiResponse<String>(response.code(), headers, response.body().string());
//                    if (response.isSuccessful() && !subscriber.isUnsubscribed()) {
//                        subscriber.onNext(apiResponse);
//                        subscriber.onCompleted();
//                    } else {
//                        String errorMsg = String.format("Unsuccessful response returned from: %s. Code: %d, Message: %s", endpoint, response.code(), response.message());
//                        ApiException error = new ApiException(errorMsg, response.code(), request, apiResponse);
//                        subscriber.onError(error);
//                    }
//                } catch (IOException e) {
//                    String error = String.format("Error occurred during HTTP call to: %s. Message: %s", endpoint, e.getLocalizedMessage());
//                    subscriber.onError(new ApiException(error, e.getCause(), request));
//                }
//            }
//            });
//    }

    @objc func putWithNSString(endpoint: String!, withComPetsCoreSharedPetstoreDataStoreApiRequest request: ComPetsCoreSharedPetstoreDataStoreApiRequest!) -> RxObservable! {
        // Return an RxObservable that emits an ApiResponse

    }



    @objc func postWithNSString(endpoint: String!, withComPetsCoreSharedPetstoreDataStoreApiRequest request: ComPetsCoreSharedPetstoreDataStoreApiRequest!) -> RxObservable! {
        // Return an RxObservable that emits an ApiResponse

    }

    @objc func delete__WithNSString(endpoint: String!, withComPetsCoreSharedPetstoreDataStoreApiRequest request: ComPetsCoreSharedPetstoreDataStoreApiRequest!) -> RxObservable! {
        // Return an RxObservable that emits an ApiResponse


    }
}
