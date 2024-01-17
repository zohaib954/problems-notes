/*
 * Q2. Factors sort (Day 49 Advance DSA sorting 2)
 * Problem Description
You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of
each element, i.e., element having the least number of factors should be the first to be displayed and the number having
highest number of factors should be the last one. If 2 elements have same number of factors, then number with less
value should come first.
Note: You cannot use any extra space


Problem Constraints
1 <= N <= 104
1 <= A[i] <= 104

Input Format
First argument A is an array of integers.

Output Format
Return an array of integers.

Example Input
Input 1:
A = [6, 8, 9]
Input 2:
A = [2, 4, 7]

Example Output
Output 1:
[9, 6, 8]
Output 2:
[2, 7, 4]


Example Explanation
For Input 1:
The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
For Input 2:
The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.

 */
package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FactorSort {
    static ArrayList<Integer> solve(ArrayList<Integer> A){

        //over riding collections.sort method inside we implementing comparator and overriding compare method.
        Collections.sort(A, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                int factA = countFact(a);
                int factB = countFact(b);

                //if return -ve then a comes right and b comes left
                if(factA < factB){
                    return -1;
                }
                // if positive no ordering
                else if(factA > factB){
                    return 1;
                }
                //in this problem we are again comparing original list values because the below else block runs only when 
                //count of factors of two numbers are same
                else{
                    if(a<b){
                        return -1;
                    }
                    else return 1;
                }
            }
        });
        return A;
    }

    public static int countFact(Integer n){
        int count = 0;

        for(int i=1; (i*i)<=n; i++){
            if(i == Math.sqrt(n)){
                count++;
            }
            else if(n%i == 0){
                count += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
      arr.add(2);
      arr.add(4);
      arr.add(7);
      System.out.println(solve(arr));
    }
}
