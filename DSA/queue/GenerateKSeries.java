/*
 * Q2. N integers containing only 1, 2 & 3 (Day 68 Adv Dsa) imp
 * Problem Description
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
NOTE: All the A integers will fit in 32-bit integers.

Problem Constraints
1 <= A <= 29500

Input Format
The only argument given is integer A.

Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.

Example Input
Input 1:
 A = 3

Input 2:
 A = 7

Example Output
Output 1:
 [1, 2, 3]

Output 2:
 [1, 2, 3, 11, 12, 13, 21]

Example Explanation
Explanation 1:
 Output denotes the first 3 integers that contains only digits 1, 2 and 3.

Explanation 2:
 Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */
package queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateKSeries {
    static int[] solve(int A) {
        Queue<String> q = new LinkedList<>();
        int arr[] = new int[A];
        if (A == 0) {
            return arr;
        } else if (A == 1) {
            arr[0] = 1;
            return arr;
        } else if (A == 2) {
            arr[0] = 1;
            arr[1] = 2;
            return arr;
        }
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        q.add("1");
        q.add("2");
        q.add("3");

        int t = A;
        int i = 3;
        while (t >= 3) {
            String temp = q.peek();
            q.add(temp + "1");

            q.add(temp + "2");
            q.add(temp + "3");
            t--;
        }
        return arr;
    }
}
