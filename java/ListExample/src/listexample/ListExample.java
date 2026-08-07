
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
        
        //Check if list is empty++++++++++++++++++++++++++++++++++++++
        if(numbers.isEmpty()){
            System.out.println("The list is empty");
            
            //Adding elements in the list+++++++++++++++++++++++++++++++++++++
            numbers.add(1); 
            numbers.add(2); 
            numbers.add(3);
            numbers.add(4); 
            numbers.add(5); 
            
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
            
            //Adding a number at an occupied index++++++++++++++++++++++++++++++++++
            System.out.println("Element at index 0 is now changed to a 10");
            numbers.add(0, 10);
            numbers.forEach(System.out::println);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            
            //REplacing an element at an index+++++++++++++++++++++++++++++++++++++++++++
            System.out.println("Element at index 0 replaced with 20");
            numbers.set(0, 20);
            numbers.forEach(System.out::println);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            
            //Checking if an element is contained in the list+++++++++++++++++++++++++++
            if(numbers.contains(20)){
                System.out.println(20 + " is present in the list. It occures at index " + numbers.indexOf(20));
            }else{
                System.out.println(20 + " is not in the list.");
            }
            
            //Clearing list++++++++++++++++++++++++++
            numbers.clear();
            
            if(numbers.isEmpty()){
                System.out.println("The list is empty");
            }
            else{
                System.out.println("The list is not empty");
            }
        }else{
            System.out.println("The is not not empty");
        }
    }
    
}
