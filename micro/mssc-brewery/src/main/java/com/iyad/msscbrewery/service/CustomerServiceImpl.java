package com.iyad.msscbrewery.service;

import com.iyad.msscbrewery.model.BeerDTO;
import com.iyad.msscbrewery.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {


    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
            return CustomerDTO.builder().id(UUID.randomUUID())
                    .name("Iyad")
                    .build();

    }

    @Override
    public CustomerDTO savedNewCustomer(CustomerDTO customerDTO) {
          return CustomerDTO.builder()
                  .id(UUID.randomUUID()
                  ).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {

        // todo update customer

    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting Customer .....");
    }
}
