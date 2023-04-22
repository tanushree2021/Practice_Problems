package crackingTheCode;

public class PrintFibonacciSeries {

    public static void main(String[] args) {
        int n = 15;
        for(int i=0; i<n; i++){
            System.out.println(i+":"+allFib(i));
        }
    }

    static int allFib(int n){
        if(n<=0) return 0;
        else if (n==1) return 1;
        return allFib(n-1)+allFib(n-2);
    }
}
