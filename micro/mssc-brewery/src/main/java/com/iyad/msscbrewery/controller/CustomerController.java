package com.iyad.msscbrewery.controller;

import com.iyad.msscbrewery.model.BeerDTO;
import com.iyad.msscbrewery.model.CustomerDTO;
import com.iyad.msscbrewery.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    ResponseEntity<CustomerDTO> getCustomer(@PathVariable ("customerId")UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handelPost( @RequestBody CustomerDTO customerDTO){
        CustomerDTO savedDto= customerService.savedNewCustomer(customerDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        // todo add hostname to URL
        httpHeaders.add("Location","/api/v1/beer" + savedDto.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity handelPut(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDTO customerDTO){

        customerService.updateCustomer(customerId,customerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomerById(customerId);

    }



}
