/*
 * 
 */
package carryForward;

class BuyStock {
    static int solve(int A[]) {
        int n = A.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int ans = 0;
        int largest = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > largest) {
                largest = A[i];
            } else {
                ans = Math.max(ans, largest - A[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A[] = { 1, 6, 8, 3, 9 };
        System.out.println(solve(A));
    }
}