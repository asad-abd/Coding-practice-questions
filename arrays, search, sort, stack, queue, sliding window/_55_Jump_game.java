class Solution {
    /*
    [2,1,2,1,4], last index = 4

    i = 0
    consider 2 jumps 
    we can reach 1 and 1 -> i = 1
    
    i = 1
    consider 1 jumps -> i = 1 + 1 => 2

    */
    // Keyword: Boundary/ current MAX REACH
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        int max = 0;

        // we can only iterate the next i if the boundary(our max reach) is greater than or equal to i
        for(int i = 0; max >= i; i ++){
            max = Math.max(max, nums[i] + i);
            if(max >= n - 1)
                return true;
        }
        if(max < n - 1)
            return false;
        return true;
    }
}