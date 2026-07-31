
package secondlargest;

/**
 *
 * @author S. X Mabuza
 */
public class SecondLargest {

    public static void main(String[] args) {
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
    }
}
    

