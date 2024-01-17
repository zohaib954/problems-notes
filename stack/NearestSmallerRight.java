package stack;

import java.util.Arrays;
import java.util.Stack;

class NearestSmallerRight {
    static int[] solve(int A[]) {
        int n = A.length;
        int arr[] = new int[n];

        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() >= A[i]) {
                s.pop();
            }
            if (s.empty()) {
                arr[i] = -1;
            } else {
                arr[i] = s.peek();
            }
            s.push(A[i]);
        }

        return arr;
    }

    public static void main(String[] args) {
        int A[] = { 4, 5, 2, 10 };
        System.out.println(Arrays.toString(solve(A)));
    }
}