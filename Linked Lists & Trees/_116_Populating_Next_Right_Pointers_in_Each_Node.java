/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    //soln 1: Queue type bfs using O(n) space
    
    //soln 2: O(1) space (except for recursion stack space):
    // TreeNode next = null;
    // we'll move from the top.
    // basically level order traversal from the rhs.
    public Node connect(Node root) {
        if(root == null) return root;
        
        if(root.right != null && root.next != null && root.next.left != null)
            root.right.next = root.next.left;

        if(root.left != null && root.right != null)
            root.left.next = root.right;
            
        if(root.right != null) root.right = connect(root.right);
        if(root.left != null) root.left = connect(root.left);
        
        return root;
    }
}