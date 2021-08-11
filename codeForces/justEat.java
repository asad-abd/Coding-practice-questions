import java.util.*;
import java.io.*;
//
public class justEat//for codeForces
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
	public static void main(String args[])
	{
		long t=0;
		FastReader sc=new FastReader();
        t=sc.nextInt();
        int n=0;
        for(int i=0;i<t;i++){
            n=sc.nextInt();
            long a[]=new long[n];
            long totalSum=0;
            long max1=a[0],maxTillHere1=0;
            long max2=a[1],maxTillHere2=0;
            for(int j=0;j<n;j++){
                a[j]=sc.nextLong();
                totalSum+=a[j];
                if(j<=n-2){
                    maxTillHere1+=a[j];
                    if(max1<maxTillHere1)
                        max1=maxTillHere1;
                    if(maxTillHere1<0)
                        maxTillHere1=0;
                }
                if(j>=1){
                    maxTillHere2+=a[j];
                    if(max2<maxTillHere2)
                        max2=maxTillHere2;
                    if(maxTillHere2<0)
                        maxTillHere2=0;

                }
            }
            long max=Math.max(max1,max2);
            if(max>=totalSum)
                System.out.println("NO");
            else
                System.out.println("YES");

        }
		
	}
}
