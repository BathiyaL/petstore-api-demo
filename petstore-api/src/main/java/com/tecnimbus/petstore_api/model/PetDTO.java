package com.tecnimbus.petstore_api.model;

import com.tecnimbus.petstore_api.entity.Category;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private String[] photoUrls;
    private Category category;
    @Valid
    private List<TagDTO> tags;
}