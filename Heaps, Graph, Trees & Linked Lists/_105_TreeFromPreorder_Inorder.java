class _105_TreeFromPreorder_Inorder {
    //review note: try to take a sample tree and write its preorder traversal (you'll see it then). 
    //be careful of the code in "node.right... Also look at _108
    HashMap <Integer, Integer> inorderIndex=new HashMap<>();
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart>preorder.length-1 || inStart>inEnd)
            return null;
        if(preStart==preorder.length-1)
            return new TreeNode(preorder[preStart]);
        
        TreeNode node=new TreeNode(preorder[preStart]);
        int nodeIndexInInorderList=inStart;
        /*for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==node.val){
                nodeIndexInInorderList=i;
                break;
            }
        }*/
        nodeIndexInInorderList=inorderIndex.get(node.val);
        node.left=helper(preStart+1,inStart,nodeIndexInInorderList-1,preorder,inorder);
        
        node.right=helper(preStart+1+nodeIndexInInorderList-inStart, nodeIndexInInorderList+1, inEnd, preorder, inorder);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
            inorderIndex.put(inorder[i], i);
        return helper(0,0,inorder.length-1, preorder,inorder);
    }
    
    // older: not good code
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
