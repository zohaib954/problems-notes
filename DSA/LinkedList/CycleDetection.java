/*
 * Q3. Remove Loop from Linked List (Day 62 ADV DSA Linked List 2) Medium Frequently asked in interviews
 * !important:- This is a floyds cycle detection algorithem 
 * 
 * Problem Description
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.

Problem Constraints
1 <= number of nodes <= 1000

Input Format
The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
The second line of the input contains an integer which denotes the position of node where cycle starts.

Output Format
return the head of the updated linked list.

Example Input
Input 1: 
1 -> 2
^    |
| - - 

Input 2:
3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -

Example Output
Output 1:
 1 -> 2 -> NULL

Output 2:
 3 -> 2 -> 4 -> 5 -> 6 -> NULL

Example Explanation
Explanation 1:
 Chain of 1->2 is broken.

Explanation 2:
 Chain of 4->6 is broken.


 solution approach easy:- step 1:- create a hashset and add the address of the linked list in it.
                          step 2:- if the address is already contains in hashset then remove the link of that perticular
                           node and return.

 Floyds algorithm:- step 1:- create two variables of type Node slow and fast;
                    step 2:- start a while loop with condition fast!=null && fast.link!=null;
                             here slow and fast will meet at one point if there is loop in list.
                    step 3:- create if condition in which if slow == fast then break the loop;
                    step 4:- create if condition in which if isLoop == true then enter the block of if.
                             here we need to understand that slow is going one step and fast is going two step which is 2x of speed.
                             when slow and fast meet at some point then there is a loop by this observation floyds algorithm states
                             that
                             
                             :- distance travel of slow from start to the looping point is x;
                             :- distance travel of slow from looping point to the mmeting point of fast is y;
                             :- total distance travelld by slow is x+y;
                             :- fast is travelled 2x times so if there is loop then fast stuck in a loop and travelled extra as 
                                compare to slow.
                             :- then we can say that the extra travelled by fast is z;
                             :- by this observation we can determine that fast travelled = x+2y+z;
                             :- Dslow = x+y, Dfast = x+2y+z;
                             :- we can say that Dfast = 2Dslow;
                             :- x+2y+z = 2(x+z);
                             :- x+2y+z = 2x+2y;
                             :- by cancelling common we get z=x
                             :- this observation we can create algorithm.

                    step 5:- assign head node to slow variable;
                    step 6:- create while loop and start updating one step for slow and also for fast.
                          :- when slow encounters fast i.e slow == fast that point or node is the looping ponit.
                    step 7:- if we get the looping point then it is very easy to break the loop in list
                          :- create temp variable and assign it with slow.
                          :- start looping and check if temp.link == fast then assign temp.link = null.
                          :- now the loop is broke.
 */

package LinkedList;

import java.util.HashSet;

public class CycleDetection {
    static MyLinkedList solve(MyLinkedList A) {
        HashSet<MyLinkedList.Node> hs = new HashSet<>();
        MyLinkedList.Node temp = A.first;
        while (temp != null) {
            if (hs.contains(temp.link)) {
                temp.link = null;
            } else {
                hs.add(temp);
            }
            temp = temp.link;
        }

        return A;
    }

    static MyLinkedList floydsAlgo(MyLinkedList A) {

        MyLinkedList.Node slow = A.first;
        MyLinkedList.Node fast = A.first;
        boolean isLoop = false;

        while (fast != null && fast.link != null) {
            fast = fast.link.link;
            slow = slow.link;

            if (slow == fast) {
                isLoop = true;
                break;
            }
        }

        if (isLoop) {
            slow = A.first;

            while (slow != fast) {
                slow = slow.link;
                fast = fast.link;
            }

            MyLinkedList.Node temp = slow;
            while (temp.link != fast) {
                temp = temp.link;
            }
            temp.link = null;
        }

        return A;
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
        ll.display();
        MyLinkedList.Node dup = ll.first.link;

        MyLinkedList.Node temp = ll.first;
        while (temp.link != null) {
            temp = temp.link;
        }
        temp.link = dup;

        ll = floydsAlgo(ll);
        ll.display();

    }
}
