import java.util.*;
public class __684_Redundant_Connection {
    //2 methods, 1.Prims with edge wt being the order of arrival
    //2 - union find:-
    //Make an array of head[], where head[i] => HEAD OF SET(connected component) IN WHICH vertex 'i' is PRESENT
	//Initially all vertices are their own heads, [1,2,3,..n]
    //if edge[1,2] is encountered -> search/find the heads of the sets vertex 1 and vertex 2 are a part of. 
    //   - if the heads are same -> they are already part of the same set - this is our answer, since this edge is making a cycle and as per the problem, we have only one such edge.
    //   - else, they belong to different sets, JOIN THEM by changing the head of one of the sets.
        
    // --In short, find vertices of edges till you encounter an edge in which BOTH VERTICES ARE ALREADY PART OF THE SAME SET --
    public int findHead(int head[], int v){
        int vertex = v;
        while(head[vertex]!=vertex)
            vertex = head[vertex];
        return vertex;
    }
    public int[] findRedundantConnection(int[][] edges) {        
        int head[] = new int[edges.length + 1];
        for(int i = 0; i <= edges.length; i++) 
            head[i] = i;
        
        for(int edge[] : edges){
            int h1 = findHead(head, edge[0]);
            int h2 = findHead(head, edge[1]);
            
            if(h1 == h2) return edge;
            
            head[h2] = h1;
        }
        return new int[]{-1,-1};
    }

    //M 1: Prim's. long
    public int[] findRedundantConnectionPrims(int[][] edges) {
        HashMap<String, Integer> edgewt = new HashMap<>();
        int[] ans = new int[2];
        int n = edges.length;
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> adj [] = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) adj[i] = new ArrayList<Integer>();
        //make graph
        int wt = 0;
        for(int edge[] : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            edgewt.put((""+edge[0]+","+edge[1]), wt);
            edgewt.put((""+edge[1]+","+edge[0]), wt);
            wt++;
        }
        
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        //pq has int[3] -->> {current vertex, parent vertex, edge wt of current and parent}
        
        //initialize pq
        for(int neigh : adj[edges[0][0]]){
            //System.out.println("HI");
            pq.add(new int[]{neigh, edges[0][0], edgewt.get(""+neigh+","+edges[0][0]) });
        }
        visited.add(edges[0][0]);
        while(pq.size()>0){
            int size = pq.size();
            int curr[] = pq.poll();
            int vertex = curr[0];
            int parent = curr[1];
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for(int neigh : adj[vertex]){
                    if(!visited.contains(neigh))
                        pq.add(new int[]{neigh, vertex, edgewt.get(""+neigh+","+vertex)});
                }
            }
            else{
                ans[0] = parent;
                ans[1] = vertex;
                //System.out.println(Arrays.toString(ans));
            }    
        }
        return new int[]{Math.min(ans[0],ans[1]), Math.max(ans[0],ans[1])};
    }

}
