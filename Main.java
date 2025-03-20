import java.util.Scanner ;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = scn.nextInt();

        int[] arr = new int[n] ; 

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println("Enter the element to be inserted at the beginning");
        
        int firstElement = scn.nextInt();


        System.out.println("Enter the element to be inserted at the end");
        int lastElement = scn.nextInt();

        // Create a new array with size increased by 2
        int newSize = arr.length + 2;
        int[] newArr = new int[newSize];

        // Insert at the beginning
        newArr[0] = firstElement;

        // Copy old array to new array
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i]; // Shift right by 1
        }

        // Insert at the end
        newArr[newArr.length - 1] = lastElement;

        // Print updated array
        System.out.print("Updated Array: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}