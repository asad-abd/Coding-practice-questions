public class _1480_running_sum_ez {
    public int[] runningSum(int[] nums) {
        int i = 1;
        while (i<nums.length){
            nums[i]+=nums[i-1];
            i++;
        }
        return nums;
    }
}
