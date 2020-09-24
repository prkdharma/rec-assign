package com.dxctraining.customermgt.customer.service;


import java.util.List;

import com.dxctraining.customermgt.customer.entities.Customer;


public interface ICustomerService {

    Customer findById(int id);

    Customer save(Customer customer);

    void remove(int id);

    List<Customer> allCustomers();

}