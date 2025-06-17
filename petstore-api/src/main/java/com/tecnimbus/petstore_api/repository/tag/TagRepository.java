package com.tecnimbus.petstore_api.repository.tag;

import com.tecnimbus.petstore_api.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    // Custom method to find Tag by its name
    Optional<Tag> findByName(String name);
}