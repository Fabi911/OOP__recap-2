package de.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
        products = new ArrayList<>();
        // Example products added for testing
        addProduct(new Product("Laptop", "Dell", "Electronics", "1", "$1000", "123456"));
        addProduct(new Product("Smartphone", "Apple", "Electronics", "1", "$999", "123457"));
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    public void getProducts() {
        System.out.println("all Products:");
        for (Product product : products) {
            System.out.println(product);
        };
    }
    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.name().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
    public boolean isProductAvailable(String productName) {
        return products.stream().anyMatch(product -> product.name().equals(productName));
    }

    public Product getProductById(String productId) {
        for (Product product : products) {
            if (product.id().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}

