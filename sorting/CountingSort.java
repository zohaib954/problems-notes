package sorting;

import java.util.Arrays;
import java.util.HashMap;

public class CountingSort {
    static void countSort(int A[]) {
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
            if (hm.containsKey(A[i])) {
                hm.put(A[i], hm.get(A[i]) + 1);
            } else {
                hm.put(A[i], 1);
            }
        }
        int j = 0;
        for (int i = min; i <= max; i++) {
            if (hm.containsKey(i)) {
                while (hm.get(i) > 0) {
                    hm.put(i, hm.get(i) - 1);
                    A[j] = i;
                    j++;
                }
            }
        }

    }

    public static void main(String[] args) {
        int A[] = { 10, 8, 4, 2, 2, 2, 1 };
        System.out.println(Arrays.toString(A));
        countSort(A);
        System.out.println(Arrays.toString(A));
    }
}
