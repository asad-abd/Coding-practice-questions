//Spent 2 days on stupid silly mistake: this snippet /*&& smap[ch-'a']<pmap[ch-'a']*/
//because then, I was not incrementing the extra characters more and their frequencies 
//were being stored lesser than what they actually were!
//Imp: Sliding window question
import java.util.*;
class _438_IMP_FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> ans =new ArrayList<>();
        int smap[]=new int[26], pmap[]=new int[26];
        int n=s.length(), m=t.length();
        if(m>n) return ans;
        for(int i=0;i<m;i++)
            pmap[t.charAt(i)-'a']++;
        
        int left=0, right=0;
        
        while(right<n){
            char ch;
            while(right-left+1<=m && right<n){
                ch=s.charAt(right);
                if(pmap[ch-'a']>0 /*&& smap[ch-'a']<pmap[ch-'a']*/)
                    smap[ch-'a']++;
                
                right++;
            }//at this point, right-left+1==m. window size met
            
            //System.out.println(Arrays.toString(pmap)+" | "+Arrays.toString(smap));
            if(Arrays.equals(smap,pmap)) ans.add(left);
            // this window has been considered. Now do left++
            
            if(smap[s.charAt(left)-'a']>=1) smap[s.charAt(left)-'a']--;
            left++;
        }
        return ans;
    }
}
