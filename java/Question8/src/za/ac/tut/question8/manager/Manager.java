
package za.ac.tut.question8.manager;

import za.ac.tut.question8.employee.Employee;

/**
 *
 * @author S. X Mabuza
 */
public class Manager extends Employee {
    //Private members++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private String department;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Manager Details");
        System.out.println("Name: " + this.name);
        System.out.println("Salary: R" + this.salary);
        System.out.println("Department: " + this.department);
    }
    
}
