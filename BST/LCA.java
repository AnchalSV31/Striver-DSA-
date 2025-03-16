package BST;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LCA {
    //IN BT
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null or root is one of p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively find the LCA in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // If one of the left or right subtree has a non-null value, return that
        return left != null ? left : right;
    }


    //OPTIMAL APPROACH [IN BST]

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val<root.val && q.val<root.val){
                root=root.left;
            }else if(p.val>root.val && q.val>root.val){
                root=root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}
