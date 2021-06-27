public class _399_Evaluate_Division {
    //code seems correct but for some reason: graph's lists are empty/null - dbug later- maybe try 2 different araylists.
    public class Nbor{
        String str;
        double val;
        public Nbor(String Str, double Value){
            str = Str;
            val = Value;
        }
    }
    public double bfs(String node, String target, HashMap<String, ArrayList<Nbor>> graph){
        Queue<Nbor> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Nbor(node, 1.0));
        while(q.size()>0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Nbor v = q.poll();
                //System.out.println("Hello  "+ v.str + " - " + target);
                if(visited.contains(v.str)) continue;
                visited.add(v.str);
                
                if(graph.containsKey(v))
                for(Nbor neigh : graph.get(v)){
                    System.out.println(neigh.str + " - "+ target);
                    if(target.equals(neigh.str)){
                        return (v.val * neigh.val);
                    }
                    if(!visited.contains(neigh.str)){
                        q.add(new Nbor(neigh.str, v.val * neigh.val));
                    }
                }
            }
            
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Nbor>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String node = equations.get(i).get(0);
            String nb = equations.get(i).get(1);
            
            if(!graph.containsKey(node))
                graph.put(node, new ArrayList<Nbor>());
            if(!graph.containsKey(nb))
                graph.put(nb, new ArrayList<Nbor>());
            Nbor n1 = new Nbor(nb, values[i]);
            Nbor n2 = new Nbor(node, (double)1.0/values[i]);
            
            graph.get(node).add(n1);
            graph.get(nb).add(n2);
            System.out.println(graph.get(node));
            System.out.println(graph.get(nb));                
        }
        //bfs for each query
        double ans[] = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            ans[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), graph);
        }
        return ans;
    }
}
