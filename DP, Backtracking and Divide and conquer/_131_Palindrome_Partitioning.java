public class _131_Palindrome_Partitioning {
    //simple back track
    boolean isPalindrome(String s, int i, int j){
        while(i <= j)
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        return true;
    }
    public void dfs(String s, List<List<String>> ans, List<String> currList, int i){
        if(i >= s.length())
            ans.add(new ArrayList<>(currList));
        for(int j = i; j < s.length(); j ++){
            //check if any partition is palindrome
            if(isPalindrome(s, i, j)){
                //consider it and deconsider it 
                currList.add(s.substring(i, j + 1));
                dfs(s, ans, currList, j + 1);
                
                //back track (deconsider)
                currList.remove(currList.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s, ans, new ArrayList<String>(), 0);
        
        return ans;
    }
}
