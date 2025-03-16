package BST;

import java.util.*;

// class Node{
//     int val;
//     Node left;
//     Node right;
//     Node(int val) {
//         this.val = val;
//         left = right = null;
//     }
// }

public class BurningTree {

    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
            left = right = null;
        }
    } 
    public static int findMaxDistance(HashMap<Node, Node> mpp, Node target){
        Queue<Node> q= new LinkedList<>();
        q.offer(target);
        HashMap<Node,Integer> vis= new HashMap<>();
        vis.put(target, 1);
        int maxi=0;

        while(!q.isEmpty()){
            int sz=q.size();
            int fl=0;

            for(int i=0; i<sz; i++){
                Node curr= q.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                    fl=1;
                    vis.put(curr.left, 1);
                    q.offer(curr.left);
                }
                if(curr.right != null && vis.get(curr.right) == null){
                    fl=1;
                    vis.put(curr.right,1);
                    q.offer(curr.right);
                }
                if(mpp.get(curr)!=null && vis.get(mpp.get(curr))==null){
                    fl=1;
                    vis.put(mpp.get(curr), 1);
                    q.offer(mpp.get(curr));
                }
            }
            if(fl==1) maxi++;
        }
        return maxi;
    }

    public static Node bfsToMapParents(Node root, HashMap<Node, Node> mpp, int start){
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        Node res=null;

        while(!q.isEmpty()){
            Node curr= q.poll();
            if(curr.val==start) res=curr;
            if(curr.left!=null){
                mpp.put(curr.left,curr);
                q.offer(curr.left);
            }   
            if(curr.right!=null){
                mpp.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        return res;
    }

    public static int timeToBurn(Node root, int start) {
        HashMap<Node, Node> mpp= new HashMap<>();
        Node target= bfsToMapParents(root, mpp, start);
        return findMaxDistance(mpp, target);
    }

    public static void main(String[] args) {
        Node root= new Node(50);
        root.left= new Node(30);
        root.right= new Node(70);
        root.left.left= new Node(20);
        root.left.right= new Node(40);
        root.right.left= new Node(60);
        root.right.right= new Node(80);

        int  result = timeToBurn(root, 20);

        System.out.println(result);
    }
}
