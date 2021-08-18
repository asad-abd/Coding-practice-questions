public class _1290_Convert_LL_to_decimal {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while(head != null){
            ans = ans*2 + head.val;
            head = head.next;
        }
        return ans;
    }
}