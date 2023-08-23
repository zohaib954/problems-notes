/*
 * Q8. Pairs With Given Xor (Day 32 intermediate easy)
 * 
 * Problem Description
Given an integer array A containing N distinct integers.
Find the number of unique pairs of integers in the array whose XOR is equal to B.
NOTE:
Pair (a, b) and (b, a) is considered to be the same and should be counted once.

Problem Constraints
1 <= N <= 105
1 <= A[i], B <= 107

Input Format
The first argument is an integer array A.
The second argument is an integer B.

Output Format
Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.

Example Input
Input 1:
 A = [5, 4, 10, 15, 7, 6]
 B = 5

Input 2:
 A = [3, 6, 8, 10, 15, 50]
 B = 5

Example Output
Output 1:
 1

Output 2:
 2

Example Explanation
Explanation 1:
(10 ^ 15) = 5
Explanation 2:
 (3 ^ 6) = 5 and (10 ^ 15) = 5 
 */
package hashing;

import java.util.HashSet;

class PairsWithGivenXOR{
    static int solve(int A[], int B){
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        int n = A.length;

        for(int i=0; i<n; i++){
            if(hs.contains(A[i]^B)){
                ans++;
            }
            else{
                hs.add(A[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 10, 15, 7, 6};
         System.out.println(solve(arr, 10));

    }
}