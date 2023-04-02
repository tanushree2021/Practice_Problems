package sortingAlgo;

/*
 *  Merge Sort is a Divide and Conquer algorithm. 
 *  It divides the input array into two halves, calls itself for the two halves, 
 *  and then it merges the two sorted halves. 
 *  The merge() function is used for merging two halves. 
 *  arr = input array
 *  l = left, m = mid, r = right
 *  The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r] 
 *  are sorted and merges the two sorted sub-arrays into one
 */
public class MergeSortTry {

	public static void main(String[] args) {
//		int arr[] = { 38, 27, 43, 3, 9, 82, 10 };
		int[] arr = { 7, 27, 43, 9, 8, 82, 10 }; // len - 7
//		int[] arr = { 10, 6, 8, 5, 7, 3, 4 };

		System.out.println("---Merge Sort---");
		for (int j : arr) {
			System.out.print(j + " ");
		}
//		sort(arr, 0, arr.length - 1);
		mergeSort(arr, arr.length);
		System.out.println("\nSorted Array -");
		for (int j : arr) {
			System.out.print(j + " ");
		}
	}
	
	static void mergeSort(int[] arr, int len) {
		
	}

//	private static void merge(int[] arr, int left,int mid, int right) {//0,3,6
//		
//		if(left<mid) {
//			merge(arr, left, (left+mid)/2, mid);//0,1,3  -> 0,0,1
//		} else {//0,0 - 1,1
//			
//		}
//		if(mid<right) { //3,6 -> 0,1
//			merge(arr, mid+1, (right+mid+1)/2, right); //4,5,6  - 1,1,1
//		} else { //1,1
//			
//		}
//
//	}
//
//	static void sort(int arr[], int l, int r) {
//		
//		int mid = (l + r) / 2;
////		System.out.println(mid);
//		merge(arr, l, mid, r);
//
//	}

}
