import java.util.*;
import java.io.*;

//Accepted but better solution in editorial.
public class aMatrixGame// for codeForces
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
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int p = 0; p < t; p++) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int game[][] = new int[rows][cols];
            int is1InRow[] = new int[rows];
            int is1InCol[] = new int[cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    game[i][j] = sc.nextInt();
                    if (is1InCol[j] == 0)
                        is1InCol[j] = game[i][j];
                    if (is1InRow[i] == 0)
                        is1InRow[i] = game[i][j];
                }
            }
            int loser = 1;// Ashish 1, Vivek -1
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (is1InCol[j] == 0) {
                        if (is1InRow[i] == 0) {
                            is1InCol[j] = 1;
                            is1InRow[i] = 1;

                            loser *= -1;
                        }
                    }

                }
            }
            if (loser == -1)
                System.out.println("Ashish");
            else
                System.out.println("Vivek");
        }

    }
}
/*
 * Editorial:- Let a be the number of rows which do not have any cell claimed in
 * them initially and similarly b be the number of columns which do not have any
 * cell claimed initially. Each time a player makes a move both a and b decrease
 * by 1, since they only claim cells in rows and columns with no claimed cells.
 * 
 * If either one of a or b becomes 0, the player whose turn comes next loses the
 * game. Since both a and b decrease by 1 after each move, min(a,b) becomes 0
 * first. So, if min(a,b) is odd, Ashish wins the game otherwise Vivek wins.
 */
