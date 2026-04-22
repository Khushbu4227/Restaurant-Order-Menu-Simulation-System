package com.restaurant.model;

public class OrderItem {

    private FoodItem item;
    private int qty;

    public OrderItem(FoodItem item, int qty) {
        if (item == null) throw new IllegalArgumentException("Item null");
        if (qty <= 0) throw new IllegalArgumentException("Invalid qty");

        this.item = item;
        this.qty = qty;
    }

    public double getTotal() {
        return item.getPrice() * qty;
    }

    public String getName() {
        return item.getName();
    }

    @Override
    public String toString() {
        return item.getName() + " x " + qty + " = ₹" + getTotal();
    }
}