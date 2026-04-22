package com.restaurant.model;

import java.util.*;

public class Order {

    private List<OrderItem> items;
    private OrderStatus status;

    public Order(List<OrderItem> items) {
        this.items = items;
        this.status = OrderStatus.PLACED;
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}