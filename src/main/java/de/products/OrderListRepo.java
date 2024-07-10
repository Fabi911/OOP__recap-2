package de.products;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo {
    protected List<Order> orders;

    public OrderListRepo() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void getOrders() {
        System.out.println("\nall Orders");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    public Order getOrderById(String orderId) {
        for (Order order : orders) {
            if (order.orderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public void removeOrder(String orderId) {
    orders.removeIf(order -> order.orderId().equals(orderId));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }

    public void setOrders(Order order) {
        if(order != null && getOrderById(order.orderId()) == null){
            this.orders.add(order);
        }
    }
}