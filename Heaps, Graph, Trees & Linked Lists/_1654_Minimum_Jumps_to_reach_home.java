public class _1654_Minimum_Jumps_to_reach_home {
    
    //apparently the max x that can be jumped is max(x, forbidden) + a + b.
    //I don't know how the above is proved
    //soln 1
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        //twice 'back' in a row not allowed!!!!!
        boolean visited[] = new boolean[100001];
        for(int f : forbidden) visited[f] = true;
        
        int ans = -1;
        Queue<int[]> q = new LinkedList<>();
        if(visited[0]) return -1;
        q.add(new int[]{0, 0, 1});//1 means previous move was an 'ahead'
        while(q.size() > 0){
            int pop[] = q.poll();
            int pos = pop[0];
            int jumps = pop[1];
            int ahead = pop[2];
            if(visited[pos])
                continue;
            //System.out.println(pos + " , " + jumps);
            if(pos == x) 
                return jumps;
                //ans = Math.min(ans, jumps);
            visited[pos] = true;
            
            //int ahead = -1, back = -1;
            if(ahead != 0 && pos - b >= 0 && !visited[pos - b])
                q.add(new int[]{pos - b, jumps + 1, 0});
            
            if(pos + a < 100000 && !visited[pos + a])
                q.add(new int[]{pos + a, jumps + 1, 1});
        }
        return -1;
    }
}
