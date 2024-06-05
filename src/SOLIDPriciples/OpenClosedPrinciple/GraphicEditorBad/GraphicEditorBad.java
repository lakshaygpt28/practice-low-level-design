package SOLIDPriciples.OpenClosedPrinciple.GraphicEditorBad;


// Open-Close Principle - Bad example

/*
* Bellow is an example which violates the Open Close Principle. It implements a graphic editor which handles
* the drawing of different shapes. It's obviously that it does not follow the Open Close Principle since the
* GraphicEditor class has to be modified for every new shape class that has to be added.
* */
public class GraphicEditorBad {

    void drawShape(Shape shape) {
        if (shape.m_type == 1) {
            drawRectangle((Rectangle) shape);
        } else if (shape.m_type == 2) {
            drawCircle((Circle) shape);
        }
    }
    void drawRectangle(Rectangle rectangle) {
        System.out.println("Drawing Rectangle");
    }

    void drawCircle(Circle circle) {
        System.out.println("Drawing Circle");
    }
}

