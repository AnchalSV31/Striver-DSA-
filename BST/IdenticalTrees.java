package BST;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int val){
        data=val;
        left=null;
        right=null;
    }
}
public class IdenticalTrees{
    public boolean isIdentical(Node p, Node q){
        if(p==null || q==null){
            return (p==q);
        }
        return(p.data==q.data) && isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    } 

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        IdenticalTrees solution = new IdenticalTrees();

        if (solution.isIdentical(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }
}
