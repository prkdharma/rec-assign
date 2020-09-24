package com.dxctraining.customermgt.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.customermgt.customer.entities.Customer;

import java.util.List;

public interface ICustomerDao extends JpaRepository<Customer,Integer> {


}