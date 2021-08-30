public class _763_Partition_Labels__merge_intervals__ {
    //So.., if 'a' appears at the 1st pos it can also appear at the 2nd last, and we'll have to take all of (1, n-1) into 1.
    //Seems like each char has an INTERVAL (1st occr, last occr)
    //We'll have intervals like this for all 26 chars.
    //and now the question devolves into MERGE INTERVALS!
    //RETURN number of merged intervals.
    public List<Integer> partitionLabels(String S) {
        //create intervals;
        char[] s = S.toCharArray();
        int [][]intervals = new int[26][2];
        for(int i = 0; i < 26; i ++)
            intervals[i] = new int[]{-1, -1};
        int ind = 0;
        for(int i = 0; i < s.length; i ++){
            ind = s[i] - 'a';
            if(intervals[ind][0] == -1){ // first occurence
                intervals[ind][0] = i;
                intervals[ind][1] = i;
            }
            else // later occurences (char has occurred atleast once before)
                intervals[ind][1] = i; 
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int st = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for(int inter[] : intervals){
            if(inter[0] == -1) continue;
            // curr start <= prev end or curr end <= prev end - merge interval
            if(inter[0] <= end)
                end = Math.max(end, inter[1]);
            else{ // curr start > prev end - create new interval
                ans.add(end - st + 1);
                st = inter[0];
                end = inter[1];
            }   
        }
        ans.add(end - st + 1);
        return ans;
    }
}
