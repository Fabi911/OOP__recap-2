package de.products;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepo {
    public List<Order> orders = new ArrayList<>();

    public default void addOrder(Order order) {
        orders.add(order);
    }

    public default void getOrders() {
        System.out.println("\nall Orders");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    public default getOrderById(String orderId) {
        for (Order order : orders) {
            if (order.orderId().equals(orderId)) {
                return de.products.order;
            }
        }
        return null;
    }

    public void removeOrder(String orderId) {
        orders.removeIf(order -> order.orderId().equals(orderId));

    }
}
