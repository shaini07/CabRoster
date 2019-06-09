package com.blujay.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blujay.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
