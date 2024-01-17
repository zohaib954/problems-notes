/*
 * Q2. Find a peak element (Day 52)
 * Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
 */
package searching;

public class FindPeak {
    static int findminimum(int A[]) {
        int n = A.length;
        int left = 1, right = n - 2;
        int mid, ans = -1;

        if (n > 1 && (A[0] < A[1])) {
            return A[0];
        } else if (n > 1 && (A[n - 1] < A[n - 2])) {
            return A[n - 1];
        }

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid] <= A[mid - 1] && A[mid] <= A[mid + 1]) {
                return A[mid];
            } else if (A[mid] > A[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    static int findPeak(int A[]) {
        int n = A.length;
        int left = 1, right = n - 2, mid;

        if (n > 1 && (A[0] > A[1])) {
            return A[0];
        } else if (n > 1 && (A[n - 1] > A[n - 2])) {
            return A[n - 1];
        }

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]) {
                return A[mid];
            } else if (A[mid] < A[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        int A[] = { 22, 23, 16, 9, 21 };
        System.out.println(findPeak(A));

    }
}
