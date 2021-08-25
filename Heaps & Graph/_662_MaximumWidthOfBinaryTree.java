import java.util.*;
class _662_MaximumWidthOfBinaryTree {
    //The idea is to map the nodes with integers similar to heaps. node=i, left=2*i+1, right=2*i+2 
    //keep a check of the min and max number associated with a node on each level and return Maximum(max-min+1)
    public int widthOfBinaryTree(TreeNode root) {
        int max;
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
            return 0;
        q.add(root);
        max=1;
        int st=0;
        int end=0;
        HashMap<TreeNode, Integer> hmap = new HashMap<>();
        hmap.put(root,0);
        while(q.size()>0 ){
            //System.out.println("loop");
            int n=q.size();
            st=Integer.MAX_VALUE;
            end=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode node=q.remove();
                st=Math.min(st,hmap.get(node));
                end=Math.max(end,hmap.get(node));
                if(node.left!=null){
                    hmap.put(node.left,2*hmap.get(node)+1);
                    q.add(node.left);
                }
                if(node.right!=null){
                    hmap.put(node.right,2*hmap.get(node)+2);
                    q.add(node.right);
                }
            }   
            max=Math.max(max,end-st+1);
        }
        return max;
        
    }
}
