package com.keerthika.cms.api;

import com.keerthika.cms.model.Customer;
import com.keerthika.cms.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(value="/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customServ;

    @PostMapping
    public Customer addcustomer(@RequestBody Customer custom){
        return customServ.addCustomer(custom);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customServ.getAllCustomers();
    }

    @GetMapping(value="/{customID}")
    public Customer getCustomerByID(@PathVariable("customID") int customID){
        return customServ.getCustomerByID(customID);
    }

    @PutMapping(value="/{customID}")
    public Customer updateCustomer(@PathVariable("customID") int customID, @RequestBody Customer custom){
        return customServ.updateCustomer(customID, custom);
    }

    @DeleteMapping(value="/{customID}")
    public void delCustomer(@PathVariable("customID") int customID){
        customServ.delCustomer(customID);
    }
}