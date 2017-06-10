package question1;

import java.util.*;
import java.io.*;

public class MergeSort1 {

	public static void main(String[] args) {
        int [] a = new int[10];
        
        //populating the Array
        populateA(a);
        
      //Check the output which is sorted array
        System.out.println("Before Sorting: ");
        printA(a);
        
        
	
	}

	public static void mergeSort(Comparable[] c){
		Comparable[] temp = new Comparable[c.length];
		sort(c, temp, 0, c.length -1);
	}

	public static void sort(Comparable[] list, Comparable[] temp, int low, int high){
		if(low<high){
			int center = (low+high)/2;
			sort(list, temp, low, center);
			sort(list, temp, center+1, high);
			merge(list, temp, low, center+1, high);
		}
	}

	private static void merge(Comparable[] list, Comparable[] temp, int leftPos, int rightPos, int rightEnd){
		int leftEnd = rightPos-1;
		int tempPos = leftPos;
		int numElements = rightEnd-leftPos+1;
		
		//main loop
		while(leftPos<=leftEnd && rightPos <=rightEnd){
			if(list[leftPos].compareTo(list[rightPos])<=0){
				temp[tempPos] = list[rightPos];
				rightPos++;
			}
			tempPos++;
		}
		
		//copy rest of left half
		while(leftPos<=leftEnd){
			temp[tempPos] = list[leftPos];
			tempPos++;
			leftPos++;
		}
	
		//Copy temp back into list
		for(int i = 0; i< numElements; i++, rightEnd--)
			list[rightEnd] = temp[rightEnd];
	}

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
