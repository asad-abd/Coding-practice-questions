// TODO R2 2022


//R1 Sep 21 done
public class __92_Reverse_Linked_List_II {
    //NICE DISCUSS: https://leetcode.com/problems/reverse-linked-list-ii/discuss/30709/Talk-is-cheap-show-me-the-code-(and-DRAWING)
    public ListNode reverseBetween(ListNode head, int l, int r) {
        int count = 0;
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy, tail;
        while(count < l - 1){
            left = left.next;
            count++;
        }
        tail = left.next;
        while(count < r - 1){
            //R1: I over complicated the mppings, read the discuss for simpler version
            ListNode temp = left.next;
            ListNode tail2next = tail.next.next;
            
            left.next = tail.next;
            tail.next.next = temp;
            tail.next = tail2next;
            count++;
        }
        
        return dummy.next;
        //still only one pass as we are going to each node only once(other than the named ones)
    }
}
