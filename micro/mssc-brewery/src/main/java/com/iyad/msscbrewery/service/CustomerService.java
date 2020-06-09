package com.iyad.msscbrewery.service;

import com.iyad.msscbrewery.model.BeerDTO;
import com.iyad.msscbrewery.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomerById(UUID customerId);

    CustomerDTO savedNewCustomer(CustomerDTO customerDTO);

    void updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomerById(UUID customerId);
}
