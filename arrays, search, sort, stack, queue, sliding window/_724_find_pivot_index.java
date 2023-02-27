public class _724_find_pivot_index {
    // 2/23: first instinct, basic
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum += num;
        
        int t = 0;
        for(int i = 0; i < nums.length; i ++){
            if(i > 0)
                t += nums[i - 1];
            if (t == sum - t - nums[i])
                return i;
        }
        return -1;
    }

    // old: donno what is this overcomplication
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n<1) return -1;
        //add 0s at the ends
        int lhs[]=new int[n+2];
        int rhs[]=new int[n+2];
        
        lhs[0]=0;
        lhs[n+1]=0;
        for(int i=1;i<=n;i++)
            lhs[i]=lhs[i-1]+nums[i-1];
        
        rhs[0]=0;
        rhs[n+1]=0;
        for(int i=n;i>=1;i--)
            rhs[i]=rhs[i+1]+nums[i-1];
        
        for(int i=1;i<=n;i++){
            if(lhs[i-1]==rhs[i+1]){
                return i-1;
            }
        }
        return -1;
    }
}
