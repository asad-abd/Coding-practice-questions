import java.util.*;
class _662_MaximumWidthOfBinaryTree {
    //sep 15 - 2022
    // dfs to assign integer values to each node.
    // assigning numbers: think like how we do in a heap
    // i -> 2*i + 1 (left child), 2*i + 2 (right child)
    // here we don't have to use -ve numbers etc. simply imagine a heap -> simply the subtract the rightmost and leftmost indices
    // then bfs to check the max difference
    
    // we can simply do using a simple bfs 
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max_width = 1; // root
        
        HashMap<TreeNode, Integer> hmap = new HashMap<>();
        hmap.put(root, 1);
        while(q.size() > 0){
            int size_curr_level = q.size();
            
            int leftmost_curr_level = 1000;
            int rightmost_curr_level = -1000;
            
            for(int i = 0; i < size_curr_level; i ++){ // pop the parent nodes -> check their max diffs
                TreeNode node = q.remove();
                int curr_node_val = hmap.get(node);
                if(i == 0)
                    leftmost_curr_level = curr_node_val;
                if(i == size_curr_level - 1)
                    rightmost_curr_level = curr_node_val;
                // rest is normal bfs - push the children
                if(node.left != null){
                    q.add(node.left);
                    hmap.put(node.left, curr_node_val * 2 + 1);
                }
                if(node.right != null){
                    q.add(node.right);
                    hmap.put(node.right, curr_node_val * 2 + 2);
                }
            }
            int max_width_curr_level = rightmost_curr_level - leftmost_curr_level + 1;
            max_width = Math.max(max_width, max_width_curr_level);
        }
        return max_width;
    }

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
