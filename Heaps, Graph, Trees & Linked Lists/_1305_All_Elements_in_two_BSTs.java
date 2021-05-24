import java.util.*;
class _1305_All_Elements_in_two_BSTs {
    public void inorder(TreeNode node, List<Integer> list){
        if(node==null) return;
        
        inorder(node.left, list);
        
        list.add(node.val);
        
        inorder(node.right, list);
    }
    public List<Integer> mergeLists(TreeNode root1, TreeNode root2){
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        int i=0,j=0;
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)==l2.get(j)){
                ans.add(l1.get(i));
                ans.add(l1.get(i));
                i++;
                j++;
            }
            else if(l1.get(i)<l2.get(j)){
                ans.add(l1.get(i));
                i++;
            }
            else{
                ans.add(l2.get(j));
                j++;
            }
        }
        while(i<l1.size()){
            ans.add(l1.get(i));
            i++;
        }
        while(j<l2.size()){
            ans.add(l2.get(j));
            j++;
        }
        return ans;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return mergeLists(root1, root2);
    }
}
