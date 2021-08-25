public class _148_Sort_List {
    //I've done is similar to merge k-sorted lists LC 23 (hard)
    //thus, break the LL in between and merge like 2 sorted lists.
    public ListNode mergeSortedList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val <= l2.val){
            l1.next = mergeSortedList(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeSortedList(l1, l2.next);
            return l2;
        }
    }
    public ListNode dNc(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode s = head, f = head;
        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        //rhs from s.next
        ListNode rightHead = s.next;
        s.next = null;
        // DNC
        ListNode lhs = dNc(head);
        ListNode rhs = dNc(rightHead);
        //conquer
        return mergeSortedList(lhs, rhs);
    }
    public ListNode sortList(ListNode head) {
        return dNc(head);
    }
}
