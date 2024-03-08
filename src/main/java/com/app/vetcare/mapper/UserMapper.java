package com.app.vetcare.mapper;



import com.app.vetcare.model.persistence.UserDao;
import com.app.vetcare.model.request.UserRequest;
import com.app.vetcare.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper interface to map user request model to dao and dao to response
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    UserDao mapUserRequestModelToCustomer(UserRequest userRequestModel);

    UserResponse mapUserDetailsToUserResponse(UserDao customerDao);
}
