package com.kodilla.good.paterns.challenges.food.delivery;

public interface Manufacturer {

    public void process(OrderRequest orderRequest);
    public ProductOrderService getProductOrderService();
    public InformationService getInformationService();
    public OrderRepository getOrderRepository();
    public ShippingService getShippingService();
}
