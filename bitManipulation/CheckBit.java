/*
Check Bit


 * Problem Description
You are given two integers A and B.
Return 1 if B-th bit in A is set
Return 0 if B-th bit in A is unset


Problem Constraints
1 <= A <= 109
0 <= B <= 30


Input Format
First argument A is an integer.
Second argument B is an integer.


Output Format
Return an integer.


Example Input
Input 1:
A = 4
B = 1
Input 2:
A = 5
B = 2


Example Output
Output 1:
0
Output 2:
1


Example Explanation
For Input 1:
Given N = 4 which is 100 in binary. The 1-st bit is unset
so we return 0
For Input 2:
 
Given N = 5 which is 101 in binary. The 2-nd bit is set
so we return 1


solution:=

1:-right shift integer A with B bits (example:-A=8, B=2;  8>>2 i.e 01000 this becomes 010, last 2 bits are shifted);
2:- now check wheather last bit is 1 or not we can check using bitwise and operator (A>>B&1),
 this look like 
 010
& 1
----
  0
 */

 package bitManipulation;

 class CheckBit{
    public static void main(String[] args) {
        int A = 8;
        int B = 2;
        int ans = A>>B&1;
       System.out.println(ans);
      

       // if the bit at B position is one then chenge it to 0 otherwise leave as it is.
       if(ans == 1){
        int shift = A^(1<<B);
        System.out.println(shift);
       }
      else{
        System.out.println(A);
      }
    }
 }