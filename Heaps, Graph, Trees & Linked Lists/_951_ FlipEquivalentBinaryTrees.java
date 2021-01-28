
class _951_FlipEquivalentBinaryTrees {
    // done first time in 30 mins/ 20 mins and missed the end case [null],[1].
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null && root2 != null || root2 == null && root1 != null)
            return false;
        if (root1.val != root2.val)
            return false;
        int l1, l2, r1, r2;
        l1 = l2 = r1 = r2 = -1;
        if (root1.left != null)
            l1 = root1.left.val;
        if (root2.left != null)
            l2 = root2.left.val;
        if (root1.right != null)
            r1 = root1.right.val;
        if (root2.right != null)
            r2 = root2.right.val;

        if (l1 == l2 && r1 == r2)
            return flipEquiv(root1.left, root2.left) & flipEquiv(root1.right, root2.right);

        else if (l1 == r2 && l2 == r1)
            return flipEquiv(root1.left, root2.right) & flipEquiv(root2.left, root1.right);

        else
            return false;
    }
    // Two null trees are flip equivalent
    // A non-null and null tree are NOT flip equivalent
    // Two non-null trees with different root values are NOT flip equivalent
    // Two non-null trees are flip equivalent if
    // The left subtree of tree1 is flip equivalent with the left subtree of tree2
    // and the right subtree of tree1 is
    // flipequivalent with the right subtree of tree2 (no flip case)
    // OR
    // The right subtree of tree1 is flip equivalent with the left subtree of tree2
    // and the left subtree of tree1 is
    // flipequivalent with the right subtree of tree2 (flip case)
}