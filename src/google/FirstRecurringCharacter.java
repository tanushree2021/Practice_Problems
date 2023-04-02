package google;

import java.util.HashMap;
import java.util.Map;

/*
 * ABCA -> A
 * BCABA -> B
 * DBCABA -> B
 * ABC -> 'None'
 * ABHKBAC -> B
 * 
 * O(n) -> Big O on N - N is the number of characters in the string
 * N time complexity
 */
public class FirstRecurringCharacter {

	public static void main(String[] args) {
		String input = "ABCA";
		String in1 = "BCABA";
		String in2 = "DBCABA";
		String in3 = "ABC";
		String in4 = "ABHKBAC";
		
		getFirstRecurringCharacter(input);
		getFirstRecurringCharacter(in1);
		getFirstRecurringCharacter(in2);
		getFirstRecurringCharacter(in3);
		getFirstRecurringCharacter(in4);
	}

	private static void getFirstRecurringCharacter(String input) {
		System.out.print("input is "+input+" - ");
		char[] charactors = input.toCharArray();
		Map<Character, Integer> charMap = new HashMap<>();
		int temp=0;
		for(int i=0; i<charactors.length;i++) {
			if(charMap.containsKey(charactors[i])) {
				System.out.println(" first recurring charater is "+charactors[i]);
				temp++;
				break;
			}else {
				charMap.put(charactors[i], 1);
			}
		}
		if(temp==0) {
			System.out.println(" no recurring character..");
		}
	}

}
