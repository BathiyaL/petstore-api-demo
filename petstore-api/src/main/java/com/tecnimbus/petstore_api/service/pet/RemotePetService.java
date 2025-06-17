package com.tecnimbus.petstore_api.service.pet;

import com.tecnimbus.petstore_api.mapper.PetMapper;
import com.tecnimbus.petstore_api.model.PetDTO;
import com.tecnimbus.petstore_api.service.external.PetStoreExternalService;
import com.tecnimbus.petstore_api.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemotePetService implements PetServiceStrategy {

    @Autowired
    PetMapper petMapper;
    @Autowired
    TagService tagService;


    @Autowired
    PetStoreExternalService petStoreExternalService;

    @Override
    public PetDTO addNewPetToTheStore(PetDTO petDTO) {
            return petStoreExternalService.addNewPetToTheStore(petDTO);
    }

    @Override
    public PetDTO findPetById(Long petId) {
        return petStoreExternalService.findPetById(petId);
    }

    @Override
    public PetDTO updateAnExistingPet(PetDTO petDTO) {
        return petStoreExternalService.updateAnExistingPet(petDTO);
    }
}
