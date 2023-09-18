package com.example.task1.CustomerService.service;

import com.example.task1.CustomerService.dto.CustomerDto;


public interface CustomerService {
    boolean save(CustomerDto customerDto);

    boolean update(CustomerDto customerDto);

    boolean delete(String id);

    CustomerDto search(String id);
}
