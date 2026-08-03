
package za.ac.tut.person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author S. X Mabuza
 */
 class Lecturer extends Person{
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++
     private List<Course> courses;
     
     //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++
     public Lecturer(String name, String id){
         super(name, id);
         this.courses = new ArrayList<>();
     }
     
     //PUBLIC mETHODS+++++++++++++++++++++++++++++++++++++++++++
     public void assignCourse(Course course){
         this.courses.add(course);
     }
     
     @Override
     public void displayInfo(){
         System.out.println("Lecturer Name: " + this.getName());
         System.out.println("Lecturer ID: " + this.getId());
         System.out.println("Courses Teaching: ");
         for (Course course : courses) {
             System.out.println(course.getCourseName());
         }
     }
}
