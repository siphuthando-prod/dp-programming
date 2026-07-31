
package za.ac.tut.question8.employee;

/**
 *
 * @author S. X Mabuza
 */
public abstract class Employee {
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private String name;
    private double salary;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    
    //PUBLIC METHODS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void displayDetails(){
    
    };
}
