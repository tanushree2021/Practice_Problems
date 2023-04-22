package crackingTheCode;

public class PrintFibonacciSeriesOptimal {

    public static void main(String[] args) {
        int N = 8;
        int[] mem = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println(i + ":" + fib(i, mem));
        }
    }

    static int fib(int n, int[] mem) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        if (mem[n] > 0) return mem[n];
        mem[n] = fib(n - 1, mem) + fib(n - 2, mem);
        return mem[n];
    }

    /*
At each call to fib(i), we have already computed and stored the values for fib( i-1) and fib(i-2).
We just look up those values, sum them, store the new result, and return. This takes a constant amount of
time.
We're doing a constant amount of work N times, so this is O ( n) time.
This technique, called memoization, is a very common one to optimize exponential time recursive algorithms.
     */
}
