public class __47_Permutations_II {
    ////Sort the array and pass. Now we avoid duplicate permutations by checking if the s[i] and s[i-1] chars are equal. If equal and we haven't alredy chosen s[i-1] then we won't choose s[i]. This is so that we avoid the case when we have the subsequence {...s[i]...s[i-1]} and {...s[i-1]...s[i]}. since both are the same! {...X...X} and {...X...X}
    
    //modification from part I _46 is that we are not going to consider the element at index that is marked as taken previously
    //NOTE: WE AREN'T MARKING THE NUMBER ITSELF (because they can repeat) BUT THE INSTANCE OF THAT CHAR AT INDEX 'i' can't repeat!!
    //infact, we can do the same in _46 (instead of checking if the value itself is present, check if the index is taken or not)
    public void permute(int[] nums, int ind, ArrayList<Integer> tempList, List<List<Integer>> ans, boolean[] taken){
        if(ind >= nums.length){
            ans.add(new ArrayList<>(tempList));
            return;
        }
        //consider all the non-considered chars yet for the index 'ind'
        for(int i = 0; i < nums.length; i++){
            if(taken[i] || i > 0 && nums[i] == nums[i - 1] && !taken[i - 1]) continue;
            //else
            taken[i] = true;
            tempList.add(nums[i]);
            permute(nums, ind + 1, tempList, ans, taken);
            //backtrack
            taken[i] = false;
            tempList.remove(tempList.size() - 1);
        }
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        Arrays.sort(nums);//important because we're checking nums[i] == nums[i - 1]
        permute(nums, 0, tempList, ans, new boolean[nums.length]);
        
        return ans;
    }
}
