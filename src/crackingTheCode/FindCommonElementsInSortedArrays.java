package crackingTheCode;

import java.util.HashMap;
import java.util.Map;

public class FindCommonElementsInSortedArrays {

    public static void main(String[] args) {
        int[] A = {13, 27, 35, 40, 49, 55, 59};
        int[] B = {17, 35, 39, 40, 55, 58, 60};

        // Time: N logN, Space : O(1)
//        findingCommonElementsBinarySearch(A,B);

        // Time : (N) , Space O(N)
//        findingCommonElementsWithHashMap(A, B);

        // Time : (N) , Space O(1)
        findingCommonElementsBinarySearchOptimalSpace(A, B);

    }

    private static void findingCommonElementsBinarySearchOptimalSpace(int[] a, int[] b) {
        int startPoint = 0;
        for (int x : a) {
            int index = binarySearchOpt(x, b,startPoint);
            if (index>=0) {
                startPoint = index;
                System.out.println(x);
            }
        }
    }

    private static int binarySearchOpt(int x, int[] b, int startIndex) {
        int index = binarySearch(b, 0, b.length - 1, x);
        return index;
    }

    private static void findingCommonElementsWithHashMap(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            if (map.containsKey(x)) {
                System.out.println(x);
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (int y : b) {
            if (map.containsKey(y)) {
                System.out.println(y);
                map.put(y, map.get(y) + 1);
            } else {
                map.put(y, 1);
            }

        }
        System.out.println(map);
    }

    private static void findingCommonElementsBinarySearch(int[] a, int[] b) {
        for (int x : a) {
            if (binarySearch(x, b)) {
                System.out.println(x);
            }
        }
    }

    private static boolean binarySearch(int x, int[] b) {
        int index = binarySearch(b, 0, b.length - 1, x);
        return index >= 0;
    }

    private static int binarySearch(int[] arr, int low, int high, int x) {
        if (low == high) {
            if (arr[low] == x) return low;
            else return -1;
        }
        int mid = (low + high) / 2;
        if (x == arr[mid]) return mid;
        if (x < arr[mid]) {
            return binarySearch(arr, low, mid, x);
        } else {
            return binarySearch(arr, mid + 1, high, x);
        }
    }
}
