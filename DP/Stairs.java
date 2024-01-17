/*
 *  Q Stairs (Day 78)
 * Problem Description
You are climbing a staircase and it takes A steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Return the number of distinct ways modulo 1000000007



Problem Constraints
1 <= A <= 105



Input Format
The first and the only argument contains an integer A, the number of steps.



Output Format
Return an integer, representing the number of ways to reach the top.



Example Input
Input 1:

 A = 2
Input 2:

 A = 3


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

 Distinct ways to reach top: [1, 1], [2].
Explanation 2:

 Distinct ways to reach top: [1 1 1], [1 2], [2 1].
 */

package DP;

import java.util.Arrays;

public class Stairs {

    // recursive code TC:- O(2^N) SC:- O(N);
    static int solve(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return (solve(n - 1) + solve(n - 2)) % 1000000007;
    }

    // Top down Approach TC:- O(N) SC:- O(N);
    static int solve2(int n, int A[]) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        if (A[n] != -1) {
            return A[n];
        }
        A[n] = (solve2(n - 1, A) + solve2(n - 2, A) % 1000000007);
        return A[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int A[] = new int[n + 1];
        Arrays.fill(A, -1);
        System.out.println(solve2(n, A));
    }

}