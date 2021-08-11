class _2_Add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode head = null, ptr = null;
        while(l1 != null || l2 != null || carry > 0){
            sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            if(head == null){
                ptr = new ListNode(sum);
                head = ptr;
            }
            else{
                ptr.next = new ListNode(sum);
                ptr = ptr.next;
            }
        }
        return head;
    }
}
