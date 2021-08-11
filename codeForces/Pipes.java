import java.util.*;
import java.io.*;
//
public class Pipes//for codeForces #590 (div3) C
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
		int n,t;
		FastReader sc=new FastReader();
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++){
			n=sc.nextInt();
			int a[][]=new int[2][n];
			String s=sc.next();
			for(int i=0;i<s.length();i++){
				a[0][i]=s.charAt(i)-'0';
			}
			s=sc.next();
			for(int i=0;i<s.length();i++){
				a[1][i]=s.charAt(i)-'0';
			}
			int type[][]=new int[2][n];
			for(int j=0;j<n;j++){
				for(int i=0;i<2;i++){
					if(a[i][j]<=2)
						type[i][j]=1;
					else
						type[i][j]=2;
				}
			}
			int level=0;
			boolean possible=true;
			if(n>0){
				int lastmove=0;//0 for right, 1 for up, 2 for down
				for(int i=0;i<n;i++){
					if(level==0&&type[level][i]==2){
						level=1-level;
						if(lastmove!=0){
							possible=false;
							break;
						}
						i--;
						lastmove=2;
						continue;
					}
					else if(level==0&&type[level][i]==1){
						level=level;
						if(lastmove!=0){
							possible=false;
							break;
						}
					}
					else if(level==1&&type[level][i]==2){
						if(lastmove!=2){
							possible=false;
							break;
						}
						lastmove=0;
					}
					else if(level==1&&type[level][i]==1){
						if(lastmove!=0){
							possible=false;
							break;
						}
						lastmove=0;
					}
				}
				if(possible==false)
					ans[p]=0;
				else if(level==1 && lastmove==0)
					ans[p]=1;
				else
					ans[p]=0;
			}
			/*if(n==1){
				if(type[0][0]==2&&type[1][0]==2)
					ans[p]=1;
				else
					ans[p]=0;
			}
			if(n==2){
				if(type[0][0]==2&&type[1][0]==2)
					ans[p]=1;
				else
					ans[p]=0;
			}*/
			
		} 
		for(int i=0;i<t;i++){
			if(ans[i]==1)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
