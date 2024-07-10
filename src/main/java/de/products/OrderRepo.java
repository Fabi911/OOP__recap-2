package de.products;
import java.util.List;

public interface OrderRepo {

    List<Order> getOrders();

    Order getOrderById(String id);

    Order addNewOrder(Order newOrder);

    void removeOrder(String id);
}