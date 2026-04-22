package com.restaurant.service;

import com.restaurant.model.FoodItem;
import java.util.*;

public class MenuService {

    private List<FoodItem> list = new ArrayList<>();

    public void addItem(FoodItem f) {
        for (FoodItem i : list) {
            if (i.getId() == f.getId()) {
                System.out.println("Duplicate ID!");
                return;
            }
        }
        list.add(f);
        System.out.println("Item added!");
    }

    public void displayMenu() {
        if (list.isEmpty()) {
            System.out.println("Menu empty");
            return;
        }
        for (FoodItem f : list) {
            System.out.println(f);
        }
    }

    public FoodItem find(int id) {
        for (FoodItem f : list) {
            if (f.getId() == id) return f;
        }
        return null;
    }

    public List<FoodItem> getMenuList() {
        return list;
    }
}