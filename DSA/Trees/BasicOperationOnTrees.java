package Trees;

public class BasicOperationOnTrees {

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        // MyBinaryTree.Node root = tree.buildTree();

        // tree.preOrderTraversal(root);
        // tree.inOrderTraversal(root);
        // tree.postOrderTraversal(root);
        // tree.BFT(root);
        // tree.inOrderIterative(root);
        // tree.printLevelPattern(root);
        // tree.printLeftleafes(root);
        // System.out.println();
        // int sum = tree.sumOfLeftLeafs(root);
        // System.out.println(sum);

        // int pre[] = { 8, 6, 2, 11, 10, 16, 12, 4, 14, 9, 18, 15 };
        // int in[] = { 11, 2, 6, 16, 10, 12, 8, 14, 4, 18, 9, 15 };
        // int n = pre.length;
        // MyBinaryTree.Node root = tree.preOrderToInOrder(pre, in, 0, n - 1);
        // tree.printLevelPattern(root);
        // System.out.println();
        // tree.preOrderTraversal(root);
        // System.out.println();
        // tree.inOrderTraversal(root);

        // MyBinaryTree.Node root = tree.createBST();
        // tree.printLevelPattern(root);

        // int randomArr[] = { 27, 14, 35, 10, 19, 31, 42, 7, 12, 22, 29, 37, 50, 5, 9,
        // 16, 24, 33, 40, 48, -1 };
        // MyBinaryTree.Node root = tree.createBST(randomArr);
        // System.out.println(tree.searchBST(root, 1));

        // int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // MyBinaryTree.Node root = tree.balancedBST(A, 0, A.length - 1);
        // tree.printLevelPattern(root);

        // MyBinaryTree.Node root = tree.buildTree();

        // ArrayList<Integer> al = new ArrayList<>();
        // tree.printPath(root, al);

        MyBinaryTree.Node root = tree.buildTree();
        tree.printAtLevel(root, 2);
    }
}
