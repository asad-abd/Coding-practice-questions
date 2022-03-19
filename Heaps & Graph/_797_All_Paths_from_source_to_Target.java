public class _797_All_Paths_from_source_to_Target {
    //done in 13 mins
    public void dfs(int graph[][], List<Integer> tempList, List<List<Integer>> ans, int node){
        if(node == graph.length - 1)
            ans.add(new ArrayList<>(tempList));
        //since there's no cycle we don't need to maintain a visited list
        for(int neigh : graph[node]){
            tempList.add(neigh);
            dfs(graph, tempList, ans, neigh);
            //backtrack
            tempList.remove(tempList.size() - 1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>(Arrays.asList(0));
        
        dfs(graph, tempList, ans, 0);
        
        return ans;
    }
}
