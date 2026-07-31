
package assignment1_qn3;

import java.text.DecimalFormat;

/**
 *
 * @author S. X Mabuza
 */
public class Assignment1_Qn3 {

    public static void main(String[] args) {
        // Instantiating Objects+++++++++++++++++++++++++++++++++++++++++++++++++
        DecimalFormat df = new DecimalFormat("###,###.00");
        
        Circle circle = new Circle();
        double area = circle.calcArea();
       double circum =  circle.calcCircumference();
        System.out.println("Area of " + circle.getColor() + " cicle: " + area);
        System.out.println("Circumference of " + circle.getColor() + " cicle: " + circum);
        
        System.out.println("************************************************************");
        
        Circle circle2 = new Circle(5, "Blue");
        area = circle2.calcArea();
        circum = circle2.calcCircumference();
        System.out.println("Area of " + circle2.getColor() + " cicle: " + df.format(area));
        System.out.println("Circumference of " + circle2.getColor() + " cicle: " + df.format(circum));
    }
    
}
