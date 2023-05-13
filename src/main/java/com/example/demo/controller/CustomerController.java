package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Mohammed Kharma
 */
@RestController
public class CustomerController {

    //    @GetMapping (path = "/student", produces = MediaType.APPLICATION_XML_VALUE)
//    @GetMapping(value = "/student/v2/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/student")
    public CustomerDto getSCustomer() {
        return new CustomerDto("Mohammed", "Kharma");
    }

    @GetMapping(value = "/students")
    public List<CustomerDto> getSCustomers() {
        List<CustomerDto> customerList = new ArrayList<CustomerDto>();
        for (int i = 0; i < 5; i++) {
            customerList.add(new CustomerDto("name" + i, "lastname" + i));
        }
        return customerList;
    }

    @GetMapping(value = "/student/V2")
    public ResponseEntity<CustomerDto> getSCustomerV2() {
        return ResponseEntity.ok(new CustomerDto("Mohammed", "Ahmad"));
    }

    //path variable,  uri template variable   {firstname}/{lastName}
    //in order ot bind value of URI template variable to method parameter, we use @PathVariable
    @GetMapping(value = "/student/{firstName}/{lastName}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return ResponseEntity.ok(new CustomerDto(firstName, lastName));
    }

    //build rest API to handle query params
    ///student?firstName=mohammad
    @GetMapping(value = "/studentRequestParam")
    public ResponseEntity<CustomerDto> getCustomerRequestParam(@RequestParam("firstName") String firstName,
                                                               @RequestParam(name = "lastName") String lastName) {
        return ResponseEntity.ok(new CustomerDto(firstName, lastName));
    }
//    @GetMapping(value = "/studentx")
//    public ResponseEntity<CustomerDto> getCustomerx(@RequestParam("firstName") String firstName,
//                                                            @RequestParam(name = "lastName") String lastName) {
//        return ResponseEntity.ok(new CustomerDto(firstName, lastName));
//    }
}
