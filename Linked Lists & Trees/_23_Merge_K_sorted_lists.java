//R1 Aug done
public class _23_Merge_K_sorted_lists {
    //LC hard
    //merge sort based solution O(n*log(k)) (other solution is using heap based using k head pointers)
    public ListNode mergeSortedLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val <= l2.val){
            l1.next = mergeSortedLists(l1.next, l2);
            return l1;
        }
        else{ //if(l1.val > l2.val)
            l2.next = mergeSortedLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode divideNconquer(ListNode[] lists, int st, int end){
        if(st > end) return null;
        if(st == end) return lists[st]; //imp
        
        int mid = st + (end - st) / 2;
        //divide
        ListNode lhsList = divideNconquer(lists, st, mid); //returns first half sorted lists combined into 1.
        ListNode rhsList = divideNconquer(lists, mid + 1, end); //returns second half sorted lists combined into 1.
        //conquer - combine the 2 sorted lists.
        return mergeSortedLists(lhsList, rhsList);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return divideNconquer(lists, 0, lists.length - 1);
    }
}
