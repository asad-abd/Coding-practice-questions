class _973_K_Closest_Points_to_origin {
    //approach 3: Quick Select ----- I. M. P.
    
    
    //approach 1: O(nlogn) sorting
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a,b) -> (Integer.compare(a[0]*a[0]+a[1]*a[1], b[0]*b[0]+b[1]*b[1])));
        int ans[][] = new int[k][2];
        for(int i = 0; i < k; i++){
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }

    //approach 2: max heap/priority queue
    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (b[0]*b[0]+b[1]*b[1] - a[0]*a[0]/*FOOL not + */ - a[1]*a[1]));
        //if (a,b). use b-a for max heap!!!
        //since we're removing the max, that is the TOP!!
        int ans[][] = new int[k][2];
        
        int i=0;
        while(i<points.length){
            pq.add(points[i++]);
            while(pq.size()>k)
                pq.poll();
        }
        i=0;
        while(i<k){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
