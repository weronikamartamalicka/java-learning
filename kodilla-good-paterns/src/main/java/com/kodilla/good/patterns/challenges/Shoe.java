package com.kodilla.good.patterns.challenges;


public final class Shoe implements Product{
    private final String nameOfProduct;
    private final String nameOfCategory;
    private final int productId;

    public Shoe(final String nameOfProduct, final String nameOfCategory, final int productId) {
        this.nameOfProduct = nameOfProduct;
        this.nameOfCategory = nameOfCategory;
        this.productId = productId;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Shoe)) return false;
        Shoe shoe = (Shoe) o;
        return getProductId() == shoe.getProductId() && getNameOfProduct().equals(shoe.getNameOfProduct()) && getNameOfCategory().equals(shoe.getNameOfCategory());
    }

    @Override
    public int hashCode() {
        return productId;
    }
}
