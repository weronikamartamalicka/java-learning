package com.kodilla.good.paterns.challenges.food.delivery;

public final class HealthyShopProducer implements Manufacturer {
    private final InformationService informationService;
    private final OrderRepository orderRepository;
    private final ProductOrderService productOrderService;
    private final ShippingService shippingService;

    public HealthyShopProducer(final InformationService informationService, final OrderRepository orderRepository, final ProductOrderService productOrderService, final ShippingService shippingService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.productOrderService = productOrderService;
        this.shippingService = shippingService;
    }

    @Override
    public void process(OrderRequest orderRequest) {
        FoodDeliveryProcess foodDeliveryProcess = new FoodDeliveryProcess();
        HealthyShopProducer healthyShopProducer = new HealthyShopProducer(informationService, orderRepository, productOrderService, shippingService);
        foodDeliveryProcess.repeatableDeliveryProcess(orderRequest, healthyShopProducer);
    }

    public InformationService getInformationService() {
        return informationService;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public ProductOrderService getProductOrderService() {
        return productOrderService;
    }

    public ShippingService getShippingService() {
        return shippingService;
    }
}
