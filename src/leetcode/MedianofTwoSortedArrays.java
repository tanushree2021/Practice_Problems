package leetcode;

/*
 * Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Input: nums1 - [], nums2 - [2,3]
stdout - 2.0 0.0
Median - 1.0

Output 1.00000
Expected 2.50000


Input [1], [2,3,4]
stdout 2.0 0.0
Median - 1.0

Output 1.00000
Expected 2.50000
 */
public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		double actualResult;
//		actualResult = findMedianSortedArrays(new int[] {1,3}, new int[] {2});
//		System.out.println("Test case passed ? "+(actualResult == 2.0));
		
//		actualResult = findMedianSortedArrays(new int[] {1,2}, new int[] {3,4});
//		System.out.println("Test case passed ? "+(actualResult == 2.5));
//		actualResult = findMedianSortedArrays(new int[] {}, new int[] {2,3});
//		System.out.println("Test case passed ? "+(actualResult == 2.5));
		actualResult = findMedianSortedArrays(new int[] {1}, new int[] {2,3,4});
		System.out.println("Test case passed ? "+(actualResult == 2.5));
		System.out.println(actualResult);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int lengthOfMergedArray=nums1.length+nums2.length;
		int mergedArr[] = new int[lengthOfMergedArray];
        double median=0;
        int m = nums1.length;//1
        int n = nums2.length;//3
//        if(m>=0 && m<=1000 && n>=0 && n<=1000 && m+n>=1 && m+n<=2000){}
        int i = 0,j=0;
        int k=0;
        while(i<m || j<n) { //i=0, j=0; 1<1, j=0
        	if(m==0){
                mergedArr[k]=nums2[j];
                j++;
            }else if(n==0){
                mergedArr[k]=nums1[i];
                i++;
            }else{
                 if(j==n) {
                    mergedArr[k]=nums1[i];
                    i++;
                } else if(i==m) {
                    mergedArr[k]=nums2[j];
                    j++;
                } else if(nums1[i]<nums2[j]) { 
                    mergedArr[k]=nums1[i];
                    i++;
                } else {
                    mergedArr[k]=nums2[j];
                    j++; 
                }   
            }
        	k++; 
        }
        
        if(lengthOfMergedArray%2==0) {
        	double m1 = mergedArr[(lengthOfMergedArray/2)-1];
        	double m2= mergedArr[lengthOfMergedArray/2];
        	System.out.println(m1 +" "+m2);
        	median = (m1+m2)/2;
        	System.out.println("Median - "+median);
        } else {
        	median = mergedArr[lengthOfMergedArray/2];
        	System.out.println("Median odd array- "+median);
        }
        return median;
    }

}
