class _215_KthLargestElementInArray {
    // first time using in built heap function O(nlog(n))
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int i=1;
        int ans=0;
        for(int j:nums){
            pq.add(j);
        }
        while(i<=k){
            ans=pq.poll();
            i++;
        }
        return ans;
    }

    // *************************************************************************************
    // O(n) average time algo (Quick Select)
}
