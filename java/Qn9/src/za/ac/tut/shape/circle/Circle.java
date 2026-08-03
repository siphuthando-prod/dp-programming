
package za.ac.tut.shape.circle;

import za.ac.tut.shape.Shape;

/**
 *
 * @author S. X Mabuza
 */
public class Circle extends Shape {
    public Circle(String name){
        super(name);
    }
    
    @Override
    public void draw(){
        System.out.println("Drawing a " + this.name);
    }
}
