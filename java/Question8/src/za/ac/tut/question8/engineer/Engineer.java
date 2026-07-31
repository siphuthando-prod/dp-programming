
package za.ac.tut.question8.engineer;

import za.ac.tut.question8.employee.Employee;

/**
 *
 * @author S. X Mabuza
 */
public class Engineer extends Employee {
    //Private member+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private String specialization;
    
    //Constructor+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Engineer(String name, double salary, String specialization){
        super(name, salary);
        this.specialization = specialization;
    }
    
    //Public method+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public void displayDetails(){
        System.out.println("Engineer Details");
        System.out.println("Name: " + this.name);
        System.out.println("Salary: R" + this.salary);
        System.out.println("Specialization: " + this.specialization);
    }
}
