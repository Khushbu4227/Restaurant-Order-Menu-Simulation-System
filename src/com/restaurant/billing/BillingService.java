package com.restaurant.billing;

import com.restaurant.service.OrderService;

public abstract class BillingService {
    public abstract double calculateBill(OrderService os);
}