package com.kodilla.good.paterns.challenges;

import java.time.LocalDateTime;

public final class ProductOrderService {

    public boolean order(final User user, final String productName, final int productId, final LocalDateTime time) {
        System.out.println("Ordering product: " + productName + productId + " on: " + time + " proceeded successfully");
        return true;
    }
}
