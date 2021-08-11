import java.util.*;
import java.io.*;
//
public class SocialNewtork1//for codeForces #590 (div3) B1
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
		int n,k;
		long ans=0;
		FastReader sc=new FastReader();
		n=sc.nextInt();
		k=sc.nextInt();
		int id[]=new int[n];
		int st=0,end=0;
		LinkedList<Integer> log=new LinkedList<Integer>(); 
		for(int i=0;i<n;i++){
			id[i]=sc.nextInt();
			if(log.size()==0)
				log.addFirst(id[i]);
			else if(log.size()<k){
		 		if(!log.contains(id[i]) ) {
		 			log.addFirst(id[i]);
		 		}
			}
			else {//>=n
		 		if(!log.contains(id[i]) ) {
		 			log.addFirst(id[i]);
		 			log.removeLast();
		 		}
			}
		}
		ans=log.size();
		System.out.println(ans);
		for(int i=0;i<ans;i++){
			System.out.print(log.pollFirst()+" ");
		}
	}
}