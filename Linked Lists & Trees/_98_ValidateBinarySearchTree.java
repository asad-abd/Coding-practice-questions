//R1 sep done
class _98_ValidateBinarySearchTree {
    // my solution.- get an inorder traversal list and if tree is
    // BST, list should be in ascending order
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) <= list.get(i))
                return false;
        }
        return true;

    }

    public static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (root.left != null)
            inorder(root.left, list);
        list.add(root.val);
        if (root.right != null)
            inorder(root.right, list);
    }

    // Why is the below approach wrong??
    // counter eg (Just see and think)
    // ---- 10
    // --- /--|
    // -- 5 --15
    // --/ | / |
    // - n n 6 20 (n=null)

    public boolean WRONGisValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null && root.right != null) {
            if (root.val <= root.left.val || root.right.val <= root.val)
                return false;
            return isValidBST(root.left) && isValidBST(root.right);
        } else if (root.left == null && root.right != null) {
            if (root.right.val <= root.val)
                return false;
            return isValidBST(root.right);
        } else if (root.left != null && root.right == null) {
            if (root.val <= root.left.val)
                return false;
            return isValidBST(root.left);

        } else {
            System.out.println("Err" + root.val);
            return true;
        }

    }
}