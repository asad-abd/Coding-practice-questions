import java.util.*;
public class _543_Diameter_of_Binary_Tree {
    //second code, less code
    //basically 2 things simultaneously happen at every vertex,
    // 1) consider this vertex to be a part of the diameter (check if the sum of the left_max and right_max is more than the current max_ans ) &
    // 2) don't consider it a part of the diameter (return the maximum of the left and right subtrees +1)
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter_root=maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode node){
        if(node==null)
            return 0;
        int l=0,r=0;
        if(node.left!=null)
            l=maxDepth(node.left);
            
        if(node.right!=null)
            r=maxDepth(node.right);
        max=Math.max(max,l+r);
        return 1+Math.max(l,r);
        
    }

    //first code
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter_root=maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode node){
        if(node==null)
            return 0;
        if(node.left!=null && node.right!=null){
            int l=maxDepth(node.left);
            int r=maxDepth(node.right);
            int temp =1 + Math.max(l, r);
            max=Math.max(max,l+r+2);
            return temp;
        }
        if(node.left==null && node.right==null){
            int temp = 0;
            max=Math.max(max,temp);
            return temp;
        }
        if(node.left!=null){
            int temp =1 + maxDepth(node.left);
            max=Math.max(max,temp);
            return temp;
        }
        else{
            int temp =1 + maxDepth(node.right);
            max=Math.max(max,temp);
            return temp;
        }
        
    }
}
