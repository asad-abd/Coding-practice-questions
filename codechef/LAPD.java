import java.util.*;
import java.io.*;
//50%
class LAPD//for CodeChef september long 2019
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
		FastReader sc=new FastReader();
		int t=sc.nextInt();
		long ans[]=new long[t];
		for(int p=0;p<t;p++){
			long count=0;
			long A=sc.nextInt();
			int B=sc.nextInt();
			long C=sc.nextInt();
			if(A>1&&C>1){
				for(int b=1;b<=B;b++){
					long b2=b*b;
					int c;
					for(c=2;c<=C;c++){
						long rhs=(b2/(c-1))+1;
						if((b2/(c-1))<1){
							break;
						}
						if(A>rhs && rhs>=2){
							count=count+A-rhs;
							count=count%mod;
						}
					}
					count=count+(A-1)*(C-c+1);
					count=count%mod;

				}
			}
			else
				count=0;
			ans[p]=count;
		}
		for(int p=0;p<t;p++){
		 	System.out.println(ans[p]);
		}
	}
}/*
		long na,nb,nc,nab,nbc,nca,nabc,b2;
			a--;c--;
			if(a!=0&&c!=0 )
				for(int b=1;b<=B;b++){
					b2=b*b;
					na=0;nb=0;nc=0;nab=0;nbc=0;nca=0;nabc=0;
					if(a-b2>0)
						na=(a-b2)*c;
					if(c-b2>0)
						nb=(c-b2)*a;
					if(((a-b)*(c-b+1)+(a-b+1)*(c-b)-(a-b)*(c-b))>0)
						nc=(a-b)*(c-b+1)+(a-b+1)*(c-b)-(a-b)*(c-b);
					if((a-b2)*(c-b2)>0)
						nab=(a-b2)*(c-b2);
					if((a-b+1)*(c-b2)>0)
						nbc=(a-b)*(c-b2)+(a-b+1)*(c-b2)-(a-b)*(c-b2);
					if((a-b2)*(c-b+1)>0)
						nca=(a-b2)*(c-b+1);
					if((a-b2)*(c-b2)>0)
						nabc=(a-b2)*(c-b2);
					//pnl(null);
					//pn(na);pn(nb);pn(nc);pn(nab);pn(nbc);pn(nca);pn(nabc);
					long temp=(na+nb+nc-(nab+nbc+nca)+nabc);
					if(temp>0){
						count+=temp;
						count=count%mod;
					}
				}
			else
				count=0;
			ans[p]=count;
*/