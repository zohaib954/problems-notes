import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Test {

    // How do you reverse a string?
    static String reverseString(String str) {
        int n = str.length();
        String ans = "";
        char c[] = str.toCharArray();
        int j = n - 1;
        while (j >= 0) {
            ans += c[j];
            j--;
        }
        return ans;
    }

    // How do you determine if a string is a palindrome?
    static boolean isPalindrome(String str) {
        int n = str.length();
        int i = 0, j = n - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // How do you calculate the number of numerical digits in a string?
    static int totalNumInString(String str) {
        int n = str.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count++;
            }
        }
        return count;
    }

    // How do you find the count for the occurrence of a particular character in a
    // string?
    static int countChar(String str, char c) {
        int n = str.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    // How do you find the non-matching characters in a string?
    static String nonMatching(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int minLength = Math.min(n1, n2);
        String ans = "";
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                ans += b.charAt(i);
            }
        }

        if (n1 != n2) {
            if (n1 == minLength) {
                ans += b.substring(minLength, n2);
            } else {
                ans += a.substring(minLength, n1);
            }
        }
        return ans;
    }

    // How do you find out if the two given strings are anagrams?
    static boolean isAnagram(String a, String b) {
        char c1[] = a.toCharArray();
        char c2[] = b.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int n1 = c1.length;
        int n2 = c2.length;
        if (n1 != n2) {
            return false;
        }

        for (int i = 0; i < n1; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    // How do you calculate the number of vowels and consonants in a string?
    static int[] countVowelsAndConsonant(String str) {
        int n = str.length();
        int[] ans = new int[2];
        int vowels = 0, consonants = 0;

        str = str.toLowerCase();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                vowels++;
            } else if (str.charAt(i) == ' ') {
                continue;
            } else {
                consonants++;
            }
        }

        ans[0] = vowels;
        ans[1] = consonants;

        return ans;
    }

    // How do you total all of the matching integer elements in an array?
    static int[] sumMatchingElem(int A[]) {
        int n = A.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int temp1 = A[i];
            if (hm.containsKey(A[i])) {
                int temp2 = hm.get(temp1) + temp1;
                hm.put(temp1, temp2);
            } else {
                hm.put(temp1, temp1);
            }
        }
        int arr[] = removeDuplicate(A);
        int n1 = arr.length;
        int ans[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            ans[i] = hm.get(arr[i]);
        }
        return ans;
    }

    // Remove duplicate elements in a Integer Array.
    static int[] removeDuplicate(int A[]) {
        int n = A.length;
        if (n == 0) {
            return new int[0];
        }
        List<Integer> al = new ArrayList<>();
        al.add(A[0]);
        for (int i = 1; i < n; i++) {
            if (al.contains(A[i])) {
                continue;
            } else {
                al.add(A[i]);
            }
        }
        int n1 = al.size();
        int ans[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            ans[i] = al.get(i);
        }
        return ans;
    }

    // Count number of element present in a integer Array
    static int[] countNumOfElem(int A[]) {
        int n = A.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            Integer temp = A[i];
            if (hm.containsKey(temp)) {
                int value = hm.get(temp);
                hm.put(temp, value + 1);
            } else {
                hm.put(temp, 1);
            }
        }

        int arr[] = removeDuplicate(A);
        int n1 = arr.length;
        int ans[] = new int[n1];

        for (int i = 0; i < n1; i++) {
            ans[i] = hm.get(arr[i]);
        }
        return ans;
    }

    // reverse Array
    static int[] reverseArray(int A[]) {
        int n = A.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
        return A;
    }

    // find maximum in Array
    static int findMax(int A[]) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    // How do you sort an array of integers in ascending order?
    // Bubble sort
    static int[] bubbleSort(int A[]) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }

    // selection sort
    static int[] selectionSort(int A[]) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[min_index]) {
                    min_index = j;
                }
            }
            int temp = A[i];
            A[i] = A[min_index];
            A[min_index] = temp;
        }
        return A;
    }

    // Insertion Sort
    static int[] insertionSort(int A[]) {
        int n = A.length;
        // for (int i = 1; i < n; i++) {
        // int key = A[i];
        // int j = i - 1;
        // while (j >= 0 && A[j] > key) {
        // A[j + 1] = A[j];
        // j--;
        // }
        // A[j + 1] = key;
        // }

        for (int i = 1; i < n; i++) {
            int key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
        return A;
    }

    // merge sort
    static int[] mergeSort(int A[]) {
        int n = A.length;
        divide(A, 0, n - 1);
        return A;
    }

    static void divide(int A[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        divide(A, start, mid);
        divide(A, mid + 1, end);
        merge(A, start, mid, end);
    }

    static void merge(int A[], int left, int mid, int right) {
        int L[] = Arrays.copyOfRange(A, left, mid + 1);
        int R[] = Arrays.copyOfRange(A, mid + 1, right + 1);
        int n1 = L.length;
        int n2 = R.length;

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                A[k++] = L[i++];
            } else {
                A[k++] = R[j++];
            }
        }
        while (i < n1) {
            A[k++] = L[i++];
        }
        while (j < n2) {
            A[k++] = R[j++];
        }
    }

    // Fibonacci sequence using bottom up approach
    static void fibb(int n) {
        if (n == 0) {
            return;
        }
        int a = 0, b = 1, c;
        if (n == 1) {
            System.out.println(a);
            return;
        } else if (n == 2) {
            System.out.println(a + " " + b);
            return;
        }

        System.out.print(a + " " + b + " ");
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Fibb series using recursion top down approach
    static void printFibb(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(fibbInt(i) + " ");
        }
    }

    // return fibonachi element at index n
    static int fibbInt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return (fibbInt(n - 1) + fibbInt(n - 2));
    }

    // How do you calculate the sum of two integers?
    static int sumOfTwoInt(int a, int b) {
        return a + b;
    }

    // How do you find the average of numbers in a list?
    static int avgInList(ArrayList<Integer> al) {
        int n = al.size();
        Integer totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += al.get(i);
        }
        return (totalSum / n);
    }

    // How do you check if an integer is even or odd?
    static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // System.out.println(reverseString("Zohaib"));
        // System.out.println(isPalindrome(str));
        // System.out.println(totalNumInString("zoh78ai2b1"));
        // System.out.println(nonMatching("zohaib", "Zoh98aib"));
        // System.out.println(isAnagram("cat", "mac"));
        // String str = "Zohaib Ahmed";
        // int vowConso[] = countVowelsAndConsonant(str);
        // System.out.println("vowels:- " + vowConso[0] + " consonents :- " +
        // vowConso[1]);
        // int A[] = { 1, 4, 5, 4, 2, 2, 6, 1 };
        // System.out.println("Array Elements: " + Arrays.toString(removeDuplicate(A)));
        // System.out.println("Number of times Array Element Occurs: " +
        // Arrays.toString(countNumOfElem(A)));
        // System.out.println("Sum of the Common elements in an Array: " +
        // Arrays.toString(sumMatchingElem(A)));
        // int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // System.out.println(Arrays.toString(reverseArray(A)));
        // int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // System.out.println(findMax(A));
        // int A[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        // System.out.println(Arrays.toString(bubbleSort(A)));
        // System.out.println(Arrays.toString(selectionSort(A)));
        // System.out.println(Arrays.toString(insertionSort(A)));
        // System.out.println(Arrays.toString(mergeSort(A)));
        // fibb(10);
        // printFibb(5);
        // System.out.println(sumOfTwoInt(10, 5));
        // ArrayList<Integer> al = new ArrayList<>();
        // al.add(10);
        // al.add(20);
        // al.add(30);
        // al.add(40);
        // al.add(50);
        // System.out.println(avgInList(al));
        // System.out.println(isEven(5));
        // MyLinkedList ll = new MyLinkedList();
        // ll.addNode(10);
        // ll.addNode(20);
        // ll.addNode(30);
        // ll.addNode(40);
        // ll.addNode(50);
        // ll.addNode(60);
        // ll.addNode(70);
        // ll.addNode(80);
        // ll.addNode(90);
        // ll.addNode(100);
        // ll.root.next.next.next.next.next = ll.root;
        // ll = ll.removeLoop(ll);
        // ll.printLL();

        MyLinkedList ll1 = new MyLinkedList();
        ll1.addNode(3);
        ll1.addNode(4);
        ll1.addNode(7);
        ll1.addNode(9);
        ll1.addNode(10);
        ll1.printLL();

        MyLinkedList ll2 = new MyLinkedList();
        ll2.addNode(1);
        ll2.addNode(2);
        ll2.addNode(5);
        ll2.addNode(6);
        ll2.addNode(8);
        ll2.printLL();

        MyLinkedList ll3 = new MyLinkedList().merge(ll1, ll2);
        ll3.printLL();

    }
}

