package com.kodilla.good.patterns.challenges.food.delivery;

public interface OrderRepository {

    public void createOrder(User user, Product product);
}
