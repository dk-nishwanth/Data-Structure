
import java.util.Scanner ; 
public class Main
{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		// Getting the number of arrray elements from the user
		int n = scn.nextInt();
		
		
		// Initialising the array for the given number of elements 
		int[] arr = new int[n];
		
		// Getting array elements from the user 
		for(int i = 0; i < n; i++){
		    arr[i] = scn.nextInt();
		}
		
		// Printing the array elements 
		for(int i = 0; i < n; i++){
		    System.out.println(arr[i]);
		}
	}
}
