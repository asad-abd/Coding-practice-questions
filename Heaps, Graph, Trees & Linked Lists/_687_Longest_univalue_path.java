class _687_Longest_univalue_path {

    //below solution is slow but works
    ////bfs. 
    //for each node: consider it as root, note its value (val)
    //then do dfs on its left and right child and return left+right (also pass in the value of root)
    //left= Max(f(root.left.left), f(root.left.right)) + Max(f(root.right.left), f(root.right.right))
    public int longestUtil(TreeNode node, int val){
        if(node==null)
            return 0;
        if(node.val!=val)
            return 0;
        return 1 + Math.max(longestUtil(node.left, val), longestUtil(node.right, val));
       
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int longest=0;
        while(q.size()>0){
            TreeNode node=q.poll();
            longest=Math.max(longestUtil(node.left,node.val)+longestUtil(node.right,node.val) , longest);
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
        }
        return longest;
    }
}
