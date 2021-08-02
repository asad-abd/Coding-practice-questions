public class _740_Delete_and_Earn_knapsack {
    
    public int deleteAndEarn(int[] nums) {//first try (my soln)
        //O(n*logn) due to sorting
        //make a new ArrayList of (num, freq) -> then normal knapsack
        Arrays.sort(nums);
        ArrayList<int[]> arr = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int j = i, freq = 0;
            while(j < nums.length && nums[i] == nums[j]){
                freq++;
                j++;
            }
            arr.add(new int[]{nums[i], freq});
            i = j;
        }
        int t[]=new int[arr.size()];// select or not select
        
        t[0] = arr.get(0)[0] * arr.get(0)[1]; //number * freq
        for(i = 1; i < arr.size(); i++){
            int prev = arr.get(i-1)[0];
            if(arr.get(i)[0] - 1 == prev){//cannot take it in the [i]
                if(i > 1){
                    t[i] = Math.max(arr.get(i)[0] * arr.get(i)[1] + t[i-2], t[i-1]);
                }
                else
                    t[i] = Math.max(arr.get(i)[0] * arr.get(i)[1], t[i-1]);
            }
            else
                t[i] = arr.get(i)[0] * arr.get(i)[1] + t[i-1];
            
        }
        return t[arr.size()-1];
    }
}
