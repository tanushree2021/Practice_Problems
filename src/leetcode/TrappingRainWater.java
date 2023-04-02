package leetcode;

import java.util.Stack;

/*
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Given n non-negative integers representing an elevation map where the width of 
 * each bar is 1, compute how much water it can trap after raining.
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 
 * Output: 6
 * 
 * Explanation: The above elevation map (black section) is represented by array 
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are 
 * being trapped.
 * 
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int output;
		output = trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
//		System.out.println(output);
//		output = trap(new int[] { 4, 2, 0, 3, 2, 5 });
		System.out.println(output);
	}

	public static int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int trap = 0;
		int startWall = 0;
		for (int i = 0; i < height.length; i++) {
			if (stack.isEmpty() && height[i] == 0) {
				;
			} else if (!stack.isEmpty() && stack.peek() < height[i] && startWall != 0 && height[i] >= startWall) {
				int endWall = height[i];
				int maxWidth = endWall > startWall ? startWall : endWall;
				for (int j = 1; j < stack.size(); j++) {
					trap += maxWidth - stack.get(j);
				}
				stack.removeAllElements();
//				stack.add(endWall);
				stack.add(height[i]);
				startWall = height[i];
			} else {
				if (stack.isEmpty()) {
					startWall = height[i];
				}
				stack.add(height[i]);
			}
		}
		return trap;
	}

}
