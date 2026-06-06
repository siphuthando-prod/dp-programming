
//Packaging
package oop.exceptionhandling.persondetails;

//Import Statements
import oop.exceptionhandling.invalididexception.InvalidIDException;

public class PersonDetails {
    //data members
    private String name;
    private String surname;
    private String ID;
    
    //Constructors
    public PersonDetails(){
        name = " ";
        surname = " ";
        ID = " ";
        }
    public PersonDetails(String name, String surname, String ID) throws InvalidIDException{
        this.setDetails(name, surname, ID);
    }
        
    //Mutator method
    public void setDetails(String name, String surname, String ID) throws InvalidIDException{
        this.name = name;
        this.surname = surname;
        
        if(ID.length() != 13){
            throw new InvalidIDException("ID number must be 13 digits long");
        }
        else{
            this.ID = ID;
        }
    }
    
    //Accessor Methods
    public String getName(){
        return this.name;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    public String getID(){
        return this.ID;
    }
}
