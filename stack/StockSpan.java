/*
 * Stock span problem (Day 62) imp
 * problem description:- lets say an array is given, the elements represents are the stock price you have to give 
 * another array represnting the number of days stock is high.
 * example:- [100, 80, 60, 70, 60, 75, 85]
 *     ans:- [1,   1,  1,  2,  1,  4,  7 ]
 */
package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    static int[] solve(int A[]) {
        int n = A.length;
        Stack<Integer> s = new Stack<>();
        int span[] = new int[n];
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.empty() && A[i] >= s.peek()) {
                s.pop();
            }
            if (s.empty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
        }

        return span;
    }

    public static void main(String[] args) {
        int A[] = { 100, 80, 60, 70, 65, 40, 85 };
        System.out.println(Arrays.toString(solve(A)));
    }

}
