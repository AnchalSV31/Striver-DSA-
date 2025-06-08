package BST;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class FlattenBT {
    //Brute Force

    // TreeNode prev=null;
    // public void flatten1(TreeNode root){
    //     if(root==null){
    //         return;
    //     }
    //     flatten1(root.right);
    //     flatten1(root.left);
    //     root.right=prev;
    //     root.left=null;
    //     prev=root;
    // }


    //Better Approach[Extension of above method but with additon of Stack]

    // TreeNode prev = null;
    // public void flatten2(TreeNode root){
    //     if(root==null) return;
    //     Stack<TreeNode> st= new Stack<>();
    //     st.push(root);
    //     while(!st.isEmpty()){
    //         TreeNode curr=st.pop();
    //         if(curr.right!=null) st.push(curr.right);
    //         if(curr.left!=null) st.push(curr.left);
    //         if(!st.isEmpty()){
    //             curr.right=st.peek();
    //         }
    //         curr.left=null;
    //     }
    // }


    //Optimised Approach

    public void flatten3(TreeNode root){
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode prev=curr.left;
                while(prev.right!=null){
                    prev=prev.right;
                }
                prev.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }


    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public void printFlattenTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printFlattenTree(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        FlattenBT sol = new FlattenBT();

        System.out.print("Binary Tree Preorder: ");
        printPreorder(root);
        System.out.println();

        // sol.flatten1(root);
        // sol.flatten2(root);
        sol.flatten3(root);

        System.out.print("Binary Tree After Flatten: ");
        sol.printFlattenTree(root);
        System.out.println();
    }
}
