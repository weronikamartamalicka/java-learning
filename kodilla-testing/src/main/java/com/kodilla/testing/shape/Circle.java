package com.kodilla.testing.shape;

public class Circle implements Shape {

    private String shapeName;
    private double field;

    public Circle(String shapeName, double field) {
        this.shapeName = shapeName;
        this.field = field;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return getShapeName().equals(circle.getShapeName()) && Double.compare(getField(), circle.getField()) == 0;
    }

    @Override
    public int hashCode() {
        int result = shapeName.hashCode();
        Double temporaryField = field;
        result = result * 31 + temporaryField.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return shapeName;
    }
}
