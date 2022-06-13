package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public final class ProductOrderProcessor {

    private final InformationService informationService;
    private final OrderRepository orderRepository;
    private final ProductOrderService productOrderService;

    public ProductOrderProcessor(final InformationService informationService, final OrderRepository orderRepository, final ProductOrderService productOrderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.productOrderService = productOrderService;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        ProductOrderService orderService = new ProductOrderService();
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct().getNameOfProduct(), orderRequest.getProduct().getProductId(), orderRequest.getTime());
        if(isOrdered) {
            informationService.informUser(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getTime());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
