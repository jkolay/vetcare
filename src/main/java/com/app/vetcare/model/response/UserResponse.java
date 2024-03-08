package com.app.vetcare.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Ingredient response model
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse {
    private String name;
    private String email;
    private String mobileNumber;;
    private String adharId;
    private String role;
    private String createDt;
    private Set<PetDetailsResponse> petDetailsResponses;
}
