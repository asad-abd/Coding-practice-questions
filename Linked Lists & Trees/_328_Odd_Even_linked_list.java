public class _328_Odd_Even_linked_list {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        // 1 2 3 4 5
        //p1 = 1, p2 = 2
        //1 2 3 4  (EVEN length)
        //$ #
        //    $ #       
        //       p1.next.next == null
        
        //1 2 3 4 5  (ODD length)
        //$ #
        //    $ #    
        //       p2.next.next == null    
        
        ListNode p1 = head, p2 = head.next;
        ListNode head2 = p2;
        while(p1.next != null && p1.next.next != null && p2.next != null && p2.next.next != null){
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p2.next != null && p2.next.next == null){ // odd length
            p1.next = p1.next.next;
            p1 = p1.next; // forgot this (SMC)
        }
        
        p2.next = null;
        p1.next = head2;
         
        return head;
    }
}
