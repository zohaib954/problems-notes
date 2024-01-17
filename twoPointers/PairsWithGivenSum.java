/*
 * Q1. Pairs with given sum II (Day 58)
 * Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:

A = [1, 5, 7, 10]
B = 8


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 There are 3 pairs.
Explanation 2:

 There is only one pair, such that i = 0, and j = 2 sums up to 8.

 */
package twoPointers;

class PairsWithGivenSum {
    static int[] findFreq(int A[], int k, int i, int j, char dir) {
        int arr[] = new int[2];
        int freq = 0;

        if (dir == 'l') {
            while (i <= j && A[i] == k) {
                freq++;
                i++;
            }
            arr[0] = i;
        } else if (dir == 'r') {
            while (j >= i && A[j] == k) {
                freq++;
                j--;
            }
            arr[0] = j;
        }
        arr[1] = freq;
        return arr;
    }

    static int solve(int A[], int B) {
        int n = A.length;
        int s = 0, e = n - 1;
        int count = 0;
        while (s < e) {
            int sum = A[s] + A[e];
            if (sum == B) {
                int left = A[s], right = A[e];
                if (left == right) {
                    int temp = e - s + 1;
                    count += temp * (temp - 1) / 2;
                    break;
                } else {
                    int freqL = findFreq(A, left, s, e, 'l')[1];
                    s = findFreq(A, left, s, e, 'l')[0];
                    int freqR = findFreq(A, right, s, e, 'r')[1];
                    e = findFreq(A, right, s, e, 'r')[0];
                    count += freqL * freqR;
                }

            } else if (sum < B) {
                s++;
            } else if (sum > B) {
                e--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int A[] = {};
        System.out.println(solve(A, 194191));
        System.out.println(A.length);

    }
}