import java.util.*;
import java.io.*;

//Done Later on own in less than 10 mins :/
//after the base conditions:-
//its just like those 2d puzzles having many square pieces (type 1) which we have to rearrange to 
//complete the puzzle where one square is empty (type 2) to allow swapping. 
//if we simply increase that space from 1 to any greater value, the swapping will only get easier.
public class TroubleSort {
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

    public static boolean isSorted(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int p = 0; p < t; p++) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int type1 = 0, type2 = 0;
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                type1 = b[i] == 0 ? (type1 + 1) : type1;
                type2 = b[i] == 1 ? (type2 + 1) : type2;
            }
            // System.out.println("type1 and type2 :" + type1 + " - " + type2);
            if (isSorted(a)) {
                System.out.println("Yes");
                continue;
            }
            if (type1 == 0 || type2 == 0)
                System.out.println("No");
            else
                System.out.println("Yes");

        }
    }
}