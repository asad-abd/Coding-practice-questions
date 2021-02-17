class _395_Longest_Substring_With_Atleast_K_Repeating_Characters {
    
    //brute force: TLE
    public int longestSubstring(String s, int k) {
        int cumm=1, n=s.length();
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int freq[]=new int[26];
                boolean skip=false;
                for(int p=i;p<=j;p++){
                    freq[s.charAt(p)-'a']++;
                }
                for(int p=0;p<26;p++){
                    if(freq[p]!=0 && freq[p]<k){
                        skip=true;
                        break;
                    }
                }
                if(!skip)
                    max=Math.max(max,j-i+1);
            }
        
        }
        return max;
    }
}
