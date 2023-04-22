package crackingTheCode;

public class PermutationsOfString {

    public static void main(String[] args) {
        String input = "car";
        permutation(input);

    }

    static void permutation(String str) {
        permutation(str, "");
    }

    static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1); // car -> i=0, ar ; ar -> i=0, r; r-> i=0 == car; ar -> i=1, a ; a-> i=0 == cra
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
