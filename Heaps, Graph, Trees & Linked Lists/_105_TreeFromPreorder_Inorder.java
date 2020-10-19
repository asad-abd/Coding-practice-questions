class _105_TreeFromPreorder_Inorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0) return null;
        HashMap<Integer,Integer> inordr=new HashMap<>(); 
        for(int i=0;i<inorder.length;i++){
            inordr.put(inorder[i],i);            
        }
        int nodeIndex=preorder.length;
        for(int i=0;i<preorder.length;i++){
            if(inordr.containsKey(preorder[i])){
                nodeIndex=inordr.get(preorder[i]);
                break;
            }
            
        }
        int l1[]=Arrays.copyOfRange(inorder,0,nodeIndex);
        int l2[]=Arrays.copyOfRange(inorder,nodeIndex+1,inorder.length);
        TreeNode Node=new TreeNode(inorder[nodeIndex]);
        Node.left=buildTree(preorder,l1);
        Node.right=buildTree(preorder,l2);
        return Node;
    }
}
