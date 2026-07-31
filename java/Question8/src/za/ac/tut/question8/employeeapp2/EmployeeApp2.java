
package za.ac.tut.question8.employeeapp2;

import za.ac.tut.question8.engineer.Engineer;
import za.ac.tut.question8.manager.Manager;

/**
 *
 * @author S. X Mabuza
 */
public class EmployeeApp2 {

    public static void main(String[] args) {
        // Instantiating Objects+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Manager man = new Manager("Siphuthando", 34900, "Hospitality");
        man.displayDetails();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        
        Engineer eng = new Engineer("Sizwe", 50000, "Electrical");
        eng.displayDetails();
    }
    
}
