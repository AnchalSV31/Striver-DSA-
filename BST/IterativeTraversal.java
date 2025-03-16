package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}


public class IterativeTraversal {

    //PREORDER
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        if (root == null) {
            return preorder;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.empty()) {
            root = st.pop();
            preorder.add(root.val);
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return preorder;
    }

    //INORDER

    public static void inorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return arr;
    }


    //POSTORDER [TWO STACK]

    public static List<Integer> postOrder1(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) {
            return postorder;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);
        while (!st1.empty()) {
            root = st1.pop();
            st2.push(root);
            if (root.left != null) {
                st1.push(root.left);
            }
            if (root.right != null) {
                st1.push(root.right);
            }
        }

        while (!st2.empty()) {
            postorder.add(st2.pop().val);
        }

        return postorder;
    }


    //ONE STACK

    static void postorder2(TreeNode root, List<Integer> arr){
        if(root == null){
            return;
        }
        // Traverse left subtree
        postorder2(root.left, arr);
        // Traverse right subtree
        postorder2(root.right, arr);
        // Visit the node
        // (append node's data to the array)
        arr.add(root.val);
    }

    static List<Integer> postOrder2(TreeNode root){
        List<Integer> arr = new ArrayList<>();
        postorder2(root, arr);
        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        IterativeTraversal sol = new IterativeTraversal();
        List<Integer> pre = sol.preorderTraversal(root);

        System.out.print("Preorder Traversal: ");
        for (int val : pre) {
            System.out.print(val + " ");
        }
        System.out.println();


        List<Integer> in = inOrder(root);
        System.out.print("Inorder Traversal: ");
        for (int val : in) {
            System.out.print(val + " ");
        }
        System.out.println();


        // List<Integer> post = postOrder1(root);
        List<Integer> post = postOrder2(root);
        System.out.print("Postorder traversal: ");
        for (int val : post) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
