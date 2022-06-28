package com.kodilla.good.paterns.challenges;

import java.time.LocalDateTime;

public interface OrderRepository {
    void createOrder(User user, Product product, LocalDateTime time);
}
