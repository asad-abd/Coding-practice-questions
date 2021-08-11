import java.util.*;
import java.io.*;
//AC
class CHEFINSQ//for CodeChef september long 2019
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
	static long nck[][]=new long[51][51];
	static void fillnCk(){
		nck[1][0]=1;nck[1][1]=1;
		for(int k=2;k<=50;k++){
			nck[k][0]=1;nck[k][k]=1;
			for(int i=0;i<=(k-2);i++)
				nck[k][i+1]=nck[k-1][i]+nck[k-1][i+1];
		}
	}
	public static long nCk(int n,int k){
		long a=1,b=1,c=1;
		for(int i=2;i<=n;i++)
			a*=i;
		for(int i=2;i<=k;i++)
			b*=i;
		for(int i=2;i<=n-k;i++)
			c*=i;
		return a/(b*c);
	}
	public static void main(String args[]){
		int n,t,k ;
		Scanner sc=new Scanner(System.in);
		fillnCk();
		t=sc.nextInt();
		long ans[]=new long[t];
		for(int p=0;p<t;p++){
			n=sc.nextInt();
			k=sc.nextInt();
			int st=0,end=k,sumk=0,minsum=0,countmin=1;
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			Arrays.sort(a);
			for(int i=0;i<k;i++)
				minsum+=a[i];
			int countr=0,countl=0;
			while(end<n){//countr(right of a[k-1])
				if(a[k-1]!=a[end]){
					break;
				}
				//else
				countr++;
				end++;
			}
			st=k-1;
			while(st>=0){//countl(right of a[k-1]-inclusive a[k-1])
				if(a[k-1]!=a[st]){
					break;
				}
				//else
				countl++;
				st--;
			}
			if((countl+countr)>1){
				ans[p]=nck[countl+countr][countl];
			}
			else
				ans[p]=1;
		}
		for(int p=0;p<t;p++){
		 	System.out.println(ans[p]);
		}
		//n=sc.nextInt();
		//k=sc.nextInt();
		//pnl(nck[n][k]);
	}
}
/*
minsum=sumk;
			while(end<=n){
				sumk-=a[st];
				st++;
				sumk+=a[end];
				end++;
				if(minsum>sumk)
					minsum=sumk;
			}
			st=0;end=k;
			while(end<=n){
				sumk-=a[st];
				st++;
				sumk+=a[end];
				end++;
				if(minsum==sumk)
					countmin++;
			}
*/