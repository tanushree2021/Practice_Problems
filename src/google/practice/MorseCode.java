package google.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MorseCode {

	public static void main(String[] args) throws IOException {
		String input;
		boolean isLoopRunning = true;
		while (isLoopRunning) {
			BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Morse Code : ");
			input = bfn.readLine();
			if (input.equals("stop")) {
				isLoopRunning = false;
				System.out.println("\nProgram Stopped..");
			} else {
				try {
					isMorseCode(input);
				} catch (Exception e) {
					System.out.println("\nNot an valid input.. Try Again.. To stop, type \"stop\"\n");
				}
			}
		}
	}

	private static void isMorseCode(String input) {
//		input=".-";
		int invalidCount = 0;
		if (input.indexOf(".")==0 && input.lastIndexOf("-")==(input.length()-1)) {
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '.' && input.charAt(i + 1) != '-') {
					invalidCount++;
					break;
				}
			}
			if (invalidCount == 0) {
				System.out.println("Given input String " + input + " is Morse Code...");
			} else {
				System.out.println("Given input String " + input + " Not Morse Code");
			}
		} else {
			System.out.println("Given input String " + input + " is not Morse Code...");
		}

	}
}
