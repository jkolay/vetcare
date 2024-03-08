package com.app.vetcare.service;

import com.app.vetcare.model.request.TestRequest;
import com.app.vetcare.model.response.TestResponse;

import java.util.List;

public interface TestDetailsService {
    public TestResponse createTest(TestRequest testRequest);

    public List<TestResponse> getAllTestDetails();

    public TestResponse getTestDetailsById(Long testId);
}
