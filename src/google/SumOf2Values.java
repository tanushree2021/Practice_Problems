package google;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SumOf2Values {

	public static void main(String[] args) {
		Integer[] values = {4,2,6,8,3,1,9,0};
		int sum = 9;
		System.out.println("Pairs are - ");//1 8; 6 3; 9 0
		
//		sumOf2ValuesNSq(values, sum);
//		Map<Integer, Integer> map = new HashMap();
		Set<Integer> set = new TreeSet<>(Arrays.asList(values));
		int count=0;
		for(int i =0;i<set.size()/2;i++) {
			if(set.contains(sum-i)) {
//				System.out.println(i+"-"+(sum-i));
				count++;
			}
		}
		System.out.println(count);
	}

	private static void sumOf2ValuesNSq(Integer[] values, int sum) {
		for(int i=0; i<values.length;i++) {
			for(int j=i+1; j<values.length; j++) {
				if(sum == (values[j]+values[i])) {
					System.out.println(values[i]+"-"+values[j]+" ");
				}
			}
		}
	}
}
