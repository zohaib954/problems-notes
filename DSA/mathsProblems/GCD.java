package mathsProblems;

public class GCD {
    static int gcdRecursion(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcdRecursion(b % a, a);
    }

    static int gcdIterative(int a, int b) {
        while (a > 0) {
            int temp = b % a;
            b = a;
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int a = 20, b = 55;

        System.out.println(gcdIterative(a, b));
        System.out.println(gcdRecursion(a, b));
    }
}
