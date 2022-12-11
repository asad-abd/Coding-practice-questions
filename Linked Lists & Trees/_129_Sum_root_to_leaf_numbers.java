class Solution {
    int ans;
    public void dfs(TreeNode node, ArrayList<Integer> Curr_nums){
        if(node == null) {
            // make curr_nums to int and append to all
            int Num = 0;
            for(int num: Curr_nums)
                Num = Num * 10 + num;
            ans += Num;
            return;
        }
        ArrayList<Integer> curr_nums = new ArrayList<>(Curr_nums);
        
        curr_nums.add(node.val);
        
        if(node.left != null && node.right != null){
            dfs(node.left, curr_nums);
            dfs(node.right, curr_nums);
        }
        
        else if(node.right == null)
            dfs(node.left, curr_nums);
        
        else
            dfs(node.right, curr_nums);
        
    }
    public int sumNumbers(TreeNode root) {
        ans = 0;
        dfs(root, new ArrayList<>());

        return ans;
    }
}