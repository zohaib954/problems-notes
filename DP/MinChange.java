/*
 * Get Change.
 * 
 * Given N and an array of coins[1,2,5,10,20,50,100], get the min number of coins as a change;
 */

package DP;

import java.util.Arrays;

public class MinChange {
    static int solve(int n, int A[], int dp[]) {
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int sp = 0;
        if (dp[n] != -1) {
            return dp[n];
        }
        for (int i = 0; i < A.length; i++) {
            if (n - A[i] >= 0) {

                sp = solve(n - A[i], A, dp);
                ans = Math.min(sp + 1, ans);

            }
        }
        dp[n] = ans;
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 9900;
        int A[] = { 100, 200, 500, 2000 };
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(solve(n, A, dp));
    }
}