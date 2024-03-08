package com.app.vetcare.repositories;

import com.app.vetcare.model.persistence.AuthorityDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class for Authorities
 */
@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityDao,Integer> {
}
