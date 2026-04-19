import java.util.Arrays;
import java.util.Scanner;
public class SortArray {
	public static double average (int []arr) {
		double sum=0;
		for (int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
		}
		return sum/arr.length;
	}
	public static int sum (int []arr) {
		int sum=0;
		for (int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
		}
		return sum;
	}
	public static void sortArray (int []arr) {
		for (int i = 0; i < arr.length - 1; i++) {
	        for (int j = 0; j < arr.length - i - 1; j++) {
	            if (arr[j] > arr[j + 1]) {
	                int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;
	            }
	        }
	    }
	}
	public static void main (String[] args) {
		Scanner keyboard = new Scanner (System.in);
		
		int n = keyboard.nextInt();
		int []arr = new int [n];
		for (int i=0 ;i<n;i++)
		{
			arr[i]=keyboard.nextInt();
		}
		sortArray (arr);
		System.out.println ("Sorted array: " + Arrays.toString(arr));
		System.out.println ("Sum: " + sum(arr) + "\n" + "Average: " + average(arr));
	}
}
