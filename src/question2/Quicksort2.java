package question2;

public class Quicksort2 {

	private static int[] a;

	public static void main(String[] args) {
			// Get a random generated array
			a = getArray();

			// prints the given array
			printArray();

			// sort the array
			sort();

			System.out.println("");

			//prints the sorted array
			printArray();
	}

	// This method sorts an array and internally calls quickSort
	public static void sort(){
		
		int start = 0;
		int end = a.length-1;

		quickSort(start, end);
	}

	// This method is used to sort the array using quicksort algorithm.
	// It takes the start and the end of the array as the two cursors.
	
	private static void quickSort(int start,int end){

		// If both cursor scanned the complete array quicksort exits
		if(start >= end)
		return;

		// For the simplicity, we took the right most item of the array as a pivot 
		int pivot = a[end];
		int partition = partition(start, end, pivot);

		// Recursively, calls the quicksort with the different left and right parameters of the sub-array
		quickSort(0, partition-1);
		quickSort(partition+1, end);
	}

	// This method is used to partition the given array and returns the integer
	// which points to the sorted pivot index
	private static int partition(int start, int end, int pivot) {
		int leftCursor = start - 1;
		int rightCursor = end;
		while (leftCursor < rightCursor) {
			while (a[++leftCursor] < pivot)
				;
			while (rightCursor > 0 && a[--rightCursor] > pivot)
				;
			if (leftCursor >= rightCursor) {
				break;
			} else {
				swap(leftCursor, rightCursor);
			}
		}
		swap(leftCursor, end);
		return leftCursor;
	}

	// This method is used to swap the values between the two given index
	public static void swap(int start, int end) {
		int temp = a[start];
		a[start] = a[end];
		a[start] = temp;
	}

	public static void printArray() {
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static int[] getArray() {
		int size = 10;
		int[] array = new int[size];
		int item = 0;
		for (int i = 0; i < size; i++) {
			item = (int) (Math.random() * 100);
			array[i] = item;
		}
		return array;
	}
}