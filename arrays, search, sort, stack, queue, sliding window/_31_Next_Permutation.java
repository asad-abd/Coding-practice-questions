//R1 Aug done
public class _31_Next_Permutation {
    //VVVVIMP - review later
    //understood algo but err in my imple
    //this is someone else's imple
    //visualize graphically - my only intuition
    //also- to reverse. simply write:-
    //while(start<end) swap(start++,end--);

    //we observe that for any given sequence that is in descending order, no next larger permutation 
    //is possible. For example, no next permutation is possible for the following array:

    //We need to find the first pair of two successive numbers a[i] and a[i-1] st. a[i−1] < a[i] 
    //see the animation in the solution section
    public void nextPermutation(int[] num) {
        int n = num.length;
        if(n < 2)
            return;
        int index = n - 1;        
        while(index > 0){
            if(num[index - 1] < num[index])
                break;
            index--;
        }
        if(index == 0){
            reverseSort(num, 0, n - 1);
            return;
        }
        else{
            //1. swap index with the JUST larger number on the right and then 2. reverse everything on the rhs.
            int val = num[index - 1];
            int j = n - 1;
            while(j >= index){
                if(num[j] > val)
                    break;
                j --;
            }
            //1.
            swap(num, j, index - 1);
            //2.
            reverseSort(num, index, n - 1);
            return;
        }
    }

    public void swap(int[] num, int i, int j){
        int temp = 0;
        temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public void reverseSort(int[] num, int start, int end){   
        if(start > end)
            return;
        for(int i = start; i <= (end + start) / 2; i++)
            swap(num, i, start + end - i);
    }

    //R1 - recode
    public void nextPermutation_R1(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return;
        int ind = n - 2;       
        while(ind >= 0 && nums[ind] >= nums[ind + 1])
            ind --;
        //if the whole arr is fully desorted then ind will be -1.
        if(ind < 0){
            //System.
            reverseSort(nums, 0, n - 1);
            return;
        }
        //num[ind] < num[ind + 1]. [1, 2, 89, 87, 86, 84.. 3, 2, 1]
        //traverse the rhs to find the JUST greater number of num[ind]
        int j = ind + 1;
        int minJ = ind + 1;
        while(j < n){
            if(nums[j] > nums[ind])
                minJ = j;
            j ++;
        }
        swap(nums, minJ, ind);
        reverseSort(nums, ind + 1, n - 1);
        
    }
}
