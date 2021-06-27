public class _141_Linked_List_cycle {
// RELATIVE VELOCITY!!!
//  @hackerhuang; General definitions:
//(1) divide the list into two parts: a line segment and a cycle.
//(2) it takes m step(s) to walk from one end to the other in the line segment
//(3) it takes n step(s) to walk back to the starting point in the cycle.
//
//Let m = 0 if the cycled list contains no line segment; n = 0 if the list has no cycle;m = 0, n = 0 for an empty list.
//
//Since runner 's speed doubles that of walker, when walker reaches the intersection of line segment and the cycle, 
//walker moves m step(s) and runner moves 2*m steps. Then, runner needs to move n - m % n step(s) more to catch up with walker in the cycle.
// It takes another (n - m % n) / 1, considering the difference of velocity between walker and runner is 1. 
//So, it takes a total of m + (n - m % n) step(s) before walker and runner meet.

    //naive: store nodes in a hashset
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hset = new HashSet<>();
        while(head != null){
            if(hset.contains(head)) return true;
            hset.add(head);
            head = head.next;
        }
        return false;
    }

    //BEST SOLUTION - also see __142
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode s = head, f = head;
        
        while(f != null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if(s == f) return true;
            //notice that the above will be true for null. since s can't be null even if f is null!! since s is always atleast 1 behind f and we already checked f.next
            
        }
        return false;
}
