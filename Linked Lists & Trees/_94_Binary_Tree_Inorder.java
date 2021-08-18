class _94_Binary_Tree_Inorder {
    //iterative: resee
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        if(root.left==null && root.right==null){
            list.add(root.val);
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr=root;
        while(stack.size()>0 || curr!=null){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            list.add(curr.val);
            curr=curr.right;//this part is req to be without 'if'
            
        }
        return list;
    }

    //recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        if(root.left==null && root.right==null){
            list.add(root.val);
            return list;
        }
        List<Integer> left=inorderTraversal(root.left);
        list.addAll(left);
        
        list.add(root.val);
        
        List<Integer> right=inorderTraversal(root.right);
        list.addAll(right);
        
        return list;
    }
}
