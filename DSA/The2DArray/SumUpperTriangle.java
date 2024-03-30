/*
 * Sum of upper triangle and lower triangle solution;
 */
package The2DArray;

public class SumUpperTriangle {
    static int solve(int A[][]){
        int n = A.length;

        int sum = 0;
        int i=0, j=0;
        while(i<n){
            //This is the solution of lower triangle, to solve upper triangle
            // change j = i; in below line and in below while loop condition (j<n)
            j = 0;
            while(j<=i){
                sum += A[i][j];
                j++;
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
        };

        System.out.println(solve(A));
    }
}
