package com.keerthika.cms.service;


import com.keerthika.cms.dao.CustomerDAO;
import com.keerthika.cms.exceptionHandling.CustomerNotFoundException;
import com.keerthika.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer custom){
        return customerDAO.save(custom);
    }

    public List<Customer> getAllCustomers(){
        return customerDAO.findAll();
    }

    public Customer getCustomerByID(int custID){
        Optional<Customer> optionalCustom=customerDAO.findById(custID);
        if(optionalCustom.isEmpty()) throw new CustomerNotFoundException("Customer Record is not available...");
        return optionalCustom.get();
    }

    public Customer updateCustomer(int customID, Customer custom){
        custom.setCustomerID(customID);
        return customerDAO.save(custom);
    }

    public void delCustomer(int customID){
        customerDAO.deleteById(customID);
    }
}
