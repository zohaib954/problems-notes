/*
 * Q7. Middle element of linked list (Day 61 ADV DSA)
 * Problem Description
Given a linked list of integers, find and return the middle element of the linked list.
NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

Problem Constraints
1 <= length of the linked list <= 100000
1 <= Node value <= 109

Input Format
The only argument given head pointer of linked list.

Output Format
Return the middle element of the linked list.

Example Input
Input 1:
 1 -> 2 -> 3 -> 4 -> 5
Input 2:
 1 -> 5 -> 6 -> 2 -> 3 -> 4

Example Output
Output 1:
 3
Output 2:
 2

Example Explanation
Explanation 1:
 The middle element is 3.
Explanation 2:
 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
 */
package LinkedList;

class MidElem {
    static int solve(MyLinkedList A) {
        if (A.first == null) {
            return 0;
        } else if (A.first.link == null) {
            return A.first.data;
        }

        int count = 0;
        MyLinkedList.Node temp = A.first;
        while (temp != null) {
            count++;
            temp = temp.link;
        }
        int size = 0;
        count = count / 2;
        temp = A.first;
        while (size < count && temp.link != null) {
            size++;
            temp = temp.link;
        }
        return temp.data;
    }

    // efficient method (2 pointer technique)
    static int solve2(MyLinkedList A) {
        if (A == null) {
            return 0;
        }

        MyLinkedList.Node fast = A.first;
        MyLinkedList.Node slow = A.first;
        while (fast != null && fast.link != null) {
            slow = slow.link;
            fast = fast.link.link;
        }

        return slow.data;
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.insert_data(10);
        ll.insert_data(20);
        ll.insert_data(30);
        ll.insert_data(40);
        ll.insert_data(50);
        ll.insert_data(60);
        ll.insert_data(70);
        ll.insert_data(80);
        ll.insert_data(90);
        ll.insert_data(100);

        ll.display();
        ll.reverseList();
        ll.display();
    }
}