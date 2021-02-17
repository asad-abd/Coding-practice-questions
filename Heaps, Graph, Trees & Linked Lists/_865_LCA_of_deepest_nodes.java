class _865_LCA_of_deepest_nodes {
    //The idea is simple, if the maxDepth(left) and maxDepth(right) are the same then return the current node.
    //Since we are calculating the left maxDepth, right maxDepth first, and then coming to the node, LRN => postorder traversal!!

    //Below approach however is a simpler version. Store max depths of in a hashmap and then do bfs to check 
    //if maxDepth(left) and maxDepth(right) are the same or not. return BFS(node.left) if maxDepth(left)>maxDepth(right) and vice versa.
    HashMap<TreeNode,Integer> maxDepth = new HashMap<>();
    public int MaxDepth(TreeNode node){
        if(node==null){
            maxDepth.put(node, 0);
            return 0;
        }
        if(node.left==null && node.right==null){
            maxDepth.put(node, 1);
            return 1;
        }
        int m_depth=1+Math.max(MaxDepth(node.left), MaxDepth(node.right));
        maxDepth.put(node, m_depth);
        return m_depth;
    }
    public TreeNode BFS(TreeNode node){
        if(node==null)
            return null;
        if(node.left==null && node.right==null){
            return node;
        }
        if(node.left==null )
            return BFS(node.right);
        if(node.right==null)
            return BFS(node.left);
        //none null
        if(maxDepth.get(node.left)==maxDepth.get(node.right))
            return node;
        if(maxDepth.get(node.left)<maxDepth.get(node.right))
            return BFS(node.right);
        return BFS(node.left);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int m_depth=MaxDepth(root);
        return BFS(root);
    }
}
