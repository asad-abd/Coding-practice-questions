import java.util.*;

public class BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // done easily (iterative approach)- BFS and print last of every level
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) {

            return ans;
        }
        q.add(root);
        while (q.size() > 0) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (i == n - 1)
                    ans.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

            }
        }
        return ans;

    }
}