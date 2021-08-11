import java.util.*;
import java.io.*;
//
public class _42_beta_Winner
{
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
		int n,k;
        FastReader sc=new FastReader();
        
        HashMap<String,Integer> hmap=new HashMap<>();
        int max=Integer.MIN_VALUE;
        String maxName="";
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            String t[]=s.split(" ");
            //System.out.println(Arrays.toString(t));
            int score=Integer.parseInt(t[1]);
            hmap.put(t[0],hmap.getOrDefault(t[0],0)+score);
            if(hmap.get(t[0])>max){
                max=hmap.get(t[0]);
                maxName=t[0];
            }
        }
        for(Map.Entry<String,Integer> entry: hmap.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                maxName=entry.getKey();
            }
        }
		System.out.println(maxName);
	}
}
