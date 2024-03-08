package com.app.vetcare.model.request;


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
public class PetDetailsRequestModel {
  private Integer agentId;

  @NotBlank(message = APIValidationConfig.PET_TYPE_NOT_VALID)
  @EnumValidator(enumClass = PetType.class, message = APIValidationConfig.INVALID_USER_ROLE)
  private String petType;

  @NotBlank(message = APIValidationConfig.BREED_NOT_VALID)
  private String breed;

  private Integer age;

  private String gender;

  private String UHID;

  @NotBlank(message = APIValidationConfig.OWNER_NAME_NOT_VALID)
  private String ownerName;

  private String ownerIDType;

  private String ownerIdNumber;

  @NotBlank(message = APIValidationConfig.OWNER_PHONE_NUMBER_NOT_VALID)
  private String ownerPhoneNumber;

  private String farmName ;

  private String insuranceId;

  private String insuranceCompanyName;

  private String insuranceType;

  private String farmAnimalCode;

}
