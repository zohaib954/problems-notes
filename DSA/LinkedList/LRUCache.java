package LinkedList;

import java.util.HashMap;

public class LRUCache {
    private int size_of_cache;
    private int current_size_of_LL = 0;
    private Node head;
    private Node tail;

    class Node {
        Node prev;
        String value;
        Node next;
    }

    // This method returns the current size of the Linked List
    int getSize() {
        return current_size_of_LL;
    }

}
