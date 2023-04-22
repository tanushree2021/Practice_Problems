package crackingTheCode;

public class SumDigitsOfNumber {
    public static void main(String[] args) {
        sumInputDigits(187);
        sumInputDigits(17);
        sumInputDigits(1567);
        sumInputDigits(-7);
        sumInputDigits(9);
    }

    private static void sumInputDigits(int n) {
        int res = sumDigits(n);
        System.out.printf("Number=%d, Result=%d\n", n, res);
    }

    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