class MyLinkedList {
    int size;

    class Node {
        int data;
        Node next;

        Node() {

        }

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node root;

    void addNode(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    void printLL() {
        if (root == null) {
            System.out.println("Linked list is empty");
        } else {
            Node temp = root;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    int midOfLL() {
        if (root == null) {
            return -1;
        } else if (root.next.next == null) {
            return root.next.data;
        } else {
            Node slow = root;
            Node fast = root;

            if (size % 2 != 0) {

                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }
                return slow.data;
            } else {
                int value = slow.data;
                while (fast != null && fast.next != null) {
                    value = slow.data;
                    fast = fast.next.next;
                    slow = slow.next;
                }
                return value;
            }
        }
    }

    MyLinkedList removeLoop(MyLinkedList A) {
        Node slow = A.root;
        Node fast = A.root;
        boolean isLoop = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                isLoop = true;
                break;
            }
        }

        if (isLoop) {
            slow = root;

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            Node temp = slow;
            while (temp.next != fast) {
                temp = temp.next;
            }
            temp.next = null;
        }
        return A;
    }

    MyLinkedList mergeTwoSortedList(MyLinkedList A, MyLinkedList B) {
        MyLinkedList root = null;
        Node temp1 = A.root;
        Node temp2 = B.root;

        // Assigining the lowest node among two nodes to root.
        if (temp1.data < temp2.data) {
            root = A;
            temp1 = temp1.next;
        } else {
            root = B;
            temp2 = temp2.next;
        }
        Node temp3 = root.root;
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                temp3.next = temp1;
                temp1 = temp1.next;
            } else {
                temp3.next = temp2;
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }

        if (temp1 != null) {
            temp3.next = temp1;
        } else if (temp2 != null) {
            temp3.next = temp2;
        }

        return root;
    }

    MyLinkedList merge(MyLinkedList A, MyLinkedList B) {
        MyLinkedList root = null;
        Node temp1 = A.root;
        Node temp2 = B.root;

        if (temp1.data < temp2.data) {
            root = A;
            temp1 = temp1.next;
        } else {
            root = B;
            temp2 = temp2.next;
        }

        Node temp3 = root.root;

        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                temp3.next = temp1;
                temp1 = temp1.next;
            } else {
                temp3.next = temp2;
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }

        if (temp1 != null) {
            temp3.next = temp1;
        } else if (temp2 != null) {
            temp3.next = temp2;
        }

        return root;
    }
}