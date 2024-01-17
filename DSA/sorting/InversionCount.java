/*
 * Q1. Inversion count in an array (Day 49) imp
Problem Description
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

Problem Constraints
1 <= length of the array <= 105
1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return the number of inversions of A modulo (109 + 7).

Example Input
Input 1:
A = [1, 3, 2]

Input 2:
A = [3, 4, 1, 2]

Example Output
Output 1:
1

Output 2:
4

Example Explanation
Explanation 1:
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]

Explanation 2:
The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
 */

package sorting;

import java.util.Arrays;

class InversionCount {

    static int countInversion(int A[], int l, int r) {
        int count = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            count += countInversion(A, l, m);
            count += countInversion(A, m + 1, r);
            count += enhanceMerge(A, l, m, r);
        }
        return count;
    }

    static int enhanceMerge(int A[], int l, int m, int r) {
        int left[] = Arrays.copyOfRange(A, l, m + 1);
        int right[] = Arrays.copyOfRange(A, m + 1, r + 1);

        int n1 = left.length;
        int n2 = right.length;

        int i = 0, j = 0, k = l, swap = 0;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
                swap += (m + 1) - (l + i);
            }
        }
        while (i < n1) {
            A[k++] = left[i++];
        }
        while (j < n2) {
            A[k++] = left[j++];
        }
        return swap;
    }

    public static void main(String[] args) {
        int A[] = { 3, 4, 1, 2 };
        System.out.println(countInversion(A, 0, A.length - 1));
    }
}