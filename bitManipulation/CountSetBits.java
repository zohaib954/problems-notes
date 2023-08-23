/*
 * Number of 1 Bits
 * 
 * Problem Description
Write a function that takes an integer and returns the number of 1 bits it has.


Problem Constraints
1 <= A <= 109


Input Format
First and only argument contains integer A


Output Format
Return an integer as the answer


Example Input
Input 1:
11
Input 2:
6


Example Output
Output 1:
3
Output 2:
2


Example Explanation
Explaination 1:
11 is represented as 1011 in binary.
Explaination 2:
6 is represented as 110 in binary.


solution Approach

if we operate bitwise & whith A&1 then we get 1 only if last bit of a number A is 1.
1:- we can apply a while loop until A is greater than 0.
2:- we store the last bit of a number A into a variable last bit.
3:- then we add the last bit of the number A to ans variable.
4:- then we right shift A to 1 bit. i.e A>>1; this will decrease right digit.
5:- then we return the integer ans.

 */

package bitManipulation;

public class CountSetBits {
   public static void main(String[] args) {
    int A = 11;
    int ans = 0;
    while(A>0){
        int lastDisgit = A&1;
        ans += lastDisgit;
        A = A>>1;
    }
    System.out.println(ans);
   }
}
