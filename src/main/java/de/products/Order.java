package de.products;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public record Order
        (
                String orderId,
                String customerId,
                LocalDate orderDate,
                List<Product> products,
                BigDecimal totalAmount
        ) {

}
