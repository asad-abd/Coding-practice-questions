//R1 Aug done
class _560_SubarraySumEqualsK {
    // O(n*n)
    public int subarraySum(int[] nums, int k) {
        int[] sumTill = new int[nums.length];
        int count = 0;
        sumTill[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumTill[i] = sumTill[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (sumTill[i] - sumTill[j] + nums[j] == k)
                    count++;
            }
        }
        return count;
    }

    // O(n) - store and keep count of all possible pre-sums (for j<i)
    // if sumTill[i]=s. I need to check in the hashmap if I have a presumFreq == s-k
    //EDIT (R1): since we're storing cumulative sums from 0 -> j in 'preSumFreq'. When we check for a preSumFreq
    //(sum - k) we are finding the subarray from (0 -> j) to subtract from subarray (0 -> i)
    //s.t. the overall sum is of subarray (j+1 -> i) == k
    //initializing the hmap with (0, 1) helps us to take into consideration the cases where 
    //sum of (0 -> i) is 'k' without writing extra if statements.
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumFreq = new HashMap<>(); 
        int ans = 0, sum = 0;
        preSumFreq.put(0, 1); // helpful in avoiding if() cases in the for loop
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSumFreq.containsKey(sum - k))
                ans += preSumFreq.get(sum - k);
            //update the freq of the sum (if previously present) or initialize it (if not present prvsly)
            preSumFreq.put(sum, preSumFreq.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
