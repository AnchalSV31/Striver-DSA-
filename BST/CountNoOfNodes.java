package BST;

//COUNT NUMBER OF NODES IN A COMPLETE BINARY TREE

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CountNoOfNodes {
    public void inorder(TreeNode root, int[] count) {
        if (root == null) {
            return;
        }

        count[0]++;
        inorder(root.left, count);
        inorder(root.right, count);
    }

    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] count = {0};
        inorder(root, count);
        return count[0];
    }


    //OPTIMAL SOLUTION

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = findHeightLeft(root);
        int rh = findHeightRight(root);

        // If the heights are equal, the tree
        // is a full binary tree, and we can
        // calculate the total nodes
        if (lh == rh) {
            return (1 << lh) - 1;
        }

        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

    private int findHeightLeft(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int findHeightRight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        CountNoOfNodes sol = new CountNoOfNodes();

        // int totalNodes = sol.countNodes1(root);
        int totalNodes = sol.countNodes2(root);

        System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
    }
}
