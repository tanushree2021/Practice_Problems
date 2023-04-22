package amazon.OnlineTest_April2023;

import java.util.*;

public class ReviewStringMaxPoints {
    static int reviewMaxPoints = 0;

    public static void main(String[] args) {
        System.out.println("Review String and Prohibited Words given, cal review points...");
//        int totalTestCases = 3;
        Map<String, List<String>> inputMap = new LinkedHashMap<>();

        inputMap.put("FastDeliveryOkayProduct", Arrays.asList("eryOka", "yO", "eli")); // 11
        inputMap.put("FastDeliveryOkayProducts", Arrays.asList("eryOka", "kay", "eli")); // 9
        inputMap.put("ExtremeValueForMoney", Arrays.asList("tuper", "douche")); // 20
        inputMap.put("GoodProductButScrapAfterWash", Arrays.asList("crap", "odPro")); //15
        inputMap.put("FastDeliveryOkayProdu", Arrays.asList("eryOkayP", "yO", "eli")); // 9
        long startTime, totalTime=0;
        for (Map.Entry<String, List<String>> entry : inputMap.entrySet()) {
            String review = entry.getKey();
            startTime = System.currentTimeMillis();
            int result = measureMaxReviewPoints(review, entry.getValue());
            totalTime = System.currentTimeMillis() - startTime;
            System.out.printf("Points for review=%s, is=%d and time taken=%d seconds \n", review, result, totalTime);
        }
    }

    private static int measureMaxReviewPoints(String review, List<String> prohibitedWords) {
        int result = 0;
        boolean contains = false;
        Map<Integer, String> wordMap = new TreeMap<>();
        for (String words : prohibitedWords) {
            if (review.contains(words)) {
                wordMap.put(review.indexOf(words), words);
                contains = true;
            }
        }
        reviewMaxPoints = review.length();
        if (contains) {
            result = calculateMaxPoints(review, prohibitedWords, wordMap);
        } else {
            result = reviewMaxPoints;
        }
        return result;
    }

    private static int calculateMaxPoints(String review, List<String> prohibitedWords, Map<Integer, String> wordMap) {
        wordMap.put(0,null);
        wordMap.put(reviewMaxPoints,null);

        int maxPoints = 0;
        int pointer = 0;
        int start;
        int end;
//        int finalStart, finalEnd;
        for (Map.Entry<Integer, String> entry : wordMap.entrySet()) { //
            int localMaxPoints = 0;
            String value = entry.getValue();
            Integer key = entry.getKey(); //
            if(value == null && key==0){
                pointer = key;
                continue;
            } else if(value == null){
                end = key+1; //
            } else {
                //pointer = key+1;
                end = key + value.length()-1; //
            }
            start = pointer; //
            localMaxPoints = end - start; //
         //   System.out.printf("start=%d, end=%d, localMaxPoints=%d \n", start, end, localMaxPoints);
            if (localMaxPoints > maxPoints) {
                    maxPoints = localMaxPoints;
//                    finalStart = pointer;
//                    finalEnd = end;
            }
            pointer = key + 1; //
        }
        return maxPoints;
    }
}
/*
Solution

1. FastDeliveryOkayProduct , "eryOka", "yO", "eli"
    Max = 23
    "eryOka" -> 9,14
    "yO" -> 11,12
    "eli" -> 5,7
    0-----5==7----9===11=12==14------22

    Words: 0~6 = 7 (include both sides)
            6~13 = 8
            10~11 = 2
            12~22 = 11

        Maximum = 11

2. FastDeliveryOkayProducts , "eryOka", "kay", "eli"
    Max = 24
    "eryOka" -> 9,14
    "kay" -> 13,15
    "eli" -> 5,7
    0-----5==7----9======14
                      13===15------23

    Words: 0~6 = 7 (include both sides)
            6~13 = 8
            10~14 = 5
            14~22 = 9

        Maximum = 9

3. GoodProductButScrapAfterWash , "crap", "odPro"

    Max = 28
    "crap" -> 15,18
    "odPro" -> 2,6

    0--2====6--------15===18---------27

    Words: 0~5 = 6 (include both sides)
            3~17 = 15
            16~26 = 11

        Maximum = 15

4. FastDeliveryOkayProdu , "eryOkayP", "yO", "eli"
    Max = 21
    "eryOkayP" -> 9,16
    "yO" -> 11,12
    "eli" -> 5,7
    0-----5==7----9===11=12====16------20

    Words: 0~6 = 7 (include both sides)
            6~13 = 10 // 6~11 = 6
            10~11 = 2 // 12~15 = 4
            12~22 = 9

        Maximum = 9
 */