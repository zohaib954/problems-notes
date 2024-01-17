/*Max Sum Contiguous Subarray


 * Problem Description
Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000



Input Format
The first and the only argument contains an integer array, A.



Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.



Example Input
Input 1:

 A = [1, 2, 3, 4, -10] 
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 


Example Output
Output 1:

 10 
Output 2:

 6 


Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6. 

 my solution
 public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int n = A.length;
        int cs = 0, ms =  Integer.MIN_VALUE;
        int temp = 0;
        for(int i=0; i<n; i++){
            if(A[i]>=-1){
                temp = 1;
                break;
            }
           ms = Math.max(A[i], ms);
        }
        if(temp == 1){
for(int i=0; i<n; i++){
            cs += A[i];
            if(cs<0) cs = 0;
            ms = Math.max(ms,cs);
        }
        }
        
        return ms;
    }
}
 */




class MaxSumContig{

    public static int maxSubArray(final int[] A) {
        int n = A.length;
        int cs = 0, ms =  Integer.MIN_VALUE;
        int temp = 0;
        for(int i=0; i<n; i++){
            if(A[i]>=-1){
                temp = 1;
                break;
            }
           ms = Math.max(A[i], ms);
        }
        if(temp == 1){
        for(int i=0; i<n; i++){
            cs += A[i];
            if(cs<0) cs = 0;
            ms = Math.max(ms,cs);
        }
        }
        return ms;
    }

    //Another Approach my Approach
    static int maxSum2(int[] A){
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            sum += A[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int A[] = {3,2};
        int B[] = {-19,-7,-6,-20,-50,-80,-40, -10,-2, -30};
        
        System.out.println(maxSubArray(A)+" "+maxSubArray(B));
        System.out.println(maxSum2(A)+" "+ maxSum2(B));
       
    }
 }