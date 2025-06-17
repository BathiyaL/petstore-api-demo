package com.tecnimbus.petstore_api.service.pet;

import com.tecnimbus.petstore_api.entity.Pet;
import com.tecnimbus.petstore_api.exception.ResourceNotFoundException;
import com.tecnimbus.petstore_api.mapper.PetMapper;
import com.tecnimbus.petstore_api.model.PetDTO;
import com.tecnimbus.petstore_api.model.TagDTO;
import com.tecnimbus.petstore_api.repository.pet.PetRepository;
import com.tecnimbus.petstore_api.service.pettag.PetTagService;
import com.tecnimbus.petstore_api.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalPetService implements PetServiceStrategy {

    @Autowired
    PetMapper petMapper;
    @Autowired
    TagService tagService;
    @Autowired
    PetRepository petRepository;

    @Autowired
    PetTagService petTagService;

    @Override
    public PetDTO addNewPetToTheStore(PetDTO petDTO) {
        Pet pet = petMapper.toEntity(petDTO);
        pet.setId(null);
        Pet savedPet = petRepository.save(pet);

        List<TagDTO> savedTags = petTagService.savePetTagsIfNotExists(pet, petDTO.getTags());
        PetDTO petDTOResponse = petMapper.toDto(savedPet);
        petDTOResponse.setTags(savedTags);
        return petDTOResponse;
    }

    @Override
    public PetDTO findPetById(Long petId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + petId));
        PetDTO petDTO = petMapper.toDto(pet);
        List<TagDTO> petTags = petTagService.getTagDTOByPet(pet);
        petDTO.setTags(petTags);
        return petDTO;
    }

    @Override
    public PetDTO updateAnExistingPet(PetDTO petDTO)  {
        Pet existingPet = petRepository.findById(petDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id " + petDTO.getId()));
        existingPet.setName(petDTO.getName());
        existingPet.setStatus(petDTO.getStatus());
        Pet updatedPet = petRepository.save(existingPet);
        return petMapper.toDto(updatedPet);
    }
}
