package amazon.OnlineTest_April2023;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'countkSpikes' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int countkSpikes(List<Integer> prices, int k) {
    // Write your code here
    int result = 0;
    
 //   List<Integer>[] kLists = new ArrayList[2];
   // Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i =1; i<prices.size()-1; i++){
        int kElement = prices.get(i);
        List<Integer> lowerList = new ArrayList<>();
        List<Integer> higherList = new ArrayList<>();
        for(int j=0;j <prices.size(); j++){
            int current = prices.get(j);
            if(j<i && kElement > current){
                lowerList.add(current);
            } else if (j>i && current < kElement){
                higherList.add(current);
            }
        }
        if(!lowerList.isEmpty() && !higherList.isEmpty()){
            if(lowerList.size()==k || higherList.size()==k){
                result++;
            }
        }
    }
    return result;
    }

}

public class CountkSpikes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int pricesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> prices = IntStream.range(0, pricesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.countkSpikes(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
