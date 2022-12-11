// https://leetcode.com/problems/binary-tree-postorder-traversal/

class Solution {
    // soln 2: do using loop - iterative


    // soln 1: 
    List<Integer> ans;
    public void postT(TreeNode node) {
        if(node == null) return;
        
        // inorder: L N R
        // preorder: N L R
        // post: L R N
        
        if(node.left != null) postT(node.left);
        if(node.right != null) postT(node.right);
        
        ans.add(node.val);
        
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        postT(root);
        
        return ans;
    }
}