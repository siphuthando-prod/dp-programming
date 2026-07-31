
package assignment1_qn3;

/**
 *
 * @author S. X Mabuza
 */
public class Circle {
    //PRIVATE MEMEBERS++++++++++++++++++++++++++++++++++++++++
    private int raduis;
    private String color;

    //GETTERS AND SETTERS++++++++++++++++++++++++++++++++++
    public int getRaduis() {
        return raduis;
    }

    public void setRaduis(int raduis) {
        this.raduis = raduis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    //CONSTRUCTOR(S)+++++++++++++++++++++++++++++++++++++++++++++++
    public Circle(){
        this.raduis = 0;
        this.color = "White";
    }
    
    public Circle(int radius, String color){
        this.raduis = radius;
        this.color = color;
    }
    
    // PUBLIC METHODS++++++++++++++++++++++++++++++++++++++++++++++++++
    public double calcArea(){
        return Math.PI * Math.pow(this.raduis, 2);
    }
    
    public double calcCircumference(){
        return 2 * Math.PI + this.raduis;
    }
    
}
