/*
 * Print the boundry elements of a 2D array
 */

package The2DArray;

class PrintInClockWise {
    public static void main(String[] args) {
        int A[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        int n = A.length, i = 0, j = 0;
        do {
            while (j < n) {
                System.out.print(A[i][j] + " ");
                j++;
            }
            j--;
            i++;

            while (i < n) {
                System.out.print(A[i][j] + " ");
                i++;
            }
            i--;
            j--;

            while (j >= 0) {
                System.out.print(A[i][j] + " ");
                j--;
            }
            j++;
            i--;
            while (i >= 1) {
                System.out.print(A[i][j] + " ");
                i--;
            }

        } while (i != 1 && j != 0);
    }
}