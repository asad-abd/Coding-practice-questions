import java.util.*;
class __gfg_Boundary_Traversal_of_binary_tree {

    //VV IMP question
    //NOTE (many twists): like in LHS, if node.left==null, move to node.right and do the same!!

    //do INORDER TRAVERSAL with the only condition of root (node.left==null && node.right==null)
    public void addLeaf(Node node, ArrayList<Integer> ans){
        if (node == null)
            return;

        addLeaf(node.left, ans);
        // Add it if it is a leaf node
        if (node.left == null && node.right == null)
            ans.add(node.data);
        addLeaf(node.right, ans);
    }
    public void lhs(Node node, ArrayList<Integer> ans){
        //node, then left
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            ans.add(node.data);
            lhs(node.left, ans);
        }
        else if (node.right != null) {
            ans.add(node.data);
            lhs(node.right, ans);
        }
    }
    public void rhs(Node node, ArrayList<Integer> ans){
        //right, then node
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            rhs(node.right,ans);
            ans.add(node.data);
        }
        else if (node.left != null) {
            rhs(node.left,ans);
            ans.add(node.data);
        }
    }
    public ArrayList<Integer> printBoundary(Node node){
	    ArrayList<Integer> ans = new ArrayList<>();
        if(node==null)
            return ans;
        if(node.left==null && node.right==null){
            ans.add(node.data);
            return ans;
        }
        //VVIMP
        ans.add(node.data);
        
        lhs(node.left, ans);
        
        //to avoid the case then root is leaf
        //print leaves of left subtree  (if exists)
        addLeaf(node.left, ans);
        
        //print leaves of right subtree (if exists)
        addLeaf(node.right, ans);
        
        rhs(node.right, ans);
        return ans;
	}
    
    //first approach
    //WA: confusion in what is asked to print.
    public ArrayList<Integer> printBoundary(Node node){
	    ArrayList<Integer> ans = new ArrayList<>();
        if(node==null)
            return ans;
        if(node.left==null && node.right==null){
            ans.add(node.data);
            return ans;
        }
        
        //BFS for lhs and rhs view (excluding leaf)
        ArrayList<Integer> lhs = new ArrayList<>();
        ArrayList<Integer> rhs = new ArrayList<>();
        ArrayList<Integer> leaf = new ArrayList<>();
        
        Queue<Node> q= new LinkedList<>();
        q.add(node);
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(i==0 && (curr.left!=null || curr.right!=null)){
                    //not leaf
                    lhs.add(curr.data);
                }
                else if(i==size-1 && (curr.left!=null || curr.right!=null)){
                    //not leaf
                    rhs.add(curr.data);
                }
                else if(curr.left==null && curr.right==null){
                    leaf.add(curr.data);
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        for(int i=0;i<lhs.size();i++)
            ans.add(lhs.get(i));
        for(int i=0;i<leaf.size();i++)
            ans.add(leaf.get(i));
        for(int i=rhs.size()-1;i>=0;i--)
            ans.add(lhs.get(i));
        return ans;
	}
}
