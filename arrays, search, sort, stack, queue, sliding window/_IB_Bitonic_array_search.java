public class _IB_Bitonic_array_search {
    public int findPeak(int []a, int n){
        int st=1, end=n-1, mid;
        while(st<=end){
            mid=st+(end-st)/2;
            if(a[mid-1]<a[mid] && a[mid]<a[mid+1])
                return mid;//since gauranteed 1 peak
            if(a[mid]>a[mid+1]){
                //descending
                end=mid-1;
            }
            else
                st=mid+1;
        }
        return -1;
    }
    public int BS(int a[], int st, int end, int target, boolean ascending){
        int mid;
        while(st<=end){
            mid=st+(end-st)/2;
            if(a[mid]==target)
                return mid;//since gauranteed 1 peak
            if(a[mid]>target){
                //if ascending, go left
                if(ascending)
                    end=mid-1;
                //if descending, go right
                else
                    st=mid+1;
            }
            else{
                //if ascending, go right
                if(ascending)
                    st=mid+1;
                //if descending, go left
                else
                    end=mid-1;
            }
            
        }
        return -1;
        
    }
    public int solve(int[] a, int target) {
        //1. find peak using BS. if peak == target) stop
        //2. BS ascending on left
        //3. BS descending on right
        int ans=-1;
        int peak=findPeak(a,a.length-1);
        
        if(a[peak]==target) 
            return peak;
        //else
        int lhs=BS(a, 0, peak-1, target, true);
        if(lhs!=-1 && a[lhs]==target) 
            return lhs;
            
        int rhs=BS(a, peak+1, a.length-1, target, false);
        if(rhs!=-1 && a[rhs]==target) 
            return rhs;
        return -1;
    }
}

