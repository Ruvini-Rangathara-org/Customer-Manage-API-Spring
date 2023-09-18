package com.example.task1.CustomerService.util;

import com.example.task1.CustomerService.dto.CustomerDto;
import com.example.task1.CustomerService.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Convertor {
    ModelMapper modelMapper;
    Convertor(){
         modelMapper = new ModelMapper();
    }
    public CustomerDto getCustomerDto(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    public CustomerEntity getCustomerEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto, CustomerEntity.class);
    }

}
