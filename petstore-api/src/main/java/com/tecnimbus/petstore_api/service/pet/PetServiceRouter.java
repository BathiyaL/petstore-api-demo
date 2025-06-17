package com.tecnimbus.petstore_api.service.pet;

import com.tecnimbus.petstore_api.config.AppConfig;
import com.tecnimbus.petstore_api.constants.OperationMode;
import com.tecnimbus.petstore_api.model.PetDTO;
import com.tecnimbus.petstore_api.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceRouter extends BaseService {

    @Autowired
    AppConfig appConfig;

    @Autowired
    LocalPetService localPetService;

    @Autowired
    RemotePetService remotePetService;

    public PetDTO findPetById(Long petId) {
        if (appConfig.getDataMode() == OperationMode.LOCAL) {
            return localPetService.findPetById(petId);
        } else {
            return remotePetService.findPetById(petId);
        }
    }

    public PetDTO addNewPetToTheStore(PetDTO petDTO) {
        if (appConfig.getDataMode() == OperationMode.LOCAL) {
            return localPetService.addNewPetToTheStore(petDTO);
        } else {
            return remotePetService.addNewPetToTheStore(petDTO);
        }
    }

    public PetDTO updateAnExistingPet(PetDTO petDTO) {
        if (appConfig.getDataMode() == OperationMode.LOCAL) {
            return localPetService.updateAnExistingPet(petDTO);
        } else {
            return remotePetService.updateAnExistingPet(petDTO);
        }
    }
}