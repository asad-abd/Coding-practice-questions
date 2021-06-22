public class __112_Path_Sum {
    //HHHHigh SMC
    //don't make the code too compact!!!
    //always write condition for root!!!!
    
    //DON'T try to reduce the code too much -- V. RISKYYYYY: WRITE CLEARLY EACH IF CASE IN TREES. 
    //BETTER SAFE THAN OVERSMART
    
    public boolean hasPathSum(TreeNode root, int target) {
        if(root == null) return false;
        
        if(root.left == null && root.right == null)
            if(target - root.val == 0) return true;//SMCDone: missed the - part!!!!
        
        else if(root.left != null && root.right == null)
            return hasPathSum(root.left, target - root.val);

        else if(root.left == null && root.right != null)
            return hasPathSum(root.right, target - root.val);
        
        return hasPathSum(root.left, target - root.val) | hasPathSum(root.right, target - root.val);
    }
}
