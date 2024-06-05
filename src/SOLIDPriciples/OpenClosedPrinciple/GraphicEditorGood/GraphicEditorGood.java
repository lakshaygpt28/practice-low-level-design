package SOLIDPriciples.OpenClosedPrinciple.GraphicEditorGood;


// Open-Close Principle - Good example
/*
* In the new design we use abstract draw() method in GraphicEditor for drawing objects,
* while moving the implementation in the concrete shape objects. Using the Open Close Principle
* the problems from the previous design are avoided, because GraphicEditor is not changed
* when a new shape class is added
*
* */
public class GraphicEditorGood {
    public void drawShape(Shape shape) {
        shape.draw();
    }
}

