package com.app.vetcare.model.response;


import com.app.vetcare.config.APIValidationConfig;
import com.app.vetcare.model.constant.PetType;
import com.app.vetcare.validator.EnumValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User request model
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDetailsResponse {

  private Long id;
  private String petType;


  private String breed;

  private Integer age;

  private String gender;

  private String UHID;


  private String ownerName;

  private String ownerIDType;

  private String ownerIdNumber;


  private String ownerPhoneNumber;

  private String farmName ;

  private String insuranceId;

  private String insuranceCompanyName;

  private String insuranceType;

  private String farmAnimalCode;

}
