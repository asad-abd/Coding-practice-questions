//uses kadane's algo
class _152_MaximumProductSubarray {
    //ultra small code idea : lee from leetcode
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int fromLeft=1,fromRight=1;
        for(int i=0;i<nums.length;i++){
            fromLeft= (fromLeft ==0 ? 1: fromLeft) * nums[i];
            fromRight= (fromRight ==0 ? 1: fromRight) * nums[nums.length-i-1];
            max=Math.max(max,Math.max(fromLeft, fromRight));
        }
        return max;
    }
    
    //my logic, beats 93%: separate the array in chunks divided by indices 'i' with nums[i]==0
    //then on the separate peices, 
    //i)  if even number of -ve nums, ans id product of that chunk
    //ii) else either remove all the numbers from the beginning till the first -ve
    //          or all the nums from the last num tll the last negative number index. 
    public int maxProdUtil(int nums[],int st,int end){
        if(st>end) return Integer.MIN_VALUE;
        if(st==end) return nums[st];
        int prod=1;
        ArrayList<Integer> indexNeg=new ArrayList<>();
        for(int i=st;i<=end;i++){
            if(nums[i]<0){ 
                indexNeg.add(i);
            }
            prod*=nums[i];
            
        }
        if(indexNeg.size()%2==0) return prod;
        int right=prod;
        int left=prod;
        for(int i=st;i<=indexNeg.get(0);i++)
            right/=nums[i];
        for(int i=end;i>=indexNeg.get(indexNeg.size()-1);i--)
            left/=nums[i];
        return Math.max(left,right);
    }
    public int maxProduct(int[] nums) {
        int maxNum=nums[0];
        int maxAns=0;
        ArrayList<Integer> separator=new ArrayList<>();
        separator.add(-1);
        for(int i=0;i<nums.length;i++){
            maxNum=Math.max(maxNum,nums[i]);
            if(nums[i]==0) separator.add(i);
        }
        separator.add(nums.length);
        
        
        maxAns=maxNum;
        //positive ans possible
        for(int i=0;i<separator.size()-1;i++){
            
            maxAns=Math.max( maxAns,maxProdUtil( nums,separator.get(i)+1,separator.get(i+1)-1 ) );
        }
        return maxAns;
    }
}
