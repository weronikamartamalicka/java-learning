package com.kodilla.good.patterns.challenges.food.delivery;

public interface InformationService {

    public void informShippingCompany(User user, Product product);
    public void informManufacturer(User user, Product product, ShippingService shippingService);
    public void informUser(User user, ShippingService shippingService, double invoice);
}
