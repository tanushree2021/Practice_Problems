package sortingAlgo;

/*
 * 
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element
 *  (considering ascending order) from unsorted part and putting it at the beginning. 
 * 
 * Approach:
Initialize minimum value(min_idx) to location 0
Traverse the array to find the minimum element in the array
While traversing if any element smaller than min_idx is found then swap both the values.
Then, increment min_idx to point to next element
Repeat until array is sorted
 */
public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 64, 25, 12, 22, 11 };
		System.out.println("---Selection Sort---");
		for (int j : arr) {
			System.out.print(j + " ");
		}
		System.out.println();

		int a = 0;
		int swap_index = 0;

		long start = System.nanoTime();
//		a = mySelectionSort(arr, a, swap_index);
		a = lessCode(arr, a);
		long total = System.nanoTime()-start;

		System.out.println("sorted after " + a + "(^2) iterations");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\nTotal time taken - "+total/1000+" milliseconds");
	}

	private static int lessCode(int[] arr, int a) {
		while (a < arr.length) {
			int min_idx = a;
			for (int i = a + 1; i < arr.length; i++) {
				if (arr[min_idx] > arr[i]) {
					min_idx = i;
				}
			}
//			if(a != min_idx) {
				int temp = arr[a];
				arr[a] = arr[min_idx];
				arr[min_idx] = temp;
//			}
			a++;
		}
		return a;
	}

	private static int mySelectionSort(int[] arr, int min_idx, int swap_index) {
		while (min_idx < arr.length) {
			int current_val = arr[min_idx];
			for (int i = min_idx + 1; i < arr.length; i++) {
				if (current_val > arr[i]) {
					current_val = arr[i];
					swap_index = i;
				}
			}
			if (current_val != arr[min_idx]) {
				arr[swap_index] = arr[min_idx];
				arr[min_idx] = current_val;
			}
			min_idx++;
		}
		return min_idx;
	}

}
