class _179_Largest_Number{
	//M1: brute force all possible arrangements and keep store of the max
    //M2: think about the comparator function while sorting. we usually check is a > b or a <= b. 
    //Now we'll simply check if a_b > b_a or otherwise (check appending which one gives bigger number)
    public String largestNumber(int[] nums) {
        String numS[] = new String[nums.length];
        for(int i = 0; i < numS.length; i ++)
            numS[i] = ""+nums[i];
        
        
        Arrays.sort(numS, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder ans = new StringBuilder();
        //don't take zeroes if a non isn't encountered
        for(int i = 0; i < numS.length; i ++)
            ans.append(numS[i]);
        if(ans.charAt(0) == '0')
            return "0";
        return ans.toString();
    }
}
