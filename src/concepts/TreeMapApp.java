package concepts;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        Map<Integer, String> wordMap = new TreeMap<>(Collections.reverseOrder());

        wordMap.put(2,"To");
        wordMap.put(5,"Five");
        wordMap.put(3,"the");
        wordMap.put(7,"Seven67");

        System.out.println(wordMap);

        Map<String,Integer> numberMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });


    }
}
