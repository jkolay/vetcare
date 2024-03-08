package com.app.vetcare.service.impl;

import com.app.vetcare.mapper.CommonConfigMapper;
import com.app.vetcare.model.persistence.TestDetailsDao;
import com.app.vetcare.model.request.TestRequest;
import com.app.vetcare.model.response.TestResponse;
import com.app.vetcare.repositories.TestRepository;
import com.app.vetcare.service.TestDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestDetailsServiceImpl implements TestDetailsService {
    private final TestRepository testRepository;
    private final CommonConfigMapper mapper;

    public TestDetailsServiceImpl(TestRepository testRepository, CommonConfigMapper mapper) {
        this.testRepository = testRepository;
        this.mapper = mapper;
    }

    @Override
    public TestResponse createTest(TestRequest testRequest) {
        TestDetailsDao testDetailsDao= mapper.mapTestRequestToTestDetailsDao(testRequest);
        testDetailsDao=testRepository.save(testDetailsDao);
        return mapper.mapTestDetailsDaoToTestResponse(testDetailsDao);
    }

    @Override
    public List<TestResponse> getAllTestDetails() {
        List<TestDetailsDao> testDetailsDaos= testRepository.findAll();
        return testDetailsDaos.stream().map(testDetailsDao -> mapper.mapTestDetailsDaoToTestResponse(testDetailsDao)).collect(Collectors.toList());
    }

    @Override
    public TestResponse getTestDetailsById(Long testId) {
        return mapper.mapTestDetailsDaoToTestResponse(testRepository.getReferenceById(testId));
    }
}
