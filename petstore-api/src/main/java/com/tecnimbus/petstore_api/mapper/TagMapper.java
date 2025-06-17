package com.tecnimbus.petstore_api.mapper;

import com.tecnimbus.petstore_api.entity.Tag;
import com.tecnimbus.petstore_api.model.TagDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag toEntity(TagDTO dto);

    TagDTO toDTO(Tag entity);
}
