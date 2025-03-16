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

public class DiameterOfBT {
    int diameter = 0;

    int calculateHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    
    int diameterOfBT1(Node root) {
        calculateHeight(root);
        return diameter;
    }


    //OPTIMAL APPROACH

    public int diameterOfBT2(Node root) {
        int[] diameter = new int[1];
        diameter[0] = 0;
        height(root, diameter);
        return diameter[0];
    }

    private int height(Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }

        int[] lh = new int[1];
        int[] rh = new int[1];
        lh[0] = height(node.left, diameter);
        rh[0] = height(node.right, diameter);

        diameter[0] = Math.max(diameter[0], lh[0] + rh[0]);

        return 1 + Math.max(lh[0], rh[0]);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        DiameterOfBT solution = new DiameterOfBT();

        // int diameter = solution.diameterOfBT1(root);
        int diameter = solution.diameterOfBT2(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }

}
