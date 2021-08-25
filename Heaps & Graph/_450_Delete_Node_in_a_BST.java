class _450_Delete_Node_in_a_BST {
    //IMPPPP: HIGH SMC
    public TreeNode findMinRIght(TreeNode node){
        //System.out.println(node.val);
        if(node.left==null)//SMC: DON'T CHECK RIGHT!!!
            return node;
        return findMinRIght(node.left);
    }
    public TreeNode delete(TreeNode node, int key) {
        if(node==null) return null;
        
        if(key>node.val){
            //now we know that the rhs of node will be changed (if at all)
            //so, update the rhs of node, i.e., node.right
            node.right = delete(node.right, key);
        }
        else if(key<node.val){
            //now we know that the lhs of node will be changed (if at all)
            //so, update the lhs of node, i.e., node.left
            node.left = delete(node.left, key);
        }
        else{//node.val==key
            //System.out.println(node.val+ "blah");
            if(node.left==null && node.right==null){
                return null;// this null is returned to the parent of this node.
            }       
            else if(node.left!=null && node.right==null){
                return node.left;
            }
            else if(node.left==null && node.right!=null){
                return node.right;
            }
            else{//(node.left!=null && node.right!=null)
                //find minimum on RHS. assign its value to the current node and delete that minimum node using the same function on the rhs. 
                TreeNode minRight = findMinRIght(node.right);
                node.val=minRight.val;
                //System.out.println(node.val  +" - "+minRight.val+ " yo ");                
                //SMC DONE: UPDATE THE right branch of curr node
                node.right = delete(node.right, node.val);
            }
        }
        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode temp=delete(root,key);
        return temp;
    }
}
