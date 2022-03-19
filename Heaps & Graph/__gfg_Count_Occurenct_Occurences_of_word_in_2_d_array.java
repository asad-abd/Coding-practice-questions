//issue while running but logic fine
//https://practice.geeksforgeeks.org/problems/count-occurences-of-a-given-word-in-a-2-d-array/1/?company[]=Paytm&company[]=Paytm&page=1&sortBy=newest&query=company[]Paytmpage1sortBynewestcompany[]Paytm#
class Solution
{
    public int dfs(char m[][], int i, int j, String S, int idx){
        int foundCount = 0; // count of number of occurences 
        if(i >=0 && i < m.length && j >= 0 && j < m[0].length && idx < S.length() && m[i][j] == S.charAt(idx)){
            //within bounds ans a MATCH
            char temp = m[i][j]; // store it to un mark it after counting done
            m[i][j] = '0'; // mark it
            idx ++;
            if(idx == S.length()){
                foundCount  = 1;
                System.out.println("haaa");
            }    
            else{
                //NOTE that 2 occurence may partially OVERLAP!
                foundCount += dfs(m, i + 1, j, S, idx);
                foundCount += dfs(m, i - 1, j, S, idx);
                foundCount += dfs(m, i, j + 1, S, idx);
                foundCount += dfs(m, i, j - 1, S, idx);
            }
            //found has been calculated un mark m[i][j]
             m[i][j] = temp;
        }
        return foundCount;
    }
    public int findOccurrence(char m[][], String target){
        int ans = 0;
        for(int i = 0; i < m.length; i ++){
            for(int j = 0; j < m[0].length; j ++){
                ans += dfs(m, i, j, target, 0);
            }
        }
        return ans;
    }
}
