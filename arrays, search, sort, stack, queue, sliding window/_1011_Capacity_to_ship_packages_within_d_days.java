class _1011_Capacity_to_ship_packages_within_d_days {
    public int shipWithinDays(int[] weights, int days) {
        //Basically it is book allocation problem. Comparison:-
        //days = students
        //weights[i] = pages_of_books[i]
        int k=days, n=weights.length;
        if(k>n) return -1;//VVVVimp condition: WA on InterviewBit w/o this.
        int st=0,end=0,mid;
        for(int i=0;i<n;i++){
            st=Math.max(st,weights[i]);
            end+=weights[i];
        }
        int ans=-1;
        //st=0;
        while(st<=end){
            mid=st+(end-st)/2;
            if(isValid(weights,n,k,mid)){
                //System.out.println(mid);
                ans=mid;
                end=mid-1;
            }
            else
                st=mid+1;
        }
        return ans;
    
    }
    boolean isValid(int[] a, int n, int k, int max){
        int students=1, sum=0;
        //System.out.println("MAX: " + max);
        for(int i=0; i<n;i++){
            sum+=a[i];
            if(sum>max){
                students++;//give the overflow to the next student 
                sum=a[i];
                
            }
            if(a[i]>max || students>k){//1 indexed! - S.M. Done before
                //System.out.println(students+"   bloody false!!!");
                return false;
                
            }
        }
        //System.out.println(students+" , k: "+k);
        
        return true;
    }
    
}
