package question1;

public class Tester {

	public static void main(String[] args) {
		
		int A[] = new int [10];
		
		populateA(A); //method to populate the Array
		
		System.out.println("Before sorting: ");
		printA(A); //method to print the array A
		
		A = mergeSort(A); //method to sort the Array 'A'
		
		System.out.println("\nAfter Sorting: ");
		printA(A);

	}

	//Main --> to break the Array 'A' up into individual pieces/elements
	public static int[] mergeSort(int[] B){
		
		if(B.length<=1){
			return B; //if there is only one element in the Array to start with
		}
	
		int midpoint = B.length/2; //dividing the Array in half
		
		int[] left = new int[midpoint];
		int[] right;
		
		if(B.length % 2 == 0){
			right = new int[midpoint];
		}
		
		else{
			right = new int[midpoint +1];	
		}
		
		int[] result = new int[B.length];
		
		for(int i = 0; i<midpoint; i++) {
			left[i] = B[i];
		}
		
		int x = 0;
		for(int j = midpoint; j<B.length; j++){
			
			if(x<right.length){
				right[x] = B[j];
				x++;
			}
		}
	
		left = mergeSort(left); //recursion
		right = mergeSort(right);
		
		result = merge(left, right);
		
		return result;
	}
	
	public static int [] merge(int[] left, int[] right){
		
		//declaring variables
		int lengthResult = left.length + right.length; //getting size for result Array
		int[] result = new int[lengthResult]; //creating array of that size
		int indexL = 0;
		int indexR = 0;
		int indexRes = 0;
		
		while(indexL<left.length || indexR<right.length){
			
			if(indexL<left.length && indexR<right.length){
				
				if(left[indexL] <= right[indexR]){
					result[indexRes] = left[indexL];
					indexL++;
					indexRes++;
				}
				else{
					result[indexRes] = right[indexR];
					indexR++;
					indexRes++;
				}
			}
			else if(indexL<left.length){
				result[indexRes] = left[indexL];
				indexL++;
				indexRes++;
			}
		
			else if(indexR<right.length){
				result [indexRes] = right[indexR];
				indexR++;
				indexRes++;
			}
		
		}
		return result;
	}
	
	//method to print the Array
	public static void printA(int[] B) {
		
		for(int i = 0; i<B.length; i++){
			System.out.print(B[i] + " ");
			}
	}
	
	//method to populate the Array 'A'
	public static int [] populateA(int[] B){
		
		for(int i = 0; i<B.length; i++){
			B[i] = (int)(Math.random()*100);
		}
		return B;
	}

}
