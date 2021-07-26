package com.sn.lde.ngy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sn.lde.ngy.model.Customer;

public interface ServiceOumouRepository extends JpaRepository<Customer, Long> {

}
