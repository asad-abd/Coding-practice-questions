//R1 Aug Done
class _40_Combination_sum_II {
    //can be optimized a little by skipping over same values (discussion, but I didn't get it)
    //first code: works but relatively slow
    //backtracking based on (my) knapsack concept
    HashSet<String> hset=new HashSet<>();
    public void knapsackUtil(int arr[], int n, int target, List<Integer> list, List<List<Integer>> ans){
        if(target==0){
            Collections.reverse(list);
            StringBuilder s=new StringBuilder();
            for(int num: list)
                s.append(""+num+",");
            if(hset.contains(s.toString()))
                return;
            hset.add(s.toString());
            ans.add(list);
            return;
        }
        if(n==0)
            return;
        List<Integer> l= new ArrayList<>(list);
        knapsackUtil(arr, n-1, target, l, ans);
        
        if(arr[n-1]<=target){
            l.add(arr[n-1]);
            knapsackUtil(arr, n-1, target-arr[n-1], l, ans);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        knapsackUtil(candidates, candidates.length, target, list, ans);
        return ans;
    }
}
