package BST;

import java.util.ArrayList;
import java.util.List;

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

public class RightLeftSideView {
    public List<Integer> rightsideView(Node root) {
        List<Integer> res = new ArrayList<>();
        recursionRight(root, 0, res);
        return res;
    }

    public List<Integer> leftsideView(Node root) {
        List<Integer> res = new ArrayList<>();
        recursionLeft(root, 0, res);
        return res;
    }

    private void recursionLeft(Node root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.data);
        }
        recursionLeft(root.left, level + 1, res);
        recursionLeft(root.right, level + 1, res);
    }


    private void recursionRight(Node root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.data);
        }
        recursionRight(root.right, level + 1, res);
        recursionRight(root.left, level + 1, res);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        RightLeftSideView solution = new RightLeftSideView();
        List<Integer> rightView = solution.rightsideView(root);

        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();


        List<Integer> leftView = solution.leftsideView(root);
        System.out.print("Left View Traversal: ");
        for (int node : leftView) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

}
