
//https://codeforces.com/contest/1396/problem/A
import java.util.*;
import java.io.*;

public class _666_MultiplesOfLength {
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
        int n, k;
        FastReader sc = new FastReader();
        n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println("1 1\n" + (-1 * a[0]));
            System.out.println("1 1\n1");
            System.out.println("1 1\n-1");
        } else {
            System.out.println("1 1\n" + (-1 * a[0]));
            a[0] = 0;
            // line 2
            System.out.println(1 + " " + n);
            for (int i = 0; i < n; i++) {
                System.out.print((-1 * a[i] * n) + " ");
            }
            // line 3
            System.out.println("\n" + 2 + " " + n);
            for (int i = 1; i < n; i++) {
                System.out.print((a[i] * (n - 1)) + " ");
            }
        }

    }
}
