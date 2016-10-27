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
package com.pets.core.shared.petstore.domain.mappers;

// TODO We Should Update the CodeGen Module so it generates FooModel
// and ViewModels can be Foo
import com.pets.core.shared.petstore.domain.models.PetModel;
import com.pets.core.shared.petstore.data.models.Pet;
import com.pets.core.shared.petstore.data.models.Tag;
import java.util.List;
import java.util.ArrayList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

public final class PetModelMapper {

    public static PetModel transform(Pet pet) {
        if (pet == null) {
            return null;
        }
        PetModel petModel = new PetModel(pet.getId());

        petModel.setName(pet.getName())
                .setStatus(pet.getStatus() == null ? null : pet.getStatus().toString())
                .setCategoryName(pet.getCategory() == null ? null : pet.getCategory().getName());

        List<Tag>tags = pet.getTags();
        if (tags != null) {
            final List<String> tagNames =
                    Lists.newArrayList(Iterables.transform(pet.getTags(), new Function<Tag, String>() {
                        @Override
                        public String apply(final Tag tag) {
                            return tag.getName();
                        }
                    }));
            petModel.setTagNames(tagNames);
        }

        // Do some business logic (that should have been on the server side)
        // and filter out non-valid photo URLs
        List<String>urls = pet.getPhotoUrls();
        if (urls != null) {
            final List<String> photoUrls =
                    Lists.newArrayList(Iterables.filter(urls, new Predicate<String>() {
                        @Override
                        public boolean apply(String url) {
                            return url.startsWith("http://") || url.startsWith("https://");
                        }
                    }));
            petModel.setPhotoUrls(photoUrls);
        }


        return petModel;
    }

    public static List<PetModel> transform(List<Pet> pets) {
        List<PetModel> petModels = new ArrayList<>();

        if (pets != null && !pets.isEmpty()) {
            for (Pet pet : pets) {
                PetModel petModel = transform(pet);
                petModels.add(petModel);
            }
        }

        return petModels;
    }
}