class _152_FindMininimumInRotatedSortedArray {
    //cleaner code (aditya verma YT)
    public int findMin(int[] nums) {
        int st=0, end=nums.length-1, mid, n=nums.length;
        if(nums[st]<=nums[end])return nums[st];
        while(st<=end){
            mid=st+(end-st)/2;
            int prev=(mid+n-1)%n;//small but ELEGANT modification
            int next=(mid+1)%n;//small but ELEGANT modification
            if(nums[prev]>nums[mid] && nums[next]>nums[mid]){
                return nums[mid];
            }
            if(nums[0]<=nums[mid])//LHS is sorted. 
                st=mid+1; //move to right
            //else if(nums[mid]<=nums[end])
            else
                end=mid-1;
        }
        return nums[0];
    }

    //first code
    //SMC (in below one) on the st==end condition
    public int findMin(int[] nums) {
        int st=0, end=nums.length-1, mid;
        if(nums[st]<=nums[end])return nums[st];//SMC
        if(end==0)
            return nums[0];
        if(end==1)
            return Math.min(nums[0],nums[1]);
        while(st<=end){
            mid=st+(end-st)/2;
            if(st==end)
                return nums[st];
            if(mid>0 && mid<nums.length-1 && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                return nums[mid];
            }
            if(nums[0]<=nums[mid])//LHS is sorted. 
                st=mid+1; //move to right
            //else if(nums[mid]<=nums[end])
            else
                end=mid-1;
        }
        return nums[0];
    }
}
