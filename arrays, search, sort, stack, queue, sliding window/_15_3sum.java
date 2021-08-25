public class _15_3sum {
    //fix 'i' and move j-> <-k (2 pointer)
    
    //IMP: notice the condition: if(i>0 && nums[i]==nums[i-1]) continue;
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<3) return ans;
        
        Arrays.sort(nums);
        //fix 'i' and move j-> <-k (2 pointer)
        for(int i=0;i<nums.length-2;i++){
            int j=i+1, k=nums.length-1;
            if(i>0 && nums[i]==nums[i-1]) continue;
            //we are skipping the cases where nums at i=i+1 and j,k give us the answer. 
            //we are not missing any case in this way because the j and k are common after i+1 bu the 'i's are both same.
            
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //increment j till unique
                    while(j < nums.length - 1 && nums[j]==nums[j+1])
                        j++;
                    while(k > i && nums[k]==nums[k-1])
                        k--;  
                    j++;
                    k--;
                }
                else if(sum > 0){
                    k--;
                }
                else
                    j++;
            }
        }
        return ans;
    }
    
    // using hset (not so good for interviews)
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<3) return ans;
        HashSet<String> hset= new HashSet<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            int j=i+1, k=nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    String str = "" + nums[i] + "," + nums[j] + "," + nums[k];
                    if(!hset.contains(str)){
                        hset.add(str);
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    j++;
                    k--;
                }
                else if(sum > 0){
                    k--;
                }
                else
                    j++;
            }
        }
        return ans;
    }
}
