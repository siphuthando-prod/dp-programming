
package universitymanagementsystem;

/**
 *
 * @author S. X Mabuza
 */
public class UniversityManagementSystem {

    public static void main(String[] args) {
        //Creating Departments+++++++++++++++++++++++++++++++++++++++
        Department csDepartment = new Department("Computer Science");
        
        //Creating LEcturers++++++++++++++++++++++++++++++++++++++++++++++
        Lecturer lectJohn = new Lecturer("John Doe", "L1001");
        Lecturer  lectJane = new Lecturer("Jane Smith", "L1002");
        
        //Adding Lecuters to Department+++++++++++++++++++++++++++++++++++++++++++++
        csDepartment.addLecturer(lectJohn);
        csDepartment.addLecturer(lectJane);
        
        //Creating Courses++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Course javaCourse = new Course("Java Programming", "CS101");
        Course dbCourse = new Course("Database Systems", "CS102");
        
        //Adding Courses to Department++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        csDepartment.addCourse(javaCourse);
        csDepartment.addCourse(dbCourse);
        
        //Creating Students+++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Student studentAlice = new Student("Alice Brown", "S2001");
        Student studentBob = new Student("Bob White", "S2002");
        
        //REgistering Students to Courses+++++++++++++++++++++++++++++++++++++++++++++++++
        studentAlice.registerCourse(javaCourse);
        studentBob.registerCourse(javaCourse);
        studentAlice.registerCourse(dbCourse);
        
        javaCourse.addStudent(studentAlice);
        javaCourse.addStudent(studentBob);
        dbCourse.addStudent(studentAlice);
        
        //Assigning Marks++++++++++++++++++++++++++++++++++++++++++++++++++++++
        studentAlice.assignMarks(javaCourse, 85.0);
        studentAlice.assignMarks(dbCourse, 90.0);
        studentBob.assignMarks(javaCourse, 78.0);
        
        //Displaying Information++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        csDepartment.displayInfo();
        lectJohn.displayInfo();
        lectJane.displayInfo();
        javaCourse.displayInfo();
        dbCourse.displayInfo();
        studentAlice.displayInfo();
        studentBob.displayInfo();
    }
    
}
