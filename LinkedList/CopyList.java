package LinkedList;

import java.util.HashMap;
import java.util.Scanner;

class RandomLinkedList {
    int size;
    Scanner s = new Scanner(System.in);

    class Node {
        int data;
        Node link;
        Node random;
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

    void display() {
        if (size == 0) {
            System.out.println("List is empty");
        } else {
            Node temp = first;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.link;
            }
            System.out.println();
        }
    }

    void dispalyRandom() {
        if (size == 0) {
            System.out.println("List is empty");
        } else {
            Node temp = first;
            for (int i = 1; i <= size; i++) {

                System.out.println(temp.data + "->" + temp.random.data);

                temp = temp.link;
            }

        }
    }

    void attachRandom() {
        RandomLinkedList.Node temp = first;
        int pos;
        while (temp != null) {
            System.out.println("Enter the position to attach random Node: 1-" + size);
            pos = s.nextInt();
            RandomLinkedList.Node temp2 = first;
            for (int i = 1; i <= pos; i++) {
                temp2 = temp2.link;
            }
            temp.random = temp2;
            temp = temp.link;
        }
    }

    void attachRandom(RandomLinkedList.Node A, int pos) {
        RandomLinkedList.Node temp = first;
        while (pos >= 1 && temp != null) {
            pos--;
            temp = temp.link;
        }
        A.random = temp;
    }
}

class CopyList {
    static RandomLinkedList copy(RandomLinkedList A) {
        RandomLinkedList B = new RandomLinkedList();
        if (A == null) {
            return B;
        }

        RandomLinkedList.Node temp = A.first;

        while (temp != null) {
            B.insert_data(temp.data);
            temp = temp.link;
        }
        return B;
    }

    // copying Random node from A list to B list
    static void copyRandom(RandomLinkedList A, RandomLinkedList B) {
        HashMap<RandomLinkedList.Node, RandomLinkedList.Node> hm = new HashMap<>();
        RandomLinkedList.Node temp1 = A.first;
        RandomLinkedList.Node temp2 = B.first;
        // putting key:value pair in HashMap as node A:node B
        while (temp1 != null) {
            hm.put(temp1, temp2);
            temp1 = temp1.link;
            temp2 = temp2.link;
        }
        // reassigining temp1 and temp2 variables to first of each node
        temp1 = A.first;
        temp2 = B.first;
        // finally attaching random nodes as A.random gives the value B.random
        // confusing right? check the code you'll understand.
        for (int i = 1; i <= B.size; i++) {
            temp2.random = hm.get(temp1.random);
            temp1 = temp1.link;
            temp2 = temp2.link;
        }

    }

    public static void main(String[] args) {
        RandomLinkedList A = new RandomLinkedList();
        A.insert_data(10);
        A.insert_data(20);
        A.insert_data(30);
        A.insert_data(40);
        A.insert_data(50);
        System.out.println("List of A");
        A.display();
        A.attachRandom(A.first, 4);
        A.attachRandom(A.first.link, 3);
        A.attachRandom(A.first.link.link, 1);
        A.attachRandom(A.first.link.link.link, 2);
        A.attachRandom(A.first.link.link.link.link, 1);
        System.out.println("Random List of A");
        A.dispalyRandom();

        RandomLinkedList B = copy(A);
        System.out.println("List of B");
        B.display();
        copyRandom(A, B);
        System.out.println("Random List of B");
        B.dispalyRandom();

    }
}
