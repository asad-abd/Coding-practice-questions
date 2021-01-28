// same as 698 with k=4 
//backtracking
class _473_matchsticks_to_square {
    public boolean partitionInto4(int nums[],boolean taken[], int setnumber, int targetSum, int currentSum, int st){
        if(setnumber==4) return true;
        if(currentSum>targetSum) return false;
        if(currentSum==targetSum) return partitionInto4(nums,taken,setnumber+1,targetSum,0,0);
        
    
        for(int i=st;i<nums.length;i++){
            if(taken[i]) continue;
            
            taken[i]=true;
            if( partitionInto4(nums,taken,setnumber,targetSum,currentSum+nums[i],i+1) == true){
                return true;}
            
            taken[i]=false;
            
            
        }
        return false;
    }
    public boolean makesquare(int[] nums) {
        int sum=0,maxnum=0;
        for(int i: nums){
            sum+=i;
            maxnum=Math.max(maxnum,i);
        }
        
        if(sum%4!=0 || maxnum> sum/4 || nums.length<4)
            return false;
        
        return partitionInto4(nums,new boolean[nums.length],0,sum/4,0,0);
    }
}
