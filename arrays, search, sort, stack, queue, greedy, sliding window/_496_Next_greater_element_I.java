public class _496_Next_greater_element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //M1: trivial method - 2 pointer - O(nlogn)
        //sort the (num, index) pair based on the num and then 2 ptrs
        
        //M2: stack
        //hashmap to store val and index of arr1
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums1.length; i ++){
            hmap.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[nums1.length];
        for(int i = nums2.length - 1; i >= 0; i --){
            while(stack.size() > 0 && nums2[i] > stack.peek()){
                stack.pop();
            }
            if(hmap.containsKey(nums2[i])){
                if(stack.size() == 0)
                    ans[hmap.get(nums2[i])] = -1;
                else
                    ans[hmap.get(nums2[i])] = stack.peek();
            }
            stack.push(nums2[i]);
        }
        return ans;
    }
}
