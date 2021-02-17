class _312_Burst_Balloons_mcm {
    //recursion + memo (dp)
    //instead of popping the kth balloon first, pop it at last!!!! (amazing modification)
    int solve(int arr[], int i, int j, int t[][]){
        if(i>j)
            return 0;
        //Since we are considering the kth balloon to burst at last. It maybe that this is a subproblem
        //of the OG problem. So there may already be a balloon that hasn't been burst yet. 
        //So, multiply the value of arr[k] with the baloon that hasn't been burst yet.(the balloon of the parent problem of this sub problem)
        if(t[i][j]!=-1)
            return t[i][j];
        int max=Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
            int coins=arr[k];
            if(i-1>=0) coins*= arr[i-1];
            if(j+1<arr.length) coins*= arr[j+1];
            //recursion
            coins+= solve(arr, i, k-1, t) + solve(arr, k+1, j, t);
            
            max=Math.max(max, coins);
        }
        //memoization
        return t[i][j]=max;
    }
    public int maxCoins(int[] nums) {
        int t[][]=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length;j++)
                t[i][j]=-1;

        return solve(nums, 0, nums.length-1, t);
    }

    //initial recursive code(TLE for n>11), gives correct ans for n<12
    int solve(int arr[]){
        if(arr.length<1)
            return 0;
        System.out.println(Arrays.toString(arr));
       
        int max=Integer.MIN_VALUE;
        for(int k=0; k<arr.length; k++){
            int temp_arr[]=new int[arr.length-1];
            
            for(int i=0,j=0;i<arr.length;i++)
                if(i!=k)
                    temp_arr[j++]=arr[i];
                
            int coins=1;
            coins*= (k==0 ? 1 : arr[k-1]);
            coins*= (k==arr.length-1 ? 1 : arr[k+1]);
            coins*= arr[k];
            coins+=solve(temp_arr); // recursion
            max=Math.max(max, coins);
        }
        return max;
    }
    public int maxCoins(int[] nums) {
        return solve(nums);
    }
}
