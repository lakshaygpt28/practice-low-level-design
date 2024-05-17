package FactoryPattern;

public class ShapeFactory {
    Shape getShape(String input) {
        return switch (input) {
            case "RECTANGLE" -> new Rectangle();
            case "CIRCLE" -> new Circle();
            default -> null;
        };
    }
}
