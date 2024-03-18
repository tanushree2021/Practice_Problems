package concepts.binarySearch;

import static concepts.sorting.MergeSort.sortUsingMergeSort;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = null;
        arr = new int[]{2, 1, 8, 3};
        sortUsingMergeSort(arr);
        binarySearch(arr, 4);
        binarySearch(arr, 8);

        arr = new int[]{2, 1, 5, 4, 9, 8, 3, 7};
        sortUsingMergeSort(arr);
        binarySearch(arr, 4);
    }

    // Using Recursive method that uses divide and conquer approach
    static void binarySearch(int[] arr, int x) {
        int index = 0;
        index = search(arr, 0, arr.length - 1, x);
        System.out.printf("Number %d found at index = %d \n", x, index);
    }

    private static int search(int[] arr, int low, int high, int x) {
        if (low == high) {
            if (arr[low] == x) return low;
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == x) return mid;
        else if (x < arr[mid]) {
            return search(arr, low, mid, x);
        } else {
            return search(arr, mid + 1, high, x);
        }
    }
}
