package com.example.task1.CustomerService.service.impl;

import com.example.task1.CustomerService.dao.CustomerDao;
import com.example.task1.CustomerService.dto.CustomerDto;
import com.example.task1.CustomerService.entity.CustomerEntity;
import com.example.task1.CustomerService.service.CustomerService;
import com.example.task1.CustomerService.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Autowired
    Convertor convertor;

    @Override
    public boolean save(CustomerDto customerDto) {
        CustomerEntity save = customerDao.save(convertor.getCustomerEntity(customerDto));
        System.out.println(save.toString());
        System.out.println("save in customer service impl");
        return true;
    }

    @Override
    public boolean update(CustomerDto customerDto) {
        System.out.println("update in customer service impl");
        customerDao.update(customerDto.getId(), customerDto.getName(),customerDto.getCity(), customerDto.getEmail());
        return true;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("delete in customer service impl");
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(id);
        customerDao.delete(customerEntity);
        return true;
    }

    @Override
    public CustomerDto search(String id) {
        System.out.println("search in customer service impl");
        Optional<CustomerEntity> byId = customerDao.findById(id);
        return byId.map(customerEntity -> convertor.getCustomerDto(customerEntity)).orElse(null);
    }
}
