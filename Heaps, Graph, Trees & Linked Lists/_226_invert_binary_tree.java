public class _226_invert_binary_tree {
    //O(n): since we're visiting each node only once
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        //change the root and return it
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        
        return root;
    }
    //iterative (soln)
    public TreeNode invertTreeIter(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
