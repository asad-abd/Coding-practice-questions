public class _938_Range_Sum_of_BST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        //Node Left Right
        if(root == null) return 0;
        if(root.val >= low && root.val <= high) 
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        
        if(root.val > low){
            //ignore the rhs tree since its even more than node
            return rangeSumBST(root.left, low, high);
        }
        else
            return rangeSumBST(root.right, low, high);
    }
}
