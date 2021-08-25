public class _337_House_Robber_III {
    //recursion + memo
    //simply add a hmap. trivial memo
    HashMap<TreeNode, Integer> hmap = new HashMap<>();
    public int rob(TreeNode node) {
        if(node == null) return 0;
        //choose root or choose its children
        if(hmap.containsKey(node)) return hmap.get(node);
        
        int takenRoot = node.val, notTakenRoot = 0;
        if(node.left != null)
            takenRoot += rob(node.left.left) + rob(node.left.right);
        
        if(node.right != null)
            takenRoot += rob(node.right.left) + rob(node.right.right);
        
        notTakenRoot = rob(node.left) + rob(node.right);
        hmap.put(node, Math.max(takenRoot, notTakenRoot));
        return Math.max(takenRoot, notTakenRoot);
    }

    //recursion: correct but TLE
    public int rob(TreeNode node) {
        if(node == null) return 0;
        //choose root or choose its children
        int takenRoot = node.val, notTakenRoot = 0;
        if(node.left != null)
            takenRoot += rob(node.left.left) + rob(node.left.right);
        
        if(node.right != null)
            takenRoot += rob(node.right.left) + rob(node.right.right);
        
        notTakenRoot = rob(node.left) + rob(node.right);
        return Math.max(takenRoot, notTakenRoot);
    }
}
