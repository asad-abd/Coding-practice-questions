import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class _133_CLoneGraph {
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        HashMap<Node,Node> hmap=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(node);
        hmap.put(node,new Node(node.val));
        
        while(q.size()>0){
            Node n=q.poll();
            for(Node neigh: n.neighbors){
                if(hmap.containsKey(neigh)==false){
                    //create the neighbor mirror and create an edge between n map and the mirros
                    Node neighMirror=new Node(neigh.val);
                    
                    
                    hmap.put(neigh,neighMirror);
                    q.offer(neigh);  
                }
                //even if there's already an edge, the below line will not create duplicate values.
                //we need this line outside the 'if' block because even if 1 was the node and had already been visited. (1->2). 2 also has 1 as a neighbor (2->1)
                //because it is an undirecrted graph.
                hmap.get(n).neighbors.add(hmap.get(neigh));
            }
        }
        return hmap.get(node);
            
    }
}
