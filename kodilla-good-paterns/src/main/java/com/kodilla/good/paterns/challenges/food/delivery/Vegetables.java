package com.kodilla.good.paterns.challenges.food.delivery;


public class Vegetables implements Product{
    private final String productName;
    private final int quantity;
    private final double tax;
    private final double price;
    private final int productId;

    public Vegetables(final String productName, final int quantity, final double tax, final double price, final int productId) {
        this.productName = productName;
        this.quantity = quantity;
        this.tax = tax;
        this.price = price;
        this.productId = productId;
    }

    @Override
    public double getValueOfInvoice() {
        double result = quantity * price + quantity * price * tax;
        return result;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTax() {
        return tax;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Vegetables)) return false;
        Vegetables that = (Vegetables) o;
        return getQuantity() == that.getQuantity() && Double.compare(that.getTax(), getTax()) == 0 && getProductId() == that.getProductId() && getProductName().equals(that.getProductName());
    }

    @Override
    public int hashCode() {
        int result = productId;
        return result;
    }
}
