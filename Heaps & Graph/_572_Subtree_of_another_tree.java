public class _572_Subtree_of_another_tree {
    //good one
    public boolean isSame(TreeNode n1, TreeNode n2){
        if(n1==null && n2==null) return true;
        if(n1==null || n2==null) return false;
        
        if(n1.val == n2.val) return isSame(n1.left, n2.left) & isSame(n1.right, n2.right);
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        
        if(isSame(root, subRoot)) return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
