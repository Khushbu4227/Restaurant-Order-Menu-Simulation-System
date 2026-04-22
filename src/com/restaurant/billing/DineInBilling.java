package com.restaurant.billing;

import com.restaurant.service.OrderService;

public class DineInBilling extends BillingService {
    public double calculateBill(OrderService os) {
        return os.total() + (os.total() * 0.05); // service charge
    }
}