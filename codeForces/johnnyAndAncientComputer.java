import java.util.*;
import java.io.*;

//
public class johnnyAndAncientComputer// for codeForces
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

    static long countAns(long num) {
        int count = 0;
        while (num > 1) {
            if (num % 8 == 0)
                num /= 8;
            else if (num % 4 == 0)
                num /= 4;
            else if (num % 2 == 0)
                num /= 2;
            count++;
        }
        return count;
    }

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (b == a) {
                System.out.println("0");
                continue;
            }
            if (b < a) {
                long temp = b;
                b = a;
                a = temp;
            }

            if (b / a == (long) Math.ceil((double) b / (double) a)) {
                // b/a is integer
                long div = b / a;
                if ((div & (div - 1)) == 0)
                    System.out.println(countAns(div));
                else
                    System.out.println("-1");
            } else
                System.out.println("-1");

        }

    }
}
