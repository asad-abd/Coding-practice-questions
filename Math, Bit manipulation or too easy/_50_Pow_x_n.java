public class _50_Pow_x_n {
    public double myPow(double x, int n) {
        if(x==1) return 1;
        
        if(n==-1) return (double)1/x;
        if(n==0) return 1;
        if(n==1) return x;
        
        double temp;
        if(n>0){
            if(n%2==0){
                temp=myPow(x,n/2);
                return temp*temp;
            }
            else{
                temp=myPow(x,(n-1)/2);
                return x*temp*temp;
            }
        }
        else{
            if((-1*n)%2==0){
                temp=myPow(x,n/2);
                return temp*temp;
            }
            else{
                temp=myPow(x,(n+1)/2);
                return ((double)1/x)*temp*temp;
            }
        }
    }
}
