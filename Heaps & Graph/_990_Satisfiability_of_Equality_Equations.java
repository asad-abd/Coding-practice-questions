class _990_Satisfiability_of_Equality_Equations {
    // Union find
    // see your _684 for reference
    // logic is that we have independent sets(IS). we can say that IS has a head parent.
    // when we encounter an == and the characters a and b are not the same
    // check the head of those independent sets. if they are different then connect 
    public int findHead(int parent[], int x){
        // search till we find the character that is the parent of itself
        while(parent[x] != x)
            x = parent[x]; 
        return x;
    }
    public boolean equationsPossible(String[] equations) {
        int parent[] = new int[26];
        for(int i = 0; i < 26; i ++)
            parent[i] = i;
        
        for(String s: equations){
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            
            int a_head = findHead(parent, a);
            int b_head = findHead(parent, b);
            
            if(s.charAt(1) == '=' && a_head != b_head){
                parent[a_head] = b_head;
            }
        }
        
        for(String s: equations){
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            
            if(s.charAt(1) == '!'){
                // check if both their parent are different 
                if(findHead(parent, a) == findHead(parent, b)) // both are in the same set
                    return false;
            }
        }
        return true;
    }
}