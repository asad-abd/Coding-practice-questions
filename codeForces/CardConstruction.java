import java.util.*;
import java.io.*;

//
public class CardConstruction// for codeForces
{
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
        int t;
        FastReader sc = new FastReader();
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int numberOfCards = sc.nextInt();
            int ans = 0;
            while (numberOfCards >= 2) {
                double l = (Math.sqrt(24 * (double) numberOfCards + 1) - 1) / 6;
                int maxCurrentHeight = (int) l;
                ans++;
                numberOfCards -= (maxCurrentHeight * (3 * maxCurrentHeight + 1)) / 2;

            }

            System.out.println(ans);
        }
    }
}
