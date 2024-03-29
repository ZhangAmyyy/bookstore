package com.zyycode.ecommerce.service;

import com.zyycode.ecommerce.dao.CustomerRepository;
import com.zyycode.ecommerce.dto.Purchase;
import com.zyycode.ecommerce.dto.PurchaseResponse;
import com.zyycode.ecommerce.entity.Customer;
import com.zyycode.ecommerce.entity.Order;
import com.zyycode.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImp1 implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImp1(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Order order = purchase.getOrder();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();

        //check if this is an existing customer
        String theEmail = customer.getEmail();
        //check by email whether the customer is in DB
        Customer customerFromDB = customerRepository.findByEmail(theEmail);
        if(customerFromDB !=null){
            //find it and assign them accordingly
            customer = customerFromDB;
        }
        customer.add(order);

        //save to the database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate a random UUID number(UUID version4)
        return UUID.randomUUID().toString();
    }
}
