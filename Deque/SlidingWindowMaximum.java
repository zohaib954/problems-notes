/*
 * 
 */
package Deque;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    static int[] solve(int[] A, int B) {
        int n = A.length;
        int arr[] = new int[n - 2];
        Deque<Integer> d = new LinkedList<>();

        for (int i = 0; i < B; i++) {
            d.addLast(A[i]);
        }
        return arr;
    }
}
