class Solution {
    public int findIndex(String date, int []cumuMonth){
        int mm = Integer.parseInt(date.substring(0, 2));
        int dd = Integer.parseInt(date.substring(3, date.length()));
        
        if(mm == 1) return dd;
        
        else
            return cumuMonth[mm - 2] + dd;
        
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int cumuMonth[] = new int[12];
        cumuMonth[0] = months[0];
        for(int i = 1; i < 12; i ++)
            cumuMonth[i] = cumuMonth[i - 1] + months[i];
        // mm = 4 -> 3 months worth days have passed -> cumulative sum of 3 months + d
        int arrivals[] = { findIndex(arriveAlice, cumuMonth), findIndex(arriveBob, cumuMonth) };
        int departures[] = { findIndex(leaveAlice, cumuMonth), findIndex(leaveBob, cumuMonth) };
        
        // System.out.println(Arrays.toString(arrivals));
        // System.out.println(Arrays.toString(departures));
        
        int ans = Math.min(departures[0], departures[1]) - Math.max(arrivals[0], arrivals[1]) + 1;
        
        return ans > 0 ? ans : 0;
    }
}
