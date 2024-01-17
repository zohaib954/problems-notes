/*
 * Q3. Square Root of Integer (Day 53)
 * Problem Description
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

The value of A can cross the range of Integer.

NOTE: 
   Do not use the sqrt function from the standard library. 
   Users are expected to solve this in O(log(A)) time.


Problem Constraints
0 <= A <= 1010


Input Format
The first and only argument given is the integer A.


Output Format
Return floor(sqrt(A))


Example Input
Input 1:

 11
Input 2:

 9


Example Output
Output 1:

 3
Output 2:

 3


Example Explanation
Explanation 1:
When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
Explanatino 2:
When A = 9 which is a perfect square of 3, so we return 3.
 */
package searching;

public class SquareRoot {
    static int solution(int A) {
        int ans = 0;
        int left = 0, right = A;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= A) {
                ans = (int) mid;
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return ans;
    }

    static float squareRoot(int A, float inc) {
        float ans = solution(A);
        for (int i = 1; i <= 3; i++) {

            while (ans * ans <= A) {
                ans += inc;
            }
            ans = ans - inc;
            inc /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        float ans = squareRoot(10, 0.1f);

        System.out.println(ans);
        System.out.println(Math.sqrt(10));
        System.out.println(ans * ans);
    }
}
