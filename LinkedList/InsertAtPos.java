/*
 * Q2. Insert in Linked List
 * Problem Description
You are given A which is the head of a linked list. Also given is the value B and position C. 
Complete the function that should insert a new node with the said value at the given position.

Notes:

In case the position is more than length of linked list, simply insert the new node at the tail only.
In case the pos is 0, simply insert the new node at head only.
Follow 0-based indexing for the node numbering.


Problem Constraints
1 <= size of linked list <= 105
1 <= value of nodes <= 109
1 <= B <= 109
0 <= C <= 105

Input Format
The first argument A is the head of a linked list.
The second argument B is an integer which denotes the value of the new node
The third argument C is an integer which denotes the position of the new node

Output Format
Return the head of the linked list

Example Input
Input 1:
A = 1 -> 2
B = 3
C = 0

Input 2:
A = 1 -> 2
B = 3
C = 1

Example Output
Output 1:
3 -> 1 -> 2

Output 2:
1 -> 3 -> 2

Example Explanation
For Input 1:
The new node is add to the head of the linked list

For Input 2:
The new node is added after the first node of the linked list
 */

package LinkedList;

class InsertAtPos {
    static MyLinkedList.Node solve(MyLinkedList.Node A, int B, int C) {
        MyLinkedList ll = new MyLinkedList();
        ll.insert_data(B);
        if (C == 0) {
            ll.first.link = A;
            A = ll.first;
            return A;
        }
        MyLinkedList.Node temp = A;
        int size = 0;
        while (size < C - 1 && temp != null) {
            if (temp.link == null) {
                temp.link = ll.first;
            }
            temp = temp.link;
            size++;
        }
        ll.first.link = temp.link;
        temp.link = ll.first;
        return A;
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.insert_data(10);
        ll.insert_data(20);
        ll.insert_data(30);
        ll.insert_data(50);
        ll.display();

        ll.first = solve(ll.first, 40, 3);
        ll.display();
    }
}