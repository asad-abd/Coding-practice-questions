import java.util.*;
class Solution{
    public static String anagram(char[] s){
        int n = s.length;
        char ans[] = new char[n];
        int freq[] = new int[26];
        for(char c : s)
            freq[c - 'a'] ++;
        
        return "0";
    }
    public static void main(String args[]){
        // (chars, freq)
        // (index, char)
        //012345
        //starts
        
        // (s,2)    (t,2)    (a,1) (r,1) 
        
        //place the chars in position that have diffn parent char and are unoccupied
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tt = 0; tt < t; tt ++){
            String s = sc.next();
            
            String ans = anagram(s.toCharArray());
            
            if(ans.equals("0"))
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(ans);
        }
        
    }   
}
