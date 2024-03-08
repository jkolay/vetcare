package com.app.vetcare.controller;

import com.app.vetcare.model.request.TestRequest;
import com.app.vetcare.model.response.TestResponse;
import com.app.vetcare.service.TestDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/test")
@Slf4j(topic = "TestDetailsController")
public class TestDetailsController {
    private final TestDetailsService testDetailsService;

    public TestDetailsController(TestDetailsService testDetailsService) {
        this.testDetailsService = testDetailsService;
    }


    @Operation(description = "Add test details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Test details has been added successfully"),
            @ApiResponse(responseCode = "404", description = "Test details has  not been added successfully")
    })
    @RequestMapping(method = RequestMethod.POST, path = "/add-test")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TestResponse> addTestDetails(@RequestBody @Valid TestRequest testRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(testDetailsService.createTest(testRequest));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get-all-test")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TestResponse>> getTestDetails() {

        return ResponseEntity.status(HttpStatus.OK).body(testDetailsService.getAllTestDetails());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get-test/{testId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TestResponse> getTestByTestId(@PathVariable Long testId) {

        return ResponseEntity.status(HttpStatus.OK).body(testDetailsService.getTestDetailsById(testId));
    }


}
