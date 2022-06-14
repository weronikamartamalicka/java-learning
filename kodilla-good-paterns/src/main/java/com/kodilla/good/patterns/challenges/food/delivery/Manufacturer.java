package com.kodilla.good.patterns.challenges.food.delivery;

public interface Manufacturer {

    public void process(OrderRequest orderRequest);
    public ProductOrderService getProductOrderService();
    public InformationService getInformationService();
    public OrderRepository getOrderRepository();
    public ShippingService getShippingService();
}
