package amazon.practiceTestsMarch_April;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * 
Sample Input 1 :
2
[()]{}{[()()]()}
[(])
Sample Output 1 :
Balanced
Not Balanced


 */

public class Valid_Parentheses {

	public static void main(String[] args) {
		System.out.println("Input total strings and the parenthesis String per loop : ");
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int j=0; j<T; j++){
            String st = sc.next();
            if(isValidParenthesis(st)){
                System.out.println("Balanced");
            } else {
                System.out.println("Not Balanced");
            }

        }

	}
public static boolean isValidParenthesis(String expression) {
        
        
        Map<Character,Character> pMap = new HashMap<>();

        pMap.put('(',')');
        pMap.put('[',']');
        pMap.put('{','}');

        Stack<Character> stack = new Stack<>();

        int i=0;
        int l = expression.length();
        for(;i<l;i++){ // [({})(){}]
           Character ch= expression.charAt(i);
          // System.out.println("Ch is "+ch);
           if(stack.isEmpty()){
               stack.push(ch); // [
           }
           else if(ch.equals(pMap.get(stack.peek()))){
               stack.pop(); // [ ( , [ , [  , [ , []
           } else {
               stack.push(ch); // [ ( { , [ (, [ {
           }
            //   System.out.println("Stack pushed and stack is "+stack);
        }
        System.out.println("Final Stack is "+stack);
        return stack.isEmpty();
    }

}
