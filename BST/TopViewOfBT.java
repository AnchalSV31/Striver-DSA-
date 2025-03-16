package BST;

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class TopViewOfBT {
    class Pair{
        int data;
        Node node;
        public Pair(Node node, int data){
            this.node=node;
            this.data=data;
        }
    }
    
    List<Integer> topView(Node root){
        List<Integer> ans= new LinkedList<>();
        if(root==null) return ans;
        Map<Integer, Integer> map= new TreeMap<>();
        Queue<Pair>q= new LinkedList<>();
        
        q.add(new Pair(root,0));        

        while(!q.isEmpty()){
            Pair it= q.remove();
            int line=it.data;
            Node temp = it.node;
            
            if(map.get(line)==null) map.put(line, temp.data);
            if(temp.left!=null){
                q.add(new Pair(temp.left, line-1));
            }
            if(temp.right!=null){
                q.add(new Pair(temp.right, line+1));
            }
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

        TopViewOfBT obj = new TopViewOfBT();
        List<Integer> ans = obj.topView(root);

        System.out.println("Vertical Traversal: ");
        for (int node : ans) {
            System.out.print(node + " ");
        }
    }
}
