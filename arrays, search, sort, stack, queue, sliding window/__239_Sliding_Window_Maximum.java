class __239_Sliding_Window_Maximum.java {
    //Idea is to push new nums from the right in DEQUE. but to push a new num X, we first pop all the numers that are smaller than X.
    
    //if the back of q has smaller elements than nums[j] then remove them because they will never be the answer for any interval!
    //removal of nums[i]: the only possiblily of nums[i] being in the q is when it's the maximum in the current k interval. So just check if arr[i] is them max (then we removeFirst())
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int i = 0, j = 0, n = nums.length;
        int max = Integer.MIN_VALUE;
        int ans[] = new int[n - k + 1];
        int p = 0;
        while(i < n && j < n && p < ans.length){
            while(j < n && j - i + 1 <= k){
                //if the back of q has smaller emelents than arr[j] then remove them because they will never be the answer for any interval!
                while(q.size() > 0 && q.getLast() < nums[j]) // deque func
                    q.removeLast();
                q.add(nums[j]);
                j ++;
            }
            max = q.getFirst(); // deque func
            ans[p++] = max;
            //remove nums[i]
            //the only possiblily of nums[i] being in the q is when it's the maximum in the current k interval.
            if(nums[i] == max)
                q.removeFirst(); // deque func
            // else - no need to worry, nums[i] is already absent in the queue.
            i ++;
        }
        return ans;
    }
    /* 
    // Correct but TLE - O(nlogk + klogk) 
    // klogk only once while creating at first, then addn and removal in logk
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int i = 0, j = 0, n = nums.length;
        int max = Integer.MIN_VALUE;
        int ans[] = new int[n - k + 1];
        int p = 0;
        while(i < n && j < n && p < ans.length){
            while(j < n && j - i + 1 <= k){
                //max = Math.max(max, nums[j]);
                pq.add(nums[j]);
                j ++;
            }
            ans[p++] = pq.peek();
            //remove arr[i]
            pq.remove(nums[i]);
            i ++;
        }
        return ans;
    }
    */
}
