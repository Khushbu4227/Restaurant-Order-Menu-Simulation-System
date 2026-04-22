package com.restaurant.billing;

public interface Discount {
    double apply(double total);
}
