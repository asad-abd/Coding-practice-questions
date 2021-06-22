public class _18_4Sum {
    //Good one, read te editorial for k-sum format.
    //make sure that the ksum function has st instead of 0 (where ever necessary)!!
    public List<List<Integer>> threeSum(int st, int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<3) return ans;
        
        //Arrays.sort(nums);
        //fix 'i' and move j-> <-k (2 pointer)
        for(int i=st;i<nums.length-2;i++){
            int j=i+1, k=nums.length-1;
            if(i>st && nums[i]==nums[i-1] ) continue;
            //we are skipping the cases where nums at i=i+1 and j,k give us the answer. 
            //we are not missing any case in this way because the j and k are common after i+1 bu the 'i's are both same.
            
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //increment j till unique
                    while(j < nums.length - 1 && nums[j]==nums[j+1])
                        j++;
                    while(k > i && nums[k]==nums[k-1])
                        k--;  
                    j++;
                    k--;
                }
                else if(sum > target){
                    k--;
                }
                else
                    j++;
            }
        }
        return ans;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<4) return ans;
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            
            List<List<Integer>> _3sum = threeSum(i+1, nums, target - nums[i]);
            //for each list triplet, add nums[i] to it
            for(List<Integer> list : _3sum){
                List<Integer> temp = new ArrayList<>(list);
                temp.add(0, nums[i]);//add to the front
                ans.add(temp);
            }
        }
        //System.out.println(threeSum(1, nums, 6));
        return ans;
    }
}
