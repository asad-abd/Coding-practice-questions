class _210_CourseScheduleII_TOPO {

    
    //my first approach: same as _207 but with hashmap for adjacency list this time.
    public boolean findOrderUtil(int numCourses, HashMap<Integer, ArrayList<Integer>> adj, int[] ans, int [] indegree, int currIndex){
        boolean possible=false;
        boolean done=true;
        for(int i=0;i< numCourses;i++){
            if(indegree[i]==0)  possible=true;
            if(indegree[i]>-1)  done=false;
        }
        if(done) return true;
        if(!possible) return false;
        //base case finished
        
        for(int i=0;i< numCourses;i++){
            if(indegree[i]!=0) continue;
            
            indegree[i]=-1;
            ans[currIndex++]=i;
            if(adj.containsKey(i))
                for(int neighbor: adj.get(i)){
                    indegree[neighbor]--;
                }
        }
        return findOrderUtil(numCourses, adj, ans, indegree,currIndex);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj =new HashMap<Integer, ArrayList<Integer>>();
        int [] indegree =new int[numCourses];
        
        for(int []edge: prerequisites){
            //edge[1] --> edge[0]
            if(!adj.containsKey(edge[1])) adj.put(edge[1],new ArrayList<Integer>());
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        
        int ans[]=new int[numCourses];
        boolean possible=findOrderUtil(numCourses, adj, ans, indegree,0);
        if(possible)
            return ans;
        return new int[0];
    }
}
