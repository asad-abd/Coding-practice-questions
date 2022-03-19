class Solution {
	// discuss solution
	public List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);//quite helpful in some other type of backtracking questions
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	//we're modifying the starting point of consideration in the array
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
		for(int i = start; i < nums.length; i++){
		    tempList.add(nums[i]);
		    backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
		    tempList.remove(tempList.size() - 1);
		}
	    }
	}

    // my mock test solution
    HashSet<String> hset = new HashSet<>();
    public void knapsack(int arr[], int n, int sum, List<Integer> tempList, List<List<Integer>> ans){
        if(sum < 0 || n < 1) return;
        if(sum == 0){
            StringBuilder key = new StringBuilder();
            for(int num: tempList){
                key.append(num);
                key.append('#');
            }
            String temp = key.toString();
            if(hset.contains(temp)) return;
            
            hset.add(temp);
            ans.add(new ArrayList<>(tempList));
        }
        //else -> 1. consider n-1 or not consider it
        if(arr[n - 1] <= sum){
            //consider
            tempList.add(arr[n - 1]);
            knapsack(arr, n, sum - arr[n - 1], tempList, ans);
            //backtrack
            tempList.remove(tempList.size() - 1);
            //not considering n'th candidate
            knapsack(arr, n - 1, sum, tempList, ans);
        }
        else{
            knapsack(arr, n - 1, sum, tempList, ans);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        knapsack(candidates, candidates.length, target, new ArrayList<Integer>(), ans);
        
        return ans;
    }
}
