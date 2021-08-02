public class _1095_Find_BS_in_mountain_array {
    //LC hard
    //aditya verma BS - ez done in 30 mins (while sleepy!)
    public int BS(MountainArray mountainArr, int target, int st, int end, boolean asc){
        int index = -1;
        while(st <= end){
            int i = st + (end - st) / 2;
            int num = mountainArr.get(i);
            if(num == target){
                index = i;
                end = i - 1;
            }
            else if(num < target){
                if(asc)
                    st = i + 1;
                else
                    end = i - 1;
            }
            else {
                if(asc)
                    end = i - 1;
                else 
                    st = i + 1;
            }
        }
            
        return index;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int st = 0, end = mountainArr.length() - 1;
        int n = end, i = 0;
        
        while(st <= end){
            i = st + (end - st) / 2;
            
            int prev = -1, num = -1, next = -1; 
            num = mountainArr.get(i);
            if(i>0)
                prev = mountainArr.get(i-1);
            if(i<n)
                next = mountainArr.get(i+1);
            
            if(i < n && num > next && i > 0 && num > prev)
                break;
            if(i < n && num > next && i > 0 && num < prev)
                end = i - 1;
            else if(i < n && num < next && i > 0 && num > prev)
                st = i + 1;
            else if(i < n && num > next)
                end = i - 1;
            else 
                st = i + 1;
        }
        int index = BS(mountainArr, target, 0, i - 1, true);
        if(index != -1) return index;

        if(mountainArr.get(i) == target) 
        return i;

        index = BS(mountainArr, target, i + 1, n, false);
        return index;
    }
}
