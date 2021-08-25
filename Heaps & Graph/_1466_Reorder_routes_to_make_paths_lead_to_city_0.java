class _1466_Reorder_routes_to_make_paths_lead_to_city_0 {
    public int minReorder(int n, int[][] connections) {
        //below logic runs, but may be a little slow: better than only 40%
        //make a bi-directional graph
        //bfs from 0 and check if it exists in the connections HSet, 
        //  if exists, ans++;
        ArrayList<Integer> adj[]=new ArrayList[n];
        HashSet<String> hset = new HashSet<>();
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<Integer>();
        for(int edge[] : connections){
            hset.add(edge[1]+","+edge[0]);
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean visited[]=new boolean[n];
        int ans=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(q.size()>0){
            //System.out.println(q);
            int node=q.poll();
            if(visited[node])
                continue;
            visited[node]=true;
            
            for(int child: adj[node]){
                if(visited[child])
                    continue;
                q.add(child);
                String check = child+","+node;
                //System.out.println(check);
                if(hset.contains(check)) ans++;
            }
        }
       // System.out.println(hset);
        return ans;
    }
}
