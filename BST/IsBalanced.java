package BST;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class IsBalanced {
    public boolean isBalanced1(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 &&
            isBalanced1(root.left) &&
            isBalanced1(root.right)) {
            return true;
        }

        return false;
    }

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }


    //OPTIMAL APPROACH

    public boolean isBalanced2(Node root) {
        return dfsHeight(root) != -1;
    }

   
    public int dfsHeight(Node root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);

        if (leftHeight == -1) 
            return -1;

        int rightHeight = dfsHeight(root.right);

        if (rightHeight == -1) 
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)  
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        IsBalanced solution = new IsBalanced();

        if (solution.isBalanced2(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
