package com.pets.core.petstore.domain.models;

import com.pets.core.petstore.data.models.Pet;
import java.util.ArrayList;
import java.util.List;

/**
 * Pet Model
 */
public class PetModel {
    private Long id = null;
    private String categoryName = null;
    private String status = null;
    private String name = null;
    private List<String> photoUrls = new ArrayList<String>();
    private List<String> tagNames = new ArrayList<String>();

    public PetModel(Long id) {
        this.id = id;
    }

    public PetModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public PetModel setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public PetModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public PetModel setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public PetModel addPhotoUrl(String photoUrl) {
        this.photoUrls.add(photoUrl);
        return this;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public PetModel setTagNames(List<String> tagNames) {
        this.tagNames = tagNames;
        return this;
    }

    public List<String> getTagNames() {
        return tagNames;
    }

    public PetModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public boolean isAvailableToOrder() {
        return (status == Pet.StatusEnum.AVAILABLE.toString());
    }

}

