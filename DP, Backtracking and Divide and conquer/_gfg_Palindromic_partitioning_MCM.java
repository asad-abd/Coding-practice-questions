//R1 Aug done
class _gfg_Palindromic_partitioning_MCM {
    //watch Aditya Verma YT
    //adding t[][] makes O(n^2)
    static boolean isPalindrome(String s,int start,int ending){
        int st=start, end=ending;
        while(st<end){
            if(s.charAt(st)!=s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
    //driver
    static int pPartition(String s,int st, int end, int t[][]){
        if(st>=end || isPalindrome(s,st,end)){ 
            t[st][end]=0;
            return 0;
            
        }
        
        if(t[st][end]!=-1) return t[st][end];
        //else
        int ans=Integer.MAX_VALUE;
        
        for(int i=st;i<end;i++){
            //System.out.println(st+"\t"+i+"\t"+end);
            int count=0;
            
            if(t[st][i]!=-1) 
                count+=t[st][i];
            else {
                t[st][i]=pPartition(s,st,i,t);
                count+=t[st][i];
            }
            if(t[i+1][end]!=-1) 
                count+=t[i+1][end];
            else{ 
                t[i+1][end]=pPartition(s,i+1,end,t);
                count+=t[i+1][end];
            }
            ans=Math.min(ans, count+1);
        }
        t[st][end]=ans;
        return ans;
    }
    static int palindromicPartition(String s){
        int t[][]=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            for(int j=0;j<s.length();j++)
                t[i][j]=-1;
        return pPartition(s,0,s.length()-1, t);
    }
}
