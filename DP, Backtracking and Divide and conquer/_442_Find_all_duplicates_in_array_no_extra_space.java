import java.util.*;
class _442_Find_all_duplicates_in_array_no_extra_space {
    //look at 448 for logic. this one has just a small modification in it.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            //if value at index already -ve then add it to the list and continue
            if(nums[index]<0){
                list.add(index+1);
                continue;
            }
            nums[index]=-1*Math.abs(nums[index]);
        }
        
        return list;
    }
}
