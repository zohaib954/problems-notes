/*
 Question :- *  Search in a row wise and column wise sorted matrix.

        Problem Description
            Given a matrix of integers A of size N x M and an integer B.
            In the given matrix every row and column is sorted in non-decreasing order. Find and return the position of B in the matrix in the given form:
            If A[i][j] = B then return (i * 1009 + j)
            If B is not present return -1.

            Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
            Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
            Note 3: Expected time complexity is linear
            Note 4: Use 1-based indexing


        Problem Constraints
            1 <= N, M <= 1000
            -100000 <= A[i] <= 100000
            -100000 <= B <= 100000


        Input Format
            The first argument given is the integer matrix A.
            The second argument given is the integer B.


        Output Format
            Return the position of B and if it is not present in A return -1 instead.


        Example Input
            Input 1:-
            A = [[1, 2, 3]
                [4, 5, 6]
                [7, 8, 9]]
            B = 2
            Input 2:-
            A = [[1, 2]
                [3, 3]]
            B = 3


        Example Output
            Output 1:-
            1011
            Output 2:-
            2019
 */

package searching;

public class StairCaseSearch {

    //Function to for stair case search
    static int stairCaseSearch(int A[][], int B){
    int n = A.length, m = A[0].length;
    int i = 0, j = m-1;
    int ans = -1;

    while(i<n-1 && j>=0){
        if(A[i][j] == B){
            ans = (i+1)*1009+(j+1);
            j--;
        }
        else if(A[i][j] > B){
            j--;
        }
        else{
            if(ans != -1){
                return ans;
            }
            i++;
        }
    }
    return ans;
}

public static void main(String[] args) {
    int A[][] = {{1,2,3},{4,5,6},{7,8,9}, {10,11,12}};
    int B = 6;
    System.out.println(stairCaseSearch(A, B));
}
}
