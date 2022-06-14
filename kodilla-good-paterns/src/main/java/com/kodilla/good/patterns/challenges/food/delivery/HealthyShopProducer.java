package com.kodilla.good.patterns.challenges.food.delivery;

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
    public OrderDto process(OrderRequest orderRequest) {
        boolean idOrdered = productOrderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getShippingService(), orderRequest.getTime());
        if(idOrdered) {
            informationService.informManufacturer(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getShippingService());
            informationService.informShippingCompany(orderRequest.getUser(), orderRequest.getProduct());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
