/*
 * Given Array A pick the elements such that sum would be maximum and no
 * adjecent element can be picked.
 * 
 * for example:-
 * Input 1:- A[1,3,4,6];
 * Output :- 9
 * Explaination:- we pick 3 + 6 = 9 (adjecent elements of 3 and 6 could not be
 * picked, so that sum become maximum)
 * 
 * 
 * Input 2:- A[4,3,2,6];
 * Output :- 10
 * Explaination:- We pick 6 and 4 = 10
 */

package DP;

class MaxSum {
    static int solve(int A[]) {
        int n = A.length;
        if (n == 1) {
            return A[0];
        } else if (n == 2) {
            return Math.max(A[0], A[1]);
        }

        int dp[] = new int[n];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max((A[i] + dp[i - 2]), dp[i - 1]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
        return dp[n - 1];
    }

    static int solve2(int n, int A[]) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return A[0];
        }
        if (n == 2) {
            return Math.max(A[0], A[1]);
        }

        return Math.max(A[n - 1] + solve2(n - 2, A), solve2(n - 1, A));
    }

    public static void main(String[] args) {
        int A[] = { 3, 2, 1, 6, -5, 6, -10, 5 };
        int n = A.length;
        System.out.println(solve2(n, A));
    }
}