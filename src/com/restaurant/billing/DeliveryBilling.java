package com.restaurant.billing;

import com.restaurant.service.OrderService;

public class DeliveryBilling extends BillingService {

    private double dist;

    public DeliveryBilling(double d) {
        if (d <= 0) throw new IllegalArgumentException("Invalid distance");
        dist = d;
    }

    public double calculateBill(OrderService os) {
        return os.total() + (dist * 10);
    }
}