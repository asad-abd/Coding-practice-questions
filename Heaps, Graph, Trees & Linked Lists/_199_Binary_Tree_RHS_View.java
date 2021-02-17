class _199_Binary_Tree_RHS_View {
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
