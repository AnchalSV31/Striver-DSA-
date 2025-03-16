package BST;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    private TreeNode root;

    // Constructor for BinaryTree
    public BinaryTree() {
        this.root = null;
    }

    // Insert method to add a new node with the given value
    public void insert(int val) {
        root = insertRec(root, val);
    }

    // Recursive helper function to insert a new value in the tree
    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val); // Create a new node
            return root;
        }

        // If value is smaller, go to the left subtree
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        }
        // If value is greater, go to the right subtree
        else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    // Delete method to remove a node with the given value
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    // Recursive helper function to delete a node
    private TreeNode deleteRec(TreeNode root, int val) {
        // Base case: if the tree is empty
        if (root == null) {
            return root;
        }

        // Recurse down the tree to find the node to be deleted
        if (val < root.val) {
            root.left = deleteRec(root.left, val);
        } else if (val > root.val) {
            root.right = deleteRec(root.right, val);
        }
        // Found the node to be deleted
        else {
            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children, get the inorder successor (smallest in the right subtree)
            root.val = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    // Helper function to find the minimum value node in a given tree
    private int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }

    // In-order traversal (Left, Root, Right)
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    // Recursive helper function for in-order traversal
    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.val + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-order traversal (Root, Left, Right)
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    // Recursive helper function for pre-order traversal
    private void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-order traversal (Left, Right, Root)
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    // Recursive helper function for post-order traversal
    private void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print traversals
        System.out.print("In-order traversal: ");
        tree.inOrder();

        System.out.print("Pre-order traversal: ");
        tree.preOrder();

        System.out.print("Post-order traversal: ");
        tree.postOrder();

        // Delete a node
        System.out.println("Deleting node 20");
        tree.delete(20);

        // Print traversals after deletion
        System.out.print("In-order traversal after deletion: ");
        tree.inOrder();
    }
}
