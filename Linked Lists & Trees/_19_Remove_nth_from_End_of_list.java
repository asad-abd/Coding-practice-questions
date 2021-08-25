public class _19_Remove_nth_from_End_of_list {
    //2ptrs: move ahead n steps forwad, then just ++ both ptrs till ahead == null. 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);//to take care of edge case {[x] , 1}
        ListNode s = dummy, ahead = dummy;
        for(int i = 0; i <= n && ahead != null; i ++)
            ahead = ahead.next;
        
        while(ahead != null){
            s = s.next;
            ahead = ahead.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }
}
