public class __gfg_Recursively_remove_all_adjacent_duplicates {
    //ALGO: don't take char if c[i] == c[i + 1]. recurse (or while loop) till no more adj duplicates
    //https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1/?page=1&sortBy=newest&company[]=Paytm&query=page1sortBynewestcompany[]Paytm#
    
    //note that if we remove just one continuous duplicate set then recurse, we'll get wrong answer
    //eg: abccbccba. correct: "" (empty)
    //if we recurse after removing first "cc", we get => abbccba => accba => aba. THIS is wrong
    //Because in one run we should remove all that are continuous. then check if that resulted in more adj duplicates!!
    String remove(String s) {
        if(s.length() <= 1) return s;
        boolean deleted = false;
        int i = 0, j = 0;
        //acaacbaab
        StringBuilder str = new StringBuilder(); 
        while(j < s.length() && i < s.length()){
            while(i < s.length() - 1 && s.charAt(i) != s.charAt(i + 1)) {
                str.append(s.charAt(i));
                i++;
            }    
            //i and i + 1 are same
            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                deleted = true;
                j = i + 1;
                while(j < s.length() && s.charAt(i) == s.charAt(j))
                    j++;
                i = j;
                //remove substring (i, j - 1), and recurse
                
            }
            else if(i == s.length() - 1){
                str.append(s.charAt(i));
                i++;
            }
        }
        if(deleted)
            return remove(str.toString());
        return s;
    }
}
