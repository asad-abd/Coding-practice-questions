public class _863_All_nodes_distance_k_in_tree {
    //M1: naive: make a graph after doing a tree traversal and then start bfs from the target node. O(n) time with double traversals, but O(n) space to store edges in graph.
    //-- This graph can be also simply made by just storing the parent for each node. (since we already have the children stored.)
    //M2: as in the solution also uses O(n) space (so M1 is better)
    
    //M1:-
    public void dfsMakeGraph(TreeNode node, HashMap<Integer, ArrayList<Integer>> adj){
        if(node == null)
            return;
        
        adj.putIfAbsent(node.val, new ArrayList<Integer>());
        if(node.left != null){
            adj.get(node.val).add(node.left.val);
            adj.putIfAbsent(node.left.val, new ArrayList<Integer>());
            adj.get(node.left.val).add(node.val);
        }
        if(node.right != null){
            adj.get(node.val).add(node.right.val);
            adj.putIfAbsent(node.right.val, new ArrayList<Integer>());
            adj.get(node.right.val).add(node.val);
        }
        dfsMakeGraph(node.left, adj);
        dfsMakeGraph(node.right, adj);
    }
    public void bfs(int target, int k, HashMap<Integer, ArrayList<Integer>> adj, List<Integer> ans ){
        Queue<Integer> q = new LinkedList<>();
        q.add(target);
        int level = 0;
        boolean visited[] = new boolean[501]; // limit in question
        
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i ++){
                int node = q.poll();
                visited[node] = true;
                if(level == k) 
                    ans.add(node);
                else
                for(int neigh : adj.get(node)){
                    if(!visited[neigh]){
                        q.add(neigh);
                    }
                }
            }
            if(level == k) break;
            level ++;
        }   
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        dfsMakeGraph(root, adj);
        bfs(target.val, k, adj, ans);
        return ans;
    }
}
