package de.products;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ShopService{
    private ProductRepo productRepo=new ProductRepo();
    private  OrderRepo orderRepo= new OrderMapRepo();



    public ShopService() {

    }

    public Order placeNewOrder(List<String> productsIds) {
        List<Product> products= new ArrayList<>();
        for (String productId : productsIds) {
            Product product = productRepo.getProductById(productId);
            if (product == null) {
                System.out.println("Product with id " + productId + " not found");
                return null;
            }
            products.add(product);
        }
        Order newOrder=new Order(UUID.randomUUID().toString(), products);
        return orderRepo.addNewOrder(newOrder);
    }
}
