/*
 * Q1. Subarray with least average (Day 22)
 * Problem Description
Given an array A of size N, find the subarray of size B with the least average.



Problem Constraints
1 <= B <= N <= 105
-105 <= A[i] <= 105


Input Format
First argument contains an array A of integers of size N.
Second argument contains integer B.


Output Format
Return the index of the first element of the subarray of size B that has least average.
Array indexing starts from 0.


Example Input
Input 1:
A = [3, 7, 90, 20, 10, 50, 40]
B = 3
Input 2:

A = [3, 7, 5, 20, -10, 0, 12]
B = 2


Example Output
Output 1:
3
Output 2:

4


Example Explanation
Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average 
among all subarrays of size 3.
Explanation 2:

 Subarray between [4, 5] has minimum average
 */
package slidingWindow;

public class subArrayLeastAvg {
    static int solve(int A[], int B) {
        int n = A.length;
        int sum = 0, index = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        int minSum = sum;
        for (int i = B; i < n; i++) {
            sum += A[i] - A[i - B];
            if (sum < minSum) {
                minSum = sum;
                index = i - B + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int A[] = { 20, 8, 5, 9, 3, 100, 1, 2, 3 };
        int B = 4;
        System.out.println(solve(A, B));
    }
}
