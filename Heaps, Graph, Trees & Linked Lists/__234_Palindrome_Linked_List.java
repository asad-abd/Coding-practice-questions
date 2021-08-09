//R1 Aug done
public class __234_Palindrome_Linked_List {
    //FAST and SLOW POINTERS
    //1 2 3 5 3 2 1 N
    //^ $                
    //  ^   $
    //    ^     $   
    //      ^       $
    //notice that if fast.next!=null && fast.next.next==null. then this is an odd length list. and slow.next is the middle element.
    //so, traverse back from slow pointer and forward from slow.next.next pointer.

    //1 2 3 4 4 3 2 1  - EVEN length
    //^ $
    //  ^   $
    //    ^     $
    //      ^       $    
    //notice, if fast.next == null then this is an even length list
    //so, traverse back from slow and front from slow + 1
    //in each step, a difference of 1 is added in the location of the fast and slow pointer.            

    //O(n) time and O(1) space.
    //with more space can use Stack. with the same fast and slow pointers.
    public ListNode reverse(ListNode head, ListNode end){
        //move newHead from actual head till the end. the newHead will be 'end' and the end.
        ListNode curr = head, nhead = null;
        while(curr != end){
            //store the next of curr
            ListNode curr_next = curr.next;
            
            curr.next = nhead;
            nhead = curr;
            
            curr = curr_next;
        }//come out of the loop when curr is end. assign its next outside of the loop
        curr.next = nhead;
        return curr;
    }
    public boolean checkPalindrome(ListNode left, ListNode right){
        while(left != null){
            if(left.val != right.val) return false;
            
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        
        ListNode slow = head, fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //check due to which condition the loop stopped (even/odd)
        if(fast.next == null){//even
            ListNode right = slow.next;
            ListNode left = reverse(head, slow);
            return checkPalindrome(left, right);
        }
        else{// if(fast.next != null && fast.next.next == null){//odd
            ListNode right = slow.next.next;
            ListNode left = reverse(head, slow);
            return checkPalindrome(left, right);
        }
    }
}
