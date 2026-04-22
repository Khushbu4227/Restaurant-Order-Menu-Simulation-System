package com.restaurant.billing;

public class StudentDiscount implements Discount {
    public double apply(double total) {
        return total * 0.9;
    }
}
