package String;

import java.util.HashMap;

class SortString {
    public static String solve(String A) {
        int n = A.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hm.containsKey(A.charAt(i))) {
                hm.put(A.charAt(i), hm.get(A.charAt(i)) + 1);
            } else {
                hm.put(A.charAt(i), 1);
            }
        }
        String ans = "";
        for (int i = 97; i <= 122; i++) {
            char c = (char) i;
            if (hm.containsKey(c)) {
                for (int j = 0; j < hm.get(c); j++) {
                    ans += (char) c;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "kdjfhr";
        System.out.println(solve(s));
    }
}