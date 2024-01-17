/*
 * Q2. Reorder List (Day 62 ADV DSA ) medium
 * 
 * Problem Description
 Given a singly linked list A
 A: A0 → A1 → … → An-1 → An 
 reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
 You must do this in-place without altering the nodes' values.



 Problem Constraints
 1 <= |A| <= 106



 Input Format
 The first and the only argument of input contains a pointer to the head of the linked list A.

 Output Format
 Return a pointer to the head of the modified linked list.

 Example Input
 Input 1:
 A = [1, 2, 3, 4, 5] 

 Input 2:
 A = [1, 2, 3, 4] 

 Example Output
 Output 1:
 [1, 5, 2, 4, 3] 

 Output 2:
 [1, 4, 2, 3] 

 Example Explanation
 Explanation 1:
 The array will be arranged to [A0, An, A1, An-1, A2].

 Explanation 2:
 The array will be arranged to [A0, An, A1, An-1, A2].

 solution approach:- step 1:- break the list into two half
                     step 2:- reverse the second list
                     step 3:- take one node from first list and another from second do it until one of the list node ends
                     step 4:- if there is odd elements list divides unequally i.e second list contains one less node
                           :- so attach the node from first list to the end of reversed list.
 */
package LinkedList;

public class ReorderList {
    
}
