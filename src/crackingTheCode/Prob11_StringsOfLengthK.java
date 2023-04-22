package crackingTheCode;

/*
Prints all strings of length k where the characters are in sorted order
 */
public class Prob11_StringsOfLengthK {

    static int numChars = 26;
    static int count = 0;
    static int inOrderCount = 0;

    public static void main(String[] args) {
        printSortedStrings(1);
        printSortedStrings(2);
        printSortedStrings(3);
        printSortedStrings(4);

    }

    static void printSortedStrings(int remaining) {
        count=0;
        inOrderCount=0;
        printSortedStrings(remaining, "");
        int totalCount = count+inOrderCount;
        System.out.printf("Total Count when N is %d : %d(count) + %d(innerCount) = %d \n", remaining,
                count, inOrderCount,totalCount);
//        System.out.printf("InOrderCount for remaining %d is %d\n", remaining, inOrderCount);
    }

    static void printSortedStrings(int remaining, String prefix) {

        if (remaining == 0) {
            inOrderCount++;
            if (isinOrder(prefix)) {
//                System.out.println(prefix);
            }
        } else {
            count++;
            for (int i = 0; i < numChars; i++) {
                char c = ithLetter(i);
                printSortedStrings(remaining - 1, prefix + c);
            }
        }
    }

    static boolean isinOrder(String s) {

        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
    }

    static char ithLetter(int i) {
        return (char) (((int) 'a') + i);
    }
}

