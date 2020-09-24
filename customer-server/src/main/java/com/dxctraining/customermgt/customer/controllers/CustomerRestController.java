package com.dxctraining.customermgt.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.customermgt.customer.dto.CreateCustomerRequest;
import com.dxctraining.customermgt.customer.dto.CustomerDetails;
import com.dxctraining.customermgt.customer.entities.Customer;
import com.dxctraining.customermgt.customer.service.ICustomerService;
import com.dxctraining.customermgt.customer.util.CustomerUtil;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerUtil customerUtil;

    @Autowired
    private RestTemplate restTemplate;

    
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDetails create(@RequestBody  CreateCustomerRequest requestData) {
        String name = requestData.getName();
        double balance= requestData.getBalance();
        Customer customer = new Customer(name, balance);
        customer = customerService.save(customer);
        CustomerDetails response = customerUtil.customerDto(customer);
        return response;
    }


    @GetMapping("/get/{id}")
    public CustomerDetails findEmployee(@PathVariable("id") int id) {
        Customer customer = customerService.findById(id);
        CustomerDetails response = customerUtil.customerDto(customer);
        return response;
    }


    @GetMapping
    public List<CustomerDetails> fetchAll() {
        List<Customer> list = customerService.allCustomers();
        List<CustomerDetails>response=new ArrayList<>();
        for (Customer customer:list){
            CustomerDetails dto= customerUtil.customerDto(customer);
            response.add(dto);
        }
        return response;
    }




}
