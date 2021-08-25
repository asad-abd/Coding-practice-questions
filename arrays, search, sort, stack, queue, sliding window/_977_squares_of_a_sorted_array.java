public class _977_squares_of_a_sorted_array {
    //can also be done in one pass (st++, end--) k from n-1 (IG)
    //Traverse like this!!  <-- 0 :i | j: 0 -->
    public int[] sortedSquares(int[] nums) {
        int i=0, j=0, k=0, n=nums.length;
        int ans[]=new int[n];
        while(j<n && nums[j]<0)
            j++;
        System.out.println(j);
        int m=j;
        i=m-1;
        while(i>=0 && j<n){
            if(-1*nums[i] < nums[j]){
                ans[k++] = nums[i]*nums[i];
                i--;
            }
            else{
                ans[k++] = nums[j]*nums[j];
                j++;
            }
        }     
        while(i>=0){
            ans[k++] = nums[i]*nums[i];
            i--;
        }
        while(j<n){
            ans[k++] = nums[j]*nums[j];
            j++;
        }
        return ans;
    }
}
