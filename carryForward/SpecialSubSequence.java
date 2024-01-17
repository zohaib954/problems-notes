/*
 * 
 */

package carryForward;

class SpecialSubSequence {
    static int solve(String A) {
        int n = A.length();
        int count = 0;
        int countA = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'A') {
                countA++;
            }
            if (A.charAt(i) == 'G') {
                count += countA;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "AGSKHGASRKYGAGGGSKFUGG";
        System.out.println(solve(A));
    }
}