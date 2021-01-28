import java.util.*;
class _207_Course_Scheduling_Topological_sort {

    public boolean topoSort(int numCourses, ArrayList<Integer> adj[],int []indegree){
        //base case
        while(true){
            boolean is0=false;
            boolean areAllNegative=true;
            for(int i=0;i<numCourses;i++){
                if(indegree[i]==0) is0=true;
                if(indegree[i]>=0) areAllNegative=false;
            }
            //System.out.println(Arrays.toString(indegree));
            if(areAllNegative){
                //System.out.println("all negative");
                return true;}
            if(!is0){
                //System.out.println("no 0");
                return false;}
            
            //else
            for(int i=0;i<numCourses;i++){
                if(indegree[i]<0) continue;
                if(indegree[i]==0){
                    //go thru all  the neighbors, reduce their indegrees by 1.
                    indegree[i]=-1;
                    for(int neighbor: adj[i]){
                        indegree[neighbor]--;
                    }
                }
            }
        }
    }

    /*****************************************************************************************************************/
    //my first approach: faster than 30%. (can be done without recursion aswell)
    //logic: focus on INDEGREES. 
    // 1) Go through the indegrees and if there's none with degree 0. return false (cycle)
    // 2) For each 0 indegree vertex:
    //      i)   Assign indegree[i] = -1
    //      ii)  Iterate over its neighbors and decrease indegrees by 1 (we are basically removing the 0 degree vertex and all its outgoing edges)
    // 3) Repeat 1 and 2 till all vertices' indegrees are less than 0. 
    public boolean topoSort(int numCourses, ArrayList<Integer> adj[],int []indegree){
        //base case
        boolean is0=false;
        boolean areAllNegative=true;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) is0=true;
            if(indegree[i]>=0) areAllNegative=false;
        }
        //System.out.println(Arrays.toString(indegree));
        if(areAllNegative){
            //System.out.println("all negative");
            return true;}
        if(!is0){
            //System.out.println("no 0");
            return false;}
        
        //else
        for(int i=0;i<numCourses;i++){
            if(indegree[i]<0) continue;
            if(indegree[i]==0){
                //go thru all  the neighbors, reduce their indegrees by 1.
                indegree[i]=-1;
                for(int neighbor: adj[i]){
                    indegree[neighbor]--;
                }
            }
        }
        return topoSort(numCourses, adj, indegree);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer> adj[]=new ArrayList[numCourses];
        
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++) adj[i]=new ArrayList<Integer>();
        for(int edge[]: prerequisites){
            //edge[1] --> edge[0]
            adj[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        return topoSort(numCourses, adj, indegree);
    }
}
