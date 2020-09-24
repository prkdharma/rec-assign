package com.dxctraining.customermgt.customer.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.customermgt.customer.dao.ICustomerDao;
import com.dxctraining.customermgt.customer.entities.Customer;
import com.dxctraining.customermgt.customer.exception.InvalidArgumentException;
import com.dxctraining.customermgt.customer.exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class ICustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao dao;

    @Override
    public Customer findById(int id) {
       Optional<Customer> optional= dao.findById(id);
       if(!optional.isPresent()){
           throw new CustomerNotFoundException("user not found for id="+id);
       }
        return optional.get();
    }

    @Override
    public Customer save(Customer customer) {
        validate(customer);
        customer=dao.save(customer);
        return customer;
    }

    @Override
    public void remove(int id) {
       dao.deleteById(id);
    }

    public void validate(Object arg){
        if(arg==null){
            throw new InvalidArgumentException("argument is null");
        }
    }

    @Override
    public List<Customer> allCustomers(){
        List<Customer>employees=dao.findAll();
        return employees;
    }


}