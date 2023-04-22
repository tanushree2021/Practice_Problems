package crackingTheCode;

public class FibonacciNumber {

    public static void main(String[] args) {
        int input = 8;
        System.out.println(fib(input));
    }

    private static int fib(int input) {
        if (input <= 0) return 0;
        else if (input == 1) return 1;
        return fib(input - 1) + fib(input - 2);
    }
}
