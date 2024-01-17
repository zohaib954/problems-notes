/*
 * Q3. 3 Sum
 * Problem Description
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108


Input Format
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format
Return a single integer denoting the sum of three integers which is closest to B.



Example Input
Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:

 
A = [1, 2, 3]
B = 6


Example Output
Output 1:

2
Output 2:

6


Example Explanation
Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6.
 */
package twoPointers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TripletSum {
    // return sum which is close to B or equal to B
    /*
     * solution approach :-
     * helper variables (n,min, ans)
     * take n as length of array, and min with max value of the integer, ans = 0;
     * step 1:- sort the array to use two pointer tecnique;
     * step 2:- check if the array size is less then 3 if yes then return -1,
     * because its not a valid input.
     * step 3:- start the for loop i from 0 - n-3;
     * step 4:- inside for loop take 2 variables s(start) and e(end) and initialize
     * s by i+1 and e by n-1;
     * step 5:- start a while loop with condition s<e;
     * step 6:- inside while loop take a variable sum and sum the values of array
     * A[i] + A[s] + A[e];
     * step 7:- check if the sum == B then return B;
     * step 8:- check if she sum > B then reduce e by 1; e--;
     * step 9:- at last if both conditions are false then it means sum is < B so
     * else increase s by 1; s++;
     * step 10:- take a diff variable and assign the value sum - B;
     * step 11:- if diff value is less the 0 then multiply the value with -1 i.e
     * diff *= -1;
     * step 12:- then check if the diff is less then min variable then update min to
     * diff and ans to sum;
     * step 13:- finally return the ans var
     * 
     */

    /*
     * below is another varient of the question where if asked to return the 3
     * values whose sum is equal to B or close to B
     */
    // if only asked to return the sum equal to B or close to B then change the
    // below code on, change the return
    // of the method to int only, from line 107 - 110 remove and return B inside if
    // sum == B
    // remove line 130 - 132
    // finally return ans instead of arr on line 136

    static int[] solve(int A[], int B) {
        Arrays.sort(A);
        int n = A.length;
        int ans = 0, min = Integer.MAX_VALUE;
        int arr[] = new int[3];
        for (int i = 0; i < n - 2; i++) {
            int s = i + 1, e = n - 1;
            int sum = 0;
            while (s < e) {
                sum = A[i] + A[s] + A[e];
                if (sum == B) {
                    arr[0] = A[i];
                    arr[1] = A[s];
                    arr[2] = A[e];
                    return arr;
                } else if (sum > B) {
                    e--;
                } else {
                    s++;
                }

            }
            if (s == e && e < n - 2) {
                e++;
            } else if (s == e && s != 0) {
                s--;
            }
            int diff = sum - B;
            if (diff < 0) {
                diff *= -1;
            }
            if (diff < min) {
                min = diff;
                ans = sum;
                arr[0] = A[i];
                arr[1] = A[s];
                arr[2] = A[e];
            }
        }

        return arr;
    }

    // return count of triplets that is equal to B
    static int solve2(int A[], int B) {
        Arrays.sort(A);
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int a = A[i];
            int s = i + 1, e = n - 1;
            while (s < e) {
                int sum = A[s] + A[e];
                if (sum > B - a) {
                    e--;
                } else {
                    count += e - s;
                    s++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int A[] = { 5, 8, 9, 2, 4, 7, 1, 5, };
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        // System.out.println(solve2(A, 19));
        System.out.println(Arrays.toString(solve(A, 12)));
    }
}
