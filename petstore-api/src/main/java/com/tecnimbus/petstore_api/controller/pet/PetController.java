package com.tecnimbus.petstore_api.controller.pet;

import com.tecnimbus.petstore_api.controller.BaseController;
import com.tecnimbus.petstore_api.model.PetDTO;
import com.tecnimbus.petstore_api.service.pet.PetServiceRouter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetController extends BaseController {

    @Autowired
    PetServiceRouter petServiceRouter;

    @Operation(summary = "Find pet by ID", description = "Returns a single pet")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pet found"),
            @ApiResponse(responseCode = "404", description = "Pet not found")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/pet/{petId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PetDTO findPetById(@PathVariable Long petId) {
        return petServiceRouter.findPetById(petId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pet")
    public ResponseEntity<PetDTO> addNewPet(@Valid @RequestBody PetDTO petDTO) {
        PetDTO saved = petServiceRouter.addNewPetToTheStore(petDTO);
        return ResponseEntity.ok(saved);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pet")
    public ResponseEntity<PetDTO> updatePet(@Valid @RequestBody PetDTO petDTO) {
        PetDTO saved = petServiceRouter.updateAnExistingPet(petDTO);
        return ResponseEntity.ok(saved);
    }
}