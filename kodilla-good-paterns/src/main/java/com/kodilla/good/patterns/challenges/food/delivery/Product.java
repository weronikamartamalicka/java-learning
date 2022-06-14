package com.kodilla.good.patterns.challenges.food.delivery;

public interface Product {

    public double getValueOfInvoice();
    public String getProductName();
    public int getQuantity();
    public double getPrice();
    public boolean equals(Object o);
    public int hashCode();

}
