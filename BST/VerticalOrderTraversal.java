package BST;
                            
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}

class VerticalOrderTraversal{
    public List<List<Integer>> verticalT(TreeNode root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            if(!map.containsKey(col)){
                map.put(col, new TreeMap<>());
            }

            if(!map.get(col).containsKey(row)){
                map.get(col).put(row, new PriorityQueue<>());
            }

            map.get(col).get(row).add(node.val);

            if(node.left != null){
                q.add(new Tuple(node.left, row + 1, col - 1));
            }

            if(node.right != null){
                q.add(new Tuple(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> col : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : col.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            for (int node : level) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        VerticalOrderTraversal solution = new VerticalOrderTraversal();

        List<List<Integer>> verticalTraversal = solution.verticalT(root);

        System.out.println("Vertical Traversal: ");
        printResult(verticalTraversal);
    }
}
    