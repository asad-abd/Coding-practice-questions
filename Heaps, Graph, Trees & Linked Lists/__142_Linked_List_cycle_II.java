public class __142_Linked_List_cycle_II {
    //CODE SMC: write nested while and use s==f NOT s.val==f.val
    public ListNode detectCycle(ListNode head) {
        //IMP: steps are ok when starting from first node.i.e, both begin from head and not (head, head.next)!!!!
        
        //logic
        //let there be 'm' length linear part and 'n' length cycle 
        
        //when s reaches m. f has taken 2m steps => m steps within the cycle 
        //GO INTO FRAME OF REFERENCE(relative velocity) of s -> stop f, now its speed is 1 (instead of 2)
        //since in s' reference it is at rest, f has to travel n-m steps to reach is and takes n-m units of time.
        
        //COME OUT OF S's REFERENCE: s has travelled 1*(n-m) steps in the cycle to meet 'f'.
        
        //Now notice that required(ans) node is m steps from the head. 
        //and s is also n - (n-m) = m steps away from the required(ans) node
        //so, have another pointer start from head as soon as val[s] == val[f]
        
        if(head == null || head.next == null) return null;
        ListNode s = head;
        ListNode f = head;
        
        while(f != null && f.next != null){//no need to check s since its behind
            //System.out.println(f.val + " slow: "+s.val);
            s = s.next;
            f = f.next.next;
            if(s == f) {
                ListNode ans = head;
                while(s != ans){
                    ans = ans.next;
                    s = s.next;
                }
                return ans;
            }
        }
        //out of the loop => m steps to travel now to reach the point of the joint
        
        return null;
    }
}
