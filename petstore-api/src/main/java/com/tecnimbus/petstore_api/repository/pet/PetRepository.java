package com.tecnimbus.petstore_api.repository.pet;

import com.tecnimbus.petstore_api.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}

