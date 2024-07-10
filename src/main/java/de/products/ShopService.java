package de.products;

import java.security.Provider;
import java.util.List;
import java.util.stream.Collectors;

public class ShopService extends OrderListRepo{


    public ShopService() {

    }

    public void placeNewOrder(Order order, ProductRepo repo,OrderListRepo orderList) {
        if(order != null && getOrderById(order.orderId()) == null){
            List<Product> unavailableProducts = order.products().stream()
                    .filter(product -> !repo.isProductAvailable(product.name()))
                    .collect(Collectors.toList());

            if(unavailableProducts.isEmpty()){
                orderList.addOrder(order);
            } else {
                System.out.println("Die folgenden Produkte in der Bestellung sind nicht verfügbar: "
                        + unavailableProducts.stream().map(Product::name).collect(Collectors.joining(", ")));
            }
        }
    }



}
