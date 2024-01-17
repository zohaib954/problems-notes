/*
 * 
 */
package carryForward;

class ClosestMinMax {
    static int solve(int A[]) {
        int n = A.length;
        int min = A[0], max = A[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        int ans = Integer.MAX_VALUE;
        int minIndex = 0, maxIndex = 0;
        int temp = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] == min) {
                minIndex = i;
                temp = Math.max(minIndex, maxIndex) - Math.min(maxIndex, minIndex) + 1;
                ans = Math.min(ans, temp);
            }
            if (A[i] == max) {
                maxIndex = i;
                temp = Math.max(minIndex, maxIndex) - Math.min(maxIndex, minIndex) + 1;
                ans = Math.min(ans, temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A[] = { 1, 6, 4, 6, 5, 1, 5, 2, 6, 4, 4, 2, 1, 5 };
        System.out.println(solve(A));

    }
}