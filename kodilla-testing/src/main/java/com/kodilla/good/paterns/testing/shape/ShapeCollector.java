package com.kodilla.good.paterns.testing.shape;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();
    
    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if(shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int numberOfFigure) {
        if(numberOfFigure >= 0 && numberOfFigure < shapes.size()) {
            return shapes.get(numberOfFigure);
        }
        return null;
    }

    public String showFigures() {
        for(int i = 0; i < shapes.size(); i++) {
            return shapes.get(i).toString();
        }
        return "null";
    }

    public int getFiguresQuantity() {
        return shapes.size();
    }
}
