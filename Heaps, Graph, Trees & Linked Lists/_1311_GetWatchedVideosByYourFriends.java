// JUST a BFS question!!!
class _1311_GetWatchedVideosByYourFriends {
    HashMap<String,Integer> freq=new HashMap<>();
    public  List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        boolean visited[]=new boolean[watchedVideos.size()];
        
        visited[id]=true;
        Queue<Integer> q=new LinkedList();
        q.add(id);
        while(q.size()>0 && level>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int currId=q.poll();
                
                for(int j: friends[currId]){
                    if(!visited[j]){
                        q.add(j);
                        visited[j]=true;
                    }
                }
            }
            level--;
        }
        if(q.size()==0 || level>0){// queue is empty before reaching the level or the level is empty.
            return new ArrayList<String>();
        }
            
        
        while(q.size()>0){
            for(String video: watchedVideos.get(q.poll())){
                freq.put(video,freq.getOrDefault(video,0)+1);
            }
        }
        ArrayList<String> ans=new ArrayList<>(freq.keySet());
        
        Collections.sort(ans, (a,b)-> freq.get(a)==freq.get(b)? a.compareTo(b) : (freq.get(a)).compareTo(freq.get(b)) );
        
        return ans;
         
    }
}
