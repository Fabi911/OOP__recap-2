package de.products;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo{
    private Map<String, Order> orders = new HashMap<>();

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }
    @Override
    public Order getOrderById(String id) {
        return orders.get(id);
    }

    @Override
    public Order addNewOrder(Order newOrder) {
        orders.put(newOrder.orderId(), newOrder);
        return newOrder;
    }

    @Override
    public void removeOrder(String id) {
        orders.remove(id);
    }
}