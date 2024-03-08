package com.app.vetcare.controller;


import com.app.vetcare.model.request.UserRequest;
import com.app.vetcare.service.UserManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for new user and log in
 */
@RestController
@RequestMapping(value = "/api/user")
public class LoginController {


    private final UserManagementService userManagementService;

    @Autowired
    public LoginController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    /**
     * register new user
     * @param userRequestModel the user details of the user
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequest userRequestModel) {
        return userManagementService.registerUser(userRequestModel);

    }

    /**
     * the method to get details of authenticated user
     * @param authentication
     * @return
     */

}
