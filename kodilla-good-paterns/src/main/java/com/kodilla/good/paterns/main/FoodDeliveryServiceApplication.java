package com.kodilla.good.paterns.main;


import com.kodilla.good.paterns.challenges.food.delivery.*;

public class FoodDeliveryServiceApplication {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetrieverOne = new OrderRequestRetriever();
        OrderRequestRetriever orderRequestRetrieverTwo = new OrderRequestRetriever();
        OrderRequestRetriever orderRequestRetrieverThree = new OrderRequestRetriever();

        OrderRequest extraFoodShop = orderRequestRetrieverOne.retrieveForExtraFoodShop();
        OrderRequest glutenFreeShop = orderRequestRetrieverTwo.retrieveForGlutenFreeShop();
        OrderRequest healthyShop = orderRequestRetrieverThree.retrieveForHealthyShop();

        GlutenFreeShopProducer glutenFreeShopProducer = new GlutenFreeShopProducer(new MailService(), new OrderRepositoryService(), new PostalShippingService(), new ProductOrderService());
        HealthyShopProducer healthyShopProducer = new HealthyShopProducer(new SMSService(), new OrderRepositoryService(), new ProductOrderService(), new PrivateCompanyShippingService());
        ExtraFoodShopProducer extraFoodShopProducer = new ExtraFoodShopProducer(new MailService(), new OrderRepositoryService(), new ProductOrderService(), new PrivateCompanyShippingService(), new OutsourcedPackageService());

        extraFoodShopProducer.process(extraFoodShop);
        glutenFreeShopProducer.process(glutenFreeShop);
        healthyShopProducer.process(healthyShop);

    }
}
