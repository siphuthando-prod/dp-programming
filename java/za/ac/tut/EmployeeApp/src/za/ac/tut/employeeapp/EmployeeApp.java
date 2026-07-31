
package za.ac.tut.employeeapp;

import java.util.ArrayList;
import za.ac.employee.Employee;

/**
 *
 * @author S. X Mabuza
 */
public class EmployeeApp {

    public static void main(String[] args) {
       //Instantiating ArrayList++++++++++++++++++++++++++++++++++++++++
    ArrayList<Employee> staff = new ArrayList<>();
    
    //Creating Employee objects+++++++++++++++++++++++++++++++++++++++++
        Employee emp1 = new Employee("Sizwe", "09260573477");
        Employee emp2 = new Employee("Michelle", "07013076583");
        Employee emp3 = new Employee("Tsepo", "0307056749");
        Employee emp4 = new Employee("Siphuthando", "02101151860");
        Employee emp5 = new Employee("Minenhle", "09101265767");
        //Adding objects to the list+++++++++++++++++++++++++++++++++
        staff.add(emp1);
        staff.add(emp2);
        staff.add(emp3);
        staff.add(emp4);
        staff.add(emp5);
   
        for (Employee employee : staff) {
            System.out.println("++++++++++++++++++++++++++");
            System.out.println("Name: " + employee.getName());
            System.out.println("ID number: " + employee.getId());
        }
       
        //Sorting elements in ascending order++++++++++++++++++++++++++++++++++++++++++++
        for(int k = 0; k < staff.size() - 1; k++){
            for(int j = 0; j < staff.size() - 1 - 1; j++){
                if(staff.get(j).getId().compareToIgnoreCase(staff.get(j + 1).getId()) > 0){
                    Employee tempEmp = staff.get(j );
                    staff.set(j, staff.get(j + 1));
                    staff.set(j + 1, tempEmp);
                }
            }
        }
        
        //Display sorted list+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
         System.out.println("Sorted list");
        for (Employee employee : staff) {
            System.out.println("++++++++++++++++++++++++++");
            System.out.println("Name: " + employee.getName());
            System.out.println("ID number: " + employee.getId());
        }
    
    }
    
}
