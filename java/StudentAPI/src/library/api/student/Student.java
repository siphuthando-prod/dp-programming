
package library.api.student;
//IMPORT STATEMENTS+++++++++++++++++++
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student in the library system.
 * 
 * <p>The {@code Student} class stores information about a student,
 * including their student number, name, surname, and the subjects
 * they are registered for.</p>
 *
 * @author S. X Mabuza
 */
public class Student {
    //PRIVATE MEMBERS++++++++++++++++++++++
    private String studNumber;
    private String name;
    private String surname;
    private List<String> subjects;
    
    //CONSTRUCTOR(S)++++++++++++++++
    
    /**
     * Creates a new Student object with empty student details
     * and an empty list of subjects.
     */
    public Student(){
        this.studNumber = "";
        this.name = "";
        this.surname = "";
        this.subjects = new ArrayList<>();
    }
    
    /**
     * Creates a new Student object with the specified student details.
     *
     * @param studNumber the student's student number
     * @param name the student's first name
     * @param surname the student's surname
     */
    public Student(String studNumber, String name, String surname){
        this.studNumber = studNumber;
        this.name = name;
        this.surname = surname;
        this.subjects = new ArrayList<>();
    }
    
    //MUTATOR(S)++++++
    
    /**
     * Sets the student's student number.
     *
     * @param studNumber the student number to assign to the student
     */
    public void setStudNumber(String studNumber){
        this.studNumber = studNumber;
    }
    
    /**
     * Sets the student's first name.
     *
     * @param name the first name to assign to the student
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Sets the student's surname.
     *
     * @param surname the surname to assign to the student
     */
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    /**
     * Adds a subject to the student's list of subjects.
     *
     * @param subjectName the name of the subject to add
     */
    public void addSubject(String subjectName){
        this.subjects.add(subjectName);
    }
    
    //ACCESSOR(S)++++++++++++
    
     /**
     * Returns the student's name.
     *
     * @return a formatted string containing the student's details
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Returns the student's surname.
     *
     * @return a formatted string containing the student's details
     */
    public String getSurname(){
        return this.surname;
    }
    
     /**
     * Returns the student number of the student.
     *
     * @return a formatted string containing the student's details
     */
    public String getStudNumber(){
        return this.studNumber;
    }
                
    /**
     * Returns the student's details, including their student number,
     * name, surname, and registered subjects.
     *
     * @return a formatted string containing the student's details
     */
    public String getDetails(){
        String output = " ";
        String sub = "";
        for (String subject : subjects) {
            sub += subject + ", ";
        }
        output =  "Student Number: " + this.studNumber 
                + "\nName: " + this.name 
                + "\nSurname: "+ this.surname 
                + "\nSubjects: "+ sub;
        return output;
    }
        
}
