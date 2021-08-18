public class __236_Lowest_Common_Ancestor_Binary_Tree {
    //M1 - recursive (try visualizing)
    //(to help understand better)
    //in case curr == p or q we will be returning curr as ans.
    //   i. and if its parent's rhs returns null, the parent will also return lhs's result
    //  ii. and if its parent's rhs returns a node, then we return the parent.
    //Notice that we are not returning the parent of the parent as the answer (as in ii.)
    //because for the parent's parent, the rhs will be null! so it'll return whatever its child returned
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q) 
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //if both nodes are on different side of the current node then its the ans.
        //because we cannot find a lower node (curr.left/curr.right) whose child will be the both of them.
        if(left != null && right != null) 
            return root;
        
        if(left != null) 
            return left; //the current node isn't an ancestor and we couldn't find the lca on the rhs
        
        if(right != null) 
            return right; //the current node isn't an ancestor and we couldn't find the lca on the lhs
        
        return null; //the current node isn't an ancestor and we couldn't find the lca on the lhs or the rhs
    }
    //we can also return true/false and convert null to false and save ans in global variable to increase runtime

    //M2 - Iterative, using parent pointers (from solution)
    //If we have parent pointers for each node we can traverse back from p and q to get their ancestors. 
    //The first common node we get during this traversal would be the LCA node. We can save the parent pointers in a dictionary as we traverse the tree.
    //
    //Start from the root node and traverse the tree.
    //Until we find p and q both, keep storing the parent pointers in a dictionary.
    //Once we have found both p and q, we get all the ancestors for p using the parent dictionary and add to a set called ancestors.
    //Similarly, we traverse through ancestors for node q. If the ancestor is present in the ancestors set for p, 
    //this means this is the first ancestor common between p and q (while traversing upwards) and hence this is the LCA node.
    
}
