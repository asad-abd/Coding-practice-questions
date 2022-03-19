class Solution {
    //other solutions are using 
    //     1. stack
    //     2. take sums from most sig to least. store them even as 2-3 digit nums. then traverse from back once more to make each node single digit. solution link below
    //https://leetcode.com/problems/add-two-numbers-ii/discuss/687339/Java-O(N)-solution-with-follow-up-question-no-recursion-no-stacks
    
    //my mock contest solution: (could have used stack for compacter code)
    public ArrayList<Integer> toArrayL(ListNode n){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(n != null){
            arr.add(n.val);
            n = n.next;
        }
        Collections.reverse(arr);
        return arr;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //reverse the lists/ store them in an array
        //add the 2 arrays. create a linked list
        ArrayList<Integer> n1 = toArrayL(l1);
        ArrayList<Integer> n2 = toArrayL(l2);
        //ArrayList<Integer> ans = new ArrayList<Integer>();
        ListNode l = null;
        int sum = 0, i = 0, j = 0;
        while(i < n1.size() && j < n2.size()){
            sum += n1.get(i) + n2.get(j);
            
            ListNode lNew = new ListNode(sum % 10);
            lNew.next = l;
            l = lNew;
            
            //ans.add(sum % 10);
            sum /= 10;
            i++;
            j++;
        }
        while(i < n1.size()){
            sum += n1.get(i);
            
            ListNode lNew = new ListNode(sum % 10);
            lNew.next = l;
            l = lNew;
            
            sum /= 10;
            i++;
            j++;
        }
        while(j < n2.size()){
            sum += n2.get(j);
            
            ListNode lNew = new ListNode(sum % 10);
            lNew.next = l;
            l = lNew;
            
            sum /= 10;
            i++;
            j++;
        }
        while(sum > 0){
            ListNode lNew = new ListNode(sum % 10);
            lNew.next = l;
            l = lNew;
            
            sum /= 10;
        }
        return l;            
    }
}   
