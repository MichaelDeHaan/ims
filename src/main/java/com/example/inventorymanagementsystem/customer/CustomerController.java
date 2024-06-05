package com.example.inventorymanagementsystem.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("customers")
    String customers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        return "customers";
    }

    @PostMapping("/customer")
    String newCustomer(@ModelAttribute Customer newCustomer) {
        customerService.save(newCustomer);
        return "redirect:/customers";
    }

    @PostMapping("/customer/{id}")
    String editCustomer(@PathVariable("id") Long id, @ModelAttribute Customer editedCustomer) {
        customerService.editCustomer(id, editedCustomer);
        return "redirect:/customers";
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
}
