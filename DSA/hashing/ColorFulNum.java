package hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ColorFulNum {
    static int solve(int A) {
        List<Integer> al = new ArrayList<>();
        Set<Integer> hs = new HashSet<>();
        while (A != 0) {
            int num = A % 10;
            al.add(num);
            A = A / 10;
        }
        Collections.reverse(al);
        int n = al.size();
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= al.get(j);
                if (hs.contains(prod)) {
                    return 0;
                } else
                    hs.add(prod);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int A = 2634;
        System.out.println(solve(A));
    }
}