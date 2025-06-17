package com.tecnimbus.petstore_api.service.pet;

import com.tecnimbus.petstore_api.model.PetDTO;

public interface PetServiceStrategy {
    PetDTO addNewPetToTheStore(PetDTO petDTO);
    PetDTO findPetById(Long petId);
    PetDTO updateAnExistingPet(PetDTO petDTO);
}
