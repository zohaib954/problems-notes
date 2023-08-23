/*
 * Problem Description
You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.

Note : Follow 0-based indexing for the node numbering.



Problem Constraints
1 <= size of linked list <= 105
1 <= value of nodes <= 109
0 <= B < size of linked list



Input Format
The first argument A is the head of a linked list.

The second arguement B is an integer.



Output Format
Return the head of the linked list after deletion



Example Input
Input 1:
A = 1 -> 2 -> 3
B = 1
Input 2:
A = 4 -> 3 -> 2 -> 1
B = 0


Example Output
Output 1:
1 -> 3
Output 2:
3 -> 2 -> 1


Example Explanation
For Input 1:
The linked list after deletion is 1 -> 3.
For Input 2:
The linked list after deletion is 3 -> 2 -> 1.

my code
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 
public class Solution {
    public ListNode solve(ListNode A, int B) {
        if(A==null){
            return A;
        }
        if(B==0){
            A = A.next;
            return A;
        }

        int size = 1;
        ListNode temp = A;
        while(size<B && temp.next!=null){
            size++;
            temp = temp.next;
        }
        if(size<B){
            return null;
        }
        temp.next = temp.next.next;
        return A;

    }
}
*/

package LinkedList;

public class DeleteNode {
    
}
