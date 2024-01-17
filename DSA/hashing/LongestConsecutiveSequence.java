/*
 * Day 44: Problem :- Longest Consecutive Sequence.
 * 
 * Problem Description
    Given an unsorted integer array A of size N.
    Find the length of the longest set of consecutive elements from array A.


Problem Constraints
    1 <= N <= 106
    -106 <= A[i] <= 106



Input Format
    First argument is an integer array A of size N.



Output Format
    Return an integer denoting the length of the longest set of consecutive elements from the array A.

Example Input
    Input 1:
    A = [100, 4, 200, 1, 3, 2]

    Input 2:
    A = [2, 1]

Example Output
    Output 1:
    4
    
    Output 2:
    2


Example Explanation
    Explanation 1:
    The set of consecutive elements will be [1, 2, 3, 4].

    Explanation 2:
    The set of consecutive elements will be [1, 2].


Solution Approach :-

    step 1 :- Add all the elements in the array into hashSet.
    step 2 :- start a for loop and check if the element (A[i]-1) doesn't contains in hashset.
    step 3 :- then take 2 variables start=A[i] and len=1;
    step 4 :- start a while loop with condition hs.contains(start); then updtate start+1 and len+1;
    step 5 :- after while loop check max of ans and len then update ans;
    return ans;

 */

 package hashing;

import java.util.Arrays;
import java.util.HashSet;

class LongestConsecutiveSequence{
    static int longestConsecutiveSequence(int A[]){
        int n = A.length;
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<n; i++){
            hs.add(A[i]);
        }


        for(int i=0; i<n; i++){
            int val = A[i];
            if(hs.contains(val-1)){
                int start = val, len = 1;
                while(hs.contains(start)){
                    start++;
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }

    static int second(int A[]){
        int n = A.length;
        int ans = 0, len = 1;

        for(int i=1; i<n; i++){
            if(A[i-1] == A[i]-1){
                len++;
                ans = Math.max(ans, len);
            }
            else{
                len = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A[] = {2,8,9,4,7,10,20,21,76,34,22,3,11,13,89,34,15,14};
        System.out.println(longestConsecutiveSequence(A));
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        System.out.println(second(A));
    }
 }