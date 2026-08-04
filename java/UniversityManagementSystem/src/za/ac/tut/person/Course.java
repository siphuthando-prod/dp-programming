
package za.ac.tut.person;

//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author S. X Mabuza
 */
class Course {
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++++++++++++++
    private String courseName;
    private String courseCode;
    private Lecturer lecturer;
    private List<Student> students;
    
    //ACCESSOR METHODS+++++++++++++++++++++++++++++++++++++++++++
    public String getCourseName(){
        return this.courseName;
    } 
    
    public String getCourseCode(){
        return this.courseCode;
    }
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Course(String courseName, String courseCode){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.students = new ArrayList<>();
    }
    
    //PUBLIC METHODS+++++++++++++++++++++++++++++++++++++++++++++++
    public void assignLecturer(Lecturer lecturer){
        this.lecturer = lecturer;
    }
    
    public void assignStudent(Student student){
        this.students.add(student);
    }
    
    public void displayInfo(){
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Course Code: " + this.courseCode);
        if(lecturer != null){
            System.out.println("Lecturer: " + this.lecturer.getName());
        }
        System.out.println("Students Enrolled: ");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
