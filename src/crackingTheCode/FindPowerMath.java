package crackingTheCode;

public class FindPowerMath {
    public static void main(String[] args) {
        findPow(2,3);
        findPow(4,3);
        findPow(7,0);
        findPow(7,-5);
        findPow(7,3);
        findPow(6,3);
    }

    private static void findPow(int a, int b) {
        int result = power(a, b);
        System.out.printf("a=%d, b=%d, a to the power b, result=%d \n", a,b, result);
    }

    private static int power(int a, int b) {
        if (b < 0) {
            return 0;
        } else if (b == 0) return 1;
        return a * power(a, b - 1);
    }
}
