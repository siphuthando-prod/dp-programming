
package assignment1_qn3;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author S. X Mabuza
 */
public class Assignment1_Qn3 {

    public static void main(String[] args) {
        // Instantiating Objects+++++++++++++++++++++++++++++++++++++++++++++++++
        DecimalFormat df = new DecimalFormat("###,###.00");
        Scanner kb = new Scanner(System.in);
        
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
        
        //HANDLING SQUARE ROOT+++++++++++++++++++++++++++++++++++++++++++++
        int number = 0;
        double sRoot = 0;
        
        try{
            System.out.print("Enter a number: ");
            number = kb.nextInt();
            
            if(number < 0){
                throw new NegativeNumberException("Can't compute square-root of a negative number!");
            }
             sRoot = Math.sqrt(number);
             System.out.println("Square root of " + number + " is: " + sRoot);
        }
        catch(NegativeNumberException e){
            System.out.println(e.getMessage());
        }
                        
    }
    
}
