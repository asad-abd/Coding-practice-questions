public class _1448_Count_Good_Nodes_in_Binary_Tree {
    //pretty ez and strgt forward. 
    //other method is to do iterative bfs while storing maxTillNow in the queue.
    public int dfs(TreeNode node, int maxTillNow){
        if(node == null) return 0;
        if(node.val >= maxTillNow){
            return 1 + dfs(node.left, node.val) + dfs(node.right, node.val);
        }
        return dfs(node.left, maxTillNow) + dfs(node.right, maxTillNow);
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
}
