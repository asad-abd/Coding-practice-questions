public class _82_remove_duplicates_from_sorted_list_II {
    //read for Remove duplicates from unsorted linked list (below)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode i, j, prev;
        ListNode dummy = new ListNode(-1, head);
        prev = dummy;
        i = j = head;
        while(i != null){
            if(i.next != null && i.next.val == i.val){
                j = i;
                while(j != null && j.val == i.val)
                    j = j.next;
                prev.next = j;
                i = j;
            }
            else{
                i = i.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
    //Remove duplicates from unsorted linked list (works on sorted list as well) :
    //M1: O(n^2) two loops
    //M2: merge sort then single loop O(nlogn) 
    //M3: We traverse the link list from head to end. For every newly encountered element, 
    // check whether it is in the hash table: if yes, remove it; otherwise put it in the hash table.
    // some one else's code.

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode pre = null;
        ListNode fakeHead = head;
        while(fakeHead != null){
            if(!set.add(fakeHead.val)){
                pre.next = fakeHead.next;
            } else{
                pre = fakeHead;
            }
            fakeHead = fakeHead.next;
        }
        return head;
    }
}
