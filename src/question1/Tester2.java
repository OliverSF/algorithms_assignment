package question1;

import java.util.Scanner;

public class Tester2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int size;
		
		System.out.println("Please enter the size of the Array: ");
		size = input.nextInt();
		
		int A[] = new int[size];

		populateA(A); // method to populate the Array

		System.out.println("Before sorting: ");
		printA(A); // method to print the array A

		A = mergeSort(A); // method to sort the Array 'A'

		System.out.println("\nAfter Sorting: ");
		printA(A); //method to print the array A
		
		input.close(); //closing scanner to avoid possible leak
	}

	// Main --> to break the Array 'A' up into individual pieces/elements
	public static int[] mergeSort(int[] B) {

		if (B.length <= 1) {
			return B; // if there is only one element in the Array to start with
		}

		int midpoint = B.length / 2; // dividing the Array in half

		int[] left = new int[midpoint]; //?creating two array left and right??
		int[] right;

		if (B.length % 2 == 0) {
			right = new int[midpoint];
		}

		else {
			right = new int[midpoint + 1];
		}

		int[] result = new int[B.length];

		for (int i = 0; i < midpoint; i++) { //to populate left hand side Array
			left[i] = B[i];
		}

		int x = 0;
		for (int j = midpoint; j < B.length; j++) { 

			if (x < right.length) { //so that on Right Array we can populate from Index 0 --> midpoint
				right[x] = B[j];
				x++;
			} //end if statement
		} //end for loop

		left = mergeSort(left); // recursion to break Left side down to single pieces
		right = mergeSort(right); // recursion to break right side down to single pieces

		result = merge(left, right); // ? calling the merge method to merge all the single elements and sort??

		return result;
	}

	public static int[] merge(int[] left, int[] right) {

		// declaring variables
		int lengthResult = left.length + right.length; // getting size for
														// result Array
		int[] result = new int[lengthResult]; // creating array of that size
		int indexL = 0;
		int indexR = 0;
		int indexRes = 0;

		while (indexL < left.length || indexR < right.length) { //while you still have elements on left or right keep going

			if (indexL < left.length && indexR < right.length) {

				if (left[indexL] <= right[indexR]) {
					result[indexRes] = left[indexL];
					indexL++;
					indexRes++;
				} else {
					result[indexRes] = right[indexR];
					indexR++;
					indexRes++;
				}
			} else if (indexL < left.length) { //for when one is exhausted we keep adding from other array
				result[indexRes] = left[indexL];
				indexL++;
				indexRes++;
			}

			else if (indexR < right.length) {
				result[indexRes] = right[indexR];
				indexR++;
				indexRes++;
			}

		}
		return result;
	}

	// method to print the Array
	public static void printA(int[] B) {

		for (int i = 0; i < B.length; i++) {
			System.out.print(B[i] + " ");
		}
	}

	// method to populate the Array 'A'
	public static int[] populateA(int[] B) {
		
		Scanner input2 = new Scanner(System.in);
		
		System.out.println("Please enter the numbers in your Array: ");
		
		for (int i = 0; i < B.length; i++) {
			
			B[i] = (int) (input2.nextInt());
		}
		input2.close();
		return B;
	}
	
}
