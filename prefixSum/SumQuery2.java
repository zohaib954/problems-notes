/*
 * Q1. Range Sum - II
 * Problem Description
 * You are given an integer array A of size N. You need to perform Q queries on
 * the given array and return the final array after processing all the queries.
 * 
 * Each query is of the form (l, r, c), where l and r are indices (1-based)
 * representing a range in the array A, and c is an integer value.
 * 
 * For each query, you are required to add the value c to every element within
 * the range [l, r] (inclusive).
 * 
 * 
 * 
 * Problem Constraints
 * 1 <= N, Q <= 105
 * 
 * -106 <= A[i], c <= 106
 * 
 * 1 <= l <= r <= N
 * 
 * 
 * 
 * Input Format
 * First argument is an integer array A of size N.
 * 
 * Second argument is a 2d array B of size Q x 3, where B[i][0] = l, B[i][1] = r
 * and B[i][2] = c.
 * 
 * 
 * 
 * Output Format
 * Return the final array after processing all queries.
 * 
 * 
 * 
 * Example Input
 * Input 1:
 * 
 * A = [1, 2, 1, 4]
 * B = [
 * [2, 3, 2]
 * [1, 4, 5]
 * [4, 4, 1]
 * ]
 * Input 2:
 * 
 * A = [1, 1, 2]
 * B = [
 * [2, 3, 2]
 * [1, 3, 5]
 * ]
 * 
 * 
 * Example Output
 * Output 1:
 * 
 * [6, 9, 8, 10]
 * Output 2:
 * 
 * [6, 8, 9]
 * 
 * 
 * Example Explanation
 * Explanation 1:
 * 
 * First query, l = 2, r = 3, c = 2, after processing array becomes : [1, 4, 3,
 * 4]
 * Second query, l = 1, r = 4, c = 5, after processing array becomes : [6, 9, 8,
 * 9]
 * Third query, l = 4, r = 4, c = 1, after processing array becomes : [6, 9, 8,
 * 10]
 * Final array is [6, 9, 8, 10]
 * Explanation 2:
 * 
 * First query, l = 2, r = 3, c = 2, after processing array becomes : [1, 3, 4]
 * Second query, l = 1, r = 3, c = 5, after processing array becomes : [6, 8, 9]
 * Final array is [6, 8, 9]
 * 
 */

package prefixSum;

import java.util.Arrays;

class SumQuery2 {
    static int[] solve(int A[], int B[][]) {
        int n = A.length;
        int m = B.length;

        int pre[] = new int[n];
        for (int i = 0; i < m; i++) {
            int l = B[i][0], r = B[i][1], p = B[i][2];
            l--;
            r--;
            pre[l] += p;
            if (r < n - 1) {
                pre[r + 1] -= p;
            }
        }

        A[0] += pre[0];
        for (int i = 1; i < n; i++) {
            pre[i] += pre[i - 1];
            A[i] += pre[i];
        }

        return A;
    }

    public static void main(String[] args) {
        int A[] = { 1, 2, 1, 4 };
        int B[][] = { { 2, 3, 2 },
                { 1, 4, 5 },
                { 4, 4, 1 } };

        System.out.println(Arrays.toString(solve(A, B)));
    }
}