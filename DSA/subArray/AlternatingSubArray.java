public class AlternatingSubArray {
    static int[] solve1(int A[], int B) {
        int n = A.length;
        B = 2 * B + 1;
        if (n == 1) {
            return new int[0];
        }

        return ans;
    }

    public static void main(String[] args) {
        int A[] = { 1 };
        int ans[] = solve1(A, 0);
        int n = ans.length;
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
