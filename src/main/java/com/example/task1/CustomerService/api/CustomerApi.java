package com.example.task1.CustomerService.api;

import com.example.task1.CustomerService.dto.CustomerDto;
import com.example.task1.CustomerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cus")
public class CustomerApi {
    @Autowired
    CustomerService customerService;

    @PostMapping
    String saveCustomer(@RequestBody CustomerDto customer) {
        if(customer == null || !customer.getName().matches("[A-Za-z ]+")){
            throw new RuntimeException("Invalid name!");
        } else if (customer.getEmail() == null) {
            throw new RuntimeException("Invalid email!");
        } else if (customer.getCity() == null) {
            throw new RuntimeException("Invalid city!");
        }
        System.out.println("Data received");
        customerService.save(customer);
        return "Saved!";
    }

    @GetMapping("/{id}")
    CustomerDto getCustomer(@PathVariable String id) {
        CustomerDto search = customerService.search(id);
        System.out.println(search.toString());
        return search;
    }
//
//    @GetMapping
//    List<CustomerDto> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }

    @PutMapping
    String updateCustomer(@RequestBody CustomerDto customer) {
        if (customer == null || !customer.getName().matches("[A-Za-z ]+")) {
            throw new RuntimeException("Invalid name!");
        } else if (customer.getEmail() == null) {
            throw new RuntimeException("Invalid email!");
        } else if (customer.getCity() == null) {
            throw new RuntimeException("Invalid city!");
        }
        System.out.println("Data received");
        boolean update = customerService.update(customer);
        if(update){
            System.out.println("updated");
            return "updated!";
        }
        return "not Updated!";
    }

//    @DeleteMapping("/api/v1/cus/{id}")
//    String deleteCustomer(@PathVariable String id) {
//        boolean delete = customerService.delete(id);
//        if(delete){
//            System.out.println("deleted");
//            return "Deleted!";
//        }
//        return "Not deleted";
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        boolean delete = customerService.delete(id);
        if (delete) {
            System.out.println("deleted");
            return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
    }

}
