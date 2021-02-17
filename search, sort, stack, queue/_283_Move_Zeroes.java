class _283_Move_Zeroes {
    //2 pointer approach: 0ms
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int nonZero=0, i=0;
        while(i<n){
            if(nums[i]!=0){
                nums[nonZero]=nums[i];
                nonZero++;
            }
            i++;
        }
        for(i=nonZero; i<n; i++){
            nums[i]=0;
        }
        return;
    }

    //first soln: slow and inefficient
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int i=0, count0=0;
        for(int num: nums){
            if(num==0) count0++;
        }
        if(count0==0) return;
        
        while(count0>0){
            if(nums[i]==0){
                //shift everything right to the left and add a 0 to the end;
                //n-i-1 elements on the right
                for(int j=i+1;j<n;j++){
                    nums[j-1]=nums[j];
                }
                nums[n-1]=0;
                count0--;
                continue;//because we may have shifted a 0 from right to left.
            }
            i++;
        }
        return;
    }
}
