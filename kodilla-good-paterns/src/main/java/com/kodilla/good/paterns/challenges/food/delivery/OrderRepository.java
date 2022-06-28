package com.kodilla.good.paterns.challenges.food.delivery;

public interface OrderRepository {

    public void createOrder(User user, Product product);
}
