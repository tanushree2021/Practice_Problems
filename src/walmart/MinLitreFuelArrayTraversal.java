package walmart;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * A matrix of size m*n where each element is a pair of (int,array).
int is the fuel needed to go through this stop, and array is the fuel 
needed to go to different locations in immediate next row.

1 2 3 4(int, List<int>)
3 2 4 5
1 7 4 8
3 2 4 1

1
| \ \ \
3 2 4 5

Fuel array => Array(3, 2, 4, 5)

  2
/ | \ \
1 7 4 8

Cost array => Array(7, 12, 11, 16)

Aim: Find the minimum litre of fuel needed to reach from first row to last row (any column)

 */
public class MinLitreFuelArrayTraversal {

	public static void main(String[] args) {
		Map<Integer, Integer[]>[][] array = new LinkedHashMap[4][4];
		

	}

}
