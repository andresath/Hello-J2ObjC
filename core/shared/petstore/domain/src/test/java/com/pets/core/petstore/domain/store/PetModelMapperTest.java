package com.pets.core.petstore.domain.store;

import com.pets.core.shared.petstore.data.models.Pet;
import com.pets.core.shared.petstore.data.models.Category;
import com.pets.core.shared.petstore.data.models.Tag;
import com.pets.core.shared.petstore.domain.models.PetModel;
import com.pets.core.shared.petstore.domain.mappers.PetModelMapper;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * API tests for PetApi
 */
public class PetModelMapperTest {

    private List<Pet> listOfTestPets() {
        Category category = new Category();
        category.id(new Long(1))
                .name("Exotic");

        List<Tag> tags = new ArrayList<Tag>();
        Tag tagA = new Tag();
        tagA.name("Mammal")
                .id(new Long(5));
        Tag tagB = new Tag();
        tagA.name("Furry")
                .id(new Long(10));

        tags.add(tagA);
        tags.add(tagB);

        List<String> urls = new ArrayList<>();
        urls.add("http://foo.com/bar.jpg");
        urls.add("https://foo.com/zee.jpg");
        urls.add("this is not a url");

        Pet petDto = new Pet();
        petDto.name("Frank")
                .id(new Long(4))
                .tags(tags)
                .category(category)
                .photoUrls(urls);

        Category categoryB = new Category();
        category.id(new Long(2))
                .name("Domestic");

        List<Tag> tagsB = new ArrayList<Tag>();
        Tag tagC = new Tag();
        tagC.name("Hypo-Allergenic")
                .id(new Long(7));

        tagsB.add(tagA);
        tagsB.add(tagB);
        tagsB.add(tagC);

        List<String> urlsB = new ArrayList<>();
        urlsB.add("http://rand.url/2");
        urlsB.add("https://rand.url/5");

        Pet petDtoB = new Pet();
        petDtoB.name("Spot")
                .id(new Long(777))
                .tags(tagsB)
                .category(categoryB)
                .photoUrls(urlsB);

        List<Pet> petDtos = new ArrayList<Pet>();
        petDtos.add(petDto);
        petDtos.add(petDtoB);
        return petDtos;
    }

    /**
     * Test mapping a single Pet DTO to a PetModel
     */
    @Test
    public void testTransformSingle() {
        Category category = new Category();
        category.id(new Long(1))
                .name("Exotic");

        List<Tag> tags = new ArrayList<Tag>();
        Tag tagA = new Tag();
        tagA.name("Mammal")
           .id(new Long(5));
        Tag tagB = new Tag();
        tagB.name("Furry")
           .id(new Long(10));

        tags.add(tagA);
        tags.add(tagB);

        List<String> urls = new ArrayList<>();
        urls.add("http://foo.com/bar.jpg");
        urls.add("https://foo.com/zee.jpg");
        urls.add("this is not a url");

        Pet petDto = new Pet();
        petDto.name("Frank")
                .id(new Long(4))
                .tags(tags)
                .category(category)
                .photoUrls(urls);

        PetModel petModel = PetModelMapper.transform(petDto);
        Assert.assertEquals(petModel.getName(), petModel.getName());
        Assert.assertEquals(petModel.getId(), petModel.getId());

        Assert.assertNotNull(petModel.getPhotoUrls());
        Assert.assertFalse(petModel.getPhotoUrls().isEmpty());
        // Invalid URLs are ignored
        Assert.assertFalse(petModel.getPhotoUrls().contains("this is not a url"));
        // Valid URLs are Mapped
        Assert.assertTrue(petModel.getPhotoUrls().contains("https://foo.com/zee.jpg"));
        Assert.assertTrue(petModel.getPhotoUrls().contains("http://foo.com/bar.jpg"));
        // First Photo in Photos list is assigned as the profile URL
        Assert.assertEquals(petModel.getProfilePhoto(), "http://foo.com/bar.jpg");

        // First Photo in Photos list is assigned as the profile URL
        Assert.assertEquals(petModel.getProfilePhoto(), "http://foo.com/bar.jpg");

        // Tags are flattened to just Display Names
        Assert.assertNotNull(petModel.getTagNames());
        Assert.assertFalse(petModel.getTagNames().isEmpty());
        Assert.assertTrue(petModel.getTagNames().contains("Mammal"));
        Assert.assertTrue(petModel.getTagNames().contains("Furry"));

        // Category is flattened to just Display Name
        Assert.assertEquals(petModel.getCategoryName(), "Exotic");
    }

    /**
     * Test mapping a multiple Pet DTOs to PetModels
     */
    @Test
    public void testTransformMultiple() {
        List<Pet> petDtos = listOfTestPets();
        List<PetModel> petModels = PetModelMapper.transform(petDtos);
        Assert.assertNotNull(petModels);
        Assert.assertFalse(petModels.isEmpty());
        Assert.assertEquals(petModels.size(), 2);
    }
}
