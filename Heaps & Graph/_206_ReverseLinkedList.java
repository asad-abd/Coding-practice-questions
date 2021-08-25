class _206_ReverseLinkedList {
    //redone later: PEPCODING addfirst with NEW POINTERS
    //less chances of error 
    //IMAGINE THE PROCESS ONNN PAPERRRRRR!!! ELSE -> SILLY MISTAKES
    static ListNode thead = null;
    public void addFirst(ListNode node){
        if(node == null) return;
        //current node is the new temporary head
        ListNode next = node.next;
        
        //change current's next to thead 
        node.next = thead;
        
        //update new head (thead)
        thead = node;
        
        //recurse
        addFirst(next);
    }
    public ListNode reverseList(ListNode head) {
        thead = null;//imp due to static
        addFirst(head);
        return thead;
    }

    //------------------------------
    //recursively, on own. the hint is the parameter new Tail, to help remove the cycle
    public ListNode revUtil(ListNode node, ListNode newTail){
        if(node==null)
            return node;
        if(node.next == null){
            node.next=newTail;
            return node;
        }
        ListNode newHead=node.next;
        node.next=newTail;
        return revUtil(newHead, node);
    }
    public ListNode reverseList(ListNode head) {
        return revUtil(head, null);
        //Write recursive
    }

    //my first soln: iterative
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        Stack<ListNode> stack= new Stack<>();
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode newHead = stack.peek();
        ListNode curr=newHead;
        while(!stack.isEmpty()){
            curr.next=stack.pop();
            curr=curr.next;
        }
        curr.next=null;
        return newHead;
    }
}
