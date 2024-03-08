package com.app.vetcare.service.impl;



import com.app.vetcare.exception.UserException;
import com.app.vetcare.mapper.CommonConfigMapper;
import com.app.vetcare.mapper.UserMapper;
import com.app.vetcare.model.persistence.AuthorityDao;
import com.app.vetcare.model.persistence.UserDao;
import com.app.vetcare.model.request.UserRequest;
import com.app.vetcare.model.response.UserResponse;
import com.app.vetcare.repositories.AuthorityRepository;
import com.app.vetcare.repositories.LoginRepository;
import com.app.vetcare.service.UserManagementService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

  private final AuthorityRepository authorityRepository;
  private final LoginRepository loginRepository;
  //private final PasswordEncoder passwordEncoder;
  private final CommonConfigMapper userMapper;

  public UserManagementServiceImpl(AuthorityRepository authorityRepository, LoginRepository loginRepository,  CommonConfigMapper userMapper) {
    this.authorityRepository = authorityRepository;
    this.loginRepository = loginRepository;
  //  this.passwordEncoder = passwordEncoder;
    this.userMapper = userMapper;
  }

  /**
   * add a new user to the app
   * @param userRequestModel
   * @return
   */
  @Override
  public ResponseEntity<String> registerUser(UserRequest userRequestModel) {
    UserDao savedCustomer = null;
    ResponseEntity response = null;
    try {
      var user = userMapper.mapUserRequestModelToCustomer(userRequestModel);
      if (!userRequestModel.getRole().equalsIgnoreCase("ADMIN")
          && !userRequestModel.getRole().equalsIgnoreCase("AGENT")) {
        throw new UserException("User role needs to be either agent or customer");
      }
      String hashPwd = user.getPassword();;
      //  String hashPwd = passwordEncoder.encode(user.getPassword());
      user.setPassword(hashPwd);
      user.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
      savedCustomer = loginRepository.save(user);
      String authorityName = "ROLE_" + user.getRole().toUpperCase();

      var authority = new AuthorityDao();
      authority.setName(authorityName);
      authority.setUserDao(savedCustomer);
      authorityRepository.save(authority);
      if (savedCustomer.getId() > 0) {
        response =
            ResponseEntity.status(HttpStatus.CREATED)
                .body("Given user details are successfully registered");
      }
    } catch (Exception ex) {
      response =
          ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("An exception occurred due to " + ex.getMessage());
    }
    return response;
  }

  /**
   * Authenticate user and generate auth token on successful authorization
   * @param authentication
   * @return
   */
/*  @Override
  public UserResponse getUserDetailsAfterLogin(Authentication authentication) {
    List<UserDao> customers = loginRepository.findByEmail(authentication.getName());
    if (customers.size() > 0) {
      return userMapper.mapUserDetailsToUserResponse(customers.get(0));
    } else {
      return null;
    }
  }*/
}
