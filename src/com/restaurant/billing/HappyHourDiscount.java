package com.restaurant.billing;

public class HappyHourDiscount implements Discount {
    public double apply(double total) {
        return total * 0.8;
    }
}