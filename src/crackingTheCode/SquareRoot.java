package crackingTheCode;

public class SquareRoot {
    public static void main(String[] args) {
        findSqRt(36);
        findSqRt(46);
        findSqRt(81);
    }

    private static void findSqRt(int n) {
        int res = sqrt_helper(n, 1, n);
        System.out.printf("Square Root of %d is %d\n",n, res);
    }

    private static int sqrt_helper(int n, int min , int max) {
        if(max < min) return -1;
        int guess = (min+max)/2;
       // System.out.println("guess="+guess);
        if(guess*guess==n){ return  guess;}
        else if(guess*guess<n){
            return sqrt_helper(n, guess+1, max);
        }
        else {
            return sqrt_helper(n, min, guess-1);
        }

    }
}
