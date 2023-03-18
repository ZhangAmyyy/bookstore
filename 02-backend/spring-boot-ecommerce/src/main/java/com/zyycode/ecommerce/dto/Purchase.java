package com.zyycode.ecommerce.dto;

import com.zyycode.ecommerce.entity.Address;
import com.zyycode.ecommerce.entity.Customer;
import com.zyycode.ecommerce.entity.Order;
import com.zyycode.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;


}
