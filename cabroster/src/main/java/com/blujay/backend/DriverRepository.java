package com.blujay.backend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blujay.backend.data.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByEmail(String email);

    Page<Driver> findByEmailLikeIgnoreCaseOrNameLikeIgnoreCase(String emailLike, String nameLike, Pageable pageable);

    long countByEmailLikeIgnoreCaseOrNameLikeIgnoreCase(String emailLike, String nameLike);
    
}
