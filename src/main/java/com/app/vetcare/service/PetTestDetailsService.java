package com.app.vetcare.service;

import com.app.vetcare.model.response.PetDetailsResponse;

public interface PetTestDetailsService {


    public PetDetailsResponse addNewTest(Long petId,Long TestId);
}
