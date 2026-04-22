package com.restaurant.main;

import com.restaurant.model.*;
import com.restaurant.service.*;
import com.restaurant.billing.*;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        MenuService ms = new MenuService();
        OrderService os = new OrderService();
        Scanner sc = new Scanner(System.in);

        // Default Menu
        ms.addItem(new FoodItem(1, "Pizza", 250, "Main"));
        ms.addItem(new FoodItem(2, "Burger", 150, "Fast"));

        while (true) {

            try {
                System.out.println("\n===== SYSTEM =====");
                System.out.println("1. Admin");
                System.out.println("2. Customer");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int role = sc.nextInt();

                // ================= ADMIN =================
                if (role == 1) {

                    while (true) {
                        System.out.println("\n--- ADMIN MENU ---");
                        System.out.println("1. View Menu");
                        System.out.println("2. Add Item");
                        System.out.println("3. Update Item");
                        System.out.println("4. Delete Item");
                        System.out.println("5. Back");

                        int ch = sc.nextInt();

                        switch (ch) {

                            case 1:
                                ms.displayMenu();
                                break;

                            case 2:
                                try {
                                    System.out.print("ID: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Name: ");
                                    String name = sc.nextLine();

                                    System.out.print("Price: ");
                                    double price = sc.nextDouble();
                                    sc.nextLine();

                                    System.out.print("Category: ");
                                    String cat = sc.nextLine();

                                    ms.addItem(new FoodItem(id, name, price, cat));

                                } catch (Exception e) {
                                    System.out.println("Invalid input!");
                                    sc.nextLine();
                                }
                                break;

                            case 3:
                                try {
                                    System.out.print("Enter ID: ");
                                    int uid = sc.nextInt();
                                    sc.nextLine();

                                    FoodItem item = ms.find(uid);
                                    if (item == null) {
                                        System.out.println("Item not found!");
                                        break;
                                    }

                                    System.out.print("New Name: ");
                                    String n = sc.nextLine();

                                    System.out.print("New Price: ");
                                    double p = sc.nextDouble();
                                    sc.nextLine();

                                    System.out.print("New Category: ");
                                    String c = sc.nextLine();

                                    ms.getMenuList().remove(item);
                                    ms.addItem(new FoodItem(uid, n, p, c));

                                    System.out.println("Updated!");

                                } catch (Exception e) {
                                    System.out.println("Error!");
                                    sc.nextLine();
                                }
                                break;

                            case 4:
                                try {
                                    System.out.print("Enter ID: ");
                                    int did = sc.nextInt();

                                    FoodItem del = ms.find(did);
                                    if (del != null) {
                                        ms.getMenuList().remove(del);
                                        System.out.println("Deleted!");
                                    } else {
                                        System.out.println("Item not found!");
                                    }

                                } catch (Exception e) {
                                    System.out.println("Invalid input!");
                                    sc.nextLine();
                                }
                                break;

                            case 5:
                                break;

                            default:
                                System.out.println("Invalid choice!");
                        }

                        if (ch == 5) break;
                    }
                }

                // ================= CUSTOMER =================
                else if (role == 2) {

                    while (true) {
                        System.out.println("\n--- CUSTOMER MENU ---");
                        System.out.println("1. View Menu");
                        System.out.println("2. Place Order");
                        System.out.println("3. Back");

                        int ch = sc.nextInt();

                        if (ch == 1) {
                            ms.displayMenu();
                        }

                        else if (ch == 2) {

                            char more = 'y';

                            while (more == 'y') {

                                ms.displayMenu();

                                try {
                                    System.out.print("Enter ID: ");
                                    int fid = sc.nextInt();

                                    FoodItem f = ms.find(fid);
                                    if (f == null) {
                                        System.out.println("Invalid ID");
                                        continue;
                                    }

                                    System.out.print("Qty: ");
                                    int q = sc.nextInt();

                                    if (q <= 0) {
                                        System.out.println("Invalid quantity!");
                                        continue;
                                    }

                                    os.add(new OrderItem(f, q));

                                } catch (Exception e) {
                                    System.out.println("Invalid input!");
                                    sc.nextLine();
                                    continue;
                                }

                                System.out.print("More? (y/n): ");
                                more = sc.next().toLowerCase().charAt(0);
                            }

                            if (os.empty()) {
                                System.out.println("No order!");
                                continue;
                            }

                            try {
                                System.out.println("1.DineIn 2.Takeaway 3.Delivery");
                                int type = sc.nextInt();

                                BillingService b;

                                if (type == 1) b = new DineInBilling();
                                else if (type == 2) b = new TakeawayBilling();
                                else if (type == 3) {
                                    System.out.print("Distance: ");
                                    double d = sc.nextDouble();
                                    b = new DeliveryBilling(d);
                                } else {
                                    System.out.println("Invalid type!");
                                    os.clear();
                                    continue;
                                }

                                os.show();

                                double total = b.calculateBill(os);

                                // ✅ Discount
                                System.out.println("Apply Discount? 1.Student 2.HappyHour 3.None");
                                int d = sc.nextInt();

                                if (d == 1) total = new StudentDiscount().apply(total);
                                else if (d == 2) total = new HappyHourDiscount().apply(total);

                                System.out.println("Final Bill: ₹" + total);

                                os.clear();

                            } catch (Exception e) {
                                System.out.println("Error!");
                                sc.nextLine();
                            }
                        }

                        else if (ch == 3) break;
                        else System.out.println("Invalid choice!");
                    }
                }

                else if (role == 3) {
                    System.out.println("Thank you!");
                    break;
                }

                else {
                    System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Enter valid number!");
                sc.nextLine();
            }
        }

        sc.close();
    }
}