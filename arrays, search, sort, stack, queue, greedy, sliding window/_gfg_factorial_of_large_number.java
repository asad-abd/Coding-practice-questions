class _gfg_factorial_of_large_number {
    //apparently O(n)
    static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> res = new ArrayList<>();
        //ans in reverse. can reverse later.
        res.add(1);
        if(N<=1) return res;
        
        for(int n=N;n>=2;n--){
            //multiply n with all the digits
            int temp_l=res.size(), carry=0, digit;
            for(int i=0;i<temp_l;i++){
                digit=(res.get(i)*n + carry)%10 ;
                carry=(res.get(i)*n + carry)/10 ;
                res.set(i, digit);
            }
            while(carry>0){
                res.add(carry%10);
                carry/=10;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
