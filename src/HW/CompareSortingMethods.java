package HW;

import java.util.Arrays;
import java.util.Random;

public class CompareSortingMethods {
	
	static int DEFAULT_SIZE = 1_000_000;
	
	static int[] generateArray() {
		Random r = new Random();
		int[] array = new int[DEFAULT_SIZE];
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(DEFAULT_SIZE);
		}
		return array;
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		int[] arr = generateArray(); 
//		int[] arr = {2, 5, 88, 77, 2, 4, 1, 6, 10, 9, 46, 30000, 789476, 8203, 476, 28903};
		long stop = System.currentTimeMillis();		
		System.out.println("Generate Array: " + (stop - start));
		
//		System.out.println(Arrays.toString(arr));
		
		
		start = System.currentTimeMillis();
		SortingMethods.mergeSort(arr);
		stop = System.currentTimeMillis();		
		System.out.println("MergeSort: " + (stop - start));
		
		start = System.currentTimeMillis();
		SortingMethods.LSD(arr);
		stop = System.currentTimeMillis();		
		System.out.println("LSD: " + (stop - start));
		
		start = System.currentTimeMillis();
		SortingMethods.quickSortIterative(arr);
		stop = System.currentTimeMillis();		
		System.out.println("QuickSort: " + (stop - start));
	}

}
