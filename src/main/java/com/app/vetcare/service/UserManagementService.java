package com.app.vetcare.service;


import com.app.vetcare.model.request.UserRequest;
import org.springframework.http.ResponseEntity;

/**
 * Service interface for user management
 */
public interface UserManagementService {
  ResponseEntity<String> registerUser(UserRequest userManagementService);


}
