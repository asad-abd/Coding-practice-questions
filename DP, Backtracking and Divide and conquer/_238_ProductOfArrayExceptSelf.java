//division not allowed in question
class _238_ProductOfArrayExceptSelf {
    //O(1) space and linear time - follow up
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];//initially we store lhs product in it 
        //then we traverse from back and store the rhs product in a constant and multiply it with the ans[i] (in which we are storing the lhs product)
        if(n==0)
            return ans;
        ans[0] = 1;
        for(int i = 1; i < n; i ++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        
        int prodRight = 1;
        for(int i = n - 1;i >= 0; i --){
            ans[i] = ans[i] * prodRight;
            prodRight = prodRight * nums[i];
        }
        return ans;
    }

    //O(n) space and time
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int output[]=new int[n];
        if(n==0)
            return output;
        int prodLeft[]=new int[n];
        int prodRight[]=new int[n];
                
        prodLeft[0]=1;
        for(int i=1;i<n;i++){
            prodLeft[i]=prodLeft[i-1]*nums[i-1];
        }
        
        prodRight[n-1]=1;
        for(int i=n-2;i>=0;i--){
            prodRight[i]=prodRight[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            output[i]=prodLeft[i]*prodRight[i];
        }
        return output;
    }
}
