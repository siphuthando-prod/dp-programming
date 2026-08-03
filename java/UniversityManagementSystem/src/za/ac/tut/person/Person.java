
package za.ac.tut.person;

/**
 *
 * @author S. X Mabuza
 */
abstract class Person {
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++++++++++++
    private String name;
    private String id;

    //ACCESSOR METTHODS+++++++++++++++++++++++++++++++++++++
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    
    //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++++++++++
    public Person(String name, String id){
        this.name = name;
        this.id = id;
    }
    
    //ABSTRACT METHODS++++++++++++++++++++++++++++++++++++++++++++++++++
    public abstract void displayInfo();
}
