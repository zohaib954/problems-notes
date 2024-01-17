/*
 * Q2. Redundant Braces (Day 66 ) easy
 * 
 * Problem Description
Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
Check whether A has redundant braces or not.
NOTE: A will be always a valid expression and will not contain any white spaces.

Problem Constraints
1 <= |A| <= 105

Input Format
The only argument given is string A.

Output Format
Return 1 if A has redundant braces else, return 0.

Example Input
Input 1:
 A = "((a+b))"

Input 2:
 A = "(a+(a+b))"

Example Output
Output 1:
 1

Output 2:
 0

Example Explanation
Explanation 1:
 ((a+b)) has redundant braces so answer will be 1.

Explanation 2:
 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.

 */
package stack;

import java.util.Stack;

public class RedundantBraces {
    static public int braces(String A) {
        int n = A.length();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char X = A.charAt(i);
            if (X == '+' || X == '-' || X == '*' || X == '/' || X == '(') {
                s.push(X);
            } else if (X == ')') {
                char top = s.peek();
                if (top == '(')
                    return 1;
                else {
                    while (s.peek() != '(') {
                        s.pop();
                        top = s.peek();
                    }
                    s.pop();
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "(a)";
        System.out.println(braces(s));
    }
}
