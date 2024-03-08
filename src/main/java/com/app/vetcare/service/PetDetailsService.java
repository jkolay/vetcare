package com.app.vetcare.service;


;
import com.app.vetcare.model.request.PetDetailsRequestModel;
import com.app.vetcare.model.response.PetDetailsResponse;
import com.app.vetcare.model.response.TestResponse;

import java.util.List;
import java.util.Set;

/**
 * Service interface class for ingredient
 */
public interface PetDetailsService {
    public PetDetailsResponse create(PetDetailsRequestModel request) ;
    public PetDetailsResponse getPetDetails(Long petId);

    public List<TestResponse> getTestDetailsByPetId(Long petId);

}
