class _730_HARD_Count_different_Palindromic_Subsequences {
    // Understanding brute force: (GFG comments) BEST EXPLANATION TO THIS ONE
    // 1. When char at i and j are equal, then count(i,j) = number of sequences INCLUDING-BOTH s[i] and s[j] (call it a) 
    //                                               + number of sequences that INCLUDE EITHER s[i] or s[j] (call it b) (but not both)
    // a = 1 + count(i+1,j-1)
    // b = count(i,j-1) + count(i-1,j) - count(i+1,j-1)
    // a+b= 1 + count(i,j-1) + count(i-1,j)
    // 2. When char at i and j are NOT equal: then it's straight forward UNION: number of sequences INCLUDING s[i] BUT NOT s[j]
    //                                               + number of sequences that are NOT-INCLUDING s[i] BUT INCLUDING s[j] (CANNOT INCLUDE BOTH OTHERWISE NOT PALINDROME!!)
    //count(i,j-1) + count(i-1,j) - count(i+1,j-1)
    
    
    //my understanding for the UNION part
    //Inspiration: n(AUB) = n(A) + n(B) + n(A and B)
    //my target is to reduce it in smaller parts I know. below is intuition from JEE maths
    // n(i,j) = 1(for the subsequence of length 2- {s[i],s[j]}) + n((i,j-1) U  (i-1,j))
    // n((i,j-1) U (i-1,j)) = n(i,j-1) + n(i-1,j) + n(and)\
    // n(and) = seeing on the array line (like a number line) the and part is n(i-1,j-1)
    long mod=(long)Math.pow(10,9)+7;
    public long cps(char[] s, int i, int j, int[][] t) {
        if(i>j) return 0;
        if(i==j) return 1;
        
        if(t[i][j]!=-1) return t[i][j];
        
        if(s[i]==s[j])
            return t[i][j]=cps(s,i,j-1) + cps(s,i+1,j-1) - cps(s,i+1,j-1) + 1 ;
            
        else
            return t[i][j]=cps(s,i,j-1) + cps(s,i+1,j-1) ;        
    }
    long countPS(String str)
    {
        int n=str.length();
        char s[] = str.toCharArray();
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                t[i][j] = -1;
        
        return cps(s,0,n-1,t);
    }
}


    /* let m = str(i-1,j-1)
    let c1..m..c2 be the current string
    if(c1==c2)
        count(str) = count(c1.m.c2)
                   + count(c1.m)
                   + count(m.c2)
                   + count(m) 
        let str=aabaa  m=aba
        now notice something about count(c1.m.c2) and count(m)
        m's palind subsequences: 
                                  a
                                 a a
                                  b
                                a b a
        ~some YT video pepcoding    
    */