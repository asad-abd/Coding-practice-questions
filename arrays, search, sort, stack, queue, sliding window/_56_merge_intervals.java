//R1 Aug done
public class _56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int [] a, int [] b){
                return Integer.compare(a[0],b[0]);
            }
        });//sort based on the starting
        ArrayList<int[]> list = new ArrayList<>();
        int st,end;
        st=intervals[0][0]; end=intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            int curr[]= intervals[i];
            //1. No Overlap with previous
            if(curr[0]>end){
                list.add(new int[]{st,end});
                st=curr[0];
                end=curr[1];
            }
            //2. Partial Overlap with previous
            else if(curr[0]<=end && curr[1]>end){
                //just change end 
                end=curr[1];
            }
            //3. Complete overlap with previous
            else{
                //no change in st and end
            }
        }
        list.add(new int[]{st,end});
        int [][]result = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
