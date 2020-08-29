/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class _95_UniqueBinaryTreesII {
    public List<TreeNode> genT(int st, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (st > end) {
            list.add(null);
            return list;
        }
        if (st == end) {
            TreeNode n = new TreeNode(st);
            list.add(n);
            return list;
        }
        for (int i = st; i <= end; i++) {
            List<TreeNode> left = genT(st, i - 1);
            List<TreeNode> right = genT(i + 1, end);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode n = new TreeNode(i);
                    n.left = left.get(j);
                    n.right = right.get(k);
                    list.add(n);
                }
            }
        }
        return list;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            return list;
        }
        return genT(1, n);
    }
}