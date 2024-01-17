/*
 * Q1. Search for a Range (Dat 52)
 * Problem Description
Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that 
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Your algorithm's runtime complexity must be in the order of O(log n).


Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].


Example Input
Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]


Example Explanation
Explanation 1:

 The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:

 There is no occurrence of 3 in the array.
 */
package searching;

public class SearchForRange {
    static int leftIndex(int A[], int key) {
        int n = A.length;
        int left = 0, right = n - 1;
        int mid, i = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid] == key) {
                i = mid;
                right = mid - 1;
            } else if (A[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return i;
    }

    static int rightIndex(int A[], int key) {
        int n = A.length;
        int left = 0, right = n - 1;
        int mid, i = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid] == key) {
                i = mid;
                left = mid + 1;
            } else if (A[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return i;
    }

    static int[] solution(int A[], int key) {
        int ans[] = new int[2];
        ans[0] = leftIndex(A, key);
        ans[1] = rightIndex(A, key);
        return ans;
    }
    //solve it in one function
    public static void main(String[] args) {
        int A[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6,
                6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8,
                8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10 };
        int[] ans = solution(A, 10);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
