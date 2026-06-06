
package oop.exceptionhandling.notnameorsurnameexception;

public class NotNameOrSurnameException extends Exception {
    public NotNameOrSurnameException(){
        
    }
    public NotNameOrSurnameException(String message){
        super(message);
    }
}
