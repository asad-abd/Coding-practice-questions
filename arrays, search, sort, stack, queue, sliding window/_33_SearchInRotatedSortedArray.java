class _33_SearchInRotatedSortedArray {
    //use concepts from #152 here.
    //the lhs and rhs of least number element are both sorted.
    //Find the least number index then do BS(LHS) and BS(RHS)
    public int BinarySearchIndex(int A[], int Start, int End, int num){
        int st=Start, end=End, mid, n=End-Start+1;
        while(st<=end){
            mid=st+(end-st)/2;
            if(A[mid]==num)
                return mid;
            if(num<A[mid])
                end=mid-1;
            else
                st=mid+1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int st=0, end=nums.length-1, mid, n=nums.length;
        int index=0;
        //if(nums[st]>nums[end])
        while(st<=end){
            mid=st+(end-st)/2;
            int prev=(mid-1+n)%n;
            int next=(mid+1)%n;
            if(nums[mid]<nums[prev] && nums[mid]<nums[next]){
                index=mid;
                break;
            }
            //SMC if I use nums[st] instead of nums[0];
            if(nums[0]<=nums[mid])
                st=mid+1;
            else
                end=mid-1;
        }
        //System.out.println(index);
        if(nums[index]==target) return index;
        int left=BinarySearchIndex(nums, 0, index-1, target);
        if(left!=-1) return left;
        
        int right=BinarySearchIndex(nums, index+1, n-1, target);
        if(right!=-1) return right;
        
        return -1;
    }
}
