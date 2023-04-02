package treesInterview;

public class Test {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int n = (int) (Math.random() * 10);
			System.out.println(n + " -  " + (n & 1));
		}
	}

}
