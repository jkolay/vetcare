package com.app.vetcare.model.request;

import com.app.vetcare.config.APIValidationConfig;
import com.app.vetcare.model.constant.UserRole;
import com.app.vetcare.validator.EnumValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = APIValidationConfig.INVALID_NAME)
    @Schema(description = "The name of the agent", example = "Dinesh P")
    private String name;

    private String password;

    @NotBlank(message = APIValidationConfig.INVALID_ADDRES)
    @Schema(description = "The address of the agent", example = "")
    private String address;

    @NotBlank(message = APIValidationConfig.INVALID_PHONEMUMBER)
    @Schema(description = "The phone number of the agent", example = "9876512345")
    private String phoneNumber;

    @NotBlank(message = APIValidationConfig.INVALID_EMAIL)
    @Schema(description = "The email of the agent", example = "dinesh@gmail.com")
    private String email;

    @NotBlank(message = APIValidationConfig.INVALID_ADHAR)
    @Schema(description = "The adhar id of the agent", example = "210000")
    private String adharId;

    @NotBlank(message = APIValidationConfig.ROLE_NOT_NULL)
    @EnumValidator(enumClass = UserRole.class, message = APIValidationConfig.INVALID_USER_ROLE)
    private String role;

}
