import java.util.*;
import java.io.*;
// Done
public class _1493_B_Planet_Lapituletti//for codeForces
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
    static int arr[]=new int[10];
    
    public static boolean reflectionValid(int hr, int min, int h, int m){
        if(arr[hr/10]==-1 || arr[hr%10]==-1 || arr[min/10]==-1 || arr[min%10]==-1)
            return false;
        //also check if reversed time is within h and m.
        int x=arr[hr%10]*10 + arr[hr/10];
        int y=arr[min%10]*10 + arr[min/10];
        if(x>=m|| y>=h)  // IMPORTANT - swap hrs and mins because of mirror - SMC
            return false;
        return true;        
    }
	public static void main(String args[])
	{
        arr[0]=0;
        arr[1]=1;
        arr[2]=5;
        arr[3]=-1;
        arr[4]=-1;
        arr[5]=2;
        arr[6]=-1;
        arr[7]=-1;
        arr[8]=8;
        arr[9]=-1;
		int T;
		FastReader sc=new FastReader();
        T=sc.nextInt();
		for(int tt=0;tt<T;tt++){
            int h=sc.nextInt();
            int m=sc.nextInt();
            String s=sc.next();
            //String s1[]=s.split(":");
            
            String temp=s;
            String s1[]=s.split(":");
            int hr=Integer.parseInt(s1[0]);
            int min=Integer.parseInt(s1[1]);
            while(!reflectionValid(hr, min, h, m)){
                min++;
                if(min==m) hr++;
                
                min%=m;
                hr%=h;
            }
            if(hr<10)
                temp="0"+hr+":";
            else
                temp=""+hr+":";
            if(min<10)
                temp+="0"+min;
            else
                temp+=""+min;
            System.out.println(temp);
            
        }
		//System.out.println(ans);
	}
}
