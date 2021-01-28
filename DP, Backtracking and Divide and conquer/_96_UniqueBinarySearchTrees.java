class _96_UniqueBinarySearchTrees {
    HashMap<Integer,Integer> numOfTrees=new HashMap<>();
    public int numTrees(int n) {
        if(n<=2){
            numOfTrees.put(n,n);
            return n;
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(!numOfTrees.containsKey(i-1))
                numOfTrees.put(i-1,numTrees(i-1));
            
            if(!numOfTrees.containsKey(n-i))
                numOfTrees.put(n-i,numTrees(n-i));
            int left= Math.max(1,numOfTrees.get(i-1));
            int right= Math.max(1,numOfTrees.get(n-i));
            
            //System.out.println(left+" - "+right+" - n = "+n);
            ans += left*right;
        }
        numOfTrees.put(n,ans);
        return ans;
    }
}
