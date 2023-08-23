/*
 * Q2. Kth Symbol - Easy (Day 35)
 * Problem Description
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence
 of 0 with 01, and each occurrence of 1 with 10.
Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).

Problem Constraints
1 <= A <= 20
0 <= B < 2A - 1

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer denoting the Bth indexed symbol in row A.

Example Input
Input 1:
 A = 3
 B = 0

Input 2:
 A = 4
 B = 4

Example Output
Output 1:
 0

Output 2:
 1

Example Explanation
Explanation 1:
 Row 1: 0
 Row 2: 01
 Row 3: 0110

Explanation 2:
 Row 1: 0
 Row 2: 01
 Row 3: 0110
 Row 4: 01101001
 */
package recursion;

class KthSymbol{
    static int solve(int A, int B){
        if(B==0 || B==1){
            return B;
        }
        int indices = 1<<(A-1);
        if(B<indices/2){
            return solve(A-1, B);
        }
        else{
            return 1-solve(A-1, B-(indices/2));
        }
       
    }
    public static void main(String[] args) {
        int a = 48, b = 36;
       while(b!=0){
        int rem = b%a;
        a = a/b;
        b = rem;
       }

       System.out.println(b);
    }
}