class Solution {
    public int removeElement(int[] nums, int val) {
        int end = -1, i = 0;
        //++ end only if 'i' is valid number
        int count = 0;
        while(i < nums.length){
            if(nums[i] != val){
                nums[end + 1] = nums[i];
                end ++;
            }
            else
                count ++;
            i ++;
        }
        return nums.length - count;
    }
}
