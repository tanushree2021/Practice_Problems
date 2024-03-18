package crackingTheCode;

public class IntersectionOfArrays {

    public static void main(String[] args) {
        int[] array1 = {1, 4, 7, 9, 13};
        int[] array2 = {2, 4, 5, 8, 9, 12};

        System.out.println("Interstion with n^2 = "+findIntersection(array1, array2));

        System.out.println("Intersection with nlogn = "+intersection(array1,array2));
    }

    // Brute Force: O(N^2) time complexity
    private static int findIntersection(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
//                    System.out.print(array1[i] + ",");
                    return ++i;
                }
            }
        }
        return -1;
    }

    // blogb + a logb
    static int intersection(int[] a, int[] b) {
        mergeSort(b);
        int intersect = 0;
        for (int x : a) {
            if (binarySearch(b, x) >= 0) {
                intersect++;
            }
        }
        return intersect;
    }

    private static void mergeSort(int[] b) {
        mergeSort(b, 0, b.length - 1);
    }

    // A = [ 2,1,8,3 ]
    private static void mergeSort(int[] A, int p, int r) {
        if (p == r) return;
        int q = (p + r) / 2;
        mergeSort(A, p, q);
        mergeSort(A, q + 1, r);
        merge(A, p, q, r);
    }

    private static void merge(int[] A, int p, int q, int r) {
        int l1 = q - p + 1;
        int l2 = r - q;
        int L[] = new int[l1];
        int R[] = new int[l2];
        for (int i = 0; i < l1; ++i)
            L[i] = A[p + i];
        for (int j = 0; j < l2; ++j)
            R[j] = A[j + q + 1];

        int leftP = 0;
        int rightP = 0;


        while (leftP != l1 || rightP != l2) {
            if (leftP != l1 && rightP == l2) {
                A[p] = L[leftP++];
            } else if (leftP == l1 && rightP != l2) {
                A[p] = R[rightP++];
            } else if (leftP != l1 && rightP != l2) {
                if (L[leftP] > R[rightP]) {
                    A[p] = R[rightP++];
                } else {
                    A[p] = L[leftP++];
                }
            }
            p++;
        }
    }

    static int binarySearch(int[] arr, int x) {
        int index = 0;
        index = search(arr, 0, arr.length - 1, x);
//        System.out.printf("Number %d found at index = %d \n", x, index);
        return index;
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
