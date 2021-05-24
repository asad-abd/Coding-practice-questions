class _643_Maximum_average_subarray_I {
    //typical sliding window
    public double findMaxAverage(int[] nums, int k) {
        int i=0, sum=0;
        double max=0.0;
        for(;i<k;i++){
            sum+=nums[i];
        }
        max=(double)sum/k;
        while(i<nums.length){
            //add nums[i] & remove nums[i-k]
            sum+=nums[i]-nums[i-k];
            max=Math.max((double)sum/k, max);
            i++;
        }
        return max;
    }
}
