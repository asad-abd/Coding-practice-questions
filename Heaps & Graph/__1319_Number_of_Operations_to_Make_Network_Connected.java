class Solution {
    // Amazing discuss ( has path compression ): https://leetcode.com/problems/number-of-operations-to-make-network-connected/discuss/477660/Java-Count-number-of-connected-components-Clean-code
    
    // solution 2: 
    //      i. precheck that if total edges E < N - 1 then answer not possible since we need atleast n - 1 edges to connect the entire graph
    //      ii. Path compression: while finding the parent we can modify the links of the connected components s.t. instead of a linear (vertical scaling) chain of parent child nodes we have a horizontal connection
    //      in short, all the non heads store their connected components' heads -> simply add another stmt in the find head part. 

    // solution 1: mine (100ms runtime -relatively slow)
    public int findHead(int head[], int i){
        while(head[i] != i){
            i = head[i];
        }
        return i;
    }
    public int makeConnected(int n, int[][] connections){
        int heads[] = new int[n];
        for (int i = 0; i < n; i ++){
            heads[i] = i;
        }
        int extra = 0;
        for(int[] edge: connections){
            int a = edge[0];
            int b = edge[1];

            int head_a = findHead(heads, a);
            int head_b = findHead(heads, b);
            if(head_a == head_b) // already connected - extra edge
                extra ++;
            else{
                heads[head_a] = head_b;
            }
            // System.out.println(Arrays.toString(heads));
            
        }
        // System.out.println("extra: " + extra);
        
        HashSet<Integer> unique = new HashSet<>();
        int connected_components = 0;
        for(int i = 0; i < n; i ++){
            int head_i = findHead(heads, i);
            if(!unique.contains(head_i)){
                connected_components ++;
                unique.add(head_i);
            }    

        }
        // System.out.println("connected_components: " + connected_components);
        
        // to join x connected_components we need atleast x - 1 edges
        if(extra < connected_components - 1)
            return -1;
        return connected_components - 1;
    }
}