package com.tecnimbus.petstore_api.mapper;

import com.tecnimbus.petstore_api.entity.Pet;
import com.tecnimbus.petstore_api.model.PetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet toEntity(PetDTO dto);
    @Mapping(target = "photoUrls", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "tags", ignore = true)
    PetDTO toDto(Pet entity);
}
