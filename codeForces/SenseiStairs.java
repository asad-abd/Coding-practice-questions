import java.util.*;
import java.io.*;

//
public class SenseiStairs// for codeForces
{
    static long mod = 1000000007;

    static void pnl(final Object o) {
        System.out.println(o);
    }

    static void pn(final Object o) {
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
                } catch (final IOException e) {
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
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(final String args[]) {
        int t, s;
        int k = 0, n = 0;
        FastReader sc = new FastReader();
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            s = sc.nextInt();
            k = sc.nextInt();
            int temp = 0;
            boolean floorsShut[] = new boolean[n + 1];
            for (int j = 0; j < k; j++) {
                temp = sc.nextInt();
                floorsShut[j] = true;

            }
            int ansR = Integer.MAX_VALUE;
            int ansL = Integer.MAX_VALUE;
            for (int j = s; j <= Math.min(s + 1000, n - 1); j++) {
                if (floorsShut[j] == false) {
                    ansR = j - s;
                    break;
                }

            }
            for (int j = s; j >= 0; j--) {
                if (floorsShut[j] == false) {
                    ansR = s - j;
                    break;
                }
            }
            // System.out.println(Math.min(ansL, ansR));
            System.out.println(ansL + " " + ansR);
        }
    }
}
