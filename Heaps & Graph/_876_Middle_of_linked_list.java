class _876_Middle_of_linked_list {
    //see _234  
    public ListNode middleNode(ListNode head) {
        //if fast.next == null // even length
        //if fast.next != null && fast.next.next == null //odd
        if(head.next == null)
             return head;
        ListNode slow = head, fast = head.next ;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow.next;
    }
}
