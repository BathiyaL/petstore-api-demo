package com.tecnimbus.petstore_api.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class PetTagsCompositeID {
    private static final long serialVersionUID = 2702030623316532377L;
    private Long pet;
    private Long tag;
}
