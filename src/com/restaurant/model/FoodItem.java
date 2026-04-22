package com.restaurant.model;

public class FoodItem {

    private int id;
    private String name;
    private double price;
    private String category;

    public FoodItem(int id, String name, double price, String category) {
        if (id <= 0) throw new IllegalArgumentException("Invalid ID");
        if (price < 0) throw new IllegalArgumentException("Invalid Price");

        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return id + " | " + name + " | ₹" + price + " | " + category;
    }
}