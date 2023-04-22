package crackingTheCode;

public class IntersectionOfArrays {

    public static void main(String[] args) {
        int[] array1 = {1,4,7,9,13};
        int[] array2 = {2,4,5,8,9,12};

        findIntersection(array1,array2);
    }

    // O(N^2) time complexity
    private static void findIntersection(int[] array1, int[] array2) {
        for(int i=0; i<array1.length; i++){
            for(int j=0; j<array2.length; j++){
                if(array1[i] == array2[j]){
                    System.out.print(array1[i]+",");
                }
            }
        }
    }

    int intersection(int[] a, int[] b) {
       // mergesort(b);
        int intersect = 0;
        for (int x : a) {
//            if (binarySearch(b, x) >= 0) {
//                intersect++;
//            }
        }
        return intersect;
    }
}
