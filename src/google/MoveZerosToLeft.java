package google;

/*
 * https://www.techiedelight.com/move-zeros-present-array-end/
 */
public class MoveZerosToLeft {

	public static void main(String[] args) {
		int[] input = { 1, 3, 0, 2, 0, 0, 11, 91, 0, 5 };
		
		int position = input.length - 1; // 0
		for (int i = input.length - 1; i >= 0; i--) { // 0, 1
			if (input[i] != 0) { // 1
				int temp = input[i]; // 1
				input[i] = input[position]; //
				input[position] = temp;
				position--;
			}
		}

//		zerosToStart_N_sq(input);
//		readWriteIndex(input);
		for (int j : input) {
			System.out.print(j + " ");
		}

	}

	private static void readWriteIndex(int[] input) {
		int write_index = input.length - 1;
		for (int read_index = input.length - 1; read_index >= 0; read_index--) {
			if (input[read_index] != 0) {
				input[write_index] = input[read_index];
				write_index--;
			}
		}
		while (write_index >= 0) {
			input[write_index] = 0;
			write_index--;
		}
	}

	private static void zerosToStart_N_sq(int[] input) {
		int position = 0;
		for (int i = 1; i < input.length; i++) { // 0 1 2 0
			if (input[i] == 0) {
				for (int k = i; k > position; k--) {
					input[k] = input[k - 1];
				}
				input[position] = 0;
				position++;
			}
		}
	}

}
