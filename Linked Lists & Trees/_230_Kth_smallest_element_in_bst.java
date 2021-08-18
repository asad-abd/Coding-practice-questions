//inoder list based solution (only way i guess)
class _230_Kth_smallest_element_in_bst {
    //sol2: 1ms (no algo change, only minor tweaks)
    public void inorder(TreeNode node, List<Integer> list){
        if(node==null)
            return;
        inorder(node.left, list);
        
        list.add(node.val);
        
        inorder(node.right, list);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        if(list.size()<k)
            return -1;
        return list.get(k-1);
       
    }
    //sol1: 2ms
    public List<Integer> inorder(TreeNode node){
        List<Integer> list = new ArrayList<>();
        if(node==null)
            return list;
        List<Integer> left=inorder(node.left);
        list.addAll(left);
        
        list.add(node.val);
        
        List<Integer> right=inorder(node.right);
        list.addAll(right);
        return list;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = inorder(root);
        if(list.size()<k)
            return -1;
        return list.get(k-1);
       
    }
}
