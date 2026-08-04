
package za.ac.tut.person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author S. X Mabuza
 */
 class Department {
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++++++++++++++++++++
     private String departmentName;
     private List<Lecturer> lecturers;
     private List<Course> courses;
     
     //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     public Department(String departmentName){
         this.departmentName = departmentName;
         this.lecturers = new ArrayList<>();
         this.courses = new ArrayList<>();
     }
     
     //PUBLIC  METHODS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     public void addLecturer(Lecturer lecturer){
         this.lecturers.add(lecturer);
     }
     
     public void addCourse(Course course){
         this.courses.add(course);
     }
     
     public void displayInfo(){
         System.out.println("Department: " + this.departmentName);
         System.out.println("Lecturers: ");
         for (Lecturer lecturer : lecturers) {
             System.out.println(lecturer.getName());
         }
         System.out.println("Courses: ");
         for (Course course : courses) {
             System.out.println(course.getCourseName());
         }
     }
}
