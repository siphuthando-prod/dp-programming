
package secondlargest;

import java.util.Scanner;

/**
 *
 * @author S. X Mabuza
 */
public class SecondLargest {

    public static void main(String[] args) {
        //Decraring and instantiating Scanner++++++++++++++++++++++++++++++++++++++++++
        Scanner kb = new Scanner(System.in);
        
        //Creating Array++++++++++++++++++++++++++++++++++++
        int[] numbers = {12, 45, 7, 45, 23, 18, 40};
        
        //Declaring variables++++++++++++++++++++++++++++++++++++++++++++++++
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > largest) {        //Obtainng the largest value++++++++++++++++++++++++++++++++++
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {     //handling of duplicate max values+++++++
                secondLargest = num;
            }
        }
        
        //Printing the Second largest number++++++++++++++++++++++++++++++++++++++++++++++
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest distinct element exists.");
        } else {
            System.out.println("Second largest number: " + secondLargest);
        }
        
        //REVERSING A STRING+++++++++++++++++++++++++++++++++++++++++++++++
        System.out.print("Enter a string you'd like to reverse: ");
        String input = kb.nextLine();
        String reversed = "";
        
        for(int k = input.length() - 1; k >= 0; k--){
            reversed += input.charAt(k);
        }
        
        System.out.println(reversed);
    }
}
    

