package question2;

public class QuickSortTest {

	public static void main(String[] args) {
		
		int A[] = {7,6,5,4,2,1,5,3,1};
		
		QuickSort(A,0,A.length -1);
		
		for(int i = 0; i<A.length; i++){
			System.out.print(A[i]);
		}
		

	}
	
	
	public static void QuickSort(int [] A, int start, int end){
		
		if(start < end) {
			
			int partitionIndex = partition(A, start, end);
			
			QuickSort(A, start, partitionIndex-1);
			QuickSort(A, partitionIndex+1, end);
		}
	}
	
	public static int partition(int [] A, int start, int end){
		
		int pivot = A[end];
		int partitionIndex = start;
		
		for(int i = start; i<end; i++){
			
			if(A[i] <= pivot) {
				swap(A, A[i],A[partitionIndex]);
				partitionIndex++;
			}
		}
	
		swap(A, A[partitionIndex], A[end]);
		return partitionIndex;
	}
	
	public static void swap(int[] A,int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[i] = temp;
		
	}
	
}
