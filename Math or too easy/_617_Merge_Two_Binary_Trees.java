public class _617_Merge_Two_Binary_Trees {
    public TreeNode mergeTrees(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return null;
        TreeNode newNode;
        if(n1 == null && n2 != null){
            newNode = new TreeNode(n2.val);
            newNode.left = mergeTrees(null, n2.left);
            newNode.right = mergeTrees(null, n2.right);
        }
        else if(n1 != null && n2 == null){
            newNode = new TreeNode(n1.val);
            newNode.left = mergeTrees(n1.left, null);
            newNode.right = mergeTrees(n1.right, null);
        }
        else{
            newNode = new TreeNode(n1.val + n2.val);
            newNode.left = mergeTrees(n1.left, n2.left);
            newNode.right = mergeTrees(n1.right, n2.right);
        }
        return newNode;
    }
}
