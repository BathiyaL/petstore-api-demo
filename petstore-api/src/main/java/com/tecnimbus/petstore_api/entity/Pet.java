package com.tecnimbus.petstore_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    //PhotoUrlArray photoUrls;
    //private Category category;
    //@OneToMany(mappedBy = "id")
//    @OneToMany(mappedBy = "id")
//    private Tag[] tags;
}

