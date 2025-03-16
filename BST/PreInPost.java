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


public class PreInPost{

    static class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node,int state){
            this.node=node;
            this.state=state;
        }   
    }

    public static List<List<Integer>> preInPostTraversal(TreeNode root) {
            List<Integer> pre = new ArrayList<>();
            List<Integer> in = new ArrayList<>();
            List<Integer> post = new ArrayList<>();
    
            if (root == null) {
                return new ArrayList<>();
            }
    
            Stack<Pair> st = new Stack<>();
    
            st.push(new Pair(root, 1));

        while (!st.empty()) {
            Pair current = st.pop();
            // this is part of pre
            if (current.state == 1) {
                // Store the node's data in the preorder traversal
                pre.add(current.node.val);
                // Move to state 2 (inorder) for this node
                current.state = 2;
                // Push the updated state back onto the stack
                st.push(current);

                // Push left child onto the stack for processing
                if (current.node.left != null) {
                    st.push(new Pair(current.node.left, 1));
                }
            }

            // this is a part of in
            else if (current.state == 2) {
                // Store the node's data
                // in the inorder traversal
                in.add(current.node.val);
                // Move to state 3
                // (postorder) for this node
                current.state = 3;
                // Push the updated state
                // back onto the stack
                st.push(current);

                // Push right child onto
                // the stack for processing
                if (current.node.right != null) {
                    st.push(new Pair(current.node.right, 1));
                }
            }

            // this is part of post
            else {
                // Store the node's data
                // in the postorder traversal
                post.add(current.node.val);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }

        public static void printList(List<Integer> list) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
    
            List<List<Integer>> traversals = PreInPost.preInPostTraversal(root);

            List<Integer> in = traversals.get(0);
            List<Integer> pre = traversals.get(1);
            List<Integer> post = traversals.get(2);
        
            System.out.print("Inorder traversal: ");
            printList(in);
            System.out.print("Preorder traversal: ");
            printList(pre);

            System.out.print("Postorder traversal: ");
            printList(post);
        }
}



