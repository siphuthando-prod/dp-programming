
package za.ac.tut.question8.employee;

/**
 *
 * @author S. X Mabuza
 */
public abstract class Employee {
    //PROTECTED MEMBERS++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    protected String name;
   protected double salary;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    
    //PUBLIC METHODS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public abstract void displayDetails();
}
