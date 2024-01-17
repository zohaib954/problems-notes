package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MyBinaryTree {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Scanner s = new Scanner(System.in);

    // function to Build tree taking input from user
    Node buildTree() {
        System.out.println("Enter data");
        int data = s.nextInt();
        if (data == -1) {
            return null;
        }
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        }
        newNode.left = buildTree();

        newNode.right = buildTree();

        return newNode;
    }

    // function to iterate pre order traversal
    void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    // Recursive function to iterate in order traversal
    void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // Recursive Function to implement post order traversal
    void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    // Function to implement Bredth First Search
    void BFT(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node f = q.poll();
            System.out.print(f.data + " ");
            if (f.left != null) {
                q.add(f.left);
            }
            if (f.right != null) {
                q.add(f.right);
            }
        }
    }

    // Iterative function to print nodes in inOrder
    void inOrderIterative(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }
    }

    // Function to print nodes as level pattern
    // ex:-
    // 1
    // / \
    // 2 3
    // /\ /\
    // 4 5 6 7

    void printLevelPattern(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node f = q.poll();
            if (f == null && !q.isEmpty()) {
                q.add(null);
                System.out.println();
            } else if (f == null && q.isEmpty()) {
                break;
            } else {
                if (f.left != null) {
                    q.add(f.left);
                }
                if (f.right != null) {
                    q.add(f.right);
                }
                if (f != null) {
                    System.out.print(f.data + " ");
                }
            }
        }
    }

    // function to print only left leaves
    void printLeftleafes(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            System.out.print(root.left.data + " ");
        }
        printLeftleafes(root.left);
        printLeftleafes(root.right);
    }

    // function which gives some of left leaves
    int sumOfLeftLeafs(Node root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.data;
        }
        ans += sumOfLeftLeafs(root.left);
        ans += sumOfLeftLeafs(root.right);

        return ans;
    }

    // Function to convert preOrder array into inOrder tree with the help of
    // preOrder and inPrder Array
    static int preIndex = 0;

    MyBinaryTree.Node preOrderToInOrder(int pre[], int in[], int s, int e) {
        if (s > e) {
            return null;
        }
        int data = pre[preIndex];
        preIndex++;
        MyBinaryTree.Node newNode = new Node(data);
        int index = findIndex(in, data, s, e);
        newNode.left = preOrderToInOrder(pre, in, s, index - 1);
        newNode.right = preOrderToInOrder(pre, in, index + 1, e);

        return newNode;
    }

    // Helper function to find the index of a key of one array to another array.
    // here finding the index of a key(data) inside the array in[] between s(start)
    // to e(left)
    static int findIndex(int in[], int data, int s, int e) {
        for (int i = s; i <= e; i++) {
            if (in[i] == data) {
                return i;
            }
        }
        return 0;
    }

    // Overloaded function to create BST by taking input from user
    MyBinaryTree.Node createBST() {
        int data = 1;
        while (true) {
            System.out.println("Enter Number");
            data = s.nextInt();
            if (data == -1) {
                break;
            }
            Node newNode = new Node(data);
            if (root == null) {
                root = newNode;
            } else {
                traverse(root, newNode, data);
            }
        }
        return root;
    }

    // Overloaded function to create BST by passing input array as a parameter
    MyBinaryTree.Node createBST(int A[]) {
        int n = A.length;
        int data = 0;
        for (int i = 0; i < n; i++) {
            data = A[i];
            if (data == -1) {
                break;
            }
            Node newNode = new Node(data);
            if (root == null) {
                root = newNode;
            } else {
                traverse(root, newNode, data);
            }
        }
        return root;
    }

    // Helper function to traverse right or left to add node in BST
    void traverse(Node root, Node newNode, int data) {
        if (root.left == null && root.data >= data) {
            root.left = newNode;
            return;
        } else if (root.right == null && root.data < data) {
            root.right = newNode;
            return;
        } else if (root.data >= data) {
            traverse(root.left, newNode, data);
        } else if (root.data < data) {
            traverse(root.right, newNode, data);
        }
    }

    // Height balanced BST
    MyBinaryTree.Node balancedBST(int A[], int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        Node root = new Node(A[mid]);

        root.left = balancedBST(A, s, mid - 1);
        root.right = balancedBST(A, mid + 1, e);
        return root;
    }

    int BSTKey = -1;

    int searchBST(Node root, int key) {
        if (root == null) {
            return -1;
        }
        if (root.data == key) {
            return BSTKey = key;
        } else if (root.data > key) {
            return searchBST(root.left, key);
        } else {
            return searchBST(root.right, key);
        }
    }

    // Check if the given Two Nodes are identical in structure as well as in value
    boolean isSameTrees(Node A, Node B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }

        return ((A.data == B.data) && isSameTrees(A.left, B.left) && isSameTrees(A.right, B.right));
    }

    // print all the paths in Tree
    void printPath(Node root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            al.add(root.data);
            printArrayList(al);
            int n = al.size();
            al.remove(n - 1);
            return;
        }

        al.add(root.data);
        printPath(root.left, al);
        printPath(root.right, al);
        int n = al.size();
        al.remove(n - 1);
    }

    void printArrayList(ArrayList<Integer> al) {
        int n = al.size();
        for (int i = 0; i < n; i++) {
            System.out.print(al.get(i) + " ");
        }
        System.out.println();
    }

    // Find the Least Common Ancester(LCA) in a Tree

    Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftAns = LCA(root.left, n1, n2);
        Node rightAns = LCA(root.right, n1, n2);

        if (leftAns != null && rightAns != null) {
            return root;
        }
        if (leftAns != null) {
            return leftAns;
        } else {
            return rightAns;
        }
    }

    // Print Nodes at a level
    void printAtLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            System.out.print(root.data + " ");
            return;
        }
        printAtLevel(root.left, level - 1);
        printAtLevel(root.right, level - 1);

    }

    // Print Nodes of distance K of a given node
    // Given Node root, subNode, int k;
    // you have to print all the nodes of subNode with a distance k;

    int printKdistance(Node root, Node target, int k) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            printAtLevel(root, k);
            return 0;
        }

        return 0;
    }
}