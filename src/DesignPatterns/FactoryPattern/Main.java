package DesignPatterns.FactoryPattern;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactoryObj = new ShapeFactory();
        Shape shapeObj = shapeFactoryObj.getShape("RECTANGLE");
        shapeObj.draw();
    }

}
