//done after 787! on own but my solution is slow - maybe due to hashmap. 
// PQ for dijkstra!, notmal queue for bfs

// Important note for Dijkstra using PQ: Priority queue removes the need of the array 'minDistance'. because, the elements tht
// are popped later will always have a greater distance than the previous ones!
class _743_NetworkDelayTime {
    //first solution
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, List<int[]>> graph=new HashMap<>();
        //      <v,<[neighbor_1, weight_1],....[neighbor_m,weight_m]> >
        
        for(int i[]: times){
            graph.putIfAbsent(i[0]-1,new ArrayList<>());
            graph.get(i[0]-1).add(new int[]{i[1]-1,i[2]});
        }// graph complete
        
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        q.offer(new int[]{K-1,0});
        
        int minDistance[]=new int[N];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[K-1]=0;
        
        HashSet<Integer> visited=new HashSet<>();
        while(q.size()>0){
            int v[]=q.poll();
            
            if(graph.containsKey(v[0]) && !visited.contains(v[0])){
                visited.add(v[0]);
            for(int neigh[]: graph.get(v[0])){
                minDistance[neigh[0]]=Math.min(minDistance[neigh[0]],minDistance[v[0]]+neigh[1]); 
                // Minimum (Distance that the Current neigh of v already has, current vertex(v) distance + edge weight(v,Current neigh of v)) (added later CN)
                q.offer(new int[]{neigh[0], minDistance[neigh[0]]});
            }}
        }
        System.out.println(K+"\n"+Arrays.toString(minDistance));
        int max=0;
        for(int i: minDistance){
            if(i==Integer.MAX_VALUE)
                return -1;
            max=Math.max(max,i);
        }
        return max;
    }
}
