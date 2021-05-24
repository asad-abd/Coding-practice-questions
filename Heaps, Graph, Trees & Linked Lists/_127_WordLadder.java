import java.util.*;
class _127_WordLadder {
    //simple bfs approach. O( |wordList|^2 * |s| ) - first solution
    //there's another double sided bfs approach also. check later
    public boolean distanceIs1(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        int count=0;
        for(int i=0;i<s2.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) count++;
            
            if(count>1) return false;
        }
        if(count!=1) return false;
        return true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        
        HashSet<String> marked=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        
        int level=1;
        marked.add(beginWord);
        while(q.size()>0){
            int size=q.size();
            level++;
            for(int k=0;k<size;k++){
                String node=q.poll();
                
                for(String s: wordList){
                    if(!marked.contains(s) && distanceIs1(s,node)){
                        if(s.equals(endWord)) return level;
                        q.add(s);
                        marked.add(s);
                    }
                }
            }
        }
        return 0;
    }
}
