package com.kodilla.good.patterns.challenges.food.delivery;

public final class ExtraFoodShopProducer implements Manufacturer{
    private final InformationService informationService;
    private final OrderRepository orderRepository;
    private final ProductOrderService productOrderService;
    private final ShippingService shippingService;
    private final PackageService packageService;

    public ExtraFoodShopProducer(final InformationService informationService, final OrderRepository orderRepository, final ProductOrderService productOrderService, final ShippingService shippingService, final PackageService packageService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.productOrderService = productOrderService;
        this.shippingService = shippingService;
        this.packageService = packageService;
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {
        boolean idOrdered = productOrderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getShippingService(), orderRequest.getTime());
        boolean isPackaged = packageService.createOrder(orderRequest.getProduct(), orderRequest.getCompanyName());
        if(idOrdered && isPackaged) {
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
