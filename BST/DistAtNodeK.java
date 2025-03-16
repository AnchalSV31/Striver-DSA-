package BST;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class DistAtNodeK {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent, TreeNode track){
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr= q.poll();
            if(curr.left!=null){
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        Map<TreeNode, TreeNode> parent= new HashMap<>();
        markParents(root, parent, null);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(target);
        vis.put(target, true);

        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k) break;
            curr_level++;
            for(int i=0; i<size; i++){
                TreeNode curr= q.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                    q.offer(curr.left);
                    vis.put(curr.left, true);
                }
                if(curr.right!=null && vis.get(curr.right)==null){
                    q.offer(curr.right);
                    vis.put(curr.right, true);
                }
                if(parent.get(curr)!=null && vis.get(parent.get(curr))==null){
                    q.offer(parent.get(curr));
                    vis.put(parent.get(curr), true);
                }
            }
        }
        List<Integer> ans= new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr= q.poll();
            ans.add(curr.val);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(3);
        root.left= new TreeNode(5);
        root.right= new TreeNode(1);
        root.left.left= new TreeNode(6);
        root.left.right= new TreeNode(2);
        root.right.left= new TreeNode(0);
        root.right.right= new TreeNode(8);
        root.left.right.left= new TreeNode(7);
        root.left.right.right= new TreeNode(4);

        DistAtNodeK obj= new DistAtNodeK();
        List<Integer> ans= obj.distanceK(root, root.left, 2);

        System.out.println(ans);

    }
}
