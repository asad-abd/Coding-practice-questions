import java.util.*;
import java.io.*;
class COKE2//for CodeChef
{
	static long IINF=(long)1e17;
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
	public static void main(String args[])
	{
		int t;
		FastReader sc=new FastReader();
		t=sc.nextInt();
		String ans[]=new String[t]; 
		for(int po=0;po<t;po++)
		{
			ans[po]="";
			int n=sc.nextInt();
			long c[]=new long[n+1];
			long p[]=new long[n+1];
			int q=sc.nextInt();
			int k=sc.nextInt();
			int l=sc.nextInt();
			int r=sc.nextInt();		
			int ftemp=0;	
			for(int i=1;i<=n;i++){
				c[i]=sc.nextInt();
				p[i]=sc.nextInt();
			}
			for(int j=1;j<=q;j++){
				long cheapest=-1;
				long minprice=IINF;
				for(int i=1;i<=n;i++){	
					if(c[i]>k){
						ftemp=(c[i]-j>=k?c[i]-j:k);//after i minutes
					}
					else if(c[i]<k){
						ftemp=(c[i]+j<=k?c[i]+j:k);
					}
					else
						ftemp=k;
					if(ftemp>=l && ftemp<=r){
						if(c[i]<minprice){
							minprice=(long)p[i];
							cheapest=minprice;
						}
					}
				}
				ans[po]+=cheapest+" ";
			}
		}
		for(int i=0;i<t;i++)
			System.out.println(ans[i]);

	}
}