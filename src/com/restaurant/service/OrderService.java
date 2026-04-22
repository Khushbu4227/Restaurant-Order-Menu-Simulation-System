package com.restaurant.service;

import com.restaurant.model.OrderItem;
import java.util.*;

public class OrderService {

    private List<OrderItem> orders = new ArrayList<>();

    public void add(OrderItem o) {
        orders.add(o);
    }

    public double total() {
        double t = 0;
        for (OrderItem o : orders) t += o.getTotal();
        return t;
    }

    public void show() {
        for (OrderItem o : orders) System.out.println(o);
    }

    public boolean empty() {
        return orders.isEmpty();
    }

    public void clear() {
        orders.clear();
    }

    public List<OrderItem> getOrders() {
        return orders;
    }
}