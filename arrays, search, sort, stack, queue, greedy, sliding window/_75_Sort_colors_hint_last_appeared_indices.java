class _75_Sort_colors_hint_last_appeared_indices {
    //inplace and one pass logic
    //keep a note of the last index that each of 0, 1, 2 appeared at.
    //initialize them to -1 -> since none have appeared at all
    //for: 
    //  if(nums[i]==2) //we aren't pushing anyone (0,1) away because 2 will always come after 1 and 2 in our sorted array
    //  if(nums[i]==1) //we will have to replace the first instance of 2 with the last instance of 1. so increment the last_appeared_index_of_2 and assign it 2.
    //  if(nums[i]==0)  //we'll be overwriting 1 and 2 both! similar above case 
    public void sortColors(int[] nums) {
        int last0=-1, last1=-1, last2=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==2){
                last2++;
                nums[last2]=2;
            }
            else if(nums[i]==1){
                last2++;
                nums[last2]=2;
                last1++;
                nums[last1]=1;
            }
            if(nums[i]==0){
                last2++;
                nums[last2]=2;
                last1++;
                nums[last1]=1;
                last0++;
                nums[last0]=0;
            }
        }
        
        //since last index start from -1 and i from 0, we'll not lose the element nums[i] before processig it since last index combined will increment by 1 only.
    }
}
