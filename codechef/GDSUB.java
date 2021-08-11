import java.util.*;
import java.io.*;
//has a very important mathematical concept 
class GDSUB//for CodeChef september long 2019
{
	static long mod=1000000007;
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
            try{ 
                str = br.readLine(); 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
	}
	//program starts here
	static long m=1000000007;
	static long nck[][]=new long[8001][8001];
	static void fillnCk(int n){
		nck[1][0]=1;nck[1][1]=1;
		for(int k=2;k<=n;k++){
			nck[k][0]=1;nck[k][k]=1;
			for(int i=0;i<=(k-2);i++)
				nck[k][i+1]=(nck[k-1][i]+nck[k-1][i+1])%m;
		}
	}
	public static void main(String args[]){
		int n,k ;
		Scanner sc=new Scanner(System.in);
		long ans=0;
		n=sc.nextInt();
		//fillnCk(n);//takes at max 0.8 secs
		k=sc.nextInt();
		int A[]=new int[n];
		int c[]=new int[8000+1];
		for(int i=0;i<n;i++){
			A[i]=sc.nextInt();	
			c[A[i]]++;																																																																													
		}int count=0;
		for(int i=2;i<=8000;i++){
			if(c[i]!=0)
				count++;
		}
		int f[]=new int[count+1];
		long a[]=new long[count+1];
		for(int i=2,j=1;i<=8000;i++){
			if(c[i]!=0){
				f[j++]=c[i];
			}
		}
		//for(int i=1;i<=count;i++)
		//	pn(" "+f[i]);
		//finding coeff of (x-f[1])...(x-f[count]) 
		a[1]=1;a[0]=-1*f[1];
		for(int m=2;m<=count;m++){
			a[m]=a[m-1];
			for(int i=m-1;i>=1;i--){
				a[i]=a[i-1]-f[m]*a[i];
				a[i]=a[i]%mod;
			}
			a[0]=-1*a[0]*f[m];
			a[0]=a[0]%mod;
		}int sign=1;
		for(int i=0;i<=k&&i<=count;i++){
			ans+=a[count-i]*sign;
			ans=ans%mod;
			sign*=-1;
		}
		pnl(ans);
	}
}