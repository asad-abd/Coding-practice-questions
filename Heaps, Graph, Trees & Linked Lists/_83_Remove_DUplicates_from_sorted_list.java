class _83_Remove_DUplicates_from_sorted_list {
    //try drawing first!!
    //DON'T JUMP TO THE CODE SPECIALLY IN LNKED LISTS!!
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr!=null){
            //don't move prev till curr is different
            if(prev.val==curr.val){
                //only move curr
                prev.next = curr.next;
                curr = curr.next;
                
            }
            else{
                //System.out.println("FOOOOLLL!");
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
        /*
        Straight-forward!!
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        */
    }
}
