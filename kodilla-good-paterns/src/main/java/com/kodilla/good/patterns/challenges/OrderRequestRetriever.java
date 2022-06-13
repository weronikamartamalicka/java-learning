package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Jan", "Kowalski");
        Shoe product = new Shoe("Seoul Premium 6 inch", "Women sneakers", 45362902);
        LocalDateTime time = LocalDateTime.now();

        return new OrderRequest(user, product, time);
    }
}
