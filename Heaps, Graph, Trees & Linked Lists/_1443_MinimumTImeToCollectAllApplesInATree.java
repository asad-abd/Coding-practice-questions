// Review- silly mistake chance
class _1443_MinimumTImeToCollectAllApplesInATree {
    
    public int DFS(int node, ArrayList<Integer> graph[], boolean visited[], List<Boolean> hasApple){
        
        int resultFromNode=0;
        visited[node]=true;
        for(int neigh: graph[node]){
            if(visited[neigh])
                continue;
            
            resultFromNode+=DFS(neigh, graph,visited,hasApple);
        }
        // if resultFromNode==0 => no one has apple in the children of node, so currently, resultFromNode=0
        // add 2 to resultFromNode if node has an apple. => if resultFromNode==2, it means that we only visit node. if resultFromNode==0, we don't even visit node (backtrack- not programmatically)
        if((resultFromNode>0 || hasApple.get(node))&& node!=0)
            resultFromNode+=2;
        // the above is also our base case! -> if no unvisited neighbours then 'hasApple' condition will return 2.
        
        return resultFromNode;
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i< n;i++)
            graph[i]=new ArrayList<Integer>();
        
        for(int edge[] : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean visited[]=new boolean[n];
        return DFS(0, graph, visited, hasApple);
        
    }
}
