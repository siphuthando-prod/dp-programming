
package listexample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author S. X Mabuza
 */
public class ListExample {

    public static void main(String[] args) {
        //Dclaring variables++++++++++++++++++++++++++++++++++++++++++++++
        List<Integer> numbers = new ArrayList<>();
        //List<String> names = new ArrayList<>();
        
        //Check if list is empty++++++++++++++++++++++++++++++++++++++
        if(numbers.isEmpty()){
            System.out.println("The list is empty");
            
            //Adding elements in the list+++++++++++++++++++++++++++++++++++++
            numbers.add(1); //names.add("sizwe-land");
            numbers.add(2); //names.add("LiNDA");
            numbers.add(3); //names.add("HIMTHESUN");
            numbers.add(4); //names.add("$kywalker");
            numbers.add(5); //names.add("Trace");
            
            //Display the elements+++++++++++++++++++++++++++++++++++++++++++++++
            System.out.println("++++++++++++++++++");
            numbers.forEach(System.out::println);
            //names.forEach(System.out::println);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
            
            //Removing an element+++++++++++++++++++++++++++++++++++++++++++
            int removedElement = numbers.remove(4);
            System.out.println("The element " + removedElement + " has been removed");
            numbers.forEach(System.out::println);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
            
            //Getting an element+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            int element = numbers.get(0);
            System.out.println("The element at index 0 is " + element);
            numbers.forEach(System.out::println);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            
            
        }
    }
    
}
