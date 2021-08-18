class _199_Binary_Tree_RHS_View {
    //In interview suggest the bfs one first

    //O(n) recursive - dfs (good to know this as well)
    public void rhsView(TreeNode node, int currDepth, List<Integer> ans){
        if(node == null) return;
        
        if(ans.size() < currDepth) ans.add(node.val);
        
        rhsView(node.right, currDepth + 1, ans);
        rhsView(node.left, currDepth + 1, ans);//this will add a node to answer if there is no right child of the parent node.
        
        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rhsView(root, 1, ans);
        return ans;
    }

    //O(n) iterative soln - bfs (more intuitive) 
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans =new ArrayList<Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        if(root==null){
            
            return ans;
        }
        q.add(root);
        while(q.size()>0){
            int n=q.size();
            
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(i==n-1)
                    ans.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);

            }
        }
        return ans;
    }
}
