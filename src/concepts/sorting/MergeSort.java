package concepts.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 8, 3};
        sortUsingMergeSort(arr);

        arr = new int[]{2, 1, 5, 4, 9, 8, 3, 7};
        sortUsingMergeSort(arr);

        arr = new int[]{9, 8, 7, 6, 5};
        sortUsingMergeSort(arr);

        arr = new int[]{1, 4, 7, 9, 13};
        sortUsingMergeSort(arr);

        arr = new int[]{2, 4, 5, 8, 9, 12};
        sortUsingMergeSort(arr);
    }

    public static void sortUsingMergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        for (int no : arr) {
            System.out.print(no + " ");
        }
        System.out.println();
    }

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

}
