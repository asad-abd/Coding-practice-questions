class _102_BFS_OG {
    //recursive.
    public void BFS(TreeNode node, List<List<Integer>> ans, int level){
        List<Integer> list = new ArrayList<>();
        if(node==null)
            return ;
        System.out.println(ans.size());
        if(ans.size()<=level){
            //System.out.println("added");
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(node.val);
        if(node.left!=null)
            BFS(node.left, ans, level+1);
        if(node.right!=null)
            BFS(node.right, ans, level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> LIST = new ArrayList<>();
        BFS(root, LIST, 0);
        return LIST;
    }
}
