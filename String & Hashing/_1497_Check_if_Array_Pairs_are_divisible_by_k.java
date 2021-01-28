//if a%k==x then b%k should == k-x
//IMP: The only catch is in JAVA: if numbers are negative we add k to the mod (remainder).
class _1497_Check_if_Array_Pairs_are_divisible_by_k {
    public boolean canArrange(int[] arr, int k) {
        
        int n=arr.length;
        int freq[]=new int[k];
        for(int i=0;i<n;i++){
            int mod=arr[i]%k;
            if(mod<0) mod+=k;
            freq[mod]++;
        }
        if(freq[0]%2!=0) return false;
        
        for(int i=1;i<k;i++){
            if(freq[i]!=freq[k-i]) return false;
        }
        return true;
    }
}
