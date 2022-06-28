package com.kodilla.good.paterns.challenges.food.delivery;

public final class GlutenFreeShopProducer implements Manufacturer{
    private final InformationService informationService;
    private final OrderRepository orderRepository;
    private final ShippingService shippingService;
    private final ProductOrderService productOrderService;

    public GlutenFreeShopProducer(final InformationService informationService, final OrderRepository orderRepository, final ShippingService shippingService, final ProductOrderService productOrderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.shippingService = shippingService;
        this.productOrderService = productOrderService;
    }

    @Override
    public void process(OrderRequest orderRequest) {
        GlutenFreeShopProducer glutenFreeShopProducer = new GlutenFreeShopProducer(informationService, orderRepository, shippingService, productOrderService);
        FoodDeliveryProcess foodDeliveryProcess = new FoodDeliveryProcess();
        OrderDto newOrder = foodDeliveryProcess.repeatableDeliveryProcess(orderRequest, glutenFreeShopProducer);
        if(newOrder.isOrdered()) {
            double invoice = orderRequest.getProduct().getValueOfInvoice() + shippingService.createOrder(glutenFreeShopProducer, orderRequest.getProduct());
            informationService.informUser(orderRequest.getUser(), orderRequest.getShippingService(), invoice);
        }
    }

    public InformationService getInformationService() {
        return informationService;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public ShippingService getShippingService() {
        return shippingService;
    }

    public ProductOrderService getProductOrderService() {
        return productOrderService;
    }
}
