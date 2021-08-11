import java.util.*;
import java.io.*;

//problem link: https://codeforces.com/problemset/problem/295/B
public class FlyodWarshallP1 {
    static long mod = 1000000007;
    static int IINF = Integer.MAX_VALUE;

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
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        int vertex[] = new int[n];
        long ans = 0;
        int minDist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                minDist[i][j] = IINF;
            }
        }
        for (int i = 0; i < n; i++) {
            vertex[n - i - 1] = sc.nextInt();
        }
        for (int k = 0; k < n; k++) {
            ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    minDist[i][j] = Math.min(minDist[i][j], minDist[i][k] + minDist[k][j]);
                    ans += minDist[i][j];
                }
            }
            System.out.println(ans);
        }

    }
}