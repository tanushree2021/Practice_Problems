package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Find Perfect Bags of Rice Grains
 * 
 * - At least 2 bags
 * - Rice Grains related like m*m = n
 * 
 * Input 1. [3,9,4,2,16]
 * 
 * Perfect Bags - [3,9], [4,2], [4,2,16]
 * Output - [4,2,16] - 3
 * 
 * Input 2. [625,4,2,5,25]
 * 
 * Perfect Bags - [625,5,25], [4,2]
 * Output - 3
 * 
 * Input 2. [6,4,8,7,9]
 * No Perfect Bags
 * Output - -1
 * 
 * Perfect Bags - [625,5,25], [4,2]
 * Output - 3
 * 
 *  Input 3. [6,4,8,36,3,81,7,9]  - 3,4,6,7,8,9,36,81
 *  Output - 3
 *  
 */
public class GroupOfRiceBags {

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(3, 9, 4, 2, 16); // 2,3,4,9,16
		input = Arrays.asList(625, 4, 2, 5, 25);
		int output = countPerfectRiceBags(input);
		System.out.println("Input - " + input + " Tested - " + (output == 3) + " ; count is " + output);
		
		input = Arrays.asList(6,4,8,7,9);
		output = countPerfectRiceBags(input);
		System.out.println("Input - " + input + " Tested - " + (output == -1) + " ; count is " + output);
		
		input = Arrays.asList(6,4,8,36,3,81,7,9);
		output = countPerfectRiceBags(input);
		System.out.println("Input - " + input + " Tested - " + (output == 3) + " ; count is " + output);
	}

	private static int countPerfectRiceBags(List<Integer> input) { // n3 time complexity
		int count = 0;
		int size = input.size();
		for (int i = 0; i < size; i++) { // n2 for sorting
			for (int j = 0; j < size - 1; j++) {
				if (input.get(j) > input.get(j + 1)) {
					int tmp = input.get(j);
					input.set(j, input.get(j + 1));
					input.set(j + 1, tmp);
				}
			}
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (Integer no : input) { // n for count
			List<Integer> listOfBags;
//			int sqkey = no * no;
			int sqrtKey = (int) Math.sqrt(no);
//			if (map.containsKey(sqkey)) {
//				listOfBags = map.get(sqkey);
//				listOfBags.add(no);
//				map.put(sqkey, listOfBags);
//			} else
			if (map.containsKey(sqrtKey)) {
				listOfBags = map.get(sqrtKey);
				listOfBags.add(no);
				map.remove(sqrtKey);
				map.put(no, listOfBags);
			} else {
				listOfBags = new ArrayList<Integer>();
				listOfBags.add(no);
				map.put(no, listOfBags);
			}
			int listSize = listOfBags.size();
			if (listSize > count) {
				count = listSize;
			}
		}
		return count == 0 || count==1? -1 : count;
	}

}
