package com.kodilla.good.paterns.challenges.food.delivery;

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
    public void process(OrderRequest orderRequest) {
        ExtraFoodShopProducer extraFoodShopProducer = new ExtraFoodShopProducer(informationService, orderRepository, productOrderService, shippingService, packageService);
        FoodDeliveryProcess foodDeliveryProcess = new FoodDeliveryProcess();
        boolean isPackaged = packageService.createOrder(orderRequest.getProduct(), orderRequest.getCompanyName());
        OrderDto newOrder = foodDeliveryProcess.repeatableDeliveryProcess(orderRequest, extraFoodShopProducer);
        if(newOrder.isOrdered() && isPackaged) {
            double invoice = orderRequest.getProduct().getValueOfInvoice() + shippingService.createOrder(extraFoodShopProducer, orderRequest.getProduct());
            informationService.informUser(orderRequest.getUser(), orderRequest.getShippingService(), invoice);
        }
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

    public PackageService getPackageService() {
        return packageService;
    }
}
