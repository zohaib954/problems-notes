package LinkedList;

public class MyLinkedList {
    int size = 0;

    class Node {
        int data;
        Node link;

        Node() {

        }

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    Node first;

    void insert_data(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
        size++;
    }

    void reverseList() {
        if (first == null) {
            System.out.println("Can't reverse List, it's Empty");
        } else if (size == 1) {
            return;
        } else {
            Node temp = first;
            Node prev = null;
            Node current = first;

            while (current != null) {
                temp = temp.link;
                current.link = prev;
                prev = current;
                current = temp;
            }
            first = prev;
        }
    }

    void display() {
        if (size == 0) {
            System.out.println("List is empty");
        } else {
            Node temp = first;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.link;
            }
            System.out.println();
        }
    }

}
