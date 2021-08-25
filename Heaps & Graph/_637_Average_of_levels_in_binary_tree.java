class _637_Average_of_levels_in_binary_tree {
    List<Double> list = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int count = queue.size();
        double sum = 0;
        for (int i = 0; i < count; i++) {
            TreeNode cur = queue.poll();
            sum += cur.val;
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        list.add(sum / count);
    }
    return list; 
}
