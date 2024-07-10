package de.products;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ProductRepo repo = new ProductRepo();
        repo.addProduct(new Product("iPhone", "Apple", "smartphone", "10", "999.99"));
        repo.addProduct(new Product("Galaxy", "Samsung", "smartphone", "32", "799.99"));
        repo.addProduct(new Product("Note", "Samsung", "smartphone", "7", "899.99"));
        repo.addProduct(new Product("S21", "Samsung", "smartphone", "6", "999.99"));
        repo.addProduct(new Product("Z Fold", "Samsung", "smartphone", "5", "1099.99"));
        repo.addProduct(new Product("MacBook Pro", "Apple", "Laptop", "20", "2399.99"));
        repo.addProduct(new Product("Galaxy Tab", "Samsung", "Tablet", "25", "499.99"));
        repo.addProduct(new Product("Apple Watch", "Apple", "Smartwatch", "15", "399.99"));
        repo.addProduct(new Product("QLED", "Samsung", "Television", "10", "1199.99"));

        repo.removeProduct(repo.getProductByName("Note"));

        repo.getProducts();
        System.out.println("\nSearch for: "+repo.getProductByName("Android"));

        OrderListRepo orderListRepo = new OrderListRepo();
        orderListRepo.addOrder( new Order(
                "O123", // Order ID
                "C456", // Customer ID
                LocalDate.now(), // Order Date
                Arrays.asList(new Product("iPhone", "Apple", "smartphone", "2", "1999.98"),
                        new Product("Android", "Samsung", "smartphone", "1", "699.99")),
                BigDecimal.valueOf(2699.97) // Total Amount
        ));

        Order order1 = new Order(
                "O124", // Order ID
                "C789", // Customer ID
                LocalDate.now(), // Order Date
                Arrays.asList(new Product("iPhone", "Apple", "smartphone", "3", "2999.97"),
                        new Product("MacBook Pro", "Apple", "Laptop", "1", "2399.99")),
                BigDecimal.valueOf(5399.96) // Total Amount
        );
        orderListRepo.addOrder(order1);

        Order order2 = new Order(
                "O125", // Order ID
                "C123", // Customer ID
                LocalDate.now(), // Order Date
                Arrays.asList(new Product("Galaxy", "Samsung", "smartphone", "2", "1599.98"),
                        new Product("Galaxy Tab", "Samsung", "Tablet", "1", "499.99")),
                BigDecimal.valueOf(2099.97) // Total Amount
        );
        orderListRepo.addOrder(order2);

        Order order3 = new Order(
                "O126", // Order ID
                "C321", // Customer ID
                LocalDate.now(), // Order Date
                Arrays.asList(new Product("QLED", "Samsung", "Television", "1", "1199.99")), // List of Products
                BigDecimal.valueOf(1199.99) // Total Amount
        );
        orderListRepo.addOrder(order3);

        orderListRepo.getOrders();

        orderListRepo.removeOrder("O125");
        System.out.println("\nOrderNo. 0124: "+orderListRepo.getOrderById("O124"));
        orderListRepo.getOrders();
        ShopService shopService = new ShopService();

        Order order4 = new Order(
                "O128", // Order ID
                "C188", // Customer ID
                LocalDate.now(), // Order Date
                Arrays.asList(new Product("Galaxy", "Samsung", "smartphone", "2", "1599.98"),new Product("Phone", "Asus", "smartphone", "2", "1199.98") ),
                BigDecimal.valueOf(2599.98) // Total Amount
        );
        shopService.placeNewOrder(order4,repo,orderListRepo);

        Order order5 = new Order(
                "O129", // Order ID
                "C188", // Customer ID
                LocalDate.now(), // Order Date
                Arrays.asList(new Product("Galaxy", "Samsung", "smartphone", "2", "1599.98") ),
                BigDecimal.valueOf(1599.98) // Total Amount
        );
        shopService.placeNewOrder(order5,repo,orderListRepo);
        System.out.println("\nnew order: "+orderListRepo.getOrderById("O129"));

        orderListRepo.getOrders();
    }

}
