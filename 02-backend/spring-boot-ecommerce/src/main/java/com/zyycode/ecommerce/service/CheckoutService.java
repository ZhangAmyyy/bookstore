package com.zyycode.ecommerce.service;

import com.zyycode.ecommerce.dto.Purchase;
import com.zyycode.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
