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
import com.pets.core.petstore.data.models.Pet;
import java.util.ArrayList;

public final class PetModelMapper {

    public static PetModel transform(Pet pet) {
        if (pet == null) {
            return pet;
        }
        PetModel petModel = new PetModel(pet.getId());
        final List<String> tagNames =
                Lists.newArrayList(Iterables.transform(pet.getTags(), new Function<Tag, String>() {
                    @Override
                    public String apply(final Tag tag) {
                        return tag.getName();
                    }
                }));

        petModel.setName(pet.getName())
                .setStatus(pet.getStatus().toString())
                .setCategoryName(pet.getCategory().getName())
                .setTagNames(tagNames)
                .setPhotoUrls(pet.getPhotoUrls());

        return petModel;
    }

    public static List<PetModel> transform(List<Pet> pets) {
        List<PetModel> petModels = new ArrayList<>();

        if (pets != null && !pets.isEmpty()) {
            petModels = new ArrayList<>();
            for (Pet pet : pets) {
                petModels.add(transform(pet));
            }
        }

        return petModels;
    }
}