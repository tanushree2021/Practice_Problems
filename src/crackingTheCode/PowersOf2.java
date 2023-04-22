package crackingTheCode;

public class PowersOf2 {

    public static void main(String[] args) {
        int N = 9;
        findPowersOf2(N);
        N=4;
        findPowersOf2(N);
        N = 19;
        findPowersOf2(N);
        N= 14;
        findPowersOf2(N);
        N= -14;
        findPowersOf2(N);
    }

    private static void findPowersOf2(int n) {
        System.out.println("Powers of 2 for "+n);
        if(n<1){
            System.out.print(0);
        }
        else {
            int max = (int) (Math.log(n) / Math.log(2));
//            System.out.println("Max = "+max);
            if(n>=1){
                System.out.print(1+",");
            }

            for (int i = 1; i <= max; i++) {
                int val = (int) Math.pow(2,i);
                if(val%2 == 0){
                    System.out.print(val+",");
                }
            }
        }
        System.out.println();
    }
}
