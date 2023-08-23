/*
 * Q1. Sorted Insert Position (Day 52 Advance DSA Searching)
 * Problem Description
You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
Your solution should have a time complexity of O(log(N)).

Problem Constraints
1 <= N <= 106
1 <= A[i] <= 105
1 <= B <= 105

Input Format
The first argument is an integer array A of size N.
The second argument is an integer B.

Output Format
Return an integer denoting the index of target value.

Example Input
Input 1:
A = [1, 3, 5, 6]
B = 5 

Input 2:
A = [1, 4, 9]
B = 3

Example Output
Output 1:
2 
Output 2:
1

Example Explanation
Explanation 1:
The target value is present at index 2. 

Explanation 2:
The target value should be inserted at index 1.
 */

package searching;

class SortedInsertionPos{
    static int solve (int A[], int B){
        int n = A.length;
        int low = 0, high = n-1, mid = 0;

        while(low<=high){
            mid = low + (high-low)/2;

            if(A[mid] == B){
                return mid;
            }
            else if(A[mid] > B){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int A[] = {1, 3, 5, 6};
        System.out.println(solve(A, 8));
    }
}