import java.util.*;
import java.io.*;

public class A_cancel_the_trains  {
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
        int n, t, m;
        FastReader sc = new FastReader();
        t = sc.nextInt();
        for(int p=0;p<t;p++){
            n=sc.nextInt();
            m=sc.nextInt();
            HashSet<Integer> hset=new HashSet<>();
            for(int i=0;i<n;i++){
                int input=sc.nextInt();
                hset.add(input);
            }
            for(int i=0;i<m;i++){
                int input=sc.nextInt();
                hset.add(input);
            }
            System.out.println(n+m-hset.size());
        }

    }
}
