
package za.ac.tut.shapesapp;

import java.util.ArrayList;
import za.ac.tut.shape.Shape;
import za.ac.tut.shape.circle.Circle;
import za.ac.tut.shape.square.Square;
import za.ac.tut.shape.triangle.Triangle;

/**
 *
 * @author S. X Mabuza
 */
public class ShapesApp {

    public static void main(String[] args) {
        // Instantiating objects++++++++++++++++++++++++++++++++++
        ArrayList<Shape> shapes = new ArrayList<>();
        
        Circle circle = new Circle("Circle");
        shapes.add(circle);
        
        Square  sq = new Square("Square");
        shapes.add(sq);
        
        Triangle tri = new Triangle("Triangle");
        shapes.add(tri);
        
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
    
}
