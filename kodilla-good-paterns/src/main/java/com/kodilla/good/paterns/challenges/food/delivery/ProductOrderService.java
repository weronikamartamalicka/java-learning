package com.kodilla.good.paterns.challenges.food.delivery;

import java.time.LocalDateTime;

public class ProductOrderService {

    public boolean order(User user, Product product, ShippingService shippingService, LocalDateTime time) {
        System.out.println("Ordering product: " + product.getProductName() +  " on: " + time + " for: " + user.getFirstName() + " " +  user.getLastName() +  " proceeded successfully");
        return true;
    }
}
