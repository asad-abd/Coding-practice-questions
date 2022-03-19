class __44_Wildcard_Matching{
	//general tip : always use if - else even with return: or SMC while memo
	/*
    s = aa
    p = *
    //'*' => we have 2 option, choose s[i++] in * or not choose it!
        rec 1 // (a,*) -> (a,*) || (a, Emp) 
        rec 2 // (a,*) -> (Emp, *) || (Emp, Emp)
    
    //'?' => simply increment both s and p
    //else => 
        if s[i] == p[j] increment both
        else return false;
    */
    
    //recur + memo AC
    public boolean dfs(char s[], char p[], int i, int j, int t[][]){
        //if pattern is over
        System.out.println(i + " - " + j);
        if(j == p.length){
            //if s is left -> false
            if(i < s.length) return false;
            return true;
        }        
        //it is posible that the string is over but we're left with "*"
        if(i == s.length){
            if(p[j] == '*')
                return dfs(s, p, i, j + 1, t);
            else
                return false;
        }
        
        //memo
        if(t[i][j] != 0) return t[i][j] == 1 ? true : false;
        
        boolean ans = false;
        if(p[j] == '*'){
            //consider s[i] in it or not in it (because even 0 instances allowed)
            ans = dfs(s, p, i + 1, j, t) || dfs(s, p, i, j + 1, t);
        }
        else if(p[j] == '?')
            ans = dfs(s, p, i + 1, j + 1, t);
        else{
            if(s[i] != p[j]) ans = false;
            else // forgot to add this while memo !! SMD
                ans = dfs(s, p, i + 1, j + 1, t);
        }
        if(ans == true)
            t[i][j] = 1;
        else
            t[i][j] = -1;
        return ans;
    }
    public boolean isMatch(String S, String P) {
        char s[] = S.toCharArray();
        char p[] = P.toCharArray();
        int t[][] = new int[s.length + 1][p.length + 1];
        return dfs(s, p, 0, 0, t);
    }
    
    //recursive TLE
    public boolean dfs(char s[], char p[], int i, int j){
        //if pattern is over
        if(j == p.length){
            //if s is left -> false
            if(i < s.length) return false;
            return true;
        }        
        //it is posible that the string is over but we're left with "*"
        if(i == s.length){
            if(p[j] == '*')
                return dfs(s, p, i, j + 1);
            else
                return false;
        }
        
        if(p[j] == '*'){
            //consider s[i] in it or not in it (because even 0 instances allowed)
            return dfs(s, p, i + 1, j) || dfs(s, p, i, j + 1);
        }
        else if(p[j] == '?')
            return dfs(s, p, i + 1, j + 1);
        else{
            if(s[i] != p[j]) return false;
            return dfs(s, p, i + 1, j + 1);
        }
    }
    public boolean isMatch(String S, String P) {
        char s[] = S.toCharArray();
        char p[] = P.toCharArray();
        //boolean t[][] = new boolean[s.length + 1][p.length + 1];
        return dfs(s, p, 0, 0);
    }
}
