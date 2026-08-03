
package za.ac.tut.shape;

/**
 *
 * @author S. X Mabuza
 */
public abstract class Shape {
    //Protected members+++++++++++++++++++++++++++++++++++++++++
    protected String name;
    
    //Constructor+++++++++++++++
    public Shape(String name){
        this.name = name;
    }
    
    //abstract methods+++++++++++++++++++++++++++++++++
    public abstract  void draw();
}
