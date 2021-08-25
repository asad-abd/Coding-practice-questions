// one of the best questions i've ever done.
// helpful solutions: https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's, https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/317262/2-Clean-Python-Solution-(BFS-Dijkstra-Explained) 

/* regarding my doubt of using priority queue.
I thought, that the condition "if(city==dst) return price;" from below caused us to miss
on the expensive but small stops path. but that isn't the case because i'll keep on polling the 
priority queue till it is empty!
*/
class _787_CheapestFlightsWithinKStops {
    // Dijkstra with PQ
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //<vertex,list[neighbors,weight]> 
        HashMap<Integer,List<int[]>> graph =new HashMap<>();
        for(int i[]: flights){
            graph.putIfAbsent(i[0],new ArrayList<>());//
            
            //graph.get(i[0]) returns to us the list of int[] (pair of (neigh,weight))
            graph.get(i[0]).add(new int[]{i[1],i[2]});
        }// graph complete
        
        
        // pq <price to reach, city, number of stops that can be further>
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        
        pq.offer(new int[]{0, src, K+1});//K+1 because from the src, the dst can be at (d+1)th position.
        
        while(pq.size()>0){
            int [] current=pq.poll();
            int price=current[0];
            int city=current[1];
            int stops=current[2];
            if(city==dst)
                return price; 
            if(stops>0){
                if(graph.containsKey(city))
                for(int[] neighbor: graph.get(city)){//graph.get(city) returns a list of 'int[]'
                    pq.offer(new int[]{price+neighbor[1], neighbor[0], stops-1});
                }
            }
        }
        //if we reach till this point, the we didn't find dst in any entry of pq (in k+1 stops)
        return -1;
    }
}




/* my first code JUST FOR DIJKSTRA (wrong)
import java.util.*;
class Solution {
    class edge{
        int val,weight;
        public edge(int Val,int Weight){
            val=Val;
            weight=Weight;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashSet<Integer> shortestPathSet=new HashSet<>();
        
        int [] distance=new int[n];
        for(int i=1;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        // create adj list
        
        ArrayList<edge> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<edge>();
        }
        
        for(int arr[]: flights){
            adj[arr[0]].add(new edge(arr[1],arr[2]));
        }
        
        /*
        //check adj(debug) 
        for(int i=0;i<n;i++){
            for(int j=0;j<adj[i].size();j++)
                System.out.print(adj[i].get(j).val+" , "+adj[i].get(j).weight+"\n");
            System.out.println();
        }*/
        /*
        //now, run dijkstra
        while(shortestPathSet.size()<n-1){
            //choose the vertex v with minimum distance which is not yet in shortestPathSet
            //traverse its neighbors and assign them Min(oldDistance,distance of v+ edge weight)
            int v=-1;
            int mindist=Integer.MAX_VALUE;
            int j=0;
            for(int i: distance){
                if(shortestPathSet.contains(i)==false&& i<mindist)
                    v=j;
            j++;
            }
            if(v==-1)
                break;
            shortestPathSet.add(v);
            for(int neigh=0;neigh<adj[v].size();neigh++){
                distance[adj[v].get(neigh).val]=Math.min(distance[adj[v].get(neigh).val],distance[v]+adj[v].get(neigh).weight);
            }
            
        }
        System.out.println(Arrays.toString(distance));
        
        return 0;
        
    }
}
*/