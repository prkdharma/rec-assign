package com.dxctraining.customermgt.customer.util;
import org.springframework.stereotype.Component;

import com.dxctraining.customermgt.customer.dto.CustomerDetails;
import com.dxctraining.customermgt.customer.entities.Customer;

@Component
public class CustomerUtil {


    public CustomerDetails customerDto(Customer customer){
        CustomerDetails details=new CustomerDetails(customer.getId(),customer.getName(),customer.getBalance());
        return details;
    }

}