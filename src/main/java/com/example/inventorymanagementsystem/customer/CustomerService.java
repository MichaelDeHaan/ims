package com.example.inventorymanagementsystem.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public void editCustomer(Long id, Customer editedCustomer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + id));
        existingCustomer.setName(editedCustomer.getName());
        existingCustomer.setAddress(editedCustomer.getAddress());
        existingCustomer.setPhoneNumber(editedCustomer.getPhoneNumber());
        customerRepository.save(existingCustomer);
    }
}
