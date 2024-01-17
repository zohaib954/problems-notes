/*
 * Q1. Single Element in Sorted Array (Day 53)
 * Problem Description
Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

Elements which are appearing twice are adjacent to each other.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the single element that appears only once.



Example Input
Input 1:

A = [1, 1, 7]
Input 2:

A = [2, 3, 3]


Example Output
Output 1:

 7
Output 2:

 2


Example Explanation
Explanation 1:

 7 appears once
Explanation 2:

 2 appears once

 */
package searching;

public class SingleElement {
    // we can solve this question by using XOR bit manupulation technique and also
    // binary search technique
    // below is the binary search technique;
    static int solve(int A[]) {
        int n = A.length;
        int ans = 0;
        int left = 1, right = n - 2, mid = 0;
        if (A[0] != A[1]) {
            return A[0];
        } else if (A[n - 1] != A[n - 2]) {
            return A[n - 1];
        }

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid] != A[mid + 1] && A[mid] != A[mid - 1]) {
                return A[mid];
            } else if (A[mid] == A[mid - 1]) {
                mid = mid - 1;
            }

            if (mid % 2 == 0) {
                left = mid + 2;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A[] = { 1, 1, 3, 3, 5, 5, 7, 7, 8, 10, 10, 12, 12 };
        System.out.println(solve(A));

    }
}
