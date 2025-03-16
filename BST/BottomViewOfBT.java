package BST;

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
public class BottomViewOfBT {
    class Pair{
        int data;
        Node node;
        public Pair(Node node, int data){
            this.node=node;
            this.data=data;
        }
    }
    public List<Integer> bottomView(Node root){
        List<Integer> ans= new ArrayList<>();
        if(root==null) return ans;

        Map<Integer,Integer> map= new TreeMap<>();
        Queue<Pair>q= new LinkedList<>();
        q.add(new Pair(root, 0)); 

        while(!q.isEmpty()){
            Pair it= q.poll();
            Node node= it.node;
            int line= it.data;

            map.put(line,node.data);

            if(node.left!=null) q.add(new Pair(node.left, line-1));

            if(node.right!=null) q.add(new Pair(node.right, line+1));
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
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

        BottomViewOfBT obj = new BottomViewOfBT();
        List<Integer> ans = obj.bottomView(root);

        System.out.println("Bottom View of BT:");
        for(int node: ans){
            System.out.print(node + " ");
        }
    }
}
