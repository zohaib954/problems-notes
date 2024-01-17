package LinkedList;

public class MergeList {
    // solution by creating extra linked list time complexity O(N), Scpace
    // complexity O(N);
    static MyLinkedList solve(MyLinkedList A, MyLinkedList B) {
        MyLinkedList ans = new MyLinkedList();
        if (A.first == null) {
            return ans;
        }

        MyLinkedList.Node temp1 = A.first;
        MyLinkedList.Node temp2 = B.first;

        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                ans.insert_data(temp1.data);
                temp1 = temp1.link;
            } else {
                ans.insert_data(temp2.data);
                temp2 = temp2.link;
            }
        }
        while (temp1 != null) {
            ans.insert_data(temp1.data);
            temp1 = temp1.link;
        }
        while (temp2 != null) {
            ans.insert_data(temp2.data);
            temp2 = temp2.link;
        }
        return ans;
    }

    // Solution using recursion without creating extra linked list
    // solution is not perfect look someones code.
    static MyLinkedList.Node solve2(MyLinkedList.Node A, MyLinkedList.Node B) {
        MyLinkedList.Node head;
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }

        if (A.data < B.data) {
            head = A;
            head.link = solve2(A.link, B.link);
        } else {
            head = B;
            head.link = solve2(A, B.link);
        }
        return head;
    }

    // solution using iterator and without using extra linked list or space;
    static MyLinkedList.Node solve3(MyLinkedList.Node A, MyLinkedList.Node B) {
        MyLinkedList.Node head;
        MyLinkedList.Node temp1 = A;
        MyLinkedList.Node temp2 = B;

        if (A.data < B.data) {
            head = A;
            temp1 = temp1.link;
        } else {
            head = B;
            temp2 = temp2.link;
        }
        MyLinkedList.Node temp3 = head;

        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                temp3.link = temp1;
                temp1 = temp1.link;
            } else {
                temp3.link = temp2;
                temp2 = temp2.link;
            }
            temp3 = temp3.link;
        }
        if (temp1 == null) {
            temp3.link = temp2;
        } else if (temp2 == null) {
            temp3.link = temp1;
        }

        return head;
    }

    public static void main(String[] args) {
        MyLinkedList ll1 = new MyLinkedList();
        ll1.insert_data(40);
        ll1.insert_data(55);
        ll1.insert_data(78);
        ll1.insert_data(90);
        ll1.insert_data(100);

        MyLinkedList ll2 = new MyLinkedList();
        ll2.insert_data(12);
        ll2.insert_data(20);
        ll2.insert_data(45);
        ll2.insert_data(80);
        ll2.insert_data(95);

        System.out.println("Linked List 1 is: ");
        MyLinkedList.Node temp1 = ll1.first;
        while (temp1 != null) {
            System.out.print(temp1.data + "->");
            temp1 = temp1.link;
        }
        System.out.println();

        System.out.println("Linked List 2 is: ");
        MyLinkedList.Node temp2 = ll2.first;
        while (temp2 != null) {
            System.out.print(temp2.data + "->");
            temp2 = temp2.link;
        }
        System.out.println();

        System.out.println("Merged Linked list is: ");
        MyLinkedList.Node ans = solve3(ll1.first, ll2.first);
        MyLinkedList.Node temp3 = ans;

        while (temp3 != null) {
            System.out.print(temp3.data + "->");
            temp3 = temp3.link;
        }
        System.out.println();
    }
}
