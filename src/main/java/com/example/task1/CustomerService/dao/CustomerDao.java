package com.example.task1.CustomerService.dao;

import com.example.task1.CustomerService.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,String> {

    @Modifying
    @Transactional
    @Query("UPDATE customer p SET p.name = :name, p.city = :city, p.email = :email WHERE p.id = :id")
    void update(@Param("id") String id,
                           @Param("name") String name,
                           @Param("city") String city,
                           @Param("email") String email);
}
