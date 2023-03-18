package com.zyycode.ecommerce.dao;

import com.zyycode.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {//long是priority key的type

    Customer findByEmail(String theEmail);
    //behind the scenes,, spring will execute a query similar to:
    //select*from customer c where c.email=theEmail

}
