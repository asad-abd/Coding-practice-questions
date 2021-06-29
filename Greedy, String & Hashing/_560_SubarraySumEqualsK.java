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
    // if sumTill[i]=s. I need to check in the hashmap if I have a presum == s-k
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int ans = 0, sum = 0;
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k))
                ans += preSum.get(sum - k);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
