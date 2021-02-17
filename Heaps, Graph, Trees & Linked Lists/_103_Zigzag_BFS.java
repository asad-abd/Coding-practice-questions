class _103_Zigzag_BFS {
    //suggest a 2 stack solution in interview
    //or use addFirst() function of LinkedList<>()
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        boolean normal=true;
        while(q.size()>0){
            int size=q.size();
            List<Integer> currLevel=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                currLevel.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            if(!normal){
                Collections.reverse(currLevel);
                ans.add(currLevel);
            }
            else
                ans.add(currLevel);
            normal=!normal;
        }
        return ans;
    }
}
