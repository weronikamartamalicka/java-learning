package com.kodilla.good.paterns.challenges.food.delivery;

import java.time.LocalDateTime;

public class OrderRequestRetriever {
    public OrderRequest retrieveForExtraFoodShop() {
        User user = new User("Jan", "Kowalski");
        String companyName = "Extra Food Shop";
        Vegetables product = new Vegetables("Tomato", 20, 0.5, 3.5, 54639);
        PostalShippingService shippingService = new PostalShippingService();
        LocalDateTime time = LocalDateTime.now();
        return new OrderRequest(user, product, shippingService, time, companyName);
    }

    public OrderRequest retrieveForGlutenFreeShop() {
        User user = new User("Grzegorz", "Kowalski");
        String companyName = "Gluten Free Shop";
        Vegetables product = new Vegetables("Potato", 50, 0.5, 2.5, 54139);
        PrivateCompanyShippingService shippingService = new PrivateCompanyShippingService();
        LocalDateTime time = LocalDateTime.now();
        return new OrderRequest(user, product, shippingService, time, companyName);
    }

    public OrderRequest retrieveForHealthyShop() {
        User user = new User("Grzegorz", "Nowak");
        String companyName = "Healthy Shop";
        Vegetables product = new Vegetables("Pepper", 5, 0.5, 5.5, 24139);
        PrivateCompanyShippingService shippingService = new PrivateCompanyShippingService();
        LocalDateTime time = LocalDateTime.now();
        return new OrderRequest(user, product, shippingService, time, companyName);
    }
}
