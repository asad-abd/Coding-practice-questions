class _1367_LinkedListInBinaryTree {
    // O(n2)
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                ListNode h = head;
                if (isSubPathOrNot(h, node)) {

                    return true;
                }
                // System.out.println(head.val+" "+ node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

        }
        return false;
    }

    public boolean isSubPathOrNot(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        if (root.val != head.val)
            return false;
        boolean ans = false;
        ans = ans | isSubPathOrNot(head.next, root.left) | isSubPathOrNot(head.next, root.right);
        // System.out.println(head.val+" "+ root.val+ " - "+ans);
        return ans;

    }
}
