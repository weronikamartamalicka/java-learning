package com.kodilla.good.paterns.challenges.food.delivery;

public class FoodDeliveryProcess {

    public OrderDto repeatableDeliveryProcess(OrderRequest orderRequest, Manufacturer manufacturer) {
        boolean idOrdered = manufacturer.getProductOrderService().order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getShippingService(), orderRequest.getTime());
        if(idOrdered) {
            manufacturer.getInformationService().informManufacturer(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getShippingService());
            manufacturer.getInformationService().informShippingCompany(orderRequest.getUser(), orderRequest.getProduct());
            manufacturer.getOrderRepository().createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
