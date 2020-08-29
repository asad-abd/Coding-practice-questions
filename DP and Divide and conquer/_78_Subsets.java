class _78_Subsets {
    // dp. start with empty list, in the next step add the first number to the empty
    // list and add it to the list of lists- answer
    // SMC - not creating a clone of the list. Correct: use- List <Integer> templist
    // =new ArrayList<Integer>(ans.get(j));
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // ans.add(new ArrayList<Integer>())
        List<Integer> list = new ArrayList<Integer>();
        ans.add(list);
        for (int num : nums) {
            int n = ans.size();
            // System.out.println(n);
            for (int j = 0; j < n; j++) {
                List<Integer> templist = new ArrayList<Integer>(ans.get(j));
                // Collections.copy(templist, );
                // System.out.println(ans);
                templist.add(num);
                ans.add(templist);
            }
        }
        return ans;
    }
}