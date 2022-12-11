class Solution {
    /*   first thoughts:
        - soln 1 [basic graph]: i.  make graph with edges between vertices having same x or y coordinate -> O(n^2)
                                ii. traverse vertices from the beginning and don't consider them in the count if they                                 are connected to any other vertex.
        
        - soln 2 [union-find] : i.  have a hashmap store the parent index for each new x or y value encountered
                                ii. for any new stone if its x/y was already encountered mark the parent index as well as the stone's index.
    */
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean eliminate[] = new boolean[n];
        
        HashMap<Integer, Integer> x_parent = new HashMap<>();
        HashMap<Integer, Integer> y_parent = new HashMap<>();
        
        int i = 0;
        for(int stone[]: stones){
            int x = stone[0];
            int y = stone[1];
            
            if(x_parent.containsKey(x)){
                // eliminate from final answer the parent index and the current index
                eliminate[i] = true;
                eliminate[x_parent.get(x)] = true;
            }
            else if(y_parent.containsKey(y)){
                eliminate[i] = true;
                eliminate[y_parent.get(y)] = true;
            }
            else{
                x_parent.put(x, i);
                y_parent.put(y, i);
            }
            
            i ++;
        }
        
        int ans = 0;
        for(boolean eliminated: eliminate){
            if(eliminated) ans ++;
        }
        return ans;
    }
}