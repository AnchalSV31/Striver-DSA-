package BinarySearchTree;

public class FloorCeil {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val=x;
            left=null;
            right=null;
        }
    }

    //Ceil in BST  [find smallest val>=key]
    public static int findCeil(TreeNode root, int key){
        int ceil=-1;
        while(root!=null){
            if(root.val==key){
                ceil=root.val;
                return ceil;
            }
            if(key>root.val){
                root=root.right;
            }else{
                ceil=root.val;
                root=root.left;
            }
        }
        return ceil;
    }

    public static int findFloor(TreeNode root, int key){
        int floor=-1;
        while(root!=null){
            if(root.val==key){
                floor=root.val;
                return floor;
            }
            if(key>root.val){
                floor=root.val;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        int target=8;
        System.out.println(findCeil(root, target));
        System.out.println(findFloor(root, target));
    }


}
