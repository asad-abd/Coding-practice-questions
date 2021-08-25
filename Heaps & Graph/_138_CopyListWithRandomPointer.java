// I did it similar to cloning a graph (_133)
class _138_CopyListWithRandomPointer {
    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        HashMap<Node,Node> hmap=new HashMap<>();
        hmap.put(head,new Node(head.val));
        Queue<Node> q=new LinkedList<>();
        q.offer(head);
        
        while(q.size()>0){
            Node n=q.poll();
            // it is guaranteed that n will have a map created already (just review the code)
            
            if(n.next!=null ){
                if(!hmap.containsKey(n.next)){
                    Node nextMap=new Node(n.next.val);
                    hmap.put(n.next,nextMap);
                    q.offer(n.next);
                }
                // q.offer(n.next); //this line could have caused an ininite loop!
                // create the directed edge.
                hmap.get(n).next=hmap.get(n.next);
            }
            if(n.random!=null ){
                if(!hmap.containsKey(n.random)){
                    Node randomMap=new Node(n.random.val);
                    hmap.put(n.random,randomMap);
                    q.offer(n.random);
                }
                // q.offer(n.random); //this line could have caused an ininite loop!
                // create the directed edge.
                hmap.get(n).random=hmap.get(n.random);;
            }
        }
        return hmap.get(head);
    }
}
