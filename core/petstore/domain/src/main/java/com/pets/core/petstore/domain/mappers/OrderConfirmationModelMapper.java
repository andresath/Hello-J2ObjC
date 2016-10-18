/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pets.core.petstore.domain.mappers;

// TODO We Should Update the CodeGen Module so it generates FooModel
// and ViewModels can be Foo
import com.pets.core.petstore.domain.models.PetModel;
import com.pets.core.petstore.domain.models.OrderConfirmationModel;
import com.pets.core.petstore.data.models.Pet;
import com.pets.core.petstore.data.models.Order;
import com.pets.core.petstore.data.models.Tag;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.base.Function;

public final class OrderConfirmationModelMapper {

    public static OrderConfirmationModel transform(Order order, PetModel pet) {
        if (order == null) {
            return null;
        }
        OrderConfirmationModel orderConfirmation = new OrderConfirmationModel();
        orderConfirmation.setPetModel(pet)
                .setOrderId(order.getId())
                .setOrderQuantity(order.getQuantity());
                //.setOrderShipDate(order.getShipDate().toString());

        return orderConfirmation;
    }
}