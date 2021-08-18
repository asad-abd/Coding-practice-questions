class _222_CountCompleteTreeNodesLOGn2 {
    //Calculate the left most height=l, calculate the rightmost height=r starting from a particular node.
    //if l==r then return 2^l-1. -> O(logn)
    //else (l>r) return f(node.left) + f(node.right) + 1 (for the current node)
    //Since at every level we do calculations that take O(logn) time. Total time complexity is
    //O((number of levels) * logn) = O(height * logn) = O(logn * logn) = O(logn^2)
    public int heightL(TreeNode node){
        if(node==null)
            return 1;
        return 1 + heightL(node.left);
    }
    public int heightR(TreeNode node){
        if(node==null)
            return 1;
        return 1 + heightR(node.right);
    }
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        
        int l=heightL(root.left);
        int r=heightR(root.right);
        //System.out.println("left length: "+l+" right length: "+r);
        
        if(l==r)
            return (1<<l)-1;
        
        return countNodes(root.left) + 1 + countNodes(root.right) ;
    }
}
