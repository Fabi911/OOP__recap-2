package de.products;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ProductRepo repo = new ProductRepo();
        repo.addProduct(new Product("test","TEST","teSt","10","12,99","123456"));
        repo.addProduct(new Product("test2","TEST","teSt","10","12,99","123457"));


        repo.getProducts();


        repo.getProducts();


        OrderMapRepo orderMapRepo = new OrderMapRepo();

        ShopService shopService = new ShopService();
        shopService.placeNewOrder(Arrays.asList(("123456"),("123457")));
        orderMapRepo.getOrders();


    }
}
