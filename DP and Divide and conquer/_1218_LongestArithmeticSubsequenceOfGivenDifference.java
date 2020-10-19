class _1218_LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> dp =new HashMap<>();
        // dp will store (number in array, longest arth. subsequence)
        dp.put(arr[0],1);
        int max=0;
        for(int i=1;i<arr.length;i++){
            dp.put(arr[i],1+dp.getOrDefault(arr[i]-difference,0));
            max=Math.max(max,dp.get(arr[i]));
        }
        return max;
    }
}
