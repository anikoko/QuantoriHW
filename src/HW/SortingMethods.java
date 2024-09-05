package HW;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;

public class SortingMethods {

	static void mergeSort(int[] array) {
		int middle = array.length / 2;
		int[] left;
		int[] right;

		if (array.length > 1) {
			middle = array.length / 2;

			left = Arrays.copyOfRange(array, 0, middle);
			right = Arrays.copyOfRange(array, middle, array.length);

			mergeSort(left);
			mergeSort(right);

			int i = 0;
			int j = 0;
			int k = 0;

			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					array[k] = left[i];
					i++;
				} else {
					array[k] = right[j];
					j++;
				}
				k++;
			}

			while (i < left.length) {
				array[k] = left[i];
				i++;
				k++;
			}

			while (j < right.length) {
				array[k] = right[j];
				j++;
				k++;
			}

		}

	}

	static void insertionSort(int[] array) {
		int key, j;
		for (int i = 0; i < array.length; i++) {
			key = array[i];
			j = i - 1;
			while (j >= 0 && key < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}

	}

	static int getMaxElement(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;

	}

	static int[] countingSort(int[] array, int digit) {
		int max = getMaxElement(array);
		int[] countArray = new int[max + 1];
		int[] sorted = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			countArray[(array[i] / digit) % 10]++;
		}

		for (int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i - 1];
		}

		for (int i = array.length - 1; i >= 0; i--) {
			sorted[countArray[(array[i] / digit) % 10] - 1] = array[i];
			countArray[(array[i] / digit) % 10]--;
		}

		for (int i = 0; i < sorted.length; i++) {
			array[i] = sorted[i];
		}

		return sorted;
	}

	static void LSD(int[] array) {
		int max = getMaxElement(array);

		for (int digit = 1; max / digit > 0; digit *= 10) {
			countingSort(array, digit);
		}
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static int partition(int[] array, int start, int end) {
		int pivotIndex = end;
		int pivot = array[end];
		int leftIndex = start;
		for (int i = start; i <= end; i++) {
			if (array[i] < pivot) {
				swap(array, i, leftIndex);
				leftIndex++;
			}
		}
		swap(array, pivotIndex, leftIndex);
		return leftIndex;
	}

	static void quickSortLoop(int[] array, int start, int end) {
		if (start < end) {
			int partition = partition(array, start, end);
			quickSortLoop(array, start, partition - 1);
			quickSortLoop(array, partition + 1, end);
		}
	}


	static void quickSort(int[] array) {
		quickSortLoop(array, 0, array.length - 1);
	}
	
	static void quickSortIterative(int[] array) {
	    int[] stack = new int[array.length];
	    int top = -1;

	    stack[++top] = 0;
	    stack[++top] = array.length - 1;

	    while (top >= 0) {
	        int end = stack[top--];
	        int start = stack[top--];

	        int partitionIndex = partition(array, start, end);

	        if (partitionIndex - 1 > start) {
	            stack[++top] = start;
	            stack[++top] = partitionIndex - 1;
	        }

	        if (partitionIndex + 1 < end) {
	            stack[++top] = partitionIndex + 1;
	            stack[++top] = end;
	        }
	    }
	}


}
