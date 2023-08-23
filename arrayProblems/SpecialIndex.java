package arrayProblems;

/*Problem Description

Given an array, arr[] of size N, the task is to find the count of array 
indices such that removing an element from these indices makes the sum of 
even-indexed and odd-indexed array elements equal.

Input Format
First argument contains an array A of integers of size N


Output Format
Return the count of array indices such that removing an element from these 
indices makes the sum of even-indexed and odd-indexed array elements equal.

Example Input
Input 1:
A=[2, 1, 6, 4]
Output 1:
1

Input 2:
A=[1, 1, 1]
Output 2:
3

Example Explanation
Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 

Explanation 2:
Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Therefore, the required output is 3.
*/
public class SpecialIndex {
    static int[] oddPrefixSum(int A[]){
        int n = A.length;
        int arr[] = new int[n];
        arr[0] = A[0];
        for(int i=1; i<n; i++){
            if(i%2!=0){
                arr[i] = arr[i-1] + A[i];
            }
            else{
                arr[i] = arr[i-1];
            }
        }
        return arr;
    }

    static int[] evenPrefixSum(int A[]){
        int n = A.length;
        int arr[] = new int[n];
        arr[0] = A[0];
        for(int i=1; i<n; i++){
            if(i%2==0){
                arr[i] = arr[i-1] + A[i];
            }
            else{
                arr[i] = arr[i-1];
            }
        }
        return arr;
    }
    static void printArray(int A[]){
        for(int i=0; i<A.length; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int A[] = {1, 1, 1};
        int n = A.length;
        
        int[] evenIndexSum = new int[n];
        int[] oddIndexSum = new int[n];
        
        evenIndexSum = evenPrefixSum(A);
        oddIndexSum = oddPrefixSum(A);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
        if (i == 0) {
        int evenSum = evenIndexSum[n - 1] - evenIndexSum[i];
        int oddSum = oddIndexSum[n - 1] - oddIndexSum[i];
        if (evenSum == oddSum) {
        count++;
        }
        } else {
        int leftEvenSum = evenIndexSum[i - 1];
        int rightEvenSum = oddIndexSum[n- 1] - oddIndexSum[i];
        int totalEvenSum = leftEvenSum + rightEvenSum;
        
        int leftOddSum = oddIndexSum[i - 1];
        int rightOddSum = evenIndexSum[n - 1] - evenIndexSum[i];
        int totalOddSum = leftOddSum +rightOddSum;
        
        if (totalEvenSum == totalOddSum) {
        count++;
        }
        System.out.println("totalEsum : "+totalEvenSum+" totalOsum : "+totalOddSum);
        }
        }
        
        System.out.println(count);
    }
}
