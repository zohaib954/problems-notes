/*
 * Q3. Largest Number (Day 49 Advance DSA sorting 2)
 * 
 * Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.

Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109

Input Format
The first argument is an array of integers.

Output Format
Return a string representing the largest number.

Example Input
Input 1:
 A = [3, 30, 34, 5, 9]
Input 2:
 A = [2, 3, 9, 0]

Example Output
Output 1:
 "9534330"
Output 2:
 "9320"

Example Explanation
Explanation 1:
Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:
Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
 */

 
package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
     public static String largestNumber(final int[] A) {
        int n = A.length;
        ArrayList<Integer> list = new ArrayList<>();
       
        for(int i=0; i<n; i++){
            list.add(A[i]);
        }

        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                String s1 = String.valueOf(a) + String.valueOf(b);
                String s2 = String.valueOf(b) + String.valueOf(a);

                if(s1.compareTo(s2) < 0){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });

        String ans = "";
        for(int i=0; i<list.size(); i++){
            ans += list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int A[] = {3, 30, 34, 5, 9};

        System.out.println(largestNumber(A));
    }
}
