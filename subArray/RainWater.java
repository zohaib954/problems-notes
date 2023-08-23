/*
 * Problem Description
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.

my Approach
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int n = A.length;
        int leftToRight[] = new int[n];
        int leftToRightMax = 0;
        int rightToLeft[] = new int[n];
        int rightToLeftMax = 0;

        for(int i=0; i<n; i++){
            leftToRightMax = Math.max(leftToRightMax,A[i]);
            leftToRight[i] = leftToRightMax;
        }
        for(int i=n-1; i>=0; i--){
            rightToLeftMax = Math.max(rightToLeftMax, A[i]);
            rightToLeft[i] = rightToLeftMax;
        }

        int minArr[] = new int[n];
        for(int i=0; i<n; i++){
            minArr[i] = Math.min(leftToRight[i], rightToLeft[i]);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += minArr[i]-A[i];
        }
        return ans;
    }
}



 */
import java.lang.Math;

public class RainWater {
    static int rainWater(int A[]){
        int n = A.length;
        int leftToRight[] = new int[n];
        int rightToLeft[] = new int[n];
        int leftToRightMax = 0, rightToLeftMax = 0;
        for(int i=0; i<n; i++){
            leftToRightMax = Math.max(leftToRightMax, A[i]);
            leftToRight[i] = leftToRightMax;
        }
        for(int i=n-1; i>=0; i--){
            rightToLeftMax = Math.max(rightToLeftMax, A[i]);
            rightToLeft[i] = rightToLeftMax;
        }

        int minArr[] = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            minArr[i] = Math.min(rightToLeft[i], leftToRight[i]);
            ans += minArr[i] - A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,5,7,4,2,3,6,8,2,3};
        System.out.println(rainWater(arr));
    }
}
