//R1 Aug done
class _108_ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }

    public TreeNode makeBST(int[] nums, int st, int end) {
        if (end < st)
            return null;
        int mid = (st + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeBST(nums, st, mid - 1);
        node.right = makeBST(nums, mid + 1, end);

        return node;
    }
}