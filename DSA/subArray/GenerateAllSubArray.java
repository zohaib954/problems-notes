/* */

import java.util.ArrayList;

class GenerateAllSubarray {
    static int[][] solve(int A[]) {
        int n = A.length;
        int n1 = (n * (n + 1)) / 2;
        int arr[][] = new int[n1][];
        int q = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ArrayList<Integer> al = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    al.add(A[k]);
                }
                int n2 = al.size();
                arr[q] = new int[n2];
                for (int k = 0; k < n2; k++) {
                    arr[q][k] = al.get(k);
                }
                q++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int A[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int arr[][] = solve(A);

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}