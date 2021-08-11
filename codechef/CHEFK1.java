import java.util.*;
import java.io.*;
//didn't like it- some sequence
class CHEFK1//for CodeChef september long 2019
{	static void pnl(Object o){
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
	public static void main(String args[]){
		long n,m,minmax ;
		FastReader sc=new FastReader();
		int t=sc.nextInt();
		long ans[]=new long[t];
		for(int p=0;p<t;p++){
			n=sc.nextLong();
			m=sc.nextLong();
			minmax=-1;
			if(m>=n-1 &&m<=(n*(n+1))/2&&n>2){//possible
				if(m<=n+1)
					minmax=2;
				else if(m<=2*n)
					minmax=3;
				else{//m>2n
				    long a=m-2*n;
				    a=a*2;
				    if(a%n==0){
				        a=a/n;
				        minmax=a+3;
				    }
				    else{
				        a=a/n;
				        minmax=a+4;
				    }
				}
				
				ans[p]=minmax;
				
			}
			else if(m>=n-1 &&m<=(n*(n+1))/2&&n==1){
				if(m==1)
					ans[p]=1;
				else 
					ans[p]=0;
			}
			else if(m>=n-1 &&m<=(n*(n+1))/2&&n==2){
				if(m==1){
					ans[p]=1;
				//pnl("hello");
				}
				else if(2<=m && m<=3)
					ans[p]=2;
				else
					ans[p]=-1;
			}
			else
				ans[p]=-1;
		}
		for(int i=0;i<t;i++){
			System.out.println(ans[i]);
		}
	}
}
/*import java.util.*;
import java.io.*;
class CHEFK1//for CodeChef september long 2019
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
	public static void main(String args[]){
		long n,m,minmax ;
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		long ans[]=new long[t];
		for(int p=0;p<t;p++){
			n=sc.nextLong();
			m=sc.nextLong();
			minmax=0;
			if(m>=n-1 &&m<=(n*(n+1))/2&&n>2){//possible
				if(m<=n+1)
					minmax=2;
				else if(m<=2*n)
					minmax=3;
				else{//m>2n
					m=m-2*n;
					if(n%2==0){
						double temp=(m*2)/n;
						minmax=3+(long)Math.ceil(temp);
					}
					else{
						int even=1;
						minmax=3;
						while(m>0){
							if(even==1){
								if(m>0)
									minmax++;
								else
									break;
								m=m-(n/2);
							}
							else{//odd
								if(m>0)
									minmax++;
								else
									break;
								m=m-(n/2)-1;
							}
							even*=(-1);
						}
					}
				}
				ans[p]=minmax;
				
			}
			else if(m>=n-1 &&m<=(n*(n+1))/2&&n==1){
				if(m==1)
					ans[p]=1;
				else 
					ans[p]=0;
			}
			else if(m>=n-1 &&m<=(n*(n+1))/2&&n==2){
				if(m==1)
					ans[p]=1;
				if(2<=m && m<=3)
					ans[p]=2;
				else
					ans[p]=-1;
			}
			else
				ans[p]=-1;

		}
		for(int i=0;i<t;i++){
			System.out.println(ans[i]);
		}
	}
}*/