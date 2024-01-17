/*
 * Q4. Search in Bitonic Array! (Day 52 advance DSA searching )
 * 
 * Problem Description
Given a bitonic sequence A of N distinct elements, write a program to find a given element B
 in the bitonic sequence in O(logN) time.
NOTE:
A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

Problem Constraints
3 <= N <= 105
1 <= A[i], B <= 108

Given array always contain a bitonic point.
Array A always contain distinct elements.

Input Format
First argument is an integer array A denoting the bitonic sequence.

Second argument is an integer B.
Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.

Example Input
Input 1:
 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20

Input 2:
 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30

Example Output
Output 1:
 3

Output 2:
 -1

Example Explanation
Explanation 1:
 B = 20 present in A at index 3

Explanation 2:
 B = 30 is not present in A

 Solution approach:-
 -> find the peak element in the array and search for B element from left of the peak element including peak, and right of the element.

 */
package searching;

public class BitonicArray {
    public static int solve(int A[], int B){
        int n = A.length;
        int low = 0, high = n-1, mid = 0, peak = -1;
        //first find the peak element or peak position
        while(low<=high){
            mid = (low+high)/2;
            if(A[mid] > A[mid-1] && A[mid] > A[mid+1]){
                peak = mid;
            }
            else if(A[mid] < A[mid-1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        //now search for B in left side of peak element.
        int l1 = 0, h1 = peak;
        while(l1<=h1){
            mid = (l1+h1)/2;
            if(A[mid] == B){
                return mid;
            }
            else if(A[mid] > B){
                h1 = mid-1;
            }
            else{
               l1 = mid+1; 
            }
        }

        // if the B element not present in left side then it is definetly on right side,
        // search B in right side.
        int l2 = peak+1, h2 = n-1;
        while(l2<=h2){
            mid = (h2+l2)/2;
            if(A[mid] == B){
                return mid;
            }
            else if(A[mid] > B){
                low = mid+1;
            }
            else high = mid-1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = {3, 9, 10, 20, 17, 5, 1};
        System.out.println(solve(A,20));







    }
}
