/*
 * Q2. Activity Selection (Day 51)
 * 
 * Given two integer arrays A and B of size N.

There are N activities where A[i] denotes the start time of the ith activity and B[i] denotes the finish time of the
ith activity.
Your task is to select the maximum number of activities that can be performed by a single person, assuming that
a person can only work on a single activity at a time.

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format
Return the maximum number of activities that can be performed by a single person.

Constraints
1 <= N <= 100000
0 <= A[i] <= B[i] <= 2*10^9 

For Example
Input 1:
    A = [5, 1, 3, 0, 5, 8]
    B = [9, 2, 4, 6, 7, 9]

Output 1:
    4
Explanation 1:
        Activites 2, 3, 5 and 6 can be selected (1- based indexing).

Input 2:
    A = [17, 8, 14, 24, 10, 8, 1, 30]
    B = [18, 45, 24, 27, 18, 10, 38, 35]
    
Output 2:
    4
 */
package sorting;

import java.util.Arrays;

public class ActivitySelection {

    static void swap(int A[], int B[], int i, int j) {
        int temp1 = A[i];
        A[i] = A[j];
        A[j] = temp1;

        int temp2 = B[i];
        B[i] = B[j];
        B[j] = temp2;
    }

    static int partition(int A[], int B[], int s, int e) {
        int p = B[e];
        int i = s - 1;
        for (int j = s; j < e; j++) {
            if (B[j] < p) {
                i++;
                swap(A, B, i, j);
            }
        }
        i++;
        swap(A, B, i, e);
        return i;
    }

    static void quickSort(int A[], int B[], int s, int e) {
        if (s >= e) {
            return;
        }
        int p = partition(A, B, s, e);
        quickSort(A, B, s, p - 1);
        quickSort(A, B, p + 1, e);
    }

    public static void main(String[] args) {
        int A[] = { 17, 8, 14, 24, 10, 8, 1, 30 };
        int B[] = { 18, 45, 24, 27, 18, 10, 38, 35 };
        int n = A.length;
        quickSort(A, B, 0, n - 1);
        int end = B[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] >= end) {
                count++;
                end = B[i];
            }
        }
        System.out.println(count);

        System.out.println(Arrays.toString(B));
        System.out.println(Arrays.toString(A));
    }
}
