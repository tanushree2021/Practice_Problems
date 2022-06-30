package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Subsets {

	public static void main(String[] args) {
		List<Integer> inputList = Arrays.asList(5, 3, 2, 4, 1, 2);
		List<Integer> outputList = Arrays.asList(4, 5);
		List<Integer> actualOutput = null;

		testMaxWeightSubset(inputList, outputList);

		inputList = Arrays.asList(4, 2, 5, 1, 6);
		outputList = Arrays.asList(5, 6);

		testMaxWeightSubset(inputList, outputList);
		
		inputList = Arrays.asList(4, 2, 5, 1, 6);
		outputList = Arrays.asList(5, 6);

		testMaxWeightSubset(inputList, outputList);
	}

	private static void testMaxWeightSubset(List<Integer> inputList, List<Integer> outputList) {
		List<Integer> actualOutput;
		actualOutput = minimumCountMaxWeightSubset(inputList);
		System.out.println(
				inputList + " Test passed - " + outputList.equals(actualOutput) + " output is " + actualOutput);
	}

	private static List<Integer> minimumCountMaxWeightSubset(List<Integer> inputList) {
		int sum = 0;
		int wts = 0;
		int tempSum = 0;
		int maxCount = inputList.size() / 2;
		int arr[] = new int[inputList.size()];
		Queue<Integer> opList = new PriorityQueue();
		int k = 0;
		for (int wt : inputList) {
			arr[k] = wt;
			sum = sum + wt;
			k++;
		}

		int count;
		for (int i = 0; i < maxCount; i++) {// 4
			count = 0;
			for (int j = i + 1; j < arr.length; j++) {// 2,5,1,6
				if (arr[j] > arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;// 5,2,4 : 6,2,4,1,5 - 6,4,2,1,5 : 6,5,2,1,4 - 6,5,4,1,2
					count++;
				}
			}
			wts = wts + arr[i];
			opList.add(arr[i]);
			if (sum - wts < wts) {
				break;
			}
		}
		return new ArrayList<Integer>(opList);
	}

}
