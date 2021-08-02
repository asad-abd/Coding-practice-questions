//classic dp problem
class _198_House_Robber {
    //DL 29/06/21 - 0ms
    public int knap(int nums[], int n, int[] t){
        if(n <= 0) return 0;
        
        if(t[n] != -1) return t[n];
        
        return t[n] = Math.max(nums[n-1] + knap(nums, n - 2, t), knap(nums, n - 1, t));
        
    }
    public int rob(int[] nums) {
        int t[] = new int [nums.length+1];
        for(int i = 0; i <= nums.length; i++)
            t[i] = -1;
        return knap(nums, nums.length, t);
    }

    //memoization with hashmap solution: 264 ms (slow)
    HashMap<String,Integer> hmap = new HashMap<>();
    public int rob1(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];
        
        return robbing(nums,0,n-1);
    }
    public int robbing(int nums[],int st, int end){
        if(st>end)
            return 0;
        if(st==end)
            return nums[st];
        int max=0;
        for(int i=st;i<=end;i++){
            int sum=0;
            sum+=nums[i];
            if(!hmap.containsKey(st+","+(i-2)) )
                hmap.put(st+","+(i-2),robbing(nums,st,i-2));
            if(!hmap.containsKey((i+2)+","+end) )
                hmap.put((i+2)+","+end,robbing(nums,i+2,end));
            sum+=hmap.get(st+","+(i-2))+hmap.get((i+2)+","+end);
            max=Math.max(max,sum);
        }
        hmap.put(st+","+end,max);
        return max;
    }
}
