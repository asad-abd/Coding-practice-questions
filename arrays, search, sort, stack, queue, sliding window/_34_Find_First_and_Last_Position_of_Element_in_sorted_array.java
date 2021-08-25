public class _34_Find_First_and_Last_Position_of_Element_in_sorted_array {
    //EZ. YT Aditya Verma
    public int BS(int arr[], int target, boolean start){
        int st = 0, end = arr.length - 1;
        int mid;
        int ans = -1;
        while(st <= end){
            mid = st + (end - st) / 2;
            if(arr[mid] == target){
                ans = mid;
                if(start)
                    end = mid - 1;
                else
                    st = mid + 1;
            }
            else if(arr[mid] > target)
                end = mid - 1;
            else
                st = mid + 1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = BS(nums, target, true);
        ans[1] = BS(nums, target, false);
        return ans;
    }
}
