public class _767_Reorganize_String {
    //SOMEONE ELSE'S CODE: UNDERSTOOD retry later
    //count letter appearance and store in hash[i]
    //find the letter with largest occurence.
    //put the letter into even index numbe (0, 2, 4 ...) char array
    //put the rest into the array
    //NOTICE that IF THE most frequent char occurs more than half the size of S then answer is NOT possible!
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        } 
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return ""; 
        }
        char[] res = new char[S.length()];
        int idx = 0;
        //place most frequent
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        //place the rest in the spaces
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }


    //attempt 2: WRONGGGG
    //just modify it a little: in each turn check if the last added was the most freq. 
    //if no, add the most frequent.
    //else add the second most frequent. add both (1st and 2nd most frequent) in the pq after decrementing them.

    //similar to a greedy problem (slightly) _621_Task_Scheduler
    //PQ<> of (char, freq). Greedily put the most frequent first
    public String reorganizeString(String S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        char s[] = S.toCharArray();
        int freq[] = new int[26];
        for(int i = 0; i < s.length; i ++)
            freq[s[i] - 'a'] ++;
        //fill the PQ
        for(int i = 0; i < 26; i ++)
            if(freq[i] > 0)
                pq.add(new int[]{i, freq[i]});
        //assort greedily
        boolean ansPossible = true;
        ArrayList<Integer> chars = new ArrayList<>(); 
        while(pq.size() > 0 && ansPossible){
            ArrayList<int[]> unfinished = new ArrayList<>();
            int size = pq.size();
            
            for(int i = 0; i < size; i ++){
                int charFreq[] = pq.poll();
                chars.add((int)'a' + charFreq[0]);
                
                charFreq[1]--;
                if(charFreq[1] > 0)
                    unfinished.add(charFreq);
            }
            if(ansPossible)
                for(int[] pair: unfinished)
                    pq.add(pair);
        }
        
        if(!ansPossible) return "";
        //convert the chars<int> to characters
        StringBuilder str = new StringBuilder(); 
        for(int c : chars)
            str.append((char)c);
        return str.toString();
        
    }
    //old code
    public String reorganizeString(String s) {
        //if(freq(ch)>n/2) not possible
        char c[]=s.toCharArray();
        HashMap<Character,Integer> hmap= new HashMap<>();
        int n=s.length();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1]- a[1]);
        int i;
        for(i=0; i<n; i++){
            if(!hmap.containsKey(c[i])){
                hmap.put(c[i], 1);
                
            }
            else
                hmap.put(c[i],hmap.get(c[i])+1);
            if(hmap.get(c[i])>(n+1)/2) return "";
        }
        
        for(i=0; i<n; i++){
            if(!hmap.containsKey(c[i])){
                hmap.put(c[i], 1);
                
            }
            else
                hmap.put(c[i],hmap.get(c[i])+1);
            if(hmap.get(c[i])>(n+1)/2) return "";
        }
        
        char ans[]=new char[n];
        i=0;
        int count=0;
        char chara='a';
        System.out.println(pq.peek());
        //fill even positions then odd ones.
        while(i<n){
            if(count==0){
                int []temp=pq.remove();
                chara=temp[0];
                count=hmap.get(chara);
            }
            ans[i]=chara;
            count--;
            i+=2;
        }
        i=1;
        while(i<n){
            if(count==0){
                chara=pq.remove();
                count=hmap.get(chara);
            }
            ans[i]=chara;
            count--;
            i+=2;
        }
        return String.valueOf(ans);
    }
}
