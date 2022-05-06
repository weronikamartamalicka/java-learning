package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {

    public String shapeName;
    private double field;

    public Triangle(String shapeName, double field) {
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
        if (o == null || !(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.getField(), getField()) == 0 && getShapeName().equals(triangle.getShapeName());
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
