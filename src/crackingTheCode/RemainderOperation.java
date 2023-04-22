package crackingTheCode;

/*
Remainder % operation
a % b

 */
public class RemainderOperation {
    public static void main(String[] args) {
        remainder(2, 3);
        remainder(201, 3);
        remainder(201, 2);
        remainder(17, 3);
        remainder(39, 4);
        remainder(83, 7); // 7*11 = 77, 7:12=84
    }

    private static void remainder(int a, int b) {
        int result = mod(a, b);
        System.out.printf("%d %% %d = %d\n", a, b, result);
    }

    private static int mod(int a, int b) {
        int res = 0;
        if(b<=0){

        }
        else if (a < b) {
            res = a;
        } else {
            int temp = a / b;
           // System.out.println("temp="+temp);
            res = a - (temp * b);
        }
        return res;
    }

}
