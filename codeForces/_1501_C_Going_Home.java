
import java.util.*;
import java.io.*;
// TLE on #73- issue with the question
public class _1501_C_Going_Home//for codeForces
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
		int T,i,j;
		FastReader sc=new FastReader();
        int n=sc.nextInt();
        int a[]=new int[n];
       
        for(i=0;i<n;i++)
            a[i]=sc.nextInt();
		HashMap<Integer, int[]> hmap=new HashMap<>();
		boolean ans=false;
		int p=0, q=0, r=0, s=0;
		for(i=0;i<n-1;i++){
			for(j=i+1;j<n;j++){
				if(hmap.containsKey(a[i]+a[j]) && i!=hmap.get(a[i]+a[j])[0] && j!=hmap.get(a[i]+a[j])[1] && j!=hmap.get(a[i]+a[j])[0] && i!=hmap.get(a[i]+a[j])[1] ){
					ans=true;
					p=hmap.get(a[i]+a[j])[0]+1;
					q=hmap.get(a[i]+a[j])[1]+1;
					r=i+1;
					s=j+1;
					break;
				}
				hmap.put(a[i]+a[j], new int[]{i, j});
			}
		}
        
        //Arrays.sort(a, (x,y)-> Integer.compare(x[0],y[0]));
        
        System.out.println(ans==true?"YES\n"+p+" "+q+" "+r+" "+s:"NO");
		
		
	}
}
