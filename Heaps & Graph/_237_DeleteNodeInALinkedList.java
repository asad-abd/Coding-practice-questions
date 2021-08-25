class _237_DeleteNodeInALinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        //node=node.next; - this doesn't work because we have only passed in the copy of the pointer and not the actual pointer. S the pointer now points to the next one but the actual list remains same.
        //so only possible solution could be to change the value of the current pointer to that of the next one and then delete the next one (the one we copied)
        if(node.next!=null){
            node.val=node.next.val;
            node.next=node.next.next;
        }
        
        //but, as we can see, we cannot delete if the given node is the tail!
    }
}
