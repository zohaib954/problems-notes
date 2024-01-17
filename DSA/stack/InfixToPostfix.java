package stack;

import java.util.Stack;

class InfixToPostfix {
    static String solve(String A) {
        int n = A.length();
        String ans = "";
        Stack<Character> s = new Stack<>();
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < n; i++) {
            char x = A.charAt(i);
            if (x >= 'a' && x <= 'z') {
                ans += x;
            } else if (x == '(') {
                while (x != ')') {
                    x = A.charAt(i + 1);
                    i++;
                    if (x >= 'a' && x <= 'z') {
                        ans += x;
                    } else if (x == '^') {
                        s1.push(x);
                    } else if (x == '/' || x == '*') {
                        while (!s1.empty() && s1.peek() == '^') {
                            ans += s1.peek();
                            s1.pop();
                        }
                        s1.push(x);
                    } else if (x == '+' || x == '-') {
                        while (!s1.empty() && (s1.peek() == '^' || s1.peek() == '*' || s1.peek() == '/')) {
                            ans += s1.peek();
                            s1.pop();
                        }
                        s1.push(x);
                    }
                }
            }
            if (x == ')') {
                while (!s1.empty()) {
                    ans += s1.peek();
                    s1.pop();
                }
            }

            if (x == '^') {
                s.push(x);
            } else if (x == '*' || x == '/') {
                while (!s.empty() && s.peek() == '^') {
                    ans += s.peek();
                    s.pop();
                }
                s.push(x);
            } else if (x == '+' || x == '-') {
                while (!s.empty() && (s.peek() == '^' || s.peek() == '*' || s.peek() == '/')) {
                    ans += s.peek();
                    s.pop();
                }
                s.push(x);
            }
        }
        while (!s.empty()) {
            ans += s.peek();
            s.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        // String s = "abcd^e-fgh*+^*+i-";
        System.out.println(Math.sqrt(10));
    }
}