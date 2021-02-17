class _22_Generate_all_possible_paranthesis {
    //Try DP later with: f(n) = (f(0))f(n-1) + (f(1))f(n-2) + ... + (f(n-2))f(1) + (f(n-1))f(0)

    //Think similarly to that water jug _365 (bfs), taking all possible steps at an instant and stopping when condition is met.
    public void generateAll(int n, int currOp, int currCl ,String s, List<String> ans){
        if(s.length()==2*n){
            ans.add(s);
            return;
        }
        if(currOp<n)
            generateAll(n, currOp+1, currCl, (s+"("), ans);
        
        if(currCl<currOp)
            generateAll(n, currOp, currCl+1, (s+")"), ans);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        generateAll(n, 0, 0, "", ans);
        return ans;
    }
}
