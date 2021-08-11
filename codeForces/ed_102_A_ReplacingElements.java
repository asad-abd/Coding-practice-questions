import java.util.*;
import java.io.*;
//
public class ed_102_A_ReplacingElements {
    int IINF=Integer.MAX_VALUE;
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
		FastReader sc=new FastReader();
        int T=sc.nextInt();
        for(int t=0;t<T;t++){
            int n=sc.nextInt();
            int d=sc.nextInt();
            int arr[]=new int[n];
            boolean flag=true;
            
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                
                if(arr[i]>d){
                    flag=false;
                }
                
            }
            
            if(flag)
                System.out.println("YES");
            else{
                Arrays.sort(arr);
                if(arr[0]+arr[1]<=d)
                    System.out.println("YES");
                else
                System.out.println("NO");
            }
        }
		//System.out.println(ans);
	}
}
