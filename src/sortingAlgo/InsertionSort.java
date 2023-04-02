package sortingAlgo;

/*
 * Insertion Sort Algorithm 

To sort an array of size N in ascending order: 

 1. Iterate from arr[1] to arr[N] over the array.
 2. Compare the current element (key) to its predecessor.
 3. If the key element is smaller than its predecessor, compare it to the elements before.
 	Move the greater elements one position up to make space for the swapped element.
 	
 	Initially, the first two elements of the array are compared in insertion sort and then swapped.
 	Then move to the next two elements and compare them.
*  
 */
public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6};
		int len = arr.length;
		System.out.println("---Insertion Sort---");
		for (int j : arr) {
			System.out.print(j + " ");
		}
		for(int i=0; i<len-1;i++) {
//			System.out.println();
			for(int j=i+1;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}else {
					break;
				}
//				for (int in : arr) {
//					System.out.print(in + " ");
//				}
			}
		}
		System.out.println("\nSorted Array -");
		for (int j : arr) {
			System.out.print(j + " ");
		}
	}

}
