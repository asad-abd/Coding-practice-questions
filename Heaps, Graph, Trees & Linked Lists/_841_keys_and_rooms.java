public class _841_keys_and_rooms {
    //EZ
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        int countUnvisited = rooms.size();
        boolean visited[] = new boolean[rooms.size()];
        q.add(0);
        while(q.size() > 0){
            int room = q.poll();
            if(!visited[room]){
                visited[room] = true;
                countUnvisited --;
            }
            for(int key : rooms.get(room)){
                if(!visited[key])
                    q.add(key);
            }
        }
        return countUnvisited == 0;
    }
}
