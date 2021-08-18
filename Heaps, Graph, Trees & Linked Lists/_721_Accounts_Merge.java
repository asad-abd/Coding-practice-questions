public class _721_Accounts_Merge {
    //Silly mistake done is parents[p2] = p1; 
    //I was assigning parents[j] earlier
    //solution inspiration: https://leetcode.com/problems/accounts-merge/discuss/140978/Easy-to-Understand-Union-Find-in-Java-95
    public int findParentAccount(int[] parents, int j){
        while(parents[j] != j){
            j = parents[j];
        }   
        return j;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //1. match the heads(ids) of the current account (i) and the account id of the owner of the email for each of the email associated with i
        int n = accounts.size();
        int parents[] = new int[n];
        HashMap <String, Integer> emails = new HashMap<>();
        int j;
        for(int i = 0; i < n; i ++)
            parents[i] = i;
        j = 0;
        for(List<String> acc : accounts){
            for(int i = 1; i < acc.size(); i ++){
                //assign the parent id of this account to the other one's if present in the hmap already
                String email = acc.get(i);
                if(emails.containsKey(email)){
                    //means that this email was also present in some other account.
                    //assign parent of this 'acc' to the the parent of the account in which this email previously appeared.
                    int p1 = findParentAccount(parents, j);
                    int p2 = findParentAccount(parents, emails.get(email));
                    if(p1 != p2)
                        parents[p2] = p1; // THIS WAS THE SMD point. I was assigning parents[j] before!!
                }
                else{
                    emails.put(email, j);
                }
            }
            j++;
        }
        //2. now iterate over all accounts and make a tree set of emails associated with the index of each overall parent of the account
        HashMap<Integer, TreeSet<String>> idEmails = new HashMap<>();
        for(int i = 0; i < n; i ++){
            int parent = findParentAccount(parents, i);
            idEmails.putIfAbsent(parent, new TreeSet<String>());
            for(int k = 1; k < accounts.get(i).size(); k ++){
                String email = accounts.get(i).get(k);
                idEmails.get(parent).add(email); //no duplicates allowed in set
            }
        }
        //System.out.println(idEmails);
        //3. now store the information in the required format to output
        List<List<String>> ans = new ArrayList<>();
        for(int i : idEmails.keySet()){
            //int parent = findParentAccount(parents, i);
            String nameOfAcc = accounts.get(i).get(0);
            List<String> ans_row = new ArrayList<>();
            ans_row.add(nameOfAcc);
            for(String email : idEmails.get(i)){
                ans_row.add(email);
            }
            ans.add(ans_row);
        }
        return ans;
    }
}
