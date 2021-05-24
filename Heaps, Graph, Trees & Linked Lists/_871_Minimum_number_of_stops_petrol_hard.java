class _871_Minimum_number_of_stops_petrol_hard {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> -1*Integer.compare(a[1],b[1]) );
        //max heap
        Arrays.sort(stations, (int []a,int []b)-> Integer.compare(a[0],b[0])); 
        int currMax=startFuel, j=0, count=0;
        while(currMax<target && j<stations.length){
            while(j<stations.length && stations[j][0]<=currMax){
                pq.offer(stations[j]);
                j++;
            }
            //added stations till currMax.
            if(pq.size()>0){
                count++;
                currMax+=pq.poll()[1];
            }
            //if nothing in the queue, means currMax< target and we cannot move further
            else
                return -1;
        }
        if(currMax>=target) return count;
        
        if(pq.size()==0) return -1;
        
        while(pq.size()>0){
            currMax+=pq.poll()[1];
            count++;
            if(currMax>=target)
                return count;
        }
        return -1;
    }
}
