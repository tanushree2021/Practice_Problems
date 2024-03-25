package crackingTheCode.Chapter2;

/*

Example: Given a smaller strings and a bigger string b, design an algorithm to find all permutations of the shorter string
within the longer one. Print the location of each permutation

s: abbc
b: cbabadcbbabbcbabaabccbabc
 */
public class PermutationsOfS_in_B {

    public static void main(String[] args) {
        String s = "abbc";
        String biggerString = "cbabadcbbabbcbabaabccbabc";
//        String biggerString = "cbaba";
        System.out.println("Smaller String is "+s);
        int sLen = s.length();
        int bLen = biggerString.length();
        int outerCount=0;
        int innerCount=0;
        for (int i = 0; i < bLen - sLen + 1 ; i++) {  // B time
            outerCount++;
            String tempStr = biggerString.substring(i, i + sLen);
            String firstS = biggerString.substring(i, i + 1);
            if (tempStr.equals(s)) {
                System.out.println("location is " + (i + 1)+" and permutation is "+tempStr);
            } else if(s.contains(firstS)) {
                int j = 0;
                boolean pExists = false;
                while (j != sLen) {
                    innerCount++;
                    String tempS = s.substring(j, j + 1);
                    if (tempStr.contains(tempS)) { // S time
                        tempStr = tempStr.replaceFirst(tempS, "");
                        pExists = true;
                    }
                    if (pExists) {
                        j++;
                        pExists = false;
                    } else break;
                }
                if (tempStr.isEmpty()) {
                    System.out.println("location is " + (i + 1)+" and permutation is "+biggerString.substring(i, i + sLen));
                }
            }
        }
        System.out.printf("OuterCount=%d, InnerCount=%d", outerCount, innerCount);
    }
}
