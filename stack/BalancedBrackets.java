/*
 * Q2. Balanced Paranthesis (Day 66 ) easy
 * Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Refer to the examples for more clarity.

Problem Constraints
1 <= |A| <= 100

Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.

Output Format
Return 0 if the parenthesis sequence is not balanced.
Return 1 if the parenthesis sequence is balanced.

Example Input
Input 1:
 A = {([])}
 
Input 2:
 A = (){

Input 3:
 A = ()[] 

Example Output
Output 1:
 1 

Output 2:
 0 

Output 3:
 1 

Example Explanation
You can clearly see that the first and third case contain valid paranthesis.
In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
 */
package stack;

import java.util.Stack;

// try solving by using hashmap and stack
public class BalancedBrackets {

    // solution using stack and if else
    static int solve(String A) {
        int n = A.length();
        Stack<Character> s = new Stack<>();

        char x = A.charAt(0);

        // if any bracket starting with closing bracket then it is definetly not
        // balanced
        if (x == '}' || x == ']' || x == ')') {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            x = A.charAt(i);
            // if brackets are opening brackets then we push the character into stack.
            if (x == '{' || x == '[' || x == '(') {
                s.push(x);
            }
            // if it is closing bracket and the peek element in stack is opening then we pop
            // the peek element
            // because its balanced.
            else if ((x == '}' && s.peek() == '{') ||
                    (x == ']' && s.peek() == '[') ||
                    (x == ')' && s.peek() == '(')) {
                s.pop();
            }
            // else peek element is not opening bracket brackets are not balanced.
            else {
                return 0;
            }
        }

        // if there is any character present in a stack then brackets are not balanced
        if (!s.empty()) {
            return 0;
        }
        // finally if stack is empty then it is known that brackets are balanced
        return 1;
    }

    public static void main(String[] args) {
        // balanced bracket string returns 1.
        String s = "{([{[[]]}])}";
        System.out.println(solve(s));

        // unbalanced bracket string returns 0.
        String s2 = "{[({})]";
        System.out.println(solve(s2));
    }
}
