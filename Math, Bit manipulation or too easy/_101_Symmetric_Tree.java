public class _101_Symmetric_Tree {
    //M1: iterative level order traversal - EZ
    //M2: recursive - simultaneous bfs
    public boolean isSym(TreeNode n1, TreeNode n2){
        //NOTE: left of n1 must be compared with right of n2
        if(n1 == null && n2 == null) return true;
        if(n1 == null && n2 != null || n1 != null && n2 == null)
            return false;
        if(n1.left == null && n2.right != null || n1.right == null && n2.left != null)
            return false;
        if(n1.val != n2.val) return false;
        
        return isSym(n1.left, n2.right) & isSym(n1.right, n2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right != null || root.right == null && root.left != null)
            return false;
        
        return isSym(root.left, root.right);
    }
}
