
import java.util.*;
import java.io.*;

public class B_Suffix_Operations  {
    int IINF = Integer.MAX_VALUE;
    static long mod = 1000000007;

    static void pnl(Object o) {
        System.out.println(o);
    }

    static void pn(Object o) {
        System.out.print(o + " ");
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String args[]) {
        int n, t;
        FastReader sc = new FastReader();
        t = sc.nextInt();
        for(int p=0;p<t;p++){
            n=sc.nextInt();
            int a[]=new int[n];
            int maxDiffIndex=0;
            int maxDiff=Integer.MIN_VALUE;
            long diff1=0,diff2=0;
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                if(i>0){
                    if(Math.abs(a[i-1]-a[i])>maxDiff){
                        maxDiffIndex=i-1;
                        maxDiff=Math.abs(a[i-1]-a[i]);
                        
                    }
                }
            }
            //System.out.println(" -> maxInd "+maxDiffIndex+" <- ");
                
            if(maxDiff==0 || n==2){
                System.out.println(" -> "+0+" <- ");
                continue;
            }
            int b[]=Arrays.copyOf(a,n);
            a[maxDiffIndex]=a[maxDiffIndex+1];
            //System.out.println(Arrays.toString(a));
            for(int i=n-2;i>=0;i--){
                diff1+=Math.abs(a[i]-a[i+1]);

            }
            //System.out.println(" -> "+diff+" <- ");
            b[maxDiffIndex+1]=b[maxDiffIndex];
            //System.out.println(Arrays.toString(a));
            for(int i=n-2;i>=0;i--){
                diff2+=Math.abs(b[i]-b[i+1]);

            }
            System.out.println("->"+Math.min(diff1,diff2));

        }

    }
}

