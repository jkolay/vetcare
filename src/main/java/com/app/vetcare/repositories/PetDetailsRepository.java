package com.app.vetcare.repositories;


import com.app.vetcare.model.persistence.PetDetailsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository class for ingredients
 */
@Repository
public interface PetDetailsRepository extends JpaRepository<PetDetailsDao, Long> {


}
