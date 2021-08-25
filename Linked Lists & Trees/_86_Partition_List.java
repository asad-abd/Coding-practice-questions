public class _86_Partition_List {
    //SMD: important to not increment prev in the 'node.val >= x' case!
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head);
        ListNode dummy2 = new ListNode(-1, head);
        ListNode l1 = dummy.next, l2 = dummy2;
        ListNode prev = dummy;
        while(l1 != null){
            if(l1.val >= x){
                l2.next = l1;
                l2 = l2.next;
                //disconnect node l2 from l1
                prev.next = l1.next;
            }
            else{
                prev = prev.next;
            }
            l1 = l1.next;
        }//after loop, l1 == null and prev is the last node < x
        l2.next = null;
        //System.out.println(prev.val);
        //System.out.println(dummy2.next.val);
        prev.next = dummy2.next;
        return dummy.next;
    }
}
