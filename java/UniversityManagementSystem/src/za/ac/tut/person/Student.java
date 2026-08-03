
package za.ac.tut.person;;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author S. X Mabuza
 */
  class Student extends Person {
      //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++++++++
      private List<Course> courses;
      private List<Double> marks;
      
      //CONSTRUCTOR+++++++++++++++++++++++
      public Student(String name, String id){
          super(name, id);
          this.courses = new ArrayList<>();
          this.marks = new ArrayList<>();
      }
      
      //PUBLIC METHODS+++++++++++++++++++++++++++++++++++++++++++++++
      public void registerCourse(Course course){
          this.courses.add(course);
          this.marks.add(0.0);      //Initialize marks with 0.0
      }
      
      public void assignMarks(Course course, double mark){
          int index = this.courses.indexOf(course);
          if(index != -1){
              this.marks.set(index, mark);
          }
      }
      
      public double calculateAverageMarks(){
          double total = 0;
          for(double mark : marks){
              total += mark;
          }
          return this.marks.size() > 0 ?  total /this.marks.size() : 0.0;
      }
      
      @Override
      public void displayInfo(){
          System.out.println("Student Name: " + this.getName());
          System.out.println("Student ID: " + this.getId());
          System.out.println("Courses Registred: ");
          for (Course course : courses) {
              System.out.println(course.getCourseName());
          }
          System.out.println("Average marks: " + this.calculateAverageMarks());
      }
}
