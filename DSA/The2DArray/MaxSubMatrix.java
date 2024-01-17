/*
 * Q3. Maximum Submatrix (Day 42)
 * Problem Description
 * Given a matrix A of size NxM, which is row-wise and column-wise sorted. Find
 * a submatrix such that sum of its elements is maximum and return this sum.
 * 
 * 
 * Problem Constraints
 * 1 <= N, M <= 103
 * -105 <= A[i][j] <= 105
 * 
 * 
 * Input Format
 * First argument A is an matrix of integers.
 * 
 * 
 * Output Format
 * Return an integer value which is maximum submatrix sum
 * 
 * 
 * Example Input
 * Input 1:
 * 
 * A = [[6, 8, 10, 11],
 * [10, 11, 12, 15]]
 * Input 2:
 * 
 * A = [[-8, 1, 1],
 * [-1, 6, 6],
 * [7, 10, 10]]
 * 
 * 
 * Example Output
 * Output 1:
 * 
 * 83
 * Output 2:
 * 
 * 38
 * 
 * 
 * Example Explanation
 * Explanation 1:
 * 
 * Since all values in the matrix are positive integers, their sum is taken
 * which is 83.
 * Explanation 2:
 * 
 * Max sum is found in submatrix from [1, 0] to [2, 2].
 */

package The2DArray;

class MaxSubMatrix {
    static long solve(int A[][]) {
        int n = A.length;
        int m = A[0].length;

        long pre[][] = new long[n][m];
        long ans = A[n - 1][m - 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    pre[i][j] = A[i][j];
                } else if (i == n - 1) {
                    pre[i][j] = pre[i][j + 1] + A[i][j];
                } else if (j == m - 1) {
                    pre[i][j] = pre[i + 1][j] + A[i][j];
                } else {
                    pre[i][j] = pre[i][j + 1] + pre[i + 1][j] - pre[i + 1][j + 1] + A[i][j];
                }
                ans = Math.max(ans, pre[i][j]);
            }
        }
        return ans;
    }
}