public class _143_Reorder_List {
    //Recursion O(n): store the parents of nodes in a map
    //In [A0, A1...An] change mappings for A0 and An. Then recursively solve for [A1, A2...A(n-1)]
    // A0.next = An
    // An.next = f(A1,...,A(n-1))
    // base case: head == tail (odd length) || head.next == tail (even length sequence)
    public ListNode reorder(ListNode head, ListNode tail, HashMap<ListNode, ListNode> parent){
        if(head == tail){ // odd length
            head.next = null; // imp
            return head;
        }
        if(head.next == tail){ // even length
            tail.next = null; // imp
            head.next = tail;
            return head;
        }
        ListNode newHead, newTail;
        
        newHead = head.next;
        newTail = parent.get(tail);
        //change node connections
        head.next = tail;
        //recur till head == tail or either is null
        
        tail.next = reorder(newHead, newTail, parent);
        return head;
    }
    public void reorderList(ListNode head) {
        //store the parents of nodes in a map
        HashMap<ListNode, ListNode> parent = new HashMap<>();
        ListNode i = head, prev = null;
        while(i != null){
            parent.put(i, prev);
            prev = i;
            i = i.next;
        }//last node is prev
        ListNode tail = prev;
        reorder(head, tail, parent);
    }
}
