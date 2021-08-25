public class _437_Path_Sum_III {
    //My solution
    //Each recursive call return the possible 2 sums list:
    //1. sum while only considering the node
    //2. sum while considering the node and F_recursion(left child).
    //3. sum while considering the node and F_recursion(right child).
    int ans;
    public ArrayList<Integer> possibleSums(TreeNode node, int target){
        //We can choose to either return the node's val or its sum with lhs() or its sum with rhs()
        ArrayList<Integer> sums = new ArrayList<Integer>();
        if(node == null)
            return sums;
        if(node.val == target)
            ans ++;
        sums.add(node.val);
        ArrayList<Integer> lhs = possibleSums(node.left, target);
        ArrayList<Integer> rhs = possibleSums(node.right, target);
        int sum;
        for(int lhsSums: lhs){
            sum = node.val + lhsSums;
            if(sum == target)
                ans ++;
            sums.add(sum);
        }
        for(int rhsSums: rhs){
            sum = node.val + rhsSums;
            if(sum == target)
                ans ++;
            sums.add(sum);
        }
        return sums;
    }
    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        possibleSums(root, targetSum)
        //System.out.println(possibleSums(root, targetSum));
        return ans;
    }

    //---------------------------------------------------------------------------------------------//
    //Someone else's solution - really smart code. worst case O(n^2), best O(nlogn) for balanced tree
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
