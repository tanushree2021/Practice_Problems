package crackingTheCode.Chapter2;

public class MedianOfExpandingArray {

    public static void main(String[] args) {
//        fixedLenAvgOfArray();
        int[] inArr = {4,9,1,6,3,5,8,2,7,10};
        int N = inArr.length;
        for(int i =0; i<N; i++){}
    }

    private static void fixedLenAvgOfArray() {
        int len = 0;
        while(len<=0){
            len = (int) (10*Math.random());
        }
        System.out.println(len);
        int[] expanArr = new int[len];
        double average = 0;
        float total = 0;
        for(int i = 0; i<len; i++){
            int rand = (int) (10*Math.random());
            expanArr[i] = rand;
            total += rand;
            average = total/(i+1);
            System.out.printf("random=%d, Avg=%4.3f\n", rand, average);
        }
    }
}
