
package za.ac.tut.shape.square;

import za.ac.tut.shape.Shape;

/**
 *
 * @author S. X Mabuza
 */
public class Square extends Shape {
    public Square(String name){
        super(name);
    }
    
    @Override
    public void draw(){
        System.out.println("Drawing a " + this.name);
    }
}
