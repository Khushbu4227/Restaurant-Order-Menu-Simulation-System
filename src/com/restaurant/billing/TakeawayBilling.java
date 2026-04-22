package com.restaurant.billing;

import com.restaurant.service.OrderService;

public class TakeawayBilling extends BillingService {
    public double calculateBill(OrderService os) {
        return os.total() + 20;
    }
}