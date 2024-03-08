package com.app.vetcare.service.impl;


import com.app.vetcare.mapper.CommonConfigMapper;
import com.app.vetcare.model.persistence.PetDetailsDao;
import com.app.vetcare.model.persistence.PetTestDetailsDao;
import com.app.vetcare.model.persistence.TestDetailsDao;
import com.app.vetcare.model.request.PetDetailsRequestModel;
import com.app.vetcare.model.response.PetDetailsResponse;
import com.app.vetcare.model.response.TestResponse;
import com.app.vetcare.repositories.PetDetailsRepository;
import com.app.vetcare.repositories.PetTestDetailsRepository;
import com.app.vetcare.repositories.TestRepository;
import com.app.vetcare.service.PetDetailsService;
import com.app.vetcare.service.PetTestDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * service implementation class for recipe service
 */
@Service
@Slf4j(topic = "PerDetailsServiceImpl")
public class PerDetailsServiceImpl implements PetDetailsService, PetTestDetailsService {
    private final PetDetailsRepository petDetailsRepository;
    private final PetTestDetailsRepository petTestDetailsRepository;

    private final TestRepository testRepository;
    private final CommonConfigMapper mapper;

    public PerDetailsServiceImpl(PetDetailsRepository petDetailsRepository, PetTestDetailsRepository petTestDetailsRepository, TestRepository testRepository, CommonConfigMapper mapper) {
        this.petDetailsRepository = petDetailsRepository;
        this.petTestDetailsRepository = petTestDetailsRepository;
        this.testRepository = testRepository;
        this.mapper = mapper;
    }




    @Override
    public PetDetailsResponse create(PetDetailsRequestModel request) {
        PetDetailsDao petDetailsDao=mapper.mapPetRequestToPetDetailsDao(request);
        return mapper.mapPetDetailsDaoToPetDetailsResponse(petDetailsRepository.save(petDetailsDao));
    }

    @Override
    public PetDetailsResponse getPetDetails(Long petId) {
        return  mapper.mapPetDetailsDaoToPetDetailsResponse(petDetailsRepository.getReferenceById(petId));
    }

    @Override
    public PetDetailsResponse addNewTest(Long petId, Long testId) {
        PetDetailsDao petDetailsDao= petDetailsRepository.getReferenceById(petId);
        TestDetailsDao testDetailsDao=testRepository.getReferenceById(testId);
        PetTestDetailsDao petTestDetailsDao= new PetTestDetailsDao();
        petTestDetailsDao.setPetDetailsDao(petDetailsDao);
        petTestDetailsDao.setTestDetailsDao(testDetailsDao);
        petTestDetailsDao.setTestOn(LocalDateTime.now());
        petTestDetailsDao=petTestDetailsRepository.save(petTestDetailsDao);
        return mapper.mapPetDetailsDaoToPetDetailsResponse(petTestDetailsDao.getPetDetailsDao());
    }

    @Override
    public List<TestResponse> getTestDetailsByPetId(Long petId) {
        PetDetailsDao petDetailsDao= petDetailsRepository.getReferenceById(petId);

        Set<PetTestDetailsDao> petTestDetailsDaos= petDetailsDao.getPetTestDetailsDaos();

        return petTestDetailsDaos.stream().map(dao->mapper.mapTestDetailsDaoToTestResponse(dao.getTestDetailsDao())).collect(Collectors.toList());
    }


}
