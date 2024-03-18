package crackingTheCode.Chapter2;

public class CheckBinaryWithHexadecimal {

    public static void main(String[] args) {
        System.out.println("Edge Cases");
        checkIfBinaryEqualsHex(" 0,1", "9");
        checkIfBinaryEqualsHex("8p1", "34");

        System.out.println("Normal Cases");
        checkIfBinaryEqualsHex("10101", "15");
        checkIfBinaryEqualsHex("101011", "2B");
        checkIfBinaryEqualsHex("101011", "2A");


//        System.out.println(pow(2,4));
//        int no = 'A';
//        System.out.println(String.valueOf('0'));
//       int no = 'B';
//        System.out.println(no);
    }

    private static void checkIfBinaryEqualsHex(String binary, String hex) {
        boolean isBinaryEqualsHex = compareBinToHex(binary, hex);
        System.out.printf("Binary=%s, HexaDecimal=%s are equal=%b \n", binary, hex, isBinaryEqualsHex);
    }

    private static boolean compareBinToHex(String binary, String hex) {
        int nl = convertFromBase(binary, 2);
        int n2 = convertFromBase(hex, 16);
        if (nl < 0 && n2 < 0) {
            return false;
        }
        return nl == n2;
    }

    private static int convertFromBase(String givenNo, int base) {
        if (base < 2 || (base > 10 && base != 16)) return -1;
        int len = givenNo.length();
        int decimal = -1;

        for (int i = len - 1; i >= 0; i--) {
            char numberCharacter = givenNo.charAt(i);
//            Integer no = getDigit(base, numberCharacter);
            Integer no = getDigit(numberCharacter);
            if (no == -1) return -1;
            if (no == -2) return -2;
            if (no == 0) {
                continue;
            }
            decimal += pow(base, len - 1 - i) * no;
        }
        return decimal;
    }

    private static Integer getDigit(char numChar) {
        int output = -1;
        if(numChar >= 65 && numChar <= 70){
            output = numChar-55;
        } else if(numChar < 48 || numChar > 57 || numChar > 70){
            output = -2;
        } else {
            output = Integer.parseInt(String.valueOf(numChar));
        }
        return output;
    }

    private static Integer getDigit(int base, char charAt) {
        int no = -1;
        if (base == 2) {
            no = Integer.parseInt(String.valueOf(charAt));
            if (no == 0 || no == 1) {

            } else {
                return null;
            }
        } else if (base == 16) {
            int ascii = charAt;
            if (ascii >= 65 && ascii <= 70) {
                no = ascii - 55;
            } else if (ascii >= 70) {
                return null;
            } else {
                char ch = charAt;
                no = Integer.parseInt(String.valueOf(ch));
            }
        }
        return no;
    }

    private static int pow(int no, int times) {
        if (times == 0)
            return 1;
        return no * pow(no, times - 1);
    }
}
