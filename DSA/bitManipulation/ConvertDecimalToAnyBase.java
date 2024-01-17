/*
 *  Any base to decimal
 * Problem Description
You are given a number A. You are also given a base B. A is a number on base B.
You are required to convert the number A into its corresponding value in decimal number system.


Problem Constraints
0 <= A <= 109
2 <= B <= 9


Input Format
First argument A is an integer.
Second argument B is an integer.


Output Format
Return an integer.


Example Input
Input 1:
A = 1010
B = 2
Input 2:
A = 22 
B = 3


Example Output
Output 1:
10
Output 2:
8


Example Explanation
For Input 1:
The decimal 10 in base 2 is 1010.
For Input 2:
The decimal 8 in base 3 is 22.
 */

 package bitManipulation;

 class ConvertDecimalToAnyBase{
    public static void main(String[] args) {
        int A = 22, B = 3;
        int ans = 0, pow = 1;

        while(A>0){
            int digit = A%10;
            ans = ans + (digit*pow);
            pow = pow*B;
            A = A/10;
        }
        System.out.println("Any Base to Decimal: "+ans);

        /*
         * Decimal to Any Base
         * Problem Description
Given a decimal number A and a base B, convert it into its equivalent number in base B.


Problem Constraints
0 <= A <= 512
2 <= B <= 10


Input Format
The first argument will be decimal number A.
The second argument will be base B.


Output Format
Return the conversion of A in base B.


Example Input
Input 1:
A = 4
B = 3
Input 2:
A = 4
B = 2 


Example Output
Output 1:
11
Output 2:
100


Example Explanation
Explanation 1:
Decimal number 4 in base 3 is 11.
Explanation 2:
Decimal number 4 in base 2 is 100.
         */

         int C = 4, D = 2;
         int ans2 = 0, pow2 = 1;
         while(C>0){
            int digit2 = C%D;
            ans2 += digit2*pow2;
            pow2 *= 10;
            C /= D;
         }

         System.out.println("Decimal to Base: "+ans2);
    }
 }