import java.util.*;
class _448_Find_All_Numbers_Disappeared_in_an_array {
    //O(1) "extra" space - INPLACE CHANGES!!
    //think in the sense of pointers.
    //simply mark the index in some way such that it doesn't lose the value at that index but is also marked
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        //for O(1), logic is this: 
        //if num exists, mark it as present in the same array somehow (without losing its value)
        //mark them with -ve. since in question, all nums are +ve. we can reuse those values by suing abs.
        
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            nums[index]=-1*Math.abs(nums[index]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) list.add(i+1);
        }
        return list;
    }
}
