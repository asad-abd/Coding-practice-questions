class Solution {
    //note: it is BST NOT binary tree!!
    public TreeNode trimBST(TreeNode root, int l, int r) {
        if(root == null) return null;
        if(root.left == null && root.right == null) {
            if(root.val < l || root.val > r)
                return null;
            return root;
        }
        
        
        if(root.val < l){ // implies that lhs is also < l ==> trim it
            //rhs can be new root.
            root = trimBST(root.right, l, r);
        }
        else if(root.val > r){ // implies that rhs is also > r ==> trim it
            root = trimBST(root.left, l, r);
        } 
        else{ // if node is within [l, r]
            root.left = trimBST(root.left, l, r);
            root.right = trimBST(root.right, l, r);
        }
        return root;
    }
}
