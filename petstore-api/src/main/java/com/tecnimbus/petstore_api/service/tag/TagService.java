package com.tecnimbus.petstore_api.service.tag;

import com.tecnimbus.petstore_api.entity.Tag;
import com.tecnimbus.petstore_api.mapper.TagMapper;
import com.tecnimbus.petstore_api.model.TagDTO;
import com.tecnimbus.petstore_api.repository.tag.TagRepository;
import com.tecnimbus.petstore_api.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService extends BaseService {

    @Autowired
    TagMapper tagMapper;

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag getOrCreateTagByDTO(TagDTO dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName().toUpperCase());
        return tagRepository.findByName(dto.getName())
                .orElseGet(() -> tagRepository.save(tag));
    }

}