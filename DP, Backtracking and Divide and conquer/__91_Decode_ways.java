public class __91_Decode_ways {
    //RESEE WHERE YOU WERE STUCK
    //memo:
    public int dfs(char c[], int i, int t[]){
        if(i >= c.length)//(Where I was STUCK***) - if we have safely traversed all the valid indices then we finally have a valid encoding. 
            return 1;
        if(c[i] == '0')
            return 0;
        if(t[i] != -1)
            return t[i];
        int val = c[i] - '0';
        int take1 = dfs(c, i + 1, t);
        int take2 = 0;
        if(i + 1 < c.length){
            val = val * 10 + (c[i + 1] - '0');
            if(val >= 10 && val <= 26)
                take2 = dfs(c, i + 2, t);
        }
        return t[i] = take1 + take2;
    }

    //recursive TLE: (lead coding @ yt)
    public int dfs(char c[], int i){
        if(i >= c.length)//(Where I was stuck) - if we have safely traversed all the valid indices then we finally have a valid encoding. 
            return 1;
        if(c[i] == '0')
            return 0;
        int val = c[i] - '0';
        int take1 = dfs(c, i + 1);
        int take2 = 0;
        if(i + 1 < c.length){
            val = val * 10 + (c[i + 1] - '0');
            if(val >= 10 && val <= 26)
                take2 = dfs(c, i + 2);
        }
        return take1 + take2;
    }
    public int numDecodings(String s) {
        char c[] = s.toCharArray();
        return dfs(c, 0);
    }
    //an old one: the checking conditions can come in handy
    /*public int numDecodings(String s) {
        //if more than 1 continuous 0s. return 0
        char c[] = s.toCharArray();
        if(c[0] == '0') return 0;
        for(int i = 0; i < c.length - 1; i ++){
            if(c[i] == '0' && c[i + 1] == '0')
                return 0;
            if(c[i + 1] == '0' && c[i] - '0' > 2)
                return 0;
        }
        return dfs(c, 0);
        //int t[] = new int[c.length + 1];
        //
        //return t[c.length];
    }*/
}
