//R1 Aug Done
public class __203_Remove_Linked_List_Elements {
    //HHHH SMC - very frequently
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        //if head is to be deleted - keep moving head to next till != val
        if(head == null) return head;
        while(head!=null && head.val == val)
            head = head.next;
        curr = head;
        while(curr!=null && curr.next != null){
            if(curr.next.val == val)
                curr.next = curr.next.next;
            else 
                curr = curr.next;
        }
        
        return head;
    }
}
