class _169_MajorityElement {
    //constant time: Moore's voting algo (IMP for this one)
    public int majorityElement(int[] nums) {
        int count=1;
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==ans)
                count++;
            else{
                count--;
                if(count==0){
                    ans=nums[i];
                    count=1;
                }
            }
        }
        return ans;
    }
    //-------------------------------------------------------------------
    //Approach 4: Randomization
    //Because more than Math.floor(n/2) array indices are 
    //occupied by the majority element, 
    //a random array index is likely to contain the majority element. 
    //check by O(n) run and repeat if not majority
    //-------------------------------------------------------------------

    //sorting approach!! (based on pigeon hole)
    //the element which is the most frequent will be present 
    //in the middle: if n is even, n/2 or n/2-1 both will have.
    //for odd n: simply n/2
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    //using HMap (O(n) space) not fully optimal
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        int reqFreq = nums.length/2 + 1;
        for(int i=0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
            if(freq.get(nums[i])>=reqFreq) return nums[i];
        }
        return -1;
    }
}
