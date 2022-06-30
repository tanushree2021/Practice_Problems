package concepts;

import java.util.HashMap;

public class HashMapApp {

	static Object PRESENT = new Object();
	public static void main(String[] args) {
		HashMap<Integer, Object> map = new HashMap(); 
		System.out.println(map.put(1, PRESENT));
		System.out.println(map.put(1, PRESENT));
	}

}
