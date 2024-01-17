/*
 * Q1. Evaluate Expression (Day 66 Adv DSA ) easy
 * Problem Description
An arithmetic expression is given by a string array A of size N. Evaluate the value of 
an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.

Problem Constraints
1 <= N <= 105

Input Format
The only argument given is string array A.

Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.

Example Input
Input 1:
A =   ["2", "1", "+", "3", "*"]

Input 2:
A = ["4", "13", "5", "/", "+"]

Example Output
Output 1:
9

Output 2:
6

Example Explanation
Explaination 1:
starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
    
Explaination 2:
starting from backside:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */
package stack;

import java.util.Stack;

public class EvaluateExpression {
    // improvise it
    static int solve(String A[]) {
        Stack<String> s = new Stack<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] == "*" || A[i] == "+" || A[i] == "-" || A[i] == "/") {
                String operator = A[i];
                int b = Integer.parseInt(s.peek());
                s.pop();
                int a = Integer.parseInt(s.peek());
                s.pop();
                int ans = 0;
                switch (operator) {
                    case "+":
                        ans = a + b;
                        break;
                    case "-":
                        ans = a - b;
                        break;
                    case "*":
                        ans = a * b;
                        break;
                    case "/":
                        ans = a / b;
                        break;
                }
                String temp = "" + ans;
                s.push(temp);
            } else {
                s.push(A[i]);
            }
        }
        return Integer.parseInt(s.peek());
    }

    public static void main(String[] args) {
        String s[] = { "2", "2", "*" };
        System.out.println(solve(s));
    }
}
