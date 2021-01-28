import java.util.*;
// idea of bactracking was clear to me, the contentious part was identifying what the base case would be and what the 
// return type would be, whether I should store the lists in a list of lists directly or let the function return a list.
// pass the final answer list in the function calls and let the base case be when the size of the temporary list == nums.length
// be careful to use: ans.add(new ArrayList<>(temp)); instead of simply ans.add(temp); (gave empty lists)
public class _46_Permutations_bactracking {
    public  void findPermutations(int[] nums, boolean visited[], List<Integer> temp ,List<List<Integer>> ans) {
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                temp.add(nums[i]);
                visited[i]=true;
                findPermutations(nums,visited,temp,ans);
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }
}
