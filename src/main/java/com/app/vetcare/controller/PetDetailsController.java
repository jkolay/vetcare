package com.app.vetcare.controller;

import com.app.vetcare.model.request.PetDetailsRequestModel;
import com.app.vetcare.model.response.PetDetailsResponse;
import com.app.vetcare.model.response.TestResponse;
import com.app.vetcare.service.PetDetailsService;

import com.app.vetcare.service.PetTestDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pet")
@Slf4j(topic = "PetDetailsController")
public class PetDetailsController {
    private final PetDetailsService petDetailsService;
    private final PetTestDetailsService petTestDetailsService;


    public PetDetailsController(PetDetailsService petDetailsService, PetTestDetailsService petTestDetailsService) {
        this.petDetailsService = petDetailsService;

        this.petTestDetailsService = petTestDetailsService;
    }

    /**
     * @param petDetailsRequestModel
     * @return
     */
    @Operation(description = "add pet details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet details has been created successfully"),
            @ApiResponse(responseCode = "404", description = "Pet details has not been created successfully")
    })
    @RequestMapping(method = RequestMethod.POST, path = "/add-pet")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PetDetailsResponse> addPetDetails(@RequestBody @Valid PetDetailsRequestModel petDetailsRequestModel) {
        log.info("adding Pet Details");
        return ResponseEntity.status(HttpStatus.OK).body(petDetailsService.create(petDetailsRequestModel));
    }

    @Operation(description = "add test details for a pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Test details has been added successfully for the pet"),
            @ApiResponse(responseCode = "404", description = "Test details has not been added successfully for the pet")
    })
    @RequestMapping(method = RequestMethod.POST, path = "/add-test/{petId}/{testId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PetDetailsResponse> addTestDetails(@PathVariable Long petId,@PathVariable Long testId) {
        log.info("adding test for a pet");
        return ResponseEntity.status(HttpStatus.OK).body(petTestDetailsService.addNewTest(petId,testId));
    }
    @Operation(description = "grt details for a pet")

    @RequestMapping(method = RequestMethod.GET, path = "/get/{petId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PetDetailsResponse> getPetDetails(@PathVariable Long petId) {
        log.info("adding test");
        return ResponseEntity.status(HttpStatus.OK).body(petDetailsService.getPetDetails(petId));
    }
    @Operation(description = "get test details for a pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Test details has been added successfully for the pet"),
            @ApiResponse(responseCode = "404", description = "Test details has not been added successfully for the pet")
    })
    @RequestMapping(method = RequestMethod.GET, path = "/getTestDetails/{petId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TestResponse>> getTestDetails(@PathVariable Long petId) {
        log.info("adding test");
        return ResponseEntity.status(HttpStatus.OK).body(petDetailsService.getTestDetailsByPetId(petId));
    }


}
