class _623_Add_One_Row_to_Tree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue <TreeNode> q= new LinkedList<>();
        q.add(root);
        int level=1;
        TreeNode insert;
        if(d==1){
            insert=new TreeNode(v);
            insert.left=root;
            return insert;
        }
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(level!=d-1){
                    if(node.left!=null)
                        q.add(node.left);
                    if(node.right!=null)
                        q.add(node.right);
                }
                else{
                    insert=new TreeNode(v);
                    insert.left=node.left;
                    node.left=insert;
                
                    insert=new TreeNode(v);
                    insert.right=node.right;
                    node.right=insert;
                }
            }
            if(level==d-1) return root;
            level++;
        }
        return root;
    }
}
