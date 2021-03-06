package com.example.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.common.NotFoundException;
import com.example.customer.manager.CustomerManager;
import com.example.customer.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerManager customerManager;

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable String id) {
		return customerManager.getCustomer(id).orElseThrow(() -> new NotFoundException("Customer not found with id " + id));
	}

}
