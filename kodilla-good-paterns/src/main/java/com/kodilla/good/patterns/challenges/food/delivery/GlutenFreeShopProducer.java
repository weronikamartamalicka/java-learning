package com.kodilla.good.patterns.challenges.food.delivery;

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
    public OrderDto process(OrderRequest orderRequest) {
        boolean idOrdered = productOrderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getShippingService(), orderRequest.getTime());
        if(idOrdered) {
            double invoice = orderRequest.getProduct().getValueOfInvoice() + shippingService.createOrder(this, orderRequest.getProduct());
            informationService.informUser(orderRequest.getUser(), orderRequest.getShippingService(), invoice);
            informationService.informManufacturer(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getShippingService());
            informationService.informShippingCompany(orderRequest.getUser(), orderRequest.getProduct());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
