package Trees;

import Trees.MyBinaryTree.MyTreeNode;
public class BasicOperationOnTrees {
    //Inorder Traversal
    /* public int[] inorderTraversal(TreeNode A) {
        ArrayList<Integer> al = new ArrayList<>();
        myList(A,al);
        int i=0;
        int arr[] = new int[al.size()];
        for(Integer value:al){
            arr[i++] = value;
        }
       return arr;
    }

    ArrayList<Integer> myList(TreeNode A, ArrayList x){
        if(A==null){
            return x;
        }   
        myList(A.left,x);
        x.add(A.val);
        myList(A.right,x);
        return x;
    } */
    static int[] inorderTraversal(MyTreeNode A){

    }

    //PreOrdert Traversal
    static int[] preOrderTraversal(MyTreeNode A){
       

        return arr;
    }

    //Count the number of nodes in a tree
    static int countNodes(MyTreeNode A){
        if(A==null){
            return 0;
        }

        return countNodes(A.left) + countNodes(A.right) + 1;

    }

    //Height of tree
    static int height(MyTreeNode A){
        if(A==null){
            return 0;
        }
        int LH = height(A.left);
        int RH = height(A.right);

        return Math.max(LH, RH) + 1;
    }

    //Sum of nodes in Binary Tree
    static int sumOfNodes(MyTreeNode A){
        if(A==null){
            return 0;
        }

        return sumOfNodes(A.left) + sumOfNodes(A.right) + A.data;
    }
    public static void main(String[] args) {
        MyBinaryTree x = new MyBinaryTree();
        MyTreeNode t1 = x.new MyTreeNode(10);
        t1.left = x.new MyTreeNode(20);
        t1.right = x.new MyTreeNode(30);
        t1.right.right = x.new MyTreeNode(40);
        t1.right.left = x.new MyTreeNode(50);
        t1.left.left = x.new MyTreeNode(5);

        System.out.println(height(t1));
        System.out.println(countNodes(t1));
        System.out.println(sumOfNodes(t1));
    }
}
