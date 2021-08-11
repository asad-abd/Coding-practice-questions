import java.util.*;
import java.io.*;
import java.math.*;
//AC- log(n) isn't accurate for larger n
class FIBEASY//for CodeChef september 19-long
{ 	
	static void pnl(Object o){
		System.out.println(o);
	} 
	static void pn(Object o){
		System.out.print(o+" ");
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}

		String next(){
			while(st==null || !st.hasMoreElements()){
				try{
					st=new StringTokenizer(br.readLine());
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt(){ 
            return Integer.parseInt(next()); 
        }
        long nextLong(){ 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble(){ 
            return Double.parseDouble(next()); 
        }
        String nextLine(){ 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
	}
	//program starts here
	int mod(String s,int r){
		int res=0;
		for (int i = 0; i < s.length(); i++) 
            res = (res * 10 + s.charAt(i)  - '0') % r;
        return res;
	}
	long pow (long a, long b){
	    if ( b == 0)        return 1;
	    if ( b == 1)        return a;
	    if (b%2==0)    return     pow ( a * a, b/2); //even a=(a^2)^b/2
	    else                return a * pow ( a * a, b/2); //odd  a=a*(a^2)^b/2
	
	}
	void solve(){
		int t;
		long n;
		FastReader sc=new FastReader();
		t=sc.nextInt();
		int ans[]=new int[t];
		int a=0,b=1,c=a+b,m=10,pisano=0;
		for(int i=1;i<=m*m;i++){
			c=(a+b)%m;
			a=b;
			b=c;
			if(a==0&&b==1){
				pisano=i;
				break;
			}
		}
		//pnl(pisano);
		int fib[]=new int[pisano];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<pisano;i++){
			fib[i]=(fib[i-1]+fib[i-2])%m;
		}
		for(int p=0;p<t;p++){
			n=sc.nextLong();
			//n=(long)(Math.log(n)/Math.log(2));
			long temp1=2;
			int count1=0;
			while(temp1<=n){
				temp1*=2;
				count1++;
			}
			//pnl("nlog= "+n);
			n=pow(2,count1);
			String s=""+n;
			int temp=mod(s,pisano)-1;
			//pnl("mod "+(temp+1));
			ans[p]=fib[(int)temp];
		}

		for(int p=0;p<t;p++){
			pnl(ans[p]);
		}
	}
	public static void main(String args[]){
		FIBEASY obj=new FIBEASY();
		obj.solve();
	}
}