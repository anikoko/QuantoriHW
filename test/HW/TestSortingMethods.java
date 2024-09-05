package HW;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class TestSortingMethods {
	
	
	@Test
	void testMergeSort() {
		int[] array = {2, 5, 88, 77, 2, 4, 1, 6, 10, 9, 46};
		int[] expected = {1, 2, 2, 4, 5, 6, 9, 10, 46, 77, 88};
		SortingMethods.mergeSort(array);
		assertArrayEquals(expected, array);
	}
	
	@Test
	void testInsertionSort() {
		int[] array = {2, 5, 88, 77, 2, 4, 1, 6, 10, 9, 46};
		int[] expected = {1, 2, 2, 4, 5, 6, 9, 10, 46, 77, 88};
		SortingMethods.insertionSort(array);
		assertArrayEquals(expected, array);
	}
	
	@Test
	void testCountingSort() {
		int[] array =    {1, 3, 5, 1, 2, 3, 4, 4};
		int[] expected = {1, 1, 2, 3, 3, 4, 4, 5};
		int[] sorted = SortingMethods.countingSort(array, 1);
		assertArrayEquals(expected, sorted);

	}
	
	@Test
	void testLSD() {
		int[] array = {2, 5, 88, 77, 2, 4, 1, 6, 10, 9, 46};
		int[] expected = {1, 2, 2, 4, 5, 6, 9, 10, 46, 77, 88};
		SortingMethods.LSD(array);
		assertArrayEquals(expected, array);
	}
	@Test
	void testQuickSort() {
		int[] array = {2, 5, 88, 77, 2, 4, 1, 6, 10, 9, 46};
		int[] expected = {1, 2, 2, 4, 5, 6, 9, 10, 46, 77, 88};
		SortingMethods.quickSortIterative(array);
		assertArrayEquals(expected, array);
	}

}
