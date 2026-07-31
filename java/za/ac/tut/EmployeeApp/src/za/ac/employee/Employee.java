
package za.ac.employee;

/**
 *
 * @author S. X Mabuza
 */
public class Employee {
    //PRIVATE_MEMBERS+++++++++++++++++++++++++++++++++++++++++++++++++++
    private String name;
    private String id;
	
//GETTERS AND SETTERS++++++++++++++++++++++++++++++++++++++++++++++++
public String getName(){
    return this.name;
}
	
public String getId(){
    return this.id;
}
	
public void setName(String name){
    this.name = name;
}
	
public void setId(String id){
    this.id = id;
}
	
//CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public Employee(String name, String id){
    this.name = name;
    this.id = id;
}
}
