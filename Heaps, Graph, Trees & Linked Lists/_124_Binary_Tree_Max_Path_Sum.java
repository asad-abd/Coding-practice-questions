//hard problem. DP YT - Aditya verma
class _124_Binary_Tree_Max_Path_Sum {
    int ans=Integer.MIN_VALUE;
    public int maxUtil(TreeNode node){
        //base case
        if(node==null)
            return 0;
        //inductive hypothesis
        int l=maxUtil(node.left);
        int r=maxUtil(node.right);
        //inductive step
        int temp=Math.max(Math.max(l,r), 0)+node.val;//part of answer
        temp=Math.max(temp,Math.max(l+r,0)+node.val);//root of ans
        ans=Math.max(ans,temp);
        return Math.max(Math.max(l,r), 0)+node.val;
    }
    public int maxPathSum(TreeNode root) {
        
        int res=maxUtil(root);
        return ans;
    }
}
