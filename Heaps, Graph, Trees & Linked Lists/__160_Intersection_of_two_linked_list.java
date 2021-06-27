public class __160_Intersection_of_two_linked_list {
    //AMAZING!!
    //basic solution, store the lists in an array. traverse from back. the point just before a difference is the answer. O(n) space
       
    //O(1) space - Think mathematically!
    //let m > n and let c be the overlapping area at the end.
    //p1 pointer traverls m-c to reach c while p2 does n-c
    //to ensure that both meet at the same point, both must travel the SAME DISTANCE! 
    //
    //after travelling m distance in LL1, point p1 to head(LL2)
    //after travelling n distance in LL2, point p2 to head(LL1)
    //
    //now p1 travels n-c in p2 and a total of m + n - c
    //and p2 travels m-c in p1 and a total of m + n - c
    //since both are same. p1/p2 is the answer when p1 == p2
    //but if they swap again (p1,p2), then they do not overlap
    //
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int countOverlap = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(countOverlap<3){
            if(p1 == null){
                p1 = headB;
                countOverlap++;
            }
            if(p2 == null){
                p2 = headA;
                countOverlap++;
            }
            if(p1 == p2) return p1;
            
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
