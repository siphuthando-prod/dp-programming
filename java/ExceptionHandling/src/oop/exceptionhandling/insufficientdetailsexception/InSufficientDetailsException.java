
package oop.exceptionhandling.insufficientdetailsexception;

public class InSufficientDetailsException extends Exception {
    public InSufficientDetailsException(){
        
    }
    public InSufficientDetailsException(String message){
        super(message);
    }
}
