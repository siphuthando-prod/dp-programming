
//Packaging
package oop.exceptionhandling.runprogram;

//Import statements
import oop.exceptionhandling.notnameorsurnameexception.NotNameOrSurnameException;
import javax.swing.JOptionPane;
import oop.exceptionhandling.insufficientdetailsexception.InSufficientDetailsException;
import oop.exceptionhandling.invalididexception.InvalidIDException;
import oop.exceptionhandling.persondetails.PersonDetails;

public class RunProgram {
    //User-defined methods
    public static void noDigits(String value) throws NotNameOrSurnameException{
        for(int k = 0; k < value.length(); k++){
            if(Character.isDigit(value.charAt(k))){
                throw new NotNameOrSurnameException("The name or  surname cannot contain digits");
            }
        }
    }
    
    public static void main(String[] args) throws InSufficientDetailsException,
            NotNameOrSurnameException{
        
        String name = " " , surname = " ", ID = "";
        
        String input = JOptionPane.showInputDialog("The your name, surname, & ID number(separated by a comma ',')");
        String[] details = input.split("[\s,;#]+");
        
        while(true){   
            try{
                if(details.length != 3){
                    throw new InSufficientDetailsException("Must enter a name, surname, and ID number for the user");
                }
                else{
                    name = details[0];
                    surname = details[1];
                    ID = details[2];
                    break;
                }
            }
            catch(InSufficientDetailsException ex){              
                JOptionPane.showMessageDialog(null, 
                        ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                
                input = JOptionPane.showInputDialog("Re-enter your name, surname, & ID number(separated by a comma ',')");
               details = input.split("[\s,;#]+");                
            }
        }
        
        while(true){
             try{
                noDigits(name);
                break;
            }
            catch(NotNameOrSurnameException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Invalid Name", JOptionPane.ERROR_MESSAGE);
                input = JOptionPane.showInputDialog("Re-ente your name");
                name = input;
            }
        }
        
       while(true)       {
            try{
                noDigits(surname);
                break;
            }
            catch(NotNameOrSurnameException e){
                JOptionPane.showMessageDialog(null, e.getMessage(),
                        "Invalid Surname", JOptionPane.ERROR_MESSAGE);
                input = JOptionPane.showInputDialog("Re-enter your surname");
                surname = input;
            }
       }
       
       PersonDetails person = new PersonDetails();
       
       while(true){
            try{
                person.setDetails(name, surname, ID);      
                break;
           }
           catch(InvalidIDException ex){
               JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid ID",
                                            JOptionPane.ERROR_MESSAGE);
               input = JOptionPane.showInputDialog("Re-enter your ID number");
               ID = input;
           }
       }
      
       int age = 0;
       input = JOptionPane.showInputDialog("Enter your age");
       
       while(true){
           try{
               age = Integer.parseInt(input);
               break;
           }
           catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null, ex.getMessage(),
                       "Invalid age", JOptionPane.ERROR_MESSAGE);
               input = JOptionPane.showInputDialog("Re-enter your age");
           }
       }
       
       int dob = Integer.parseInt(ID.substring(0, 3));
       int actYear = 0;
       if(dob < 26){
           dob += 2000;
           actYear = 2026 - dob;
       }
       else{
           dob += 1900;
           actYear = 2026 - dob;
       }
       
       if(actYear == age){
           JOptionPane.showMessageDialog(null, "Your ID number is valid");
       }
       else{
           JOptionPane.showMessageDialog(null, "Your ID number is not valid");
       }
    }
    
}
