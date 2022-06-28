package com.kodilla.good.paterns.challenges.food.delivery;

public class OutsourcedPackageService implements PackageService {
    @Override
    public boolean createOrder(Product product, String companyName) {
        System.out.println("Package order for: " + companyName + " proceeded successfully");
        return true;
    }
}
