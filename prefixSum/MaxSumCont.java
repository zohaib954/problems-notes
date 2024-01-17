/*
 * Q5. Max Sum Contiguous Subarray Day (44 Adv DSA);
 * Problem Description
Find the maximum sum of contiguous non-empty subarray within an array A of length N.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000



Input Format
The first and the only argument contains an integer array, A.



Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.



Example Input
Input 1:

 A = [1, 2, 3, 4, -10] 
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 


Example Output
Output 1:

 10 
Output 2:

 6 


Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6. 

 */
package prefixSum;

public class MaxSumCont {
    static int solve(int A[]) {
        int n = A.length;
        int currentSum = 0, maxSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += A[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int A[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solve(A));
    }
}
