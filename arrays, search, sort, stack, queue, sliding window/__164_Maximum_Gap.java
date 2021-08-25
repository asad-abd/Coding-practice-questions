public class __164_Maximum_Gap {//O(n): Pigeon hole/buckets, HARD and amazing
//interview advice: transition from nlogn sorting solution to
//bucket sorting with max-min+1 buckets, then
//optimizing the number of buckets used -> thinking about what could limit the number of buckets then ask for hint
//then suggest the buckets to be of some(average) interval size!

//1. decide a bucket size and create 2 buckets arrays (max and min)
//2. map each number to a bucket (only max and min of a bucket are useful in this question)
//3. iterate over buckets and take max(bucketMIN[i]-prevMAX)
//DONE!

    //create n-1 buckets (lists)
    //if all gaps/intervals are assumed to be of equal size -> this is the least the max_gap answer could be, i.e., the answer max_gap is atleast greater than or equal to the average gap(which considers all intervals to be of same length)
    //Hence: max_gap >= average_gap(average bucket size)
    //since we know that the max_gap >= average bucket size -> the elements in the same bucket can never give us our desired answer!
    //WE NEED TO MAP NUMBERS TO THEIR RESPECTIVE BUCKETS
    //SOME BUCKETS MAYBE EMPTY SO WE NEED TO STORET THE MAX OF PREVIOUS BUCKETS 
    public int maximumGap(int[] nums) {
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        if(n<2) return 0;
        if(n==2) return Math.abs(nums[1]-nums[0]);
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        //we'll have n-1 buckets. and each bucket will have its max and min
        //WE NEED TO MAP NUMBERS TO THEIR RESPECTIVE BUCKETS
        for(int num:nums){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        if(max==min) return 0;
        int avgGapSize = (int)Math.ceil((double)(max-min)/(n-1));
        int bucketMax[]=new int[n];//ideally, should be n-1 but to  
        int bucketMin[]=new int[n];//put max in a bucket in worst case we need this.
        
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        //placing nums in their respective buckets
        for(int num:nums){
            //i=>intervalIndex
            int i = (int)((num-min)/avgGapSize);
            bucketMin[i]=Math.min(bucketMin[i],num);
            bucketMax[i]=Math.max(bucketMax[i],num);
        }//since buckets may not be filled in order, we need to check for consecutive buckets later;
        
        int prevMax=bucketMax[0];//=min
        for(int i=1;i<n;i++){//over buckets
            if(bucketMin[i]==Integer.MAX_VALUE)
                continue;
            
            ans=Math.max(ans,bucketMin[i]-prevMax);
            prevMax=Math.max(prevMax,bucketMax[i]);
            
            //ans=Math.max(ans,bucketMin[i]-bucketMax[i-1]);
            // this is wrong because some buckets maybe empty!
        }
        return ans;
        
    }
}
