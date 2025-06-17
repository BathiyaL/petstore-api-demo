package com.tecnimbus.petstore_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO {
    private Long id;
    @NotBlank(message = "Tag name cannot be blank")
    private String name;
}
