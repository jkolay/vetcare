package com.app.vetcare.repositories;

import com.app.vetcare.model.persistence.PetDetailsDao;
import com.app.vetcare.model.persistence.TestDetailsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository class for ingredients
 */
@Repository
public interface TestRepository extends JpaRepository<TestDetailsDao, Long> {


}

