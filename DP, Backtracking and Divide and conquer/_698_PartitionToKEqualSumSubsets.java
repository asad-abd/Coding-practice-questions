// MUST REVIEW!
class _698_PartitionToKEqualSumSubsets {
    public boolean canPartitionIntoSubsets(int []nums,int k,boolean visited[], int st, int currSubsetSum,int ReqSum){
        if(k==1) return true;
        if(currSubsetSum>ReqSum) return false;
        if(currSubsetSum==ReqSum) return canPartitionIntoSubsets(nums,k-1,visited,0,0, ReqSum);
        
        for(int i=st;i<nums.length;i++){
            if(visited[i]) continue;
            
            visited[i]=true;
            
            if(canPartitionIntoSubsets(nums,k,visited,i+1,currSubsetSum+nums[i], ReqSum))
                return true;
            // else
            visited[i]=false;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0,maxnum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxnum=Math.max(maxnum,nums[i]);
        }
        if(sum%k!=0|| maxnum>sum/k || nums.length<k)
            return false;
    
        return canPartitionIntoSubsets(nums,k,new boolean[nums.length], 0,0,sum/k);
    }
}
