package sortingAlgo;

/*
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping 
 * the adjacent elements if they are in the wrong order. 
 * This algorithm is not suitable for large data sets as its average and 
 * worst case time complexity is quite high.
 * 
 * Optimized Implementation of Bubble Sort: 
The function always runs O(n^2) time even if the array is sorted.
It can be optimized by stopping the algorithm if the inner loop didn’t cause any swap. 
 */
public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {5, 1, 4, 2, 8};
		int len = arr.length;
		System.out.println("---Bubble Sort---");
		for (int j : arr) {
			System.out.print(j + " ");
		}
		System.out.println();
		long start = System.nanoTime();
		bubbleSort(arr, len);
		long total = System.nanoTime()-start;
//		optimizedBubbleSort(arr, len);
		System.out.println("Sorted Array -");
		for (int j : arr) {
			System.out.print(j + " ");
		}
		System.out.println("\nTotal time taken - "+total/1000+" milliseconds");
	}

	private static void bubbleSort(int[] arr, int len) {
		for(int i=0; i<len;i++) {
			for(int j=0; j<len-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	private static void optimizedBubbleSort(int[] arr, int len) {
		boolean swapped = false;
		for(int i=0; i<len;i++) {
			for(int j=0; j<len-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			if(swapped==false) {
				break;
			}
		}
	}

}
