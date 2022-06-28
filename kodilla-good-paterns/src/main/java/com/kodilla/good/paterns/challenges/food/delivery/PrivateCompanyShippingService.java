package com.kodilla.good.paterns.challenges.food.delivery;

public final class PrivateCompanyShippingService implements ShippingService {
    public double createOrder(Manufacturer manufacturer, Product product) {
        double charge = 30.0;
        return charge;
    }
}

