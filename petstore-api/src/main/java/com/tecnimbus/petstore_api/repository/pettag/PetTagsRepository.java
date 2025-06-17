package com.tecnimbus.petstore_api.repository.pettag;

import com.tecnimbus.petstore_api.entity.Pet;
import com.tecnimbus.petstore_api.entity.PetTags;
import com.tecnimbus.petstore_api.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetTagsRepository extends JpaRepository<PetTags, Long> {
    List<PetTags> findByPet(Pet pet);
    List<PetTags> findByTag(Tag tag);
    Optional<PetTags> findByPetAndTag(Pet pet, Tag tag);
}