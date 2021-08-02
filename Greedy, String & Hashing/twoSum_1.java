
//Easy #1. FB, MSFT, AMZ
//interesting tweak to the normal solution- inserting num[i] int hashmap after checking for target-nums[i]
//it'll include even repeated numbers*
import java.util.*;

class twoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        int n = nums.length, temp = 0;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            temp = target - nums[i];
            if (hmap.containsKey(temp)) {
                ans[0] = i;
                ans[1] = hmap.get(temp);
            }
            hmap.put(nums[i], i);
        }

        return ans;
    }
}

// this part doesn't work for input of the type [3,3,...3]
// for(int i=0;i<n;i++){
// hmap.put(nums[i],i);
// }
// for(int i=0;i<n;i++){
// int comp=target-nums[i];
// if(hmap.containsKey(comp)==false || nums[i]==comp)
// continue;
// int x=hmap.get(comp);//return key (index)
// ans[0]=i;
// ans[1]=x;

// }
// }