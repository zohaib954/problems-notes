/*
 * Q2. Rotated Sorted Array Search (Day 53)
 * Problem Description
Given a sorted array of integers A of size N and an integer B, 
where array A is rotated at some pivot unknown beforehand.

For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].

Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.

You can assume that no duplicates exist in the array.

NOTE: You are expected to solve this problem with a time complexity of O(log(N)).


Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 109
All elements in A are Distinct.


Input Format
The First argument given is the integer array A.
The Second argument given is the integer B.


Output Format
Return index of B in array A, otherwise return -1


Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4 
Input 2:

A : [ 9, 10, 3, 5, 6, 8 ]
B : 5


Example Output
Output 1:

 0 
Output 2:

 3


Example Explanation
Explanation 1:

Target 4 is found at index 0 in A. 
Explanation 2:

Target 5 is found at index 3 in A.

 */
package searching;

public class RotatedArray {
    static int pivotPoint(int A[]) {
        int n = A.length;
        int left = 0, right = n - 1, mid;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                return A[mid];
            } else if (A[mid] > A[left] && A[mid] > A[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return ans;
    }

    static int indxOf(int A[], int B) {
        int n = A.length;
        if (n == 1 && A[0] == B) {
            return 0;
        }
        int left = 0, right = n - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            System.out.println(A[mid]);
            if (A[mid] == B) {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = { 180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5,
                6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51,
                52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101,
                102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130,
                135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171,
                172, 173, 174, 175, 176, 177 };
        int B = 42;
        System.out.println(indxOf(A, B));
    }
}
