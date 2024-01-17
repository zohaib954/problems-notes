/*
 * Q1. Fibonacci Number (Adv DSA Day 78)
 * 
 Problem Description
Given a positive integer A, write a program to find the Ath Fibonacci number.

In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.

NOTE: 0th term is 0. 1th term is 1 and so on.



Problem Constraints
0 <= A <= 44



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the Ath Fibonacci number.



Example Input
Input 1:

 A = 4
Input 2:

 A = 6


Example Output
Output 1:

 3
Output 2:

 8


Example Explanation
Explanation 1:

 Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 0th term is 0 So, 4th term of Fibonacci series is 3. 
Explanation 2:

 6th term of Fibonacci series is 8.
 */

package DP;

import java.util.Scanner;

class FindFibbonachi {

    // Top down Approach TC :- O(N+N-1) => O(N), SC :- O(N)
    static int findFibb(int n, int A[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (A[n] != -1) {
            return A[n];
        }

        A[n] = (findFibb(n - 1, A) + findFibb(n - 2, A));
        return A[n];
    }

    // Bottom up approach TC :- O(N), SC :- O(N)
    static int[] findFibbonachi(int n, int[] A) {

        for (int i = 2; i <= n; i++) {
            int prev1 = A[i - 2];
            int prev2 = A[i - 1];
            A[i] = prev1 + prev2;
        }

        return A;
    }

    // Bottom up Approach without using extra space TC :- O(N) SC :- O(1);
    static int fibb(int n) {
        int ans = 0;
        int prev1 = 0;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            ans = prev1 + prev2;
            prev1 = prev2;
            prev2 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = s.nextInt();
        System.out.println(fibb(n));
        s.close();

    }
}