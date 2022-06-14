package com.kodilla.good.patterns.challenges.food.delivery;

import java.time.LocalDateTime;

public final class OrderRequest {
    private final User user;
    private final Product product;
    private final ShippingService shippingService;
    private final LocalDateTime time;
    private final String companyName;

    public OrderRequest(final User user, final Product product, final ShippingService shippingService, final LocalDateTime time, final String companyName) {
        this.user = user;
        this.product = product;
        this.shippingService = shippingService;
        this.time = time;
        this.companyName = companyName;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public ShippingService getShippingService() {
        return shippingService;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getCompanyName() {
        return companyName;
    }
}
