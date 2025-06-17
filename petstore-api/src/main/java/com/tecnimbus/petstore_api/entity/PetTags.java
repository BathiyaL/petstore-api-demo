package com.tecnimbus.petstore_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet_tags")
@IdClass(PetTagsCompositeID.class)
public class PetTags {
    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    private Pet pet;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
