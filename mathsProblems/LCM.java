package mathsProblems;

public class LCM {
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return (a * b) / gcd;
    }

    public static void main(String[] args) {
        System.out.println(lcm(4, 30));
    }
}
