package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class SortMapByValues {

	public static void main(String[] args) {
		int[] arr = {1,3,3,1,4,2,6,1,3,1,4};

		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			} else {
				map.put(i, 1);
			}
		}
		
		System.out.println(map);

		System.out.println("----------------");
//		Comparator<Entry<Integer, Integer>> comp = new Comparator() {
//
//			@Override
//			public int compare(Object o1, Object o2) {
//				Entry e1 =(Entry) o1;
//				Entry e2 = (Entry) o2;
//				Integer in1 =  (Integer) e1.getValue();
//				Integer in2 =  (Integer) e2.getValue();
//				return in1.compareTo(in2);
//			}
//
//		};
		
		List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());		
		list.sort(Entry.comparingByValue());
		list.forEach(System.out::println);
		
		System.out.println("After Sorting by value");
		Stream<Map.Entry<Integer, Integer>> sorted =
			    map.entrySet().stream()
			       .sorted(Map.Entry.comparingByValue());
		sorted.forEach(System.out::println);
	}

}
