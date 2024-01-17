package LinkedList;

public class MergeSortList {
    static MyLinkedList.Node solve(MyLinkedList.Node head) {
        if (head == null || head.link == null)
            return head;

        MyLinkedList.Node mid = getMid(head);
        MyLinkedList.Node A = head;
        MyLinkedList.Node B = mid.link;
        mid.link = null;

        A = solve(A);
        B = solve(B);
        head = mergeList(A, B);
        return head;
    }

    static MyLinkedList.Node getMid(MyLinkedList.Node A) {
        MyLinkedList.Node fast = A.link;
        MyLinkedList.Node slow = A;
        if (A.link == null) {
            return A;
        }

        while (fast != null && fast.link != null) {
            slow = slow.link;
            fast = fast.link.link;
        }

        return slow;
    }

    static MyLinkedList.Node mergeList(MyLinkedList.Node A, MyLinkedList.Node B) {
        MyLinkedList.Node head = null;
        if (A == null || B == null)
            return head;
        if (A.data < B.data) {
            head = A;
            A = A.link;
        } else {
            head = B;
            B = B.link;
        }
        MyLinkedList.Node T = head;
        while (A != null && B != null) {
            if (A.data < B.data) {
                T.link = A;
                A = A.link;
            } else {
                T.link = B;
                B = B.link;
            }
            T = T.link;
        }

        if (A != null) {
            T.link = A;
        } else {
            T.link = B;
        }

        return head;
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.insert_data(2);
        ll.insert_data(10);
        ll.insert_data(9);
        ll.insert_data(66);
        ll.insert_data(15);
        ll.insert_data(30);
        ll.insert_data(32);
        ll.insert_data(70);
        ll.insert_data(5);
        ll.insert_data(7);
        ll.insert_data(90);
        System.out.println("Unsorted List: ");
        ll.display();
        System.out.println("Sorted List:");

        MyLinkedList.Node ans = solve(ll.first);
        while (ans != null) {
            System.out.print(ans.data + " ");
            ans = ans.link;
        }
        System.out.println();

    }
}
